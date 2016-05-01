package com.jfilowk.elementstest.base;

import android.app.Fragment;
import android.os.Bundle;
import com.jfilowk.elementstest.presentation.internal.di.HasComponent;

public class BaseFragment extends Fragment {

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }


  protected <C> C getComponent(Class<C> componentType) {
    return componentType.cast(((HasComponent<C>)getActivity()).getComponent());
  }
}
