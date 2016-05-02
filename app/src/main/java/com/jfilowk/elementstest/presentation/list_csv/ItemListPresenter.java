package com.jfilowk.elementstest.presentation.list_csv;

import com.jfilowk.elementstest.presentation.ItemListView;
import com.jfilowk.elementstest.presentation.base.Presenter;

public interface ItemListPresenter extends Presenter {

  void loadItemsList();

  void attachView(ItemListView view);
}
