package com.jfilowk.elementstest.data.cache;

import com.jfilowk.elementstest.data.entity.ItemEntity;
import com.jfilowk.elementstest.data.network.CallbackGeneric;
import java.util.Collection;

public interface ItemCache {

  void obtainListDeviceApplicationEntity(CallbackGeneric<Collection<ItemEntity>> callback);
}
