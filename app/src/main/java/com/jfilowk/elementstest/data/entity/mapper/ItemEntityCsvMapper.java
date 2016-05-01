package com.jfilowk.elementstest.data.entity.mapper;

import com.jfilowk.elementstest.data.entity.ItemEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ItemEntityCsvMapper {

  public static final int TITLE = 0;
  public static final int DESCRIPTION = 1;
  public static final int URL = 2;

  public ItemEntityCsvMapper() {
  }

  public ItemEntity transform(String[] strings) {
    ItemEntity itemEntity = null;
    if (strings != null) {
      itemEntity = new ItemEntity();
      itemEntity.setTitle(strings[TITLE]);
      itemEntity.setDescription(strings[DESCRIPTION]);
      itemEntity.setUrl(strings[URL]);
    }
    return itemEntity;
  }

  public Collection<ItemEntity> transform(List<String[]> strings) {
    Collection<ItemEntity> itemEntityList = new ArrayList<>();
    ItemEntity itemEntity;
    for (int i = 1; i < strings.size(); i++) {
      itemEntity = this.transform(strings.get(i));
      itemEntityList.add(itemEntity);
    }
    return itemEntityList;
  }
}
