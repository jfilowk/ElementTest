package com.jfilowk.elementstest.presentation;

import com.jfilowk.elementstest.presentation.base.LoadDataView;
import com.jfilowk.elementstest.presentation.model.ItemModel;
import java.util.Collection;

public interface ItemListView extends LoadDataView {

  void displayItemsList(Collection<ItemModel> itemModelCollection);

  // TODO: display detail
}
