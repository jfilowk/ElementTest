package com.jfilowk.elementstest.data.repository;

import com.jfilowk.elementstest.data.entity.ItemEntity;
import com.jfilowk.elementstest.data.entity.mapper.ItemEntityMapper;
import com.jfilowk.elementstest.data.exception.RepositoryErrorBundle;
import com.jfilowk.elementstest.data.network.CallbackGeneric;
import com.jfilowk.elementstest.data.repository.datasource.CacheItemData;
import com.jfilowk.elementstest.data.repository.datasource.CloudItemData;
import com.jfilowk.elementstest.data.repository.datasource.ItemData;
import com.jfilowk.elementstest.domain.Item;
import com.jfilowk.elementstest.domain.repository.ItemRepository;
import java.util.Collection;
import javax.inject.Inject;

public class ItemDataRepository implements ItemRepository {

  private CloudItemData cloudItemData;

  private CacheItemData cacheItemData;
  private ItemEntityMapper mapper;

  @Inject public ItemDataRepository(CloudItemData cloudItemData, CacheItemData cacheItemData,
      ItemEntityMapper mapper) {
    this.cloudItemData = cloudItemData;
    this.cacheItemData = cacheItemData;
    this.mapper = mapper;
  }

  // This should be done in a Factory of ItemData
  @Override public void getItemList(final ItemListCallack itemListCallack) {
    cacheItemData.getItemEntityList(new ItemData.ItemEntityListCallback() {
      @Override public void onItemListLoaded(Collection<ItemEntity> itemEntityCollection) {
        if (itemEntityCollection.size() == 0) {
          getItemListFromServer(itemListCallack);
        } else {
          Collection<Item> itemCollection = mapper.transform(itemEntityCollection);
          itemListCallack.onItemListLoaded(itemCollection);
        }
      }

      @Override public void onError(Exception e) {
        itemListCallack.onError(new RepositoryErrorBundle(e));
      }
    });
  }

  private void getItemListFromServer(final ItemListCallack itemListCallack) {
    cloudItemData.getItemEntityList(new ItemData.ItemEntityListCallback() {
      @Override public void onItemListLoaded(Collection<ItemEntity> itemEntityCollection) {
        insertItemListCache(itemEntityCollection);
        Collection<Item> list = mapper.transform(itemEntityCollection);
        itemListCallack.onItemListLoaded(list);
      }

      @Override public void onError(Exception e) {
        itemListCallack.onError(new RepositoryErrorBundle(e));
      }
    });
  }

  private void insertItemListCache(Collection<ItemEntity> itemEntityCollection) {
    cacheItemData.insertItemEntityList(itemEntityCollection, new CallbackGeneric<Boolean>() {
      @Override public void onSuccess(Boolean result) {
        // TODO: save last insert
      }

      @Override public void onError(Exception e) {

      }
    });
  }
}
