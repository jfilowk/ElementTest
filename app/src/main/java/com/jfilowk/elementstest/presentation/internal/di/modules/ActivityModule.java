package com.jfilowk.elementstest.presentation.internal.di.modules;

import android.app.Activity;
import com.jfilowk.elementstest.presentation.base.BaseActivity;
import com.jfilowk.elementstest.presentation.internal.di.PerActivity;
import dagger.Module;
import dagger.Provides;

@Module public class ActivityModule {

  private final BaseActivity baseActivity;

  public ActivityModule(BaseActivity baseActivity) {
    this.baseActivity = baseActivity;
  }

  @Provides @PerActivity Activity provideActivity() {
    return this.baseActivity;
  }

  ;
}
