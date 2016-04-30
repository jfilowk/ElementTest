package com.jfilowk.elementstest.presentation.list_csv;

public class ItemsListPresenterImpl implements ItemsListPresenter {

  ItemsListView view;

  // TODO: Inject interactor y un mapper para pasar de domain a presentation model

  public ItemsListPresenterImpl() {
  }

  @Override public void loadItemsList() {
    this.view.hideRetry();
    this.view.showLoading();
    this.getItemList();
  }

  private void getItemList() {
    // TODO: call interactor
  }

  @Override public void attachView(ItemsListView view) {
    this.view = view;
  }

  @Override public void resume() {

  }

  @Override public void pause() {

  }
}
