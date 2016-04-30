package com.jfilowk.elementstest.base;

import android.app.Fragment;
import android.os.Bundle;

public class BaseFragment extends Fragment {

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }
}
