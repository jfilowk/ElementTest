package com.jfilowk.elementstest.data.network;

import com.jfilowk.elementstest.data.entity.ItemEntity;
import com.jfilowk.elementstest.data.entity.mapper.ItemEntityCsvMapper;
import com.opencsv.CSVReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Streaming;

public class ElementsService {

  private ElementsServiceApi elementsServiceApi;

  private ItemEntityCsvMapper itemEntityCsvMapper;

  @Inject public ElementsService(ServiceGenerator serviceGenerator,
      ItemEntityCsvMapper itemEntityCsvMapper) {
    this.itemEntityCsvMapper = itemEntityCsvMapper;
    elementsServiceApi = serviceGenerator.createService(ElementsServiceApi.class);
  }

  public void getItems(final ServiceCallback<Collection<ItemEntity>> collectionServiceCallback) {
    Call<ResponseBody> bodyCall = elementsServiceApi.getItems();

    bodyCall.enqueue(new Callback<ResponseBody>() {
      @Override public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        // TODO: CSV transform

        CSVReader reader = new CSVReader(response.body().charStream());
        try {
          List<String[]> listEntitiesCsv = reader.readAll();
          Collection<ItemEntity> itemEntityCollection =
              itemEntityCsvMapper.transform(listEntitiesCsv);
          collectionServiceCallback.onSuccess(itemEntityCollection);
        } catch (IOException e) {
          collectionServiceCallback.onError();
          e.printStackTrace();
        }
      }

      @Override public void onFailure(Call<ResponseBody> call, Throwable t) {
        collectionServiceCallback.onError();
      }
    });
  }

  public interface ElementsServiceApi {
    @Streaming
    @GET("ccc?key=0Aqg9JQbnOwBwdEZFN2JKeldGZGFzUWVrNDBsczZxLUE&single=true&gid=0&output=csv")
    Call<ResponseBody> getItems();
  }
}

