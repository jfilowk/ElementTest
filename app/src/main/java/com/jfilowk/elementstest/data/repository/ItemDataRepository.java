package com.jfilowk.elementstest.data.repository;

import com.jfilowk.elementstest.data.entity.ItemEntity;
import com.jfilowk.elementstest.data.entity.mapper.ItemEntityMapper;
import com.jfilowk.elementstest.data.repository.datasource.CloudItemData;
import com.jfilowk.elementstest.data.repository.datasource.ItemData;
import com.jfilowk.elementstest.domain.Item;
import com.jfilowk.elementstest.domain.repository.ItemRepository;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

public class ItemDataRepository implements ItemRepository {

  private CloudItemData cloudItemData;
  private ItemEntityMapper mapper;

  @Inject public ItemDataRepository(CloudItemData cloudItemData, ItemEntityMapper mapper) {
    this.cloudItemData = cloudItemData;
    this.mapper = mapper;
  }

  @Override public void getItemList(final ItemListCallack itemListCallack) {
    Timber.e("showLoading2");
    cloudItemData.getItemEntityList(new ItemData.ItemEntityListCallback() {
      @Override public void onItemListLoaded(Collection<ItemEntity> itemEntityCollection) {
        List<Item> list = (List<Item>) mapper.transform(itemEntityCollection);
        itemListCallack.onItemListLoaded(list);
      }

      @Override public void onError() {
        itemListCallack.onError();
      }
    });
  }
}
