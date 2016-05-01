package com.jfilowk.elementstest.presentation.list_csv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jfilowk.elementstest.R;
import com.jfilowk.elementstest.base.BaseFragment;
import com.jfilowk.elementstest.presentation.internal.di.components.ItemComponent;
import com.jfilowk.elementstest.presentation.list_csv.adapters.ItemListAdapter;
import com.jfilowk.elementstest.presentation.model.ItemModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

public class ItemsListFragment extends BaseFragment implements ItemsListView {

  @Inject ItemsListPresenter presenter;

  @BindView(R.id.rv_list_items) RecyclerView rvItemList;
  @BindView(R.id.rl_view_progress) RelativeLayout rlProgress;
  @BindView(R.id.rl_retry) LinearLayout rlRetry;
  @BindView(R.id.btn_retry) Button btnRetry;

  private List<ItemModel> itemModelList;

  private ItemListAdapter adapter;

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View fragmentView = inflater.inflate(R.layout.fragment_list_items, container, true);

    ButterKnife.bind(this, fragmentView);
    rvItemList.setLayoutManager(new LinearLayoutManager(getActivity()));
    itemModelList = new ArrayList<>();
    return fragmentView;
  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    this.initialize();
    this.loadItemList();
  }

  private void initialize() {
    this.getComponent(ItemComponent.class).inject(this);
    this.presenter.attachView(this);
  }

  private void loadItemList() {
    this.presenter.loadItemsList();
  }

  @Override public void displayItemsList(Collection<ItemModel> itemModelCollection) {
    if (itemModelCollection != null) {
      itemModelList = (List<ItemModel>) itemModelCollection;
      if (adapter == null) {
        adapter = new ItemListAdapter(getActivity(), itemModelList);
      } else {
        // TODO: actualizar
      }
      this.rvItemList.setAdapter(adapter);
    }
  }

  @Override public void showLoading() {
    Timber.e("showLoading");
    rlProgress.setVisibility(View.VISIBLE);
  }

  @Override public void hideLoading() {
    Timber.e("hideLoading");
    rlProgress.setVisibility(View.GONE);
  }

  @Override public void showRetry() {
    rlRetry.setVisibility(View.VISIBLE);
  }

  @Override public void hideRetry() {
    rlRetry.setVisibility(View.GONE);
  }

  @Override public void showError(String errorMessage) {
    showToastMessage(errorMessage);
  }
}
