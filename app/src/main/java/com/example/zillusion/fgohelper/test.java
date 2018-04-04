package com.example.zillusion.fgohelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class test extends AppCompatActivity {
    //region TestValue
    Integer[] imgid={
            R.drawable.s001,R.drawable.s002,R.drawable.s003,R.drawable.s004,R.drawable.s005,R.drawable.s006,R.drawable.s007,R.drawable.s008,R.drawable.s009,R.drawable.s010,
            R.drawable.s011,R.drawable.s012,R.drawable.s013,R.drawable.s014,R.drawable.s015,R.drawable.s016,R.drawable.s107,R.drawable.s018,R.drawable.s019,R.drawable.s020
    };
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        RadioGroup rgp1= findViewById(R.id.RDGStage);
        RadioGroup rgp2= findViewById(R.id.RDGBStage);
        rgp1.setOnCheckedChangeListener(listener);
        rgp2.setOnCheckedChangeListener(listener);




    }


    //region BAD
    RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {


        public void onCheckedChanged(RadioGroup group, int checkedId) {

            ImageView img= findViewById(R.id.image_servent_stage);
            ImageView img1=findViewById(R.id.image_servent_BStage);
            //img.setImageResource(R.drawable.my_image);
            switch (checkedId) {
                case R.id.radioButtonS1:
                    img.setImageResource(R.drawable.test_servent01);
                    break;
                case R.id.radioButtonS2:
                    img.setImageResource(R.drawable.test_servent02);
                    break;
                case R.id.radioButtonS3:
                    img.setImageResource(R.drawable.test_servent03);
                    break;
                case R.id.radioButtonS4:
                    img.setImageResource(R.drawable.test_servent04);
                    break;
                case R.id.radioButtonS5:
                    img.setImageResource(R.drawable.test_skillicon01);
                    break;
                case R.id.radioButtonBS1:
                    img1.setImageResource(R.drawable.test_servent01);
                    break;
                case R.id.radioButtonBS2:
                    img1.setImageResource(imgid[10]);
                     break;
                case R.id.radioButtonBS3:
                    img1.setImageResource(R.drawable.test_servent03);
                     break;
            }
        }
    };
//endregion
}
