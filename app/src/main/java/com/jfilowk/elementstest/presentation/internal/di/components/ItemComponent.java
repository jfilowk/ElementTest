package com.jfilowk.elementstest.presentation.internal.di.components;

import com.jfilowk.elementstest.presentation.internal.di.PerActivity;
import com.jfilowk.elementstest.presentation.internal.di.modules.ActivityModule;
import com.jfilowk.elementstest.presentation.internal.di.modules.ItemModule;
import com.jfilowk.elementstest.presentation.list_csv.ItemsListFragment;
import dagger.Component;

@PerActivity @Component(dependencies = ApplicationComponent.class, modules = {
    ActivityModule.class, ItemModule.class
}) public interface ItemComponent {

  void inject(ItemsListFragment itemsListFragment);
}
