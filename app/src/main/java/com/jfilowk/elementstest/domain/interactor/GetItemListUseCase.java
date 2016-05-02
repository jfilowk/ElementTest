package com.jfilowk.elementstest.domain.interactor;

import com.jfilowk.elementstest.domain.Item;
import com.jfilowk.elementstest.domain.exception.ErrorBundle;
import java.util.Collection;

public interface GetItemListUseCase extends Interactor {

  void execute(ItemListCallback callback);

  interface ItemListCallback {
    void onItemListLoaded(Collection<Item> itemCollection);

    void onError(ErrorBundle errorBundle);
  }
}
