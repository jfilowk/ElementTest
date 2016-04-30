package com.jfilowk.elementstest.presentation.internal.di.components;

import android.content.Context;
import com.jfilowk.elementstest.ElementTest;
import com.jfilowk.elementstest.domain.MainThread;
import com.jfilowk.elementstest.presentation.internal.di.modules.ApplicationModule;
import dagger.Component;
import java.util.concurrent.ExecutorService;

@Component(modules = ApplicationModule.class) public interface ApplicationComponent {
  void inject(ElementTest elementTest);

  Context getContext();

  ExecutorService executorService();

  MainThread mainThread();

  // TODO: repository
}
