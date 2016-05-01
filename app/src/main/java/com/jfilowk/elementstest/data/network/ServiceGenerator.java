package com.jfilowk.elementstest.data.network;

import javax.inject.Inject;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

public class ServiceGenerator {

  private final Retrofit retrofit;

  @Inject public ServiceGenerator(String URL) {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
    OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();
    // TODO: jackson https://github.com/FasterXML/jackson-dataformat-csv
    retrofit = new Retrofit.Builder().baseUrl(URL).client(okHttpClient).build();
  }

  public <T> T createService(Class<T> serviceClass) {
    return retrofit.create(serviceClass);
  }
}
