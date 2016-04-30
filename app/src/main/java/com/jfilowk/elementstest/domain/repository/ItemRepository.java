package com.jfilowk.elementstest.domain.repository;

import com.jfilowk.elementstest.domain.Item;
import java.util.Collection;

public interface ItemRepository {

  void getItemList(ItemListCallack itemListCallack);

  interface ItemListCallack {
    void onItemListLoaded(Collection<Item> itemCollection);

    // TODO: manage errors
    void onError();
  }
}
