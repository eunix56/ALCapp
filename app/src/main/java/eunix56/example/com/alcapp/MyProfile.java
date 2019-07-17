package eunix56.example.com.alcapp;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class MyProfile extends AppCompatActivity {
  private Toolbar pToolBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my_profile);

    pToolBar = (Toolbar)findViewById(R.id.p_tool);
    pToolBar.setTitle("My Profile");
    pToolBar.setTitleTextColor(getResources().getColor(R.color.white));
    setSupportActionBar(pToolBar);

    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    if (item.getItemId() == android.R.id.home){
      finish();
    }
    return super.onOptionsItemSelected(item);
  }
}
