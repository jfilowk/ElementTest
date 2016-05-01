package com.jfilowk.elementstest.data.exception;

public class NetworkConnectionException extends Exception {
  public NetworkConnectionException() {
  }

  public NetworkConnectionException(String detailMessage) {
    super(detailMessage);
  }

  public NetworkConnectionException(String detailMessage, Throwable throwable) {
    super(detailMessage, throwable);
  }

  public NetworkConnectionException(Throwable throwable) {
    super(throwable);
  }
}
