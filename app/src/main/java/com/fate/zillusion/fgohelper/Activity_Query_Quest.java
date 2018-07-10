package com.fate.zillusion.fgohelper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Activity_Query_Quest extends AppCompatActivity {
    //region Value Define
    private String [][] str_Quest={
            {

            },//8
            {

            },//7
            {

            },//6
            {

            },//5
            {

            },//4
            {

            },//3
            {

            },//2
            {

            },//1
            {
                    "「炎上汚染都市：冬木」","第一節：燃える街","進行度1","第二節：霊脈地へ","進行度1","第三節：大橋を調べる","進行度1","進行度2","進行度3",
                    "第四節：港跡を調べる","進行度1","進行度2","第五節：教会跡を調べる","進行度1","進行度2","第六節：影のサーヴァント",
                    "進行度1","進行度2","進行度3","第七節：大聖杯を目指せ","進行度1","進行度2","第八節：マシュの特訓","進行度1",
                    "進行度2","進行度3","進行度4","進行度5","第九節：暗がりの洞窟","進行度1","進行度2","進行度3","第十節：大聖杯目前",
                    "進行度1","進行度2","進行度3","第十一節：グランドオーダー","進行度1"
            },//0
    };
    private String [][] img_Url={
            {},//8
            {},//7
            {},//6
            {},//5
            {},//4
            {},//3
            {},//2
            {},//1
            {},//0
    };
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__query__quest);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Advertise();

        //region Get Bundle Value
        Bundle bundle=getIntent().getExtras();
        String str_BundleQuest=bundle.getString("BundleQuest");
        int int_getQuest=Integer.valueOf(str_BundleQuest);
        //endregion
        Toast.makeText(this,str_BundleQuest,Toast.LENGTH_LONG).show();




    }
    private void Advertise()
    {
        MobileAds.initialize(this, "ca-app-pub-8418426477328402~2027922183");
        AdView mAdView = findViewById(R.id.adview_queryquest);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
