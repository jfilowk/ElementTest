package com.jfilowk.elementstest.presentation.internal.di.modules;

import android.content.Context;
import com.jfilowk.elementstest.ElementTest;
import com.jfilowk.elementstest.presentation.internal.MainThread;
import com.jfilowk.elementstest.presentation.internal.MainThreadImpl;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

@Module public class ApplicationModule {

  private ElementTest elementTest;

  public ApplicationModule(ElementTest elementTest) {
    this.elementTest = elementTest;
  }

  @Provides @Singleton Context provideApplicationContext() {
    return elementTest.getApplicationContext();
  }

  @Provides @Singleton ExecutorService provideExecutor() {
    return Executors.newFixedThreadPool(2);
  }

  @Provides @Singleton MainThread provideMainThread(MainThreadImpl mainThread) {
    return mainThread;
  }

}
