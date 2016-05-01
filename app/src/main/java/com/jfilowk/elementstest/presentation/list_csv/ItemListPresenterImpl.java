package com.jfilowk.elementstest.presentation.list_csv;

import android.content.Context;
import com.jfilowk.elementstest.domain.Item;
import com.jfilowk.elementstest.domain.exception.ErrorBundle;
import com.jfilowk.elementstest.domain.interactor.GetItemListUseCase;
import com.jfilowk.elementstest.presentation.internal.exception.ErrorMessageFactory;
import com.jfilowk.elementstest.presentation.model.ItemModel;
import com.jfilowk.elementstest.presentation.model.mapper.ItemModelMapper;
import java.util.Collection;
import javax.inject.Inject;

public class ItemListPresenterImpl implements ItemListPresenter {

  ItemListView view;

  private Context context;
  private GetItemListUseCase getItemListUseCase;
  private ItemModelMapper itemModelMapper;

  @Inject public ItemListPresenterImpl(Context context, GetItemListUseCase getItemListUseCase,
      ItemModelMapper itemModelMapper) {
    this.context = context;

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

        @Override public void onError(ErrorBundle errorBundle) {
          showError(errorBundle);
        }
      };

  private void showItemList(Collection<ItemModel> itemModelCollection) {
    this.view.displayItemsList(itemModelCollection);
    this.view.hideLoading();
  }

  private void showError(ErrorBundle errorBundle) {
    String errorMessage = ErrorMessageFactory.create(context, errorBundle.getException());
    this.view.showError(errorMessage);
    this.view.hideLoading();
    this.view.showRetry();
  }

  @Override public void attachView(ItemListView view) {
    this.view = view;
  }

  @Override public void resume() {

  }

  @Override public void pause() {

  }
}
