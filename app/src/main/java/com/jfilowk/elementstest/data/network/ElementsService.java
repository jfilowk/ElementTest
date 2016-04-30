package com.jfilowk.elementstest.data.network;

import com.jfilowk.elementstest.data.entity.ItemEntity;
import java.util.Collection;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

public class ElementsService {

  private ElementsServiceApi elementsServiceApi;

  public ElementsService(ServiceGenerator serviceGenerator) {
    elementsServiceApi = serviceGenerator.createService(ElementsServiceApi.class);
  }

  public void getItems(final ServiceCallback<Collection<ItemEntity>> collectionServiceCallback) {
    Call<ResponseBody> bodyCall = elementsServiceApi.getItems();

    bodyCall.enqueue(new Callback<ResponseBody>() {
      @Override public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

      }

      @Override public void onFailure(Call<ResponseBody> call, Throwable t) {

      }
    });
  }

  public interface ElementsServiceApi {
    @GET("/") Call<ResponseBody> getItems();
  }
}

