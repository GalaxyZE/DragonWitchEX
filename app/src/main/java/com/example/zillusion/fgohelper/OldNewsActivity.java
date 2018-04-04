package com.example.zillusion.fgohelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OldNewsActivity extends AppCompatActivity {
    Integer[] eventimgid={
            R.drawable.e001,R.drawable.e002,R.drawable.e003,R.drawable.e004,R.drawable.e005,R.drawable.e006,R.drawable.e007,R.drawable.e008,R.drawable.e009,R.drawable.e010
            ,R.drawable.e011,R.drawable.e012,R.drawable.e013,R.drawable.e014,R.drawable.e015,R.drawable.e016,R.drawable.e017,R.drawable.e018,R.drawable.e019,R.drawable.e020
            ,R.drawable.e021,R.drawable.e022,R.drawable.e023,R.drawable.e024,R.drawable.e025,R.drawable.e026,R.drawable.e027,R.drawable.e028,R.drawable.e029,R.drawable.e030
            ,R.drawable.e031,R.drawable.e032,R.drawable.e033,R.drawable.e034,R.drawable.e035,R.drawable.e036,R.drawable.e037,R.drawable.e038,R.drawable.e039,R.drawable.e040
            ,R.drawable.e041,R.drawable.e042,R.drawable.e043,R.drawable.e044,R.drawable.e045,R.drawable.e046,R.drawable.e047,R.drawable.e048,R.drawable.e049,R.drawable.e050
            ,R.drawable.e051,R.drawable.e052,R.drawable.e053,R.drawable.e054,R.drawable.e055,R.drawable.e056,R.drawable.e057,R.drawable.e058,R.drawable.e059,R.drawable.e060
            ,R.drawable.e061,R.drawable.e062,R.drawable.e063,R.drawable.e064,R.drawable.e065,R.drawable.e066,R.drawable.e067,R.drawable.e068,R.drawable.e069,R.drawable.e070
            ,R.drawable.e071,R.drawable.e072,R.drawable.e073,R.drawable.e074,R.drawable.e075,R.drawable.e076,R.drawable.e077,R.drawable.e078,R.drawable.e079,R.drawable.e080
            ,R.drawable.e081,R.drawable.e082,R.drawable.e083,R.drawable.e084,R.drawable.e085,R.drawable.e086,R.drawable.e087,R.drawable.e088,R.drawable.e089,R.drawable.e090
            ,R.drawable.e091,R.drawable.e092,R.drawable.e093,R.drawable.e094,R.drawable.e095,R.drawable.e096,R.drawable.e097,R.drawable.e098,R.drawable.e099,R.drawable.e100
            ,R.drawable.e101,R.drawable.e102,R.drawable.e103,R.drawable.e104,R.drawable.e105,R.drawable.e106,R.drawable.e107,R.drawable.e108,R.drawable.e109,R.drawable.e110
            ,R.drawable.e111,R.drawable.e112,R.drawable.e113,R.drawable.e114,R.drawable.e115,R.drawable.e116,R.drawable.e117,R.drawable.e118,R.drawable.e119,R.drawable.e120
            ,R.drawable.e121,R.drawable.e122,R.drawable.e123,R.drawable.e124,R.drawable.e125,R.drawable.e126,R.drawable.e127,R.drawable.e128,R.drawable.e129,R.drawable.e130
            ,R.drawable.e131,R.drawable.e132,R.drawable.e133,R.drawable.e134,R.drawable.e135,R.drawable.e136,R.drawable.e137,R.drawable.e138,R.drawable.e139,R.drawable.e140
            ,R.drawable.e141,R.drawable.e142,R.drawable.e143,R.drawable.e144,R.drawable.e145,R.drawable.e146,R.drawable.e147,R.drawable.e148,R.drawable.e149,R.drawable.e150
            ,R.drawable.e151
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_news);
        //設定隱藏標題
        getSupportActionBar().hide();
        //設定隱藏狀態
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        //region Fragment ListView

        ListView listView = (ListView) findViewById(R.id.listviewOldnews);
        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        for(int i=eventimgid.length-19;i>0;i--){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("img", Integer.toString(eventimgid[i]) );
            aList.add(hm);
        }
        String[] from = {"img"};
        int[] to = { R.id.newsimageView};
        SimpleAdapter adapter = new SimpleAdapter(this, aList, R.layout.imagelistviewlayout, from, to);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();//Inner
                Toast.makeText(getApplicationContext(),String.valueOf(+position), Toast.LENGTH_SHORT).show();//Display position

                //region 傳值
                    /*
                    Intent intent = new Intent();
                    intent.setClass(g, EventDetail.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("BundleNews", String.valueOf(+position));
                    intent.putExtras(bundle);
                    startActivity(intent);
                    */
                //endregion

            }
        });

        //endregion

    }
}
