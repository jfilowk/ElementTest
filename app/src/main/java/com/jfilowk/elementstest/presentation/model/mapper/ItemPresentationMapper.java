package com.jfilowk.elementstest.presentation.model.mapper;

import com.jfilowk.elementstest.domain.Item;
import com.jfilowk.elementstest.presentation.model.ItemModel;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;

public class ItemPresentationMapper {

  @Inject public ItemPresentationMapper() {
  }

  public ItemModel transform(Item item) {
    ItemModel itemModel = null;

    if (item != null) {
      itemModel = new ItemModel();
      itemModel.setTitle(item.getTitle());
      itemModel.setDescription(item.getDescription());
      itemModel.setUrl(item.getUrl());
    }

    return itemModel;
  }

  public Collection<ItemModel> transform(Collection<Item> itemCollection) {
    Collection<ItemModel> itemModelCollection = new ArrayList<>();
    ItemModel itemModel;

    for (Item item : itemCollection) {
      itemModel = transform(item);
      itemModelCollection.add(itemModel);
    }

    return itemModelCollection;
  }
}
