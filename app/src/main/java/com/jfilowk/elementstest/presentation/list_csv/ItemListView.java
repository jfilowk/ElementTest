package com.jfilowk.elementstest.presentation.list_csv;

import com.jfilowk.elementstest.base.LoadDataView;
import com.jfilowk.elementstest.presentation.model.ItemModel;
import java.util.Collection;

public interface ItemListView extends LoadDataView {

  void displayItemsList(Collection<ItemModel> itemModelCollection);

  // TODO: display detail
}
