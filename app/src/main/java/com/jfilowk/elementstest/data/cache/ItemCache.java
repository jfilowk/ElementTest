package com.jfilowk.elementstest.data.cache;

import com.jfilowk.elementstest.data.entity.ItemEntity;
import com.jfilowk.elementstest.data.network.CallbackGeneric;
import java.util.Collection;

public interface ItemCache {

  boolean insertItemListEntity(Collection<ItemEntity> itemEntityCollection);

  void obtainItemListEntity(CallbackGeneric<Collection<ItemEntity>> callback);
}
