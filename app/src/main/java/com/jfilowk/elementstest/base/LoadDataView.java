package com.jfilowk.elementstest.base;

public interface LoadDataView {

  void showLoading();

  void hideLoading();

  void showRetry();

  void hideRetry();

  void showError(String errorMessage);
}
