package com.jfilowk.elementstest.presentation.list_csv.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jfilowk.elementstest.R;
import com.jfilowk.elementstest.presentation.model.ItemModel;

public class ItemListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  public ItemListAdapter() {
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return null;
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

  }

  @Override public int getItemCount() {
    return 0;
  }

  public static class RowViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_title) TextView txtTitle;
    @BindView(R.id.txt_description) TextView txtDescription;
    @BindView(R.id.img_item) ImageView imgItem;

    public RowViewHolder(View view) {
      super(view);

      ButterKnife.bind(this, view);
    }

    public void bindItemModel(ItemModel itemModel) {
      txtTitle.setText(itemModel.getTitle());
      txtDescription.setText(itemModel.getDescription());

    }
  }
}
