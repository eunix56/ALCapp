package eunix56.example.com.alcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {
  private Toolbar fToolBar;
  private Button aboutALC;
  private Button myProfile;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_first);

    fToolBar = (Toolbar)findViewById(R.id.f_tool);
    aboutALC = (Button)findViewById(R.id.about_alc);
    myProfile = (Button)findViewById(R.id.profile);

    fToolBar.setTitle("ALC 4 Phase 1");
    fToolBar.setTitleTextColor(getResources().getColor(R.color.white));
    setSupportActionBar(fToolBar);

    aboutALC.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(FirstActivity.this, AboutPage.class);
        startActivity(i);
      }
    });

    myProfile.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(FirstActivity.this, MyProfile.class);
        startActivity(i);
      }
    });
  }
}
