package com.jfilowk.elementstest.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.jfilowk.elementstest.ElementTest;
import com.jfilowk.elementstest.presentation.internal.di.components.ApplicationComponent;
import com.jfilowk.elementstest.presentation.internal.di.modules.ActivityModule;

public class BaseActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  public ApplicationComponent getApplicationComponent() {
    return ((ElementTest) getApplication()).getApplicationComponent();
  }

  public ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }
}
