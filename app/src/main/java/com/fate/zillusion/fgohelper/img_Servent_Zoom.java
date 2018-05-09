package com.fate.zillusion.fgohelper;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class img_Servent_Zoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img__servent__zoom);
        //region HideTitleBar
        //getSupportActionBar().hide();
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        super.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Advertise();
        getSupportActionBar().setTitle("Image");
        //endregion

        //region GetImage from Servent Activity
        Bitmap bitmap=null;

        try {
             bitmap = BitmapFactory.decodeStream(img_Servent_Zoom.this
                    .openFileInput("myImage"));//here context can be anything like getActivity() for fragment, this or MainActivity.this
        }
        catch (Exception e)
        {
            Log.d("Fileopen", "img_Servent_Zoom: OnCreate "+e);
        }



        SubsamplingScaleImageView imageView = (SubsamplingScaleImageView)findViewById(R.id.imageView);
        if (bitmap!=null)
        {
            imageView.setImage(ImageSource.bitmap(bitmap));
        }
        else
        {
            Toast.makeText(this,"Image is not found",Toast.LENGTH_LONG);
        }
        bitmap=null;//release Memory




        //endregion

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {// Backbutton
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void Advertise ()
    {
        MobileAds.initialize(this, "ca-app-pub-8418426477328402~2027922183");
        AdView adview=(AdView) findViewById(R.id.ad_ServentZoom);
        AdRequest adRequest = new AdRequest.Builder().build();
        adview.loadAd(adRequest);

    }
}
