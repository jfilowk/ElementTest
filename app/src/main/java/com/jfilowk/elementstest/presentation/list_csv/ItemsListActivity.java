package com.jfilowk.elementstest.presentation.list_csv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import com.jfilowk.elementstest.R;
import com.jfilowk.elementstest.base.BaseActivity;
import com.jfilowk.elementstest.presentation.internal.di.HasComponent;
import com.jfilowk.elementstest.presentation.internal.di.components.DaggerItemComponent;
import com.jfilowk.elementstest.presentation.internal.di.components.ItemComponent;

public class ItemsListActivity extends BaseActivity implements HasComponent<ItemComponent> {

  private ItemComponent itemComponent;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
    setContentView(R.layout.activity_list_items);

    this.initializeInjector();
  }

  private void initializeInjector() {

    if (itemComponent == null) {
      itemComponent = DaggerItemComponent.builder()
          .applicationComponent(getApplicationComponent())
          .activityModule(getActivityModule())
          .build();
    }

    itemComponent.inject(this);
  }

  @Override public ItemComponent getComponent() {
    return itemComponent;
  }
}
