package com.example.zillusion.fgohelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class WebActivity extends AppCompatActivity {
    private String Url_CE="https://ms0266378.github.io/fgo.query/Craft_Essence.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        super.getSupportActionBar().setDisplayHomeAsUpEnabled(true);// Backbutton


        WebView webview = (WebView) findViewById(R.id.webview1);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
       //setContentView(webview);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl(Url_CE);
        Toast.makeText(this,"Loading...",Toast.LENGTH_SHORT).show();
        Advertise();
    }

    private void Advertise()
    {
        MobileAds.initialize(this, "ca-app-pub-8418426477328402~2027922183");
        AdView mAdView = (AdView) findViewById(R.id.ad_webview);
        //AdView mAdView1 = (AdView) findViewById(R.id.ad_ServentQuery_View1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public boolean onOptionsItemSelected(MenuItem item) {// Backbutton
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                //startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

