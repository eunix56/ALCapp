package eunix56.example.com.alcapp;


import android.net.ConnectivityManager;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


public class AboutPage extends AppCompatActivity {
  private WebView alcWeb;
  private Toolbar aboutToolBar;
  private ProgressBar progress;
  private SwipeRefreshLayout refresh;

  private final String Url = "https://andela.com/alc/";

  @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_about_page);


    aboutToolBar = (Toolbar)findViewById(R.id.a_tool);
    aboutToolBar.setTitle("About ALC");
    aboutToolBar.setTitleTextColor(getResources().getColor(R.color.white));
    setSupportActionBar(aboutToolBar);

    if (getSupportActionBar() != null){
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    progress = (ProgressBar)findViewById(R.id.progress);
    refresh = (SwipeRefreshLayout)findViewById(R.id.refresh);

    refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
            refresh.setRefreshing(false);
            alcWeb.reload();
          }
        }, 3000);
      }
    });


    alcWeb = (WebView) findViewById(R.id.alc_web);
    alcWeb.getSettings().setJavaScriptEnabled(true);
    alcWeb.getSettings().setLoadWithOverviewMode(true);
    alcWeb.getSettings().setUseWideViewPort(true);
    alcWeb.getSettings().setDomStorageEnabled(true);
//    alcWeb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
    alcWeb.setWebViewClient(new Browser());
    alcWeb.loadUrl(Url);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    if (item.getItemId() == android.R.id.home){
      finish();
    }
    return super.onOptionsItemSelected(item);
  }

  private class Browser extends WebViewClient{
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
      progress.setVisibility(View.VISIBLE);
      view.loadUrl(url);
      return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
      progress.setVisibility(View.GONE);
    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
      if (handler != null)
        handler.proceed();
      else
        super.onReceivedSslError(view, null, error);
    }
  }


}
