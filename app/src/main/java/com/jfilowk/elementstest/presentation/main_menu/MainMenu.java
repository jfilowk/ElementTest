package com.jfilowk.elementstest.presentation.main_menu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jfilowk.elementstest.R;
import com.jfilowk.elementstest.presentation.base.BaseActivity;
import com.jfilowk.elementstest.presentation.list_csv.ItemListActivity;

public class MainMenu extends BaseActivity {

  @BindView(R.id.btn_show_me) Button btnShowList;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_menu);

    ButterKnife.bind(this);
  }

  @OnClick(R.id.btn_show_me) public void navigateToList() {
    Intent intent = new Intent(this, ItemListActivity.class);
    startActivity(intent);
  }

  @Override protected void onResume() {
    super.onResume();
  }

  @Override protected void onPause() {
    super.onPause();
  }
}
