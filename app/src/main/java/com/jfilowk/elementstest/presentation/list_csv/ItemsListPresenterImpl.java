package com.jfilowk.elementstest.presentation.list_csv;

import com.jfilowk.elementstest.domain.Item;
import com.jfilowk.elementstest.domain.interactor.GetItemListUseCase;
import com.jfilowk.elementstest.presentation.model.ItemModel;
import com.jfilowk.elementstest.presentation.model.mapper.ItemModelMapper;
import java.util.Collection;
import javax.inject.Inject;

public class ItemsListPresenterImpl implements ItemsListPresenter {

  ItemsListView view;

  private GetItemListUseCase getItemListUseCase;
  private ItemModelMapper itemModelMapper;

  @Inject public ItemsListPresenterImpl(GetItemListUseCase getItemListUseCase,
      ItemModelMapper itemModelMapper) {

    this.getItemListUseCase = getItemListUseCase;
    this.itemModelMapper = itemModelMapper;
  }

  @Override public void loadItemsList() {

    this.view.hideRetry();
    this.view.showLoading();
    this.getItemList();
  }

  private void getItemList() {
    this.getItemListUseCase.execute(itemListCallback);
  }

  private final GetItemListUseCase.ItemListCallback itemListCallback =
      new GetItemListUseCase.ItemListCallback() {

        @Override public void onItemListLoaded(Collection<Item> itemCollection) {
          Collection<ItemModel> itemModelCollection = itemModelMapper.transform(itemCollection);
          showItemList(itemModelCollection);
        }

        @Override public void onError() {
          showError();
        }
      };

  private void showItemList(Collection<ItemModel> itemModelCollection) {

    this.view.displayItemsList(itemModelCollection);
    this.view.hideLoading();
  }

  private void showError() {

    this.view.hideLoading();
    this.view.showRetry();
  }

  @Override public void attachView(ItemsListView view) {
    this.view = view;
  }

  @Override public void resume() {

  }

  @Override public void pause() {

  }
}
