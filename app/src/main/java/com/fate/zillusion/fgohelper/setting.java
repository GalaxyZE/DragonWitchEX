package com.fate.zillusion.fgohelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class setting extends AppCompatActivity {
    public int Selectlanguage;
    private boolean initialselect=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        super.getSupportActionBar().setDisplayHomeAsUpEnabled(true);// Backbutton
        //region Spinner
        //region readData
        String str;
        SharedPreferences settings;
        settings = getSharedPreferences("Data",0);
        str=settings.getString("SetLanguage","0");
        //endregion
        final Spinner spinner = (Spinner)findViewById(R.id.settingspinner);
        final ArrayAdapter<CharSequence> LanguageList = ArrayAdapter.createFromResource(setting.this,
                R.array.Setting_Spinner_Language,android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(LanguageList);


        try {
            spinner.setSelection(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                SharedPreferences settings;
                settings = getSharedPreferences("Data",0);
                settings.edit()
                        .putString("SetLanguage", Integer.toString(position))
                        .commit();
                Toast.makeText(setting.this,"Language changes is first applied when the progarm has been restarted.",Toast.LENGTH_SHORT).show();
                //Toast.makeText(setting.this,Integer.toString(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        //endregion

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

    public void readData(String settinglanguage){
        String str;
        SharedPreferences settings;
        settings = getSharedPreferences("Data",0);
        str=settings.getString("SetLanguage","");


    }
    public void saveData(String Language){
        SharedPreferences settings;
        settings = getSharedPreferences("Data",0);
        settings.edit()
                .putString("SetLanguage", Language)
                .commit();
    }
/*
以下程式碼會在 Fragment 內執行

寫入至共用的偏好設定
SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPref.edit();
editor.putInt(getString(R.string.saved_high_score), newHighScore);
editor.commit();

從共用的偏好設定進行讀取
SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
int defaultValue = getResources().getInteger(R.string.saved_high_score_default);
long highScore = sharedPref.getInt(getString(R.string.saved_high_score), defaultValue);
 */


}
