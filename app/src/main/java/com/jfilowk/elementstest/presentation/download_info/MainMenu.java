package com.jfilowk.elementstest.presentation.download_info;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jfilowk.elementstest.R;

public class MainMenu extends AppCompatActivity {

  @BindView(R.id.btn_show_me) Button btnShowList;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_menu);

    ButterKnife.bind(this);
  }

  @OnClick(R.id.btn_show_me)
  public void navigateToList(){
    // TODO: implement navigation to
  }

  @Override protected void onResume() {
    super.onResume();
  }

  @Override protected void onPause() {
    super.onPause();
  }
}
