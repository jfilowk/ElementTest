package com.jfilowk.elementstest;

import android.app.Application;
import com.jfilowk.elementstest.presentation.internal.di.components.ApplicationComponent;
import com.jfilowk.elementstest.presentation.internal.di.components.DaggerApplicationComponent;
import com.jfilowk.elementstest.presentation.internal.di.modules.ApplicationModule;
import timber.log.Timber;

import static timber.log.Timber.DebugTree;

public class ElementTest extends Application {

  private ApplicationComponent component;

  @Override public void onCreate() {
    super.onCreate();

    initializeDagger();

    initializeTimber();
  }

  private void initializeTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new DebugTree());
    }
  }

  private void initializeDagger() {

    if (component == null) {
      component = DaggerApplicationComponent.builder()
          .applicationModule(new ApplicationModule(this))
          .build();
    }

    component.inject(this);
  }

  private ApplicationComponent getComponent() {
    return this.component;
  }
}
