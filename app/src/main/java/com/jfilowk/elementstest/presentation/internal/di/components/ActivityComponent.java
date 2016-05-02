package com.jfilowk.elementstest.presentation.internal.di.components;

import android.app.Activity;
import com.jfilowk.elementstest.presentation.base.BaseActivity;
import com.jfilowk.elementstest.presentation.internal.di.PerActivity;
import com.jfilowk.elementstest.presentation.internal.di.modules.ActivityModule;
import dagger.Component;

@PerActivity @Component(modules = {
    ActivityModule.class
}, dependencies = ApplicationComponent.class) public interface ActivityComponent {
  void inject(BaseActivity baseActivity);

  Activity activity();
}
