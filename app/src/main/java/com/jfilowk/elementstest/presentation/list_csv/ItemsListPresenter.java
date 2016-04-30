package com.jfilowk.elementstest.presentation.list_csv;

import com.jfilowk.elementstest.base.Presenter;

public interface ItemsListPresenter extends Presenter {

  void loadItemsList();

  void attachView(ItemsListView view);
}
