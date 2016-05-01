package com.jfilowk.elementstest.data.exception;

public class ItemException extends Exception {
  public ItemException() {
    super();
  }

  public ItemException(String detailMessage) {
    super(detailMessage);
  }

  public ItemException(String detailMessage, Throwable throwable) {
    super(detailMessage, throwable);
  }

  public ItemException(Throwable throwable) {
    super(throwable);
  }
}
