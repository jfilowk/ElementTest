package com.jfilowk.elementstest.data.network;

import android.content.Context;
import com.jfilowk.elementstest.data.entity.ItemEntity;
import com.jfilowk.elementstest.data.entity.mapper.ItemEntityCsvMapper;
import com.jfilowk.elementstest.data.exception.ItemException;
import com.jfilowk.elementstest.data.exception.NetworkConnectionException;
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

  public static final String NO_CONNECTIVITY = "No connectivity";
  private ElementsServiceApi elementsServiceApi;
  private Context context;
  private ItemEntityCsvMapper itemEntityCsvMapper;

  @Inject public ElementsService(Context context, ServiceGenerator serviceGenerator,
      ItemEntityCsvMapper itemEntityCsvMapper) {
    this.context = context;
    this.itemEntityCsvMapper = itemEntityCsvMapper;
    elementsServiceApi = serviceGenerator.createService(ElementsServiceApi.class);
  }

  public void getItems(final CallbackGeneric<Collection<ItemEntity>> collectionCallbackGeneric) {
    Call<ResponseBody> bodyCall = elementsServiceApi.getItems();

    bodyCall.enqueue(new Callback<ResponseBody>() {
      @Override public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        CSVReader reader = new CSVReader(response.body().charStream());
        try {
          List<String[]> listEntitiesCsv = reader.readAll();
          Collection<ItemEntity> itemEntityCollection =
              itemEntityCsvMapper.transform(listEntitiesCsv);
          collectionCallbackGeneric.onSuccess(itemEntityCollection);
          response.body().close();
        } catch (IOException e) {
          collectionCallbackGeneric.onError(new ItemException(""));
          e.printStackTrace();
        }
      }

      @Override public void onFailure(Call<ResponseBody> call, Throwable t) {
        collectionCallbackGeneric.onError(new NetworkConnectionException(""));
      }
    });
  }

  public interface ElementsServiceApi {
    @Streaming
    @GET("ccc?key=0Aqg9JQbnOwBwdEZFN2JKeldGZGFzUWVrNDBsczZxLUE&single=true&gid=0&output=csv")
    Call<ResponseBody> getItems();
  }
}

