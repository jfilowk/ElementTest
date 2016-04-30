package com.jfilowk.elementstest.data.entity.mapper;

import com.jfilowk.elementstest.data.entity.ItemEntity;
import com.jfilowk.elementstest.domain.Item;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;

public class ItemEntityMapper {

  @Inject
  public ItemEntityMapper() {
  }

  public Item transform(ItemEntity itemEntity) {

    Item item = null;

    if (itemEntity != null) {
      item = new Item();
      item.setTitle(itemEntity.getTitle());
      item.setDescription(itemEntity.getDescription());
      item.setUrl(itemEntity.getUrl());
    }

    return item;
  }

  public Collection<Item> transform(Collection<ItemEntity> itemEntityCollection) {

    Collection<Item> itemCollection = new ArrayList<>();
    Item item = null;

    for (ItemEntity itemEntity : itemEntityCollection) {
      item = transform(itemEntity);
      itemCollection.add(item);
    }

    return itemCollection;
  }
}
