package com.jfilowk.elementstest.data.repository.datasource;

import com.jfilowk.elementstest.data.cache.ItemCache;
import com.jfilowk.elementstest.data.entity.ItemEntity;
import com.jfilowk.elementstest.data.exception.NetworkConnectionException;
import com.jfilowk.elementstest.data.network.CallbackGeneric;
import java.util.Collection;
import javax.inject.Inject;

public class CacheItemData implements ItemData {

  private ItemCache itemCache;

  @Inject
  public CacheItemData(ItemCache itemCache) {
    this.itemCache = itemCache;
  }

  @Override public void insertItemEntityList(Collection<ItemEntity> itemEntities,
      CallbackGeneric<Boolean> callback) {
    boolean b = itemCache.insertItemListEntity(itemEntities);
    if (b) {
      callback.onSuccess(true);
    } else {
      callback.onError(new NetworkConnectionException());
    }
  }

  @Override public void getItemEntityList(final ItemEntityListCallback entityListCallback) {
    itemCache.obtainItemListEntity(new CallbackGeneric<Collection<ItemEntity>>() {
      @Override public void onSuccess(Collection<ItemEntity> result) {
        entityListCallback.onItemListLoaded(result);
      }

      @Override public void onError(Exception e) {
        entityListCallback.onError(e);
      }
    });
  }
}
