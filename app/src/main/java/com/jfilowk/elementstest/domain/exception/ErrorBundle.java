package com.jfilowk.elementstest.domain.exception;

public interface ErrorBundle {
  Exception getException();

  String getErrorMessage();
}
