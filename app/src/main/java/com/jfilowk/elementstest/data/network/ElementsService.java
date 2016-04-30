package com.jfilowk.elementstest.data.network;

import com.jfilowk.elementstest.data.entity.ItemEntity;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

public class ElementsService {

  private ElementsServiceApi elementsServiceApi;

  private static final List<ItemEntity> ITEM_ENTITIES =
      Arrays.asList(new ItemEntity("Item1", "Descripcion1", "Url1"),
          new ItemEntity("Item1", "Descripcion1", "Url1"),
          new ItemEntity("Item2", "Descripcion2", "Url2"),
          new ItemEntity("Item3", "Descripcion3", "Url3"),
          new ItemEntity("Item4", "Descripcion4", "Url4"),
          new ItemEntity("Item5", "Descripcion5", "Url5"),
          new ItemEntity("Item6", "Descripcion6", "Url6"),
          new ItemEntity("Item7", "Descripcion7", "Url7"));

  @Inject
  public ElementsService(ServiceGenerator serviceGenerator) {
    elementsServiceApi = serviceGenerator.createService(ElementsServiceApi.class);
  }

  public void getItems(final ServiceCallback<Collection<ItemEntity>> collectionServiceCallback) {
    Call<ResponseBody> bodyCall = elementsServiceApi.getItems();

    bodyCall.enqueue(new Callback<ResponseBody>() {
      @Override public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        // TODO: CSV transform
        collectionServiceCallback.onSuccess(ITEM_ENTITIES);
      }

      @Override public void onFailure(Call<ResponseBody> call, Throwable t) {
        collectionServiceCallback.onError();
      }
    });
  }

  public interface ElementsServiceApi {
    @GET("/") Call<ResponseBody> getItems();
  }
}

