package com.jfilowk.elementstest.data.network;

public interface CallbackGeneric<T> {
  void onSuccess(T result);

  void onError(Exception e);
}
