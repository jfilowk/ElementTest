package com.jfilowk.elementstest.data.entity.mapper;

import android.database.Cursor;
import android.support.annotation.NonNull;
import com.jfilowk.elementstest.data.entity.ItemEntity;
import com.jfilowk.elementstest.domain.Item;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;

public class ItemEntityMapper {

  public static final int COLUMN_TITLE = 1;
  public static final int COLUMN_DESCRIPTION = 2;
  public static final int COLUMN_URL = 3;

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

  public Collection<ItemEntity> transform(Cursor cursor) {
    Collection<ItemEntity> itemEntityCollection = new ArrayList<>();
    ItemEntity itemEntity = null;
    while (cursor.moveToNext()) {
      itemEntity = getItemEntity(cursor);
      itemEntityCollection.add(itemEntity);
    }
    return itemEntityCollection;
  }

  @NonNull private ItemEntity getItemEntity(Cursor cursor) {
    ItemEntity itemEntity;
    itemEntity = new ItemEntity();
    itemEntity.setTitle(cursor.getString(COLUMN_TITLE));
    itemEntity.setDescription(cursor.getString(COLUMN_DESCRIPTION));
    itemEntity.setUrl(cursor.getString(COLUMN_URL));
    return itemEntity;
  }
}
