package com.jfilowk.elementstest.data.repository.datasource;

import com.jfilowk.elementstest.data.entity.ItemEntity;
import com.jfilowk.elementstest.data.network.CallbackGeneric;
import java.util.Collection;

public interface ItemData {

  void insertItemEntityList(Collection<ItemEntity> itemEntities, CallbackGeneric<Boolean> callback);

  void getItemEntityList(ItemEntityListCallback entityListCallback);

  interface ItemEntityListCallback {
    void onItemListLoaded(Collection<ItemEntity> itemEntityCollection);

    void onError(Exception e);
  }
}
