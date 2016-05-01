package com.jfilowk.elementstest.data.exception;

import com.jfilowk.elementstest.domain.exception.ErrorBundle;

public class RepositoryErrorBundle implements ErrorBundle {
  private Exception exception;

  public RepositoryErrorBundle(Exception exception) {
    this.exception = exception;
  }

  @Override public Exception getException() {
    return exception;
  }

  @Override public String getErrorMessage() {
    String message = "";

    if (this.exception != null) {
      message = this.exception.getMessage();
    }

    return message;
  }
}
