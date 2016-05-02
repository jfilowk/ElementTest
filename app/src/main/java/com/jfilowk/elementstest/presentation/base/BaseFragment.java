package com.jfilowk.elementstest.presentation.base;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;
import com.jfilowk.elementstest.presentation.internal.di.HasComponent;

public class BaseFragment extends Fragment {

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }

  public void showToastMessage(String message) {
    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
  }

  protected <C> C getComponent(Class<C> componentType) {
    return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
  }
}
