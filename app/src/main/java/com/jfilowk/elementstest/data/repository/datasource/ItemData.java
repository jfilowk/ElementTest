package com.jfilowk.elementstest.data.repository.datasource;

import com.jfilowk.elementstest.data.entity.ItemEntity;
import java.util.Collection;

public interface ItemData {

  interface ItemEntityListCallback {
    void onItemListLoaded(Collection<ItemEntity> itemEntityCollection);

    void onError(Exception e);
  }

  void getItemEntityList(ItemEntityListCallback entityListCallback);
}
