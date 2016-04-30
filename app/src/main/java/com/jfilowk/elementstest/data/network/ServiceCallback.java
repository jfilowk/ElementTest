package com.jfilowk.elementstest.data.network;

public interface ServiceCallback<T> {
  void onSuccess(T result);

  void onError();
}
