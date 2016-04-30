package com.jfilowk.elementstest.presentation.list_csv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.jfilowk.elementstest.base.BaseActivity;
import com.jfilowk.elementstest.presentation.internal.di.components.ActivityComponent;
import com.jfilowk.elementstest.presentation.internal.di.components.DaggerActivityComponent;

public class ItemsListActivity extends BaseActivity {

  private ActivityComponent activityComponent;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    initializeInjector();
  }

  private void initializeInjector() {

    if (activityComponent == null) {
      activityComponent = DaggerActivityComponent.builder()
          .applicationComponent(getApplicationComponent())
          .activityModule(getActivityModule())
          .build();
    }

    activityComponent.inject(this);
  }
}
