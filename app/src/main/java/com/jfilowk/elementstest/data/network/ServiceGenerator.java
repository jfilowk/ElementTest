package com.jfilowk.elementstest.data.network;

import javax.inject.Inject;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class ServiceGenerator {

  // TODO: copy paste in dagger
  public static final String URL =
      "https://docs.google.com/spr eadsheet/ccc?key=0Aqg9JQbnOwBwdEZFN2JKeldGZGFzUWVrNDBsczZxLUE&single=true&gid=0&output=csv";

  private final Retrofit retrofit;

  @Inject public ServiceGenerator(String URL) {
    OkHttpClient okHttpClient = new OkHttpClient();
    // TODO: jackson https://github.com/FasterXML/jackson-dataformat-csv
    retrofit = new Retrofit.Builder().baseUrl(URL).client(okHttpClient).build();
  }

  public <T> T createService(Class<T> serviceClass) {
    return retrofit.create(serviceClass);
  }
}
