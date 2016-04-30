package com.jfilowk.elementstest.domain.interactor;

import com.jfilowk.elementstest.domain.Item;
import java.util.Collection;

public interface getItemListUseCase extends Interactor {

  interface ItemListCallback {
    void onItemListLoaded(Collection<Item> itemCollection);

    void onError();
  }

  void execute(ItemListCallback callback);
}
