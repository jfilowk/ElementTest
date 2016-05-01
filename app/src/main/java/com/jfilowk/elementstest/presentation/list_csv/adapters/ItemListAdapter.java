package com.jfilowk.elementstest.presentation.list_csv.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jfilowk.elementstest.R;
import com.jfilowk.elementstest.presentation.model.ItemModel;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private Context context;
  private List<ItemModel> itemModelList;

  public ItemListAdapter(Context context, List<ItemModel> itemModelList) {
    this.context = context;
    this.itemModelList = itemModelList;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View rowView =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_list, parent, false);

    return new RowViewHolder(rowView, context);
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    ItemModel itemModel = itemModelList.get(position);
    ((RowViewHolder) holder).bindItemModel(itemModel);
  }

  @Override public int getItemCount() {
    return itemModelList == null || itemModelList.size() == 0 ? 0 : itemModelList.size();
  }

  public static class RowViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_title) TextView txtTitle;
    @BindView(R.id.txt_description) TextView txtDescription;
    @BindView(R.id.img_item) ImageView imgItem;
    private Context context;

    public RowViewHolder(View view, Context context) {
      super(view);
      this.context = context;

      ButterKnife.bind(this, view);
    }

    public void bindItemModel(ItemModel itemModel) {
      txtTitle.setText(checkStyleString(itemModel.getTitle(), 20));
      txtDescription.setText(checkStyleString(itemModel.getDescription(), 30));
      if (!itemModel.getUrl().equals("")) {
        Picasso.with(context)
            .load(itemModel.getUrl())
            .fit()
            .placeholder(R.drawable.notfound)
            .error(R.drawable.notfound)
            .into(imgItem);
      }
    }
  }

  public static String checkStyleString(String string, int maxLength) {
    string = maxLengthSring(string, maxLength);
    string = escapeHtml(string);
    return string;
  }

  public static String maxLengthSring(String string, int maxLength) {
    if (string.length() > maxLength) {
      string = String.format("%s...", string.substring(0, maxLength));
    }
    return string;
  }

  public static String escapeHtml(String string) {
    string = Html.fromHtml(string).toString();
    return string;
  }
}
