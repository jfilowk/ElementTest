package com.jfilowk.elementstest.domain.interactor;

import com.jfilowk.elementstest.domain.Item;
import com.jfilowk.elementstest.domain.MainThread;
import com.jfilowk.elementstest.domain.repository.ItemRepository;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

public class GetItemListUseCaseImpl implements GetItemListUseCase {
  private ItemRepository itemRepository;
  private ExecutorService executor;
  private MainThread mainThread;

  private ItemListCallback callback;

  // TODO: inject repository, mainthread, executor

  @Inject public GetItemListUseCaseImpl(ItemRepository itemRepository, ExecutorService executor,
      MainThread mainThread) {
    this.itemRepository = itemRepository;
    this.executor = executor;
    this.mainThread = mainThread;
  }

  @Override public void execute(ItemListCallback callback) {
    if (callback == null) {
      throw new IllegalArgumentException("Cannot be null");
    }

    this.callback = callback;
    this.executor.submit(this);
  }

  @Override public void run() {
    this.itemRepository.getItemList(this.itemListCallack);
  }

  private final ItemRepository.ItemListCallack itemListCallack =
      new ItemRepository.ItemListCallack() {
        @Override public void onItemListLoaded(Collection<Item> itemCollection) {
          notifyItemListLoaded(itemCollection);
        }

        @Override public void onError() {
          notifyError();
        }
      };

  private void notifyItemListLoaded(Collection<Item> itemCollection) {
    callback.onItemListLoaded(itemCollection);
  }

  private void notifyError() {
    callback.onError();
  }
}
