package com.jfilowk.elementstest.data.repository.datasource;

import com.jfilowk.elementstest.data.entity.ItemEntity;
import com.jfilowk.elementstest.data.network.ElementsService;
import com.jfilowk.elementstest.data.network.ServiceCallback;
import java.util.Collection;
import javax.inject.Inject;

public class CloudItemData implements ItemData {

  private ElementsService elementsService;

  @Inject public CloudItemData(ElementsService elementsService) {
    this.elementsService = elementsService;
  }

  @Override public void getItemEntityList(final ItemEntityListCallback entityListCallback) {
    this.elementsService.getItems(new ServiceCallback<Collection<ItemEntity>>() {
      @Override public void onSuccess(Collection<ItemEntity> result) {
        entityListCallback.onItemListLoaded(result);
      }

      @Override public void onError(Exception e) {
        entityListCallback.onError(e);
      }
    });
  }
}
