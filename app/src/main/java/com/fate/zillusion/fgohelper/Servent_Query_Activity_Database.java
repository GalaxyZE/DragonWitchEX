package com.fate.zillusion.fgohelper;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.fate.zillusion.fgohelper.FGO_RelateData.CommandCard;
import static com.fate.zillusion.fgohelper.FGO_RelateData.Servent_Class_Describe;
import static com.fate.zillusion.fgohelper.FGO_RelateData.icon_ServentClassSkill;
import static com.fate.zillusion.fgohelper.FGO_RelateData.imgid_ServentClass;
import static com.fate.zillusion.fgohelper.FGO_RelateData.itemname_EN;
import static com.fate.zillusion.fgohelper.FGO_RelateData.textid_Servent_Status;
import static com.fate.zillusion.fgohelper.FGO_RelateData_01.url_imgid_Servent_AF;
import static com.fate.zillusion.fgohelper.FGO_RelateData_01.url_imgid_Servent_BS;
import static com.fate.zillusion.fgohelper.FGO_RelateData_02.Skill_Describe;
import static com.fate.zillusion.fgohelper.FGO_RelateData_02.imgid_ServentSkill;
import static com.fate.zillusion.fgohelper.FGO_RelateData_03.NP_DescribeEn;
import static com.fate.zillusion.fgohelper.FGO_RelateData_03.Skill_Describe_Effect;
import static com.fate.zillusion.fgohelper.FGO_RelateData_04.img_Required_EventMaterials;
import static com.fate.zillusion.fgohelper.FGO_RelateData_04.img_Required_Materials;
import static com.fate.zillusion.fgohelper.FGO_RelateData_04.str_LanguageRequired_Materials;
import static com.fate.zillusion.fgohelper.FGO_RelateData_05.str_RequiredMaterials;
import static com.fate.zillusion.fgohelper.FGO_SkillData1.str_SkillRequiredMaterials_part1;
import static com.fate.zillusion.fgohelper.FGO_SkillData2.str_SkillRequiredMaterials_part2;
import static com.fate.zillusion.fgohelper.FGO_SkillData3.str_SkillRequiredMaterials_part3;
import static com.fate.zillusion.fgohelper.FGO_SkillData4.str_SkillRequiredMaterials_part4;
import static com.fate.zillusion.fgohelper.FGO_SkillData5.str_SkillRequiredMaterials_part5;
import static com.fate.zillusion.fgohelper.FGO_SkillData6.str_SkillRequiredMaterials_part6;
import static com.fate.zillusion.fgohelper.FGO_SkillData7.str_SkillRequiredMaterials_part7;
import static com.fate.zillusion.fgohelper.FGO_SkillData8.str_SkillRequiredMaterials_part8;
import static com.fate.zillusion.fgohelper.FGO_SkillData9.str_SkillRequiredMaterials_part9;

public class Servent_Query_Activity_Database extends AppCompatActivity {
    private Integer GetValue=null;
    private String [] itemname;
    private int selectedradio=0;
    private boolean AF,BS;
    private ProgressDialog mpg;
    private boolean initial=true;
    //https://ms0266378.github.io/fgo.query/images/android/
    //https://raw.githubusercontent.com/ms0266378/fgo.query/master/images/android/
    private String Url_Site="https://ms0266378.github.io/fgo.query/images/android/";
    private String File=".png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servent__query___net);
        super.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Servent Info");
        itemname=itemname_EN;


        //region Process
        /*
        // Create a progressdialog
        ProgressDialog mProgressDialog = new ProgressDialog(Servent_Query_Activity.this);
        // Set progressdialog title
        mProgressDialog.setTitle("Download Image Tutorial");
        // Set progressdialog message
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.setIndeterminate(false);
        // Show progressdialog
        mProgressDialog.show();
        mProgressDialog.dismiss();
        */
        //endregion

        //region 取值

        Bundle bundle = getIntent().getExtras();
        String strNoServent = bundle.getString("BundleServent");

        int intNoServent = Integer.parseInt(strNoServent);
        GetValue = intNoServent;

        //Toast.makeText(this,strNoServent, Toast.LENGTH_SHORT).show();

        //endregion


        //region RadioButton
        RadioButton RBS1 = findViewById(R.id.radioButtonS1);
        RadioButton RBS2 = findViewById(R.id.radioButtonS2);
        RadioButton RBS3 = findViewById(R.id.radioButtonS3);
        RadioButton RBS4 = findViewById(R.id.radioButtonS4);
        RadioButton RBS5 = findViewById(R.id.radioButtonS5);
        RadioButton RBS6 = findViewById(R.id.radioButtonS6);
        RadioButton RBBS1 = findViewById(R.id.radioButtonBS1);
        RadioButton RBBS2 = findViewById(R.id.radioButtonBS2);
        RadioButton RBBS3 = findViewById(R.id.radioButtonBS3);
        RadioButton RBBS4 = findViewById(R.id.radioButtonBS4);
        RadioGroup rgp1 = findViewById(R.id.RDGStage);
        RadioGroup rgp2 = findViewById(R.id.RDGBStage);

        try {
            rgp1.setOnCheckedChangeListener(listener);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            rgp2.setOnCheckedChangeListener(listener);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //endregion

        // RBS1.setChecked(true);
        // RBBS1.setChecked(true);

        //region Stage_Check Function
        for (int i = 0; i < 6; i++) {
            if (url_imgid_Servent_AF[GetValue][i] == null) {
                switch (i) {
                    case 0:
                        RBS1.setEnabled(false);
                        break;
                    case 1:
                        RBS2.setEnabled(false);
                        break;
                    case 2:
                        RBS3.setEnabled(false);
                        break;
                    case 3:
                        RBS4.setEnabled(false);
                        break;
                    case 4:
                        RBS5.setEnabled(false);
                        break;
                    case 5:
                        RBS6.setEnabled(false);
                        break;
                    default:
                        break;
                }
            }
        }

        RBS1.setChecked(true);
        RBBS1.setChecked(true);
        //endregion
        //region Stage2 Check Function
        for (int i = 0; i < 4; i++) {
            if (url_imgid_Servent_BS[GetValue][i] == null) {
                switch (i) {
                    case 0:
                        RBBS1.setEnabled(false);
                        break;
                    case 1:
                        RBBS2.setEnabled(false);
                        break;
                    case 2:
                        RBBS3.setEnabled(false);
                        break;
                    case 3:
                        RBBS4.setEnabled(false);
                        break;
                }
            }
        }
        //endregion

        //region ImageView Onclick
        final ImageView img_Servent=(ImageView) findViewById(R.id.image_servent_stage);
        img_Servent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent img_ActShow=new Intent();
                img_ActShow.setClass(Servent_Query_Activity_Database.this,img_Servent_Zoom.class);


                Bitmap bitmap=((BitmapDrawable)img_Servent.getDrawable()).getBitmap();
                if (createImageFromBitmap(bitmap)!=null)
                {
                    try {
                        startActivity(img_ActShow);
                    } catch (Exception e) {
                        String TAG = "---ImageView Button---";
                        Log.d(TAG, "onClick: " + e);
                    }
                }
            }
        });
        //endregion

        Advertise();
        Data_Management();

    }


    //region RadioButtonGroup
    RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {

        public void onCheckedChanged(RadioGroup group, int checkedId) {

            mpg=new ProgressDialog(Servent_Query_Activity_Database.this);
            mpg.setTitle("Please Wait");
            mpg.setMessage("Loading...");
            mpg.setIndeterminate(false);
            mpg.setCancelable(true);
            if (!initial)
                mpg.show();
            switch (checkedId) {
                case R.id.radioButtonS1:
                    if (url_imgid_Servent_AF[GetValue][0]!=null)
                    {
                        AF=true;
                        selectedradio=1;
                        //img_AF.setImageResource(imgid_Servent_AF[GetValue][0]);
                        new MyAsyncTask().execute(Url_Site+url_imgid_Servent_AF[GetValue][0]+File);
                    }
                    break;
                case R.id.radioButtonS2:
                    if (url_imgid_Servent_AF[GetValue][1]!=null)
                    {
                        AF=true;
                        selectedradio=2;
                        new MyAsyncTask().execute(Url_Site+url_imgid_Servent_AF[GetValue][1]+File);
                    }

                    break;
                case R.id.radioButtonS3:
                    if (url_imgid_Servent_AF[GetValue][2]!=null)
                    {
                        AF=true;
                        selectedradio=3;
                        new MyAsyncTask().execute(Url_Site+url_imgid_Servent_AF[GetValue][2]+File);
                    }
                    break;
                case R.id.radioButtonS4:
                    if (url_imgid_Servent_AF[GetValue][3]!=null)
                    {
                        AF=true;
                        selectedradio=4;
                        new MyAsyncTask().execute(Url_Site+url_imgid_Servent_AF[GetValue][3]+File);
                    }
                    break;
                case R.id.radioButtonS5:
                    if (url_imgid_Servent_AF[GetValue][4]!=null)
                    {
                        AF=true;
                        selectedradio=5;
                        new MyAsyncTask().execute(Url_Site+url_imgid_Servent_AF[GetValue][4]+File);
                    }
                    break;
                case R.id.radioButtonS6:
                    if (url_imgid_Servent_AF[GetValue][5]!=null)
                    {
                        AF=true;
                        selectedradio=1;
                        new MyAsyncTask().execute(Url_Site+url_imgid_Servent_AF[GetValue][5]+File);
                    }
                    break;

                case R.id.radioButtonBS1:
                    if (url_imgid_Servent_BS[GetValue][0]!=null)
                    {
                        BS=true;
                        selectedradio=1;
                        new MyAsyncTask().execute(Url_Site+url_imgid_Servent_BS[GetValue][0]+File);
                    }
                    break;
                case R.id.radioButtonBS2:
                    if (url_imgid_Servent_BS[GetValue][1]!=null)
                    {
                        BS=true;
                        selectedradio=2;
                        new MyAsyncTask().execute(Url_Site+url_imgid_Servent_BS[GetValue][1]+File);
                    }
                    break;
                case R.id.radioButtonBS3:
                    if (url_imgid_Servent_BS[GetValue][2]!=null)
                    {
                        BS=true;
                        selectedradio=3;
                        new MyAsyncTask().execute(Url_Site+url_imgid_Servent_BS[GetValue][2]+File);
                    }
                    break;
                case R.id.radioButtonBS4:
                    if (url_imgid_Servent_BS[GetValue][3]!=null)
                    {
                        BS=true;
                        selectedradio=4;
                        new MyAsyncTask().execute(Url_Site+url_imgid_Servent_BS[GetValue][3]+File);
                    }
                    break;
                default:

                    break;
            }
            initial=false;
        }
    };
    //endregion
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {// Backbutton
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here
                Intent intent = new Intent(Servent_Query_Activity_Database.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                //startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void Data_Management() {
        //region 變數宣告

        //region Status-region
        TextView StatusName = (TextView) findViewById(R.id.StatusNameEditTextview);
        TextView StatusNo = (TextView) findViewById(R.id.StatusNoEditTextview);
        TextView StatusRarity = (TextView) findViewById(R.id.Status_Rarity_EditTextView);
        TextView StatusClass = (TextView) findViewById(R.id.Status_Class_EditTextView);
        TextView StatusATK1 = (TextView) findViewById(R.id.Status_AtkLV1_EditTextView);
        TextView StatusHP1 = (TextView) findViewById(R.id.Status_HPLV1_EditTextView);
        TextView StatusATK90 = (TextView) findViewById(R.id.Status_AtkLV90_EditTextView);
        TextView StatusHP90 = (TextView) findViewById(R.id.Status_HPLV90_EditTextView);
        TextView StatusATK100 = (TextView) findViewById(R.id.Status_AtkLV100_EditTextView);
        TextView StatusHP100 = (TextView) findViewById(R.id.Status_HPLV100_EditTextView);
        TextView StatusCost = (TextView) findViewById(R.id.Status_CostEditTextView);
        TextView StatusMaxLV = (TextView) findViewById(R.id.Status_MaxLVEditTextView);
        String Star = "";
        //img
        ImageView img_StatusClass = (ImageView) findViewById(R.id.img_Status_Class);
        //endregion

        //region Servent_Skill
        ImageView img_ServentSkill01 = (ImageView) findViewById(R.id.img_Skill_01);
        ImageView img_ServentSkill02 = (ImageView) findViewById(R.id.img_Skill_02);
        ImageView img_ServentSkill03 = (ImageView) findViewById(R.id.img_Skill_03);
        TextView edit_ServentSkill01 = (TextView) findViewById(R.id.Skill_Describe01);
        TextView edit_ServentSkill02 = (TextView) findViewById(R.id.Skill_Describe02);
        TextView edit_ServentSkill11 = (TextView) findViewById(R.id.Skill_Describe11);
        TextView edit_ServentSkill12 = (TextView) findViewById(R.id.Skill_Describe12);
        TextView edit_ServentSkill21 = (TextView) findViewById(R.id.Skill_Describe21);
        TextView edit_ServentSkill22 = (TextView) findViewById(R.id.Skill_Describe22);

        TextView editSkillEffect001 = (TextView) findViewById(R.id.EditSkillLv01);
        TextView editSkillEffect002 = (TextView) findViewById(R.id.EditSkillLv02);
        TextView editSkillEffect003 = (TextView) findViewById(R.id.EditSkillLv03);
        TextView editSkillEffect004 = (TextView) findViewById(R.id.EditSkillLv04);
        TextView editSkillEffect005 = (TextView) findViewById(R.id.EditSkillLv05);
        TextView editSkillEffect006 = (TextView) findViewById(R.id.EditSkillLv06);
        TextView editSkillEffect007 = (TextView) findViewById(R.id.EditSkillLv07);
        TextView editSkillEffect008 = (TextView) findViewById(R.id.EditSkillLv08);
        TextView editSkillEffect009 = (TextView) findViewById(R.id.EditSkillLv09);
        TextView editSkillEffect010 = (TextView) findViewById(R.id.EditSkillLv10);

        TextView editSkillEffect101 = (TextView) findViewById(R.id.EditSkillLv11);
        TextView editSkillEffect102 = (TextView) findViewById(R.id.EditSkillLv12);
        TextView editSkillEffect103 = (TextView) findViewById(R.id.EditSkillLv13);
        TextView editSkillEffect104 = (TextView) findViewById(R.id.EditSkillLv14);
        TextView editSkillEffect105 = (TextView) findViewById(R.id.EditSkillLv15);
        TextView editSkillEffect106 = (TextView) findViewById(R.id.EditSkillLv16);
        TextView editSkillEffect107 = (TextView) findViewById(R.id.EditSkillLv17);
        TextView editSkillEffect108 = (TextView) findViewById(R.id.EditSkillLv18);
        TextView editSkillEffect109 = (TextView) findViewById(R.id.EditSkillLv19);
        TextView editSkillEffect110 = (TextView) findViewById(R.id.EditSkillLv110);

        TextView editSkillEffect201 = (TextView) findViewById(R.id.EditSkillLv21);
        TextView editSkillEffect202 = (TextView) findViewById(R.id.EditSkillLv22);
        TextView editSkillEffect203 = (TextView) findViewById(R.id.EditSkillLv23);
        TextView editSkillEffect204 = (TextView) findViewById(R.id.EditSkillLv24);
        TextView editSkillEffect205 = (TextView) findViewById(R.id.EditSkillLv25);
        TextView editSkillEffect206 = (TextView) findViewById(R.id.EditSkillLv26);
        TextView editSkillEffect207 = (TextView) findViewById(R.id.EditSkillLv27);
        TextView editSkillEffect208 = (TextView) findViewById(R.id.EditSkillLv28);
        TextView editSkillEffect209 = (TextView) findViewById(R.id.EditSkillLv29);
        TextView editSkillEffect210 = (TextView) findViewById(R.id.EditSkillLv210);
        //endregion

        //region Servent Class_Skill Define
        ImageView img_CalssSkill01 = (ImageView) findViewById(R.id.img_ClassSkill01);
        ImageView img_CalssSkill02 = (ImageView) findViewById(R.id.img_ClassSkill02);
        ImageView img_CalssSkill03 = (ImageView) findViewById(R.id.img_ClassSkill03);
        ImageView img_CalssSkill04 = (ImageView) findViewById(R.id.img_ClassSkill04);
        TextView editClassSkill01 = (TextView) findViewById(R.id.Edit_ClassSkill01);
        TextView editClassSkill02 = (TextView) findViewById(R.id.Edit_ClassSkill02);
        TextView editClassSkill03 = (TextView) findViewById(R.id.Edit_ClassSkill03);
        TextView editClassSkill04 = (TextView) findViewById(R.id.Edit_ClassSkill04);


        // img initial values
        //img_CalssSkill01.setImageResource(android.R.color.transparent);//Image Clear


        //text initial values
        editClassSkill01.setText("");
        editClassSkill02.setText("");
        editClassSkill03.setText("");
        editClassSkill04.setText("");


        //endregion

        //region CommandCard

        ImageView img_CommandCard_01 = (ImageView) findViewById(R.id.img_CommandCard_01);
        ImageView img_CommandCard_02 = (ImageView) findViewById(R.id.img_CommandCard_02);
        ImageView img_CommandCard_03 = (ImageView) findViewById(R.id.img_CommandCard_03);
        ImageView img_CommandCard_04 = (ImageView) findViewById(R.id.img_CommandCard_04);
        ImageView img_CommandCard_05 = (ImageView) findViewById(R.id.img_CommandCard_05);


        //endregion


        //region NP_寶具
        TextView editNP_Name = (TextView) findViewById(R.id.Status_NPName_EditTextView);
        TextView editNP_Rank = (TextView) findViewById(R.id.Status_Rank_EditTextView);
        TextView editNP_Target = (TextView) findViewById(R.id.Status_Rank_Target_EditTextView);

        TextView editNP_Descriibe = (TextView) findViewById(R.id.NP_Describe);
        TextView editNP_Name1 = (TextView) findViewById(R.id.Status_NPName_EditTextView01);
        TextView editNP_Rank1 = (TextView) findViewById(R.id.Status_Rank_EditTextView01);
        TextView editNP_Target1 = (TextView) findViewById(R.id.Status_Rank_Target_EditTextView01);

        TextView editNP_LV01 = (TextView) findViewById(R.id.NPLV_EditTextView1);
        TextView editNP_LV02 = (TextView) findViewById(R.id.NPLV_EditTextView2);
        TextView editNP_LV03 = (TextView) findViewById(R.id.NPLV_EditTextView3);
        TextView editNP_LV04 = (TextView) findViewById(R.id.NPLV_EditTextView4);
        TextView editNP_LV05 = (TextView) findViewById(R.id.NPLV_EditTextView5);

        TextView editNP_LV11 = (TextView) findViewById(R.id.NPLV_EditTextView11);
        TextView editNP_LV12 = (TextView) findViewById(R.id.NPLV_EditTextView12);
        TextView editNP_LV13 = (TextView) findViewById(R.id.NPLV_EditTextView13);
        TextView editNP_LV14 = (TextView) findViewById(R.id.NPLV_EditTextView14);
        TextView editNP_LV15 = (TextView) findViewById(R.id.NPLV_EditTextView15);

        ImageView img_NP1 = (ImageView) findViewById(R.id.img_NoblePhantasm);
        ImageView img_NP2 = (ImageView) findViewById(R.id.img_NoblePhantasm01);

        //region Layout
        final ViewGroup.LayoutParams editNP_Namp_Layout = editNP_Name.getLayoutParams();
        final ViewGroup.LayoutParams editNP_Rank_Layout = editNP_Rank.getLayoutParams();
        final ViewGroup.LayoutParams editNP_Target_Layout = editNP_Target.getLayoutParams();
        final ViewGroup.LayoutParams editNP_Descriibe_Layout = editNP_Descriibe.getLayoutParams();
        final ViewGroup.LayoutParams editNP_Name1_Layout = editNP_Name1.getLayoutParams();
        final ViewGroup.LayoutParams editNP_Rank1_Layout = editNP_Rank1.getLayoutParams();
        final ViewGroup.LayoutParams editNP_Target1_Layout = editNP_Target1.getLayoutParams();

        final ViewGroup.LayoutParams editNP_LV01_Layout = editNP_LV01.getLayoutParams();
        final ViewGroup.LayoutParams editNP_LV02_Layout = editNP_LV02.getLayoutParams();
        final ViewGroup.LayoutParams editNP_LV03_Layout = editNP_LV03.getLayoutParams();
        final ViewGroup.LayoutParams editNP_LV04_Layout = editNP_LV04.getLayoutParams();
        final ViewGroup.LayoutParams editNP_LV05_Layout = editNP_LV05.getLayoutParams();

        final ViewGroup.LayoutParams editNP_LV11_Layout = editNP_LV11.getLayoutParams();
        final ViewGroup.LayoutParams editNP_LV12_Layout = editNP_LV12.getLayoutParams();
        final ViewGroup.LayoutParams editNP_LV13_Layout = editNP_LV13.getLayoutParams();
        final ViewGroup.LayoutParams editNP_LV14_Layout = editNP_LV14.getLayoutParams();
        final ViewGroup.LayoutParams editNP_LV15_Layout = editNP_LV15.getLayoutParams();

        final ViewGroup.LayoutParams img_NP1_Layout = img_NP1.getLayoutParams();
        final ViewGroup.LayoutParams img_NP2_Layout = img_NP2.getLayoutParams();
        //endregion

        //endregion

        //region 技能素材
        final ImageView img_SkillMaterials00 = (ImageView) findViewById(R.id.img_SkillMaterials00);
        final ImageView img_SkillMaterials01 = (ImageView) findViewById(R.id.img_SkillMaterials01);
        final ImageView img_SkillMaterials02 = (ImageView) findViewById(R.id.img_SkillMaterials02);
        final ImageView img_SkillMaterials03 = (ImageView) findViewById(R.id.img_SkillMaterials03);
        final ImageView img_SkillMaterials10 = (ImageView) findViewById(R.id.img_SkillMaterials10);
        final ImageView img_SkillMaterials11 = (ImageView) findViewById(R.id.img_SkillMaterials11);
        final ImageView img_SkillMaterials12 = (ImageView) findViewById(R.id.img_SkillMaterials12);
        final ImageView img_SkillMaterials13 = (ImageView) findViewById(R.id.img_SkillMaterials13);
        final ImageView img_SkillMaterials20 = (ImageView) findViewById(R.id.img_SkillMaterials20);
        final ImageView img_SkillMaterials21 = (ImageView) findViewById(R.id.img_SkillMaterials21);
        final ImageView img_SkillMaterials22 = (ImageView) findViewById(R.id.img_SkillMaterials22);
        final ImageView img_SkillMaterials23 = (ImageView) findViewById(R.id.img_SkillMaterials23);
        final ImageView img_SkillMaterials30 = (ImageView) findViewById(R.id.img_SkillMaterials30);
        final ImageView img_SkillMaterials31 = (ImageView) findViewById(R.id.img_SkillMaterials31);
        final ImageView img_SkillMaterials32 = (ImageView) findViewById(R.id.img_SkillMaterials32);
        final ImageView img_SkillMaterials33 = (ImageView) findViewById(R.id.img_SkillMaterials33);
        final ImageView img_SkillMaterials40 = (ImageView) findViewById(R.id.img_SkillMaterials40);
        final ImageView img_SkillMaterials41 = (ImageView) findViewById(R.id.img_SkillMaterials41);
        final ImageView img_SkillMaterials42 = (ImageView) findViewById(R.id.img_SkillMaterials42);
        final ImageView img_SkillMaterials43 = (ImageView) findViewById(R.id.img_SkillMaterials43);
        final ImageView img_SkillMaterials50 = (ImageView) findViewById(R.id.img_SkillMaterials50);
        final ImageView img_SkillMaterials51 = (ImageView) findViewById(R.id.img_SkillMaterials51);
        final ImageView img_SkillMaterials52 = (ImageView) findViewById(R.id.img_SkillMaterials52);
        final ImageView img_SkillMaterials53 = (ImageView) findViewById(R.id.img_SkillMaterials53);
        final ImageView img_SkillMaterials60 = (ImageView) findViewById(R.id.img_SkillMaterials60);
        final ImageView img_SkillMaterials61 = (ImageView) findViewById(R.id.img_SkillMaterials61);
        final ImageView img_SkillMaterials62 = (ImageView) findViewById(R.id.img_SkillMaterials62);
        final ImageView img_SkillMaterials63 = (ImageView) findViewById(R.id.img_SkillMaterials63);
        final ImageView img_SkillMaterials70 = (ImageView) findViewById(R.id.img_SkillMaterials70);
        final ImageView img_SkillMaterials71 = (ImageView) findViewById(R.id.img_SkillMaterials71);
        final ImageView img_SkillMaterials72 = (ImageView) findViewById(R.id.img_SkillMaterials72);
        final ImageView img_SkillMaterials73 = (ImageView) findViewById(R.id.img_SkillMaterials73);
        final ImageView img_SkillMaterials80 = (ImageView) findViewById(R.id.img_SkillMaterials80);
        final ImageView img_SkillMaterials81 = (ImageView) findViewById(R.id.img_SkillMaterials81);
        final ImageView img_SkillMaterials82 = (ImageView) findViewById(R.id.img_SkillMaterials82);
        final ImageView img_SkillMaterials83 = (ImageView) findViewById(R.id.img_SkillMaterials83);

        final TextView Edit_SkillMaterials00 = (TextView) findViewById(R.id.Edit_SkillMaterials00);
        final TextView Edit_SkillMaterials01 = (TextView) findViewById(R.id.Edit_SkillMaterials01);
        final TextView Edit_SkillMaterials02 = (TextView) findViewById(R.id.Edit_SkillMaterials02);
        final TextView Edit_SkillMaterials03 = (TextView) findViewById(R.id.Edit_SkillMaterials03);
        final TextView Edit_SkillMaterials10 = (TextView) findViewById(R.id.Edit_SkillMaterials10);
        final TextView Edit_SkillMaterials11 = (TextView) findViewById(R.id.Edit_SkillMaterials11);
        final TextView Edit_SkillMaterials12 = (TextView) findViewById(R.id.Edit_SkillMaterials12);
        final TextView Edit_SkillMaterials13 = (TextView) findViewById(R.id.Edit_SkillMaterials13);
        final TextView Edit_SkillMaterials20 = (TextView) findViewById(R.id.Edit_SkillMaterials20);
        final TextView Edit_SkillMaterials21 = (TextView) findViewById(R.id.Edit_SkillMaterials21);
        final TextView Edit_SkillMaterials22 = (TextView) findViewById(R.id.Edit_SkillMaterials22);
        final TextView Edit_SkillMaterials23 = (TextView) findViewById(R.id.Edit_SkillMaterials23);
        final TextView Edit_SkillMaterials30 = (TextView) findViewById(R.id.Edit_SkillMaterials30);
        final TextView Edit_SkillMaterials31 = (TextView) findViewById(R.id.Edit_SkillMaterials31);
        final TextView Edit_SkillMaterials32 = (TextView) findViewById(R.id.Edit_SkillMaterials32);
        final TextView Edit_SkillMaterials33 = (TextView) findViewById(R.id.Edit_SkillMaterials33);
        final TextView Edit_SkillMaterials40 = (TextView) findViewById(R.id.Edit_SkillMaterials40);
        final TextView Edit_SkillMaterials41 = (TextView) findViewById(R.id.Edit_SkillMaterials41);
        final TextView Edit_SkillMaterials42 = (TextView) findViewById(R.id.Edit_SkillMaterials42);
        final TextView Edit_SkillMaterials43 = (TextView) findViewById(R.id.Edit_SkillMaterials43);
        final TextView Edit_SkillMaterials50 = (TextView) findViewById(R.id.Edit_SkillMaterials50);
        final TextView Edit_SkillMaterials51 = (TextView) findViewById(R.id.Edit_SkillMaterials51);
        final TextView Edit_SkillMaterials52 = (TextView) findViewById(R.id.Edit_SkillMaterials52);
        final TextView Edit_SkillMaterials53 = (TextView) findViewById(R.id.Edit_SkillMaterials53);
        final TextView Edit_SkillMaterials60 = (TextView) findViewById(R.id.Edit_SkillMaterials60);
        final TextView Edit_SkillMaterials61 = (TextView) findViewById(R.id.Edit_SkillMaterials61);
        final TextView Edit_SkillMaterials62 = (TextView) findViewById(R.id.Edit_SkillMaterials62);
        final TextView Edit_SkillMaterials63 = (TextView) findViewById(R.id.Edit_SkillMaterials63);
        final TextView Edit_SkillMaterials70 = (TextView) findViewById(R.id.Edit_SkillMaterials70);
        final TextView Edit_SkillMaterials71 = (TextView) findViewById(R.id.Edit_SkillMaterials71);
        final TextView Edit_SkillMaterials72 = (TextView) findViewById(R.id.Edit_SkillMaterials72);
        final TextView Edit_SkillMaterials73 = (TextView) findViewById(R.id.Edit_SkillMaterials73);
        final TextView Edit_SkillMaterials80 = (TextView) findViewById(R.id.Edit_SkillMaterials80);
        final TextView Edit_SkillMaterials81 = (TextView) findViewById(R.id.Edit_SkillMaterials81);
        final TextView Edit_SkillMaterials82 = (TextView) findViewById(R.id.Edit_SkillMaterials82);
        final TextView Edit_SkillMaterials83 = (TextView) findViewById(R.id.Edit_SkillMaterials83);
        final TextView Edit_SkillQP0=(TextView) findViewById(R.id.Edit_SkillMaterials_QP0);
        final TextView Edit_SkillQP1=(TextView) findViewById(R.id.Edit_SkillMaterials_QP1);
        final TextView Edit_SkillQP2=(TextView) findViewById(R.id.Edit_SkillMaterials_QP2);
        final TextView Edit_SkillQP3=(TextView) findViewById(R.id.Edit_SkillMaterials_QP3);
        final TextView Edit_SkillQP4=(TextView) findViewById(R.id.Edit_SkillMaterials_QP4);
        final TextView Edit_SkillQP5=(TextView) findViewById(R.id.Edit_SkillMaterials_QP5);
        final TextView Edit_SkillQP6=(TextView) findViewById(R.id.Edit_SkillMaterials_QP6);
        final TextView Edit_SkillQP7=(TextView) findViewById(R.id.Edit_SkillMaterials_QP7);
        final TextView Edit_SkillQP8=(TextView) findViewById(R.id.Edit_SkillMaterials_QP8);
        Edit_SkillQP0.setText("");
        Edit_SkillQP1.setText("");
        Edit_SkillQP2.setText("");
        Edit_SkillQP3.setText("");
        Edit_SkillQP4.setText("");
        Edit_SkillQP5.setText("");
        Edit_SkillQP6.setText("");
        Edit_SkillQP7.setText("");
        Edit_SkillQP8.setText("");
        Edit_SkillMaterials00.setText("");
        Edit_SkillMaterials10.setText("");
        Edit_SkillMaterials20.setText("");
        Edit_SkillMaterials30.setText("");
        Edit_SkillMaterials40.setText("");
        Edit_SkillMaterials50.setText("");
        Edit_SkillMaterials60.setText("");
        Edit_SkillMaterials70.setText("");
        Edit_SkillMaterials80.setText("");

        //endregion

        //region 靈基素材
        final ImageView img_item_AM01 = (ImageView) findViewById(R.id.img_item_AM01);
        final ImageView img_item_AM02 = (ImageView) findViewById(R.id.img_item_AM02);
        final ImageView img_item_AM03 = (ImageView) findViewById(R.id.img_item_AM03);
        final ImageView img_item_AM04 = (ImageView) findViewById(R.id.img_item_AM04);
        final ImageView img_item_AM11 = (ImageView) findViewById(R.id.img_item_AM11);
        final ImageView img_item_AM12 = (ImageView) findViewById(R.id.img_item_AM12);
        final ImageView img_item_AM13 = (ImageView) findViewById(R.id.img_item_AM13);
        final ImageView img_item_AM14 = (ImageView) findViewById(R.id.img_item_AM14);
        final ImageView img_item_AM21 = (ImageView) findViewById(R.id.img_item_AM21);
        final ImageView img_item_AM22 = (ImageView) findViewById(R.id.img_item_AM22);
        final ImageView img_item_AM23 = (ImageView) findViewById(R.id.img_item_AM23);
        final ImageView img_item_AM24 = (ImageView) findViewById(R.id.img_item_AM24);
        final ImageView img_item_AM31 = (ImageView) findViewById(R.id.img_item_AM31);
        final ImageView img_item_AM32 = (ImageView) findViewById(R.id.img_item_AM32);
        final ImageView img_item_AM33 = (ImageView) findViewById(R.id.img_item_AM33);
        final ImageView img_item_AM34 = (ImageView) findViewById(R.id.img_item_AM34);
        final TextView EditItemAM00 = (TextView) findViewById(R.id.EditItemAM00);
        final TextView EditItemAM01 = (TextView) findViewById(R.id.EditItemAM01);
        final TextView EditItemAM02 = (TextView) findViewById(R.id.EditItemAM02);
        final TextView EditItemAM03 = (TextView) findViewById(R.id.EditItemAM03);
        final TextView EditItemAM10 = (TextView) findViewById(R.id.EditItemAM10);
        final TextView EditItemAM11 = (TextView) findViewById(R.id.EditItemAM11);
        final TextView EditItemAM12 = (TextView) findViewById(R.id.EditItemAM12);
        final TextView EditItemAM13 = (TextView) findViewById(R.id.EditItemAM13);
        final TextView EditItemAM20 = (TextView) findViewById(R.id.EditItemAM20);
        final TextView EditItemAM21 = (TextView) findViewById(R.id.EditItemAM21);
        final TextView EditItemAM22 = (TextView) findViewById(R.id.EditItemAM22);
        final TextView EditItemAM23 = (TextView) findViewById(R.id.EditItemAM23);
        final TextView EditItemAM30 = (TextView) findViewById(R.id.EditItemAM30);
        final TextView EditItemAM31 = (TextView) findViewById(R.id.EditItemAM31);
        final TextView EditItemAM32 = (TextView) findViewById(R.id.EditItemAM32);
        final TextView EditItemAM33 = (TextView) findViewById(R.id.EditItemAM33);
        final TextView EditQP01_down = (TextView) findViewById(R.id.EditItemAMQP00);
        final TextView EditQP02_down = (TextView) findViewById(R.id.EditItemAMQP10);
        final TextView EditQP03_down = (TextView) findViewById(R.id.EditItemAMQP20);
        final TextView EditQP04_down = (TextView) findViewById(R.id.EditItemAMQP30);
        final TextView EditQP01=(TextView) findViewById(R.id.EditAM02);
        final TextView EditQP02=(TextView) findViewById(R.id.EditAM12);
        final TextView EditQP03=(TextView) findViewById(R.id.EditAM22);
        final TextView EditQP04=(TextView) findViewById(R.id.EditAM32);

        EditQP01_down.setText("");
        EditQP02_down.setText("");
        EditQP03_down.setText("");
        EditQP04_down.setText("");

        img_item_AM01.setImageBitmap(null);
        img_item_AM11.setImageBitmap(null);
        img_item_AM21.setImageBitmap(null);
        img_item_AM31.setImageBitmap(null);

        EditItemAM00.setText("");
        EditItemAM10.setText("");
        EditItemAM20.setText("");
        EditItemAM30.setText("");

        EditQP01.setText("");
        EditQP02.setText("");
        EditQP03.setText("");
        EditQP04.setText("");

        //endregion


        //region Data_mangement

        //region Servent Status_狀態-名稱-編號-等...
        //{No,Rarity,Class,StatusATKLV1,Status_HPLV1,StatusATKFinal,Status_HPFinal,StatusATKLV100,Status_HPLV100,COST,MAX LV}
        StatusNo.setText(textid_Servent_Status[GetValue][0]);
        StatusATK1.setText(textid_Servent_Status[GetValue][3]);
        StatusHP1.setText(textid_Servent_Status[GetValue][4]);
        StatusATK100.setText(textid_Servent_Status[GetValue][7]);
        StatusHP100.setText(textid_Servent_Status[GetValue][8]);
        StatusName.setText(itemname[GetValue]);
        StatusCost.setText(textid_Servent_Status[GetValue][9]);
        StatusMaxLV.setText(textid_Servent_Status[GetValue][10]);
        //StatusRarity.setText(textid_Servent_Status[GetValue][1]+"★");
        if (textid_Servent_Status[GetValue][1] != "?") {
            for (int i = 0; i < Integer.parseInt(textid_Servent_Status[GetValue][1]); i++) {
                Star += "★";
            }
            StatusRarity.setText(Star);
        } else {
            StatusRarity.setText("Unknow");
        }
        if (textid_Servent_Status[GetValue][10] != "90" && textid_Servent_Status[GetValue][10] != "?") {
            TextView _90atkTitle = (TextView) findViewById(R.id.StatusATKLV90);
            TextView _90HPTitle = (TextView) findViewById(R.id.Status_HPLV90);
            _90atkTitle.setText("Atk Lv." + textid_Servent_Status[GetValue][10]);
            _90HPTitle.setText("HP Lv." + textid_Servent_Status[GetValue][10]);
            StatusATK90.setText(textid_Servent_Status[GetValue][5]);
            StatusHP90.setText(textid_Servent_Status[GetValue][6]);
        } else if (textid_Servent_Status[GetValue][10] != "?") {
            StatusATK90.setText(textid_Servent_Status[GetValue][5]);
            StatusHP90.setText(textid_Servent_Status[GetValue][6]);
        } else if (textid_Servent_Status[GetValue][10] == "?") {
            StatusATK90.setText("Unknow");
            StatusHP90.setText("Unknow");
        }


        //region Switch Class
        switch (textid_Servent_Status[GetValue][2]) {
            //Saber   archer   lancer  rider   caster   assassin  Berserker    shielder  ruler    avenger  alterego      mooncancer    foreinger     beast

            case "1":
                StatusClass.setText("Saber");
                img_StatusClass.setImageResource(imgid_ServentClass[0]);
                break;
            case "2":
                StatusClass.setText("Archer");
                img_StatusClass.setImageResource(imgid_ServentClass[1]);
                break;

            case "3":
                StatusClass.setText("Lancer");
                img_StatusClass.setImageResource(imgid_ServentClass[2]);
                break;
            case "4":
                StatusClass.setText("Rider");
                img_StatusClass.setImageResource(imgid_ServentClass[3]);
                break;

            case "5":
                StatusClass.setText("Caster");
                img_StatusClass.setImageResource(imgid_ServentClass[4]);
                break;

            case "6":
                StatusClass.setText("Assassin");
                img_StatusClass.setImageResource(imgid_ServentClass[5]);
                break;

            case "7":
                StatusClass.setText("Berserker");
                img_StatusClass.setImageResource(imgid_ServentClass[6]);
                break;

            case "8":
                StatusClass.setText("Shielder");
                img_StatusClass.setImageResource(imgid_ServentClass[7]);
                break;

            case "9":
                StatusClass.setText("Ruler");
                img_StatusClass.setImageResource(imgid_ServentClass[8]);
                break;

            case "10":
                StatusClass.setText("Avenger");
                img_StatusClass.setImageResource(imgid_ServentClass[9]);
                break;

            case "11":
                StatusClass.setText("Alterego");
                img_StatusClass.setImageResource(imgid_ServentClass[10]);
                break;

            case "12":
                StatusClass.setText("Mooncancer");
                img_StatusClass.setImageResource(imgid_ServentClass[11]);
                break;

            case "13":
                StatusClass.setText("Foreinger");
                img_StatusClass.setImageResource(imgid_ServentClass[12]);
                break;

            case "14":
                StatusClass.setText("Beast");
                img_StatusClass.setImageResource(imgid_ServentClass[13]);
                break;

            default:
                StatusClass.setText("Unknow");
                img_StatusClass.setImageResource(R.drawable.null_caster);
                break;
        }
        //endregion


        //endregion


        //region Servent_Skill --技能區塊

        //region Image
        for (int i = 0; i < 3; i++) {
            if (imgid_ServentSkill[GetValue][i] != null) {
                switch (i) {
                    case 0:
                        img_ServentSkill01.setImageResource(imgid_ServentSkill[GetValue][i]);
                        break;
                    case 1:
                        img_ServentSkill02.setImageResource(imgid_ServentSkill[GetValue][i]);
                        break;
                    case 2:
                        img_ServentSkill03.setImageResource(imgid_ServentSkill[GetValue][i]);
                        break;
                }
            } else {
                switch (i) {
                    case 0:
                        img_ServentSkill01.setImageResource(R.drawable.icon_skill_090);
                        break;
                    case 1:
                        img_ServentSkill02.setImageResource(R.drawable.icon_skill_090);
                        break;
                    case 2:
                        img_ServentSkill03.setImageResource(R.drawable.icon_skill_090);
                        break;
                }
            }
        }

        //endregion

        //region Describe
        for (int i = 0; i < 6; i++) {
            if (Skill_Describe[GetValue][i] != null) {
                switch (i) {
                    case 0:
                        edit_ServentSkill01.setText(Skill_Describe[GetValue][i]);
                        break;
                    case 1:
                        edit_ServentSkill02.setText(Skill_Describe[GetValue][i]);
                        break;
                    case 2:
                        edit_ServentSkill11.setText(Skill_Describe[GetValue][i]);
                        break;
                    case 3:
                        edit_ServentSkill12.setText(Skill_Describe[GetValue][i]);
                        break;
                    case 4:
                        edit_ServentSkill21.setText(Skill_Describe[GetValue][i]);
                        break;
                    case 5:
                        edit_ServentSkill22.setText(Skill_Describe[GetValue][i]);
                        break;

                }
            } else {
                switch (i) {
                    case 0:
                        edit_ServentSkill01.setText("");
                        break;
                    case 1:
                        edit_ServentSkill02.setText("");
                        break;
                    case 2:
                        edit_ServentSkill11.setText("");
                        break;
                    case 3:
                        edit_ServentSkill12.setText("");
                        break;
                    case 4:
                        edit_ServentSkill21.setText("");
                        break;
                    case 5:
                        edit_ServentSkill22.setText("");
                        break;

                }
            }
        }

        //endregion

        //region Skill Effect
        for (int i = 0; i < 30; i++) {
            if (Skill_Describe_Effect[GetValue][i] != null) {
                //region switch
                switch (i) {
                    case 0:
                        editSkillEffect001.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 1:
                        editSkillEffect002.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 2:
                        editSkillEffect003.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 3:
                        editSkillEffect004.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 4:
                        editSkillEffect005.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 5:
                        editSkillEffect006.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 6:
                        editSkillEffect007.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 7:
                        editSkillEffect008.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 8:
                        editSkillEffect009.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 9:
                        editSkillEffect010.setText(Skill_Describe_Effect[GetValue][i]);
                        break;

                    case 10:
                        editSkillEffect101.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 11:
                        editSkillEffect102.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 12:
                        editSkillEffect103.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 13:
                        editSkillEffect104.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 14:
                        editSkillEffect105.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 15:
                        editSkillEffect106.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 16:
                        editSkillEffect107.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 17:
                        editSkillEffect108.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 18:
                        editSkillEffect109.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 19:
                        editSkillEffect110.setText(Skill_Describe_Effect[GetValue][i]);
                        break;

                    case 20:
                        editSkillEffect201.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 21:
                        editSkillEffect202.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 22:
                        editSkillEffect203.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 23:
                        editSkillEffect204.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 24:
                        editSkillEffect205.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 25:
                        editSkillEffect206.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 26:
                        editSkillEffect207.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 27:
                        editSkillEffect208.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 28:
                        editSkillEffect209.setText(Skill_Describe_Effect[GetValue][i]);
                        break;
                    case 29:
                        editSkillEffect210.setText(Skill_Describe_Effect[GetValue][i]);
                        break;

                }
                //endregion switch
            } else {
                //region switch
                switch (i) {
                    case 0:
                        editSkillEffect001.setText("");
                        break;
                    case 1:
                        editSkillEffect002.setText("");
                        break;
                    case 2:
                        editSkillEffect003.setText("");
                        break;
                    case 3:
                        editSkillEffect004.setText("");
                        break;
                    case 4:
                        editSkillEffect005.setText("");
                        break;
                    case 5:
                        editSkillEffect006.setText("");
                        break;
                    case 6:
                        editSkillEffect007.setText("");
                        break;
                    case 7:
                        editSkillEffect008.setText("");
                        break;
                    case 8:
                        editSkillEffect009.setText("");
                        break;
                    case 9:
                        editSkillEffect010.setText("");
                        break;

                    case 10:
                        editSkillEffect101.setText("");
                        break;
                    case 11:
                        editSkillEffect102.setText("");
                        break;
                    case 12:
                        editSkillEffect103.setText("");
                        break;
                    case 13:
                        editSkillEffect104.setText("");
                        break;
                    case 14:
                        editSkillEffect105.setText("");
                        break;
                    case 15:
                        editSkillEffect106.setText("");
                        break;
                    case 16:
                        editSkillEffect107.setText("");
                        break;
                    case 17:
                        editSkillEffect108.setText("");
                        break;
                    case 18:
                        editSkillEffect109.setText("");
                        break;
                    case 19:
                        editSkillEffect110.setText("");
                        break;

                    case 20:
                        editSkillEffect201.setText("");
                        break;
                    case 21:
                        editSkillEffect202.setText("");
                        break;
                    case 22:
                        editSkillEffect203.setText("");
                        break;
                    case 23:
                        editSkillEffect204.setText("");
                        break;
                    case 24:
                        editSkillEffect205.setText("");
                        break;
                    case 25:
                        editSkillEffect206.setText("");
                        break;
                    case 26:
                        editSkillEffect207.setText("");
                        break;
                    case 27:
                        editSkillEffect208.setText("");
                        break;
                    case 28:
                        editSkillEffect209.setText("");
                        break;
                    case 29:
                        editSkillEffect210.setText("");
                        break;
                }
                //endregion switch
            }
        }


        //endregion

        //endregion


        //region Servent Class Skill-職階技能區塊

        for (int i = 0; i < 4; i++) {
            if (Servent_Class_Describe[GetValue][i] != null && Servent_Class_Describe[GetValue][i] != "?") {
                switch (i) {
                    case 0:
                        if (icon_ServentClassSkill[GetValue][i] != null)
                            img_CalssSkill01.setImageResource(icon_ServentClassSkill[GetValue][0]);
                        editClassSkill01.setText(Servent_Class_Describe[GetValue][0]);
                        break;
                    case 1:
                        if (icon_ServentClassSkill[GetValue][i] != null)
                            img_CalssSkill02.setImageResource(icon_ServentClassSkill[GetValue][1]);
                        editClassSkill02.setText(Servent_Class_Describe[GetValue][1]);
                        break;
                    case 2:
                        if (icon_ServentClassSkill[GetValue][i] != null)
                            img_CalssSkill03.setImageResource(icon_ServentClassSkill[GetValue][2]);
                        editClassSkill03.setText(Servent_Class_Describe[GetValue][2]);
                        break;
                    case 3:
                        if (icon_ServentClassSkill[GetValue][i] != null)
                            img_CalssSkill04.setImageResource(icon_ServentClassSkill[GetValue][3]);
                        editClassSkill04.setText(Servent_Class_Describe[GetValue][3]);
                        break;
                }
            } else {
                final ViewGroup.LayoutParams text1 = editClassSkill01.getLayoutParams();
                final ViewGroup.LayoutParams img1 = img_CalssSkill01.getLayoutParams();
                final ViewGroup.LayoutParams text2 = editClassSkill02.getLayoutParams();
                final ViewGroup.LayoutParams img2 = img_CalssSkill02.getLayoutParams();
                final ViewGroup.LayoutParams text3 = editClassSkill03.getLayoutParams();
                final ViewGroup.LayoutParams img3 = img_CalssSkill03.getLayoutParams();
                final ViewGroup.LayoutParams text4 = editClassSkill04.getLayoutParams();
                final ViewGroup.LayoutParams img4 = img_CalssSkill04.getLayoutParams();


                switch (i) {
                    case 0:

                        text1.height = 1;
                        img1.height = 1;
                        break;
                    case 1:
                        text2.height = 1;
                        img2.height = 1;
                        break;
                    case 2:
                        text3.height = 1;
                        img3.height = 1;
                        break;
                    case 3:
                        text4.height = 1;
                        img4.height = 1;
                        break;
                }
            }
        }

        //endregion

        //region CommandCard_配牌
        char B, A, Q;
        char cardflag = 1;
        Integer[] Card = {R.drawable.card_buster, R.drawable.card_arts, R.drawable.card_quicks};

        B = (char) Integer.parseInt(CommandCard[GetValue][0]);
        A = (char) Integer.parseInt(CommandCard[GetValue][1]);
        Q = (char) Integer.parseInt(CommandCard[GetValue][2]);
        //region Buster
        for (int i = 0; i < 3; i++) {
            if (B > 0 && cardflag > 0) {
                if (cardflag == 1) {
                    img_CommandCard_01.setImageResource(Card[0]);
                    cardflag++;
                    B--;
                } else if (cardflag == 2) {
                    img_CommandCard_02.setImageResource(Card[0]);
                    cardflag++;
                    B--;
                } else if (cardflag == 3) {
                    img_CommandCard_03.setImageResource(Card[0]);
                    cardflag++;
                    B--;
                } else if (cardflag == 4) {
                    img_CommandCard_04.setImageResource(Card[0]);
                    cardflag++;
                    B--;
                } else if (cardflag == 5) {
                    img_CommandCard_05.setImageResource(Card[0]);
                    cardflag++;
                    B--;
                }
            } else {
                break;
            }
        }
        //endregion

        //region Arts
        for (int i = 0; i < 3; i++) {
            if (A > 0 && cardflag > 0) {
                if (cardflag == 1) {
                    img_CommandCard_01.setImageResource(Card[1]);
                    cardflag++;
                    A--;
                } else if (cardflag == 2) {
                    img_CommandCard_02.setImageResource(Card[1]);
                    cardflag++;
                    A--;
                } else if (cardflag == 3) {
                    img_CommandCard_03.setImageResource(Card[1]);
                    cardflag++;
                    A--;
                } else if (cardflag == 4) {
                    img_CommandCard_04.setImageResource(Card[1]);
                    cardflag++;
                    A--;
                } else if (cardflag == 5) {
                    img_CommandCard_05.setImageResource(Card[1]);
                    cardflag++;
                    A--;
                }
            } else {
                break;
            }
        }
        //endregion

        //region Quick
        for (int i = 0; i < 3; i++) {
            if (Q > 0 && cardflag > 0) {
                if (cardflag == 1) {
                    img_CommandCard_01.setImageResource(Card[2]);
                    cardflag++;
                    Q--;
                } else if (cardflag == 2) {
                    img_CommandCard_02.setImageResource(Card[2]);
                    cardflag++;
                    Q--;
                } else if (cardflag == 3) {
                    img_CommandCard_03.setImageResource(Card[2]);
                    cardflag++;
                    Q--;
                } else if (cardflag == 4) {
                    img_CommandCard_04.setImageResource(Card[2]);
                    cardflag++;
                    Q--;
                } else if (cardflag == 5) {
                    img_CommandCard_05.setImageResource(Card[2]);
                    cardflag++;
                    Q--;
                }
            } else {
                break;
            }
        }
        //endregion
        cardflag = 1;
        //endregion


        //region NP_寶具

        String[][] localNP = NP_DescribeEn;

        for (int i = 0; i < 17; i++) {
            if (localNP[GetValue][i] != null) {
                //region Switch
                switch (i) {
                    case 0:
                        //region CardColor
                        switch (localNP[GetValue][i]) {
                            case "0":
                                if (localNP[GetValue][11] != null) {
                                    img_NP1.setImageResource(R.drawable.card_buster);
                                    img_NP2.setImageResource(R.drawable.card_buster);
                                } else {
                                    img_NP1.setImageResource(R.drawable.card_buster);
                                }
                                break;
                            case "1":
                                if (localNP[GetValue][11] != null) {
                                    img_NP1.setImageResource(R.drawable.card_arts);
                                    img_NP2.setImageResource(R.drawable.card_arts);
                                } else {
                                    img_NP1.setImageResource(R.drawable.card_arts);
                                }

                                break;
                            case "2":
                                if (localNP[GetValue][11] != null) {
                                    img_NP1.setImageResource(R.drawable.card_quicks);
                                    img_NP2.setImageResource(R.drawable.card_quicks);
                                } else {
                                    img_NP1.setImageResource(R.drawable.card_quicks);
                                }
                                break;
                        }
                        break;
                    //endregion
                    case 1:
                        //region NP_Name
                        editNP_Name.setText(localNP[GetValue][i]);
                        if (localNP[GetValue][11] != null)//判斷RANK
                        {
                            if (localNP[GetValue][10] != null) {
                                editNP_Name1.setText(localNP[GetValue][10]);
                            } else {
                                editNP_Name1.setText(localNP[GetValue][i]);
                            }
                        }
                        break;
                    //endregion
                    case 2:

                        //region NP_Describe
                        if (localNP[GetValue][i] != null) {
                            editNP_Descriibe.setText(localNP[GetValue][i]);
                        } else {
                            editNP_Descriibe.setText("");
                        }

                        break;
                    //endregion

                    case 3:
                        //region NP Rank
                        if (localNP[GetValue][i] != null) {
                            editNP_Rank.setText(localNP[GetValue][i]);
                        } else {
                            editNP_Rank.setText("");
                        }
                        //endregion
                        break;

                    case 4:
                        //region NP Target
                        if (localNP[GetValue][i] != null) {
                            editNP_Target.setText(localNP[GetValue][i]);
                            if (localNP[GetValue][12] != null)
                                editNP_Target1.setText(localNP[GetValue][i]);
                        } else {
                            editNP_Target.setText("");
                            editNP_Target1.setText("");
                        }
                        //endregion
                        break;

                    case 5:
                        //region NP_Level_1-5
                        if (localNP[GetValue][i] != null) {
                            editNP_LV01.setText(localNP[GetValue][i]);
                        } else {
                            editNP_LV01.setText("");
                        }
                        break;
                    case 6:
                        if (localNP[GetValue][i] != null) {
                            editNP_LV02.setText(localNP[GetValue][i]);
                        } else {
                            editNP_LV02.setText("");
                        }
                        break;
                    case 7:
                        if (localNP[GetValue][i] != null) {
                            editNP_LV03.setText(localNP[GetValue][i]);
                        } else {
                            editNP_LV03.setText("");
                        }
                        break;
                    case 8:
                        if (localNP[GetValue][i] != null) {
                            editNP_LV04.setText(localNP[GetValue][i]);
                        } else {
                            editNP_LV04.setText("");
                        }
                        break;
                    case 9:
                        if (localNP[GetValue][i] != null) {
                            if (localNP[GetValue][i] != null) {
                                editNP_LV05.setText(localNP[GetValue][i]);
                            } else {
                                editNP_LV05.setText("");
                            }
                        }
                        break;
                    //endregion
                    case 10:
                        break;

                    case 11:
                        //region SecondRank
                        if (localNP[GetValue][i] != null) {
                            editNP_Rank1.setText(localNP[GetValue][i]);
                        } else {
                            editNP_Rank1.setText("");
                        }
                        break;
                    //endregion

                    case 12:
                        //region Second NP LV1-5
                        if (localNP[GetValue][i] != null) {
                            editNP_LV11.setText(localNP[GetValue][i]);
                        } else {
                            editNP_LV11.setText("");
                        }
                        break;
                    case 13:
                        if (localNP[GetValue][i] != null) {
                            editNP_LV12.setText(localNP[GetValue][i]);
                        } else {
                            editNP_LV12.setText("");
                        }
                        break;
                    case 14:
                        if (localNP[GetValue][i] != null) {
                            editNP_LV13.setText(localNP[GetValue][i]);
                        } else {
                            editNP_LV13.setText("");
                        }
                        break;
                    case 15:
                        if (localNP[GetValue][i] != null) {
                            editNP_LV14.setText(localNP[GetValue][i]);
                        } else {
                            editNP_LV14.setText("");
                        }
                        break;
                    case 16:
                        if (localNP[GetValue][i] != null) {
                            editNP_LV15.setText(localNP[GetValue][i]);
                        } else {
                            editNP_LV15.setText("");
                        }
                        break;
                    //endregion

                }
                //endregion
            } else {
                //region Switch

                switch (i) {
                    case 0:
                        img_NP1_Layout.height = 1;
                        img_NP2_Layout.height = 1;
                        break;
                    case 1:
                        editNP_Name.setText("Unknow");
                        editNP_Name1.setText("");
                        break;
                    case 2:
                        editNP_Descriibe_Layout.height = 1;
                        break;
                    case 3:
                        editNP_Rank_Layout.height = 1;
                        break;
                    case 4:
                        editNP_Target_Layout.height = 1;
                        break;
                    case 5:
                        editNP_LV01_Layout.height = 1;
                        break;
                    case 6:
                        editNP_LV02_Layout.height = 1;
                        break;
                    case 7:
                        editNP_LV03_Layout.height = 1;
                        break;
                    case 8:
                        editNP_LV04_Layout.height = 1;
                        break;
                    case 9:
                        editNP_LV05_Layout.height = 1;
                        break;
                    case 10:
                        break;
                    case 11:
                        editNP_Rank1_Layout.height = 1;
                        break;
                    case 12:
                        editNP_LV11_Layout.height = 1;
                        break;
                    case 13:
                        editNP_LV12_Layout.height = 1;
                        break;
                    case 14:
                        editNP_LV13_Layout.height = 1;
                        break;
                    case 15:
                        editNP_LV14_Layout.height = 1;
                        break;
                    case 16:
                        editNP_LV15_Layout.height = 1;
                        break;

                }
                //endregion
            }

        }
        //endregion


        //region 靈基素材





        new Thread(new Runnable() {
            public void run() {
                try{

                    //region 靈基素材判斷
                    if (str_RequiredMaterials[GetValue][0]!=null)
                    {
                        for (int i = 0; i < 4; i++)//靈基有4階段拆成4組
                        {
                            for (int j = 0; j < 9; j++)//靈基1組9筆資料
                            {
                                if (str_RequiredMaterials[GetValue][j + (i * 9)] != null)
                                {
                                    switch (i)
                                    {
                                        case 0:
                                            //region switch j
                                            switch (j) {
                                                case 0://QP
                                                    EditQP01.setText("\n"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;

                                                case 1:
                                                    boolean find=false;

                                                    for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                                    {
                                                        if (str_RequiredMaterials[GetValue][j + (i * 9)]==str_LanguageRequired_Materials[1][materials])
                                                        {
                                                            img_item_AM01.setImageResource(img_Required_Materials[materials]);
                                                            find=true;
                                                            break;
                                                        }
                                                    }
                                                    if (!find)
                                                    {
                                                        for (int materials=0;materials<str_LanguageRequired_Materials[2].length;materials++)
                                                        {
                                                            if (str_RequiredMaterials[GetValue][j]==str_LanguageRequired_Materials[2][materials])
                                                            {
                                                                img_item_AM01.setImageResource(img_Required_EventMaterials[materials]);
                                                                img_item_AM11.setImageResource(img_Required_EventMaterials[materials]);
                                                                img_item_AM21.setImageResource(img_Required_EventMaterials[materials]);
                                                                img_item_AM31.setImageResource(img_Required_EventMaterials[materials]);
                                                                find=true;
                                                                break;
                                                            }
                                                        }
                                                    }


                                                    break;

                                                case 2:
                                                    EditItemAM00.setText("x"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;

                                                case 3:
                                                    for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                                    {
                                                        if (str_RequiredMaterials[GetValue][j + (i * 9)]==str_LanguageRequired_Materials[1][materials])
                                                        {
                                                            img_item_AM02.setImageResource(img_Required_Materials[materials]);
                                                            break;
                                                        }
                                                    }
                                                    break;

                                                case 4:
                                                    EditItemAM01.setText("x"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;

                                                case 5:
                                                    for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                                    {
                                                        if (str_RequiredMaterials[GetValue][j + (i * 9)]==str_LanguageRequired_Materials[1][materials])
                                                        {
                                                            img_item_AM03.setImageResource(img_Required_Materials[materials]);
                                                            break;
                                                        }
                                                    }
                                                    break;

                                                case 6:
                                                    EditItemAM02.setText("x"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;

                                                case 7:
                                                    for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                                    {
                                                        if (str_RequiredMaterials[GetValue][j + (i * 9)]==str_LanguageRequired_Materials[1][materials])
                                                        {
                                                            img_item_AM04.setImageResource(img_Required_Materials[materials]);
                                                            break;
                                                        }
                                                    }
                                                    break;

                                                case 8:
                                                    EditItemAM03.setText("x"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;
                                            }
                                            //endregion
                                            break;

                                        case 1:
                                            //region switch j
                                            switch (j) {
                                                case 0://QP
                                                    EditQP02.setText("\n"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;

                                                case 1:
                                                    for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                                    {
                                                        if (str_RequiredMaterials[GetValue][j + (i * 9)]==str_LanguageRequired_Materials[1][materials])
                                                        {
                                                            img_item_AM11.setImageResource(img_Required_Materials[materials]);
                                                            break;
                                                        }
                                                    }
                                                    break;

                                                case 2:
                                                    EditItemAM10.setText("x"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;

                                                case 3:
                                                    for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                                    {
                                                        if (str_RequiredMaterials[GetValue][j + (i * 9)]==str_LanguageRequired_Materials[1][materials])
                                                        {
                                                            img_item_AM12.setImageResource(img_Required_Materials[materials]);
                                                            break;
                                                        }
                                                    }
                                                    break;

                                                case 4:
                                                    EditItemAM11.setText("x"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;

                                                case 5:
                                                    for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                                    {
                                                        if (str_RequiredMaterials[GetValue][j + (i * 9)]==str_LanguageRequired_Materials[1][materials])
                                                        {
                                                            img_item_AM13.setImageResource(img_Required_Materials[materials]);
                                                            break;
                                                        }
                                                    }
                                                    break;

                                                case 6:
                                                    EditItemAM12.setText("x"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;

                                                case 7:
                                                    for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                                    {
                                                        if (str_RequiredMaterials[GetValue][j + (i * 9)]==str_LanguageRequired_Materials[1][materials])
                                                        {
                                                            img_item_AM14.setImageResource(img_Required_Materials[materials]);
                                                            break;
                                                        }
                                                    }
                                                    break;

                                                case 8:
                                                    EditItemAM13.setText("x"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;
                                            }
                                            //endregion
                                            break;
                                        case 2:
                                            //region switch j
                                            switch (j) {
                                                case 0://QP
                                                    EditQP03.setText("\n"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;

                                                case 1:
                                                    for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                                    {
                                                        if (str_RequiredMaterials[GetValue][j + (i * 9)]==str_LanguageRequired_Materials[1][materials])
                                                        {
                                                            img_item_AM21.setImageResource(img_Required_Materials[materials]);
                                                            break;
                                                        }
                                                    }
                                                    break;

                                                case 2:
                                                    EditItemAM20.setText("x"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;

                                                case 3:
                                                    for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                                    {
                                                        if (str_RequiredMaterials[GetValue][j + (i * 9)]==str_LanguageRequired_Materials[1][materials])
                                                        {
                                                            img_item_AM22.setImageResource(img_Required_Materials[materials]);
                                                            break;
                                                        }
                                                    }
                                                    break;

                                                case 4:
                                                    EditItemAM21.setText("x"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;

                                                case 5:
                                                    for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                                    {
                                                        if (str_RequiredMaterials[GetValue][j + (i * 9)]==str_LanguageRequired_Materials[1][materials])
                                                        {
                                                            img_item_AM23.setImageResource(img_Required_Materials[materials]);
                                                            break;
                                                        }
                                                    }
                                                    break;

                                                case 6:
                                                    EditItemAM22.setText("x"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;

                                                case 7:
                                                    for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                                    {
                                                        if (str_RequiredMaterials[GetValue][j + (i * 9)]==str_LanguageRequired_Materials[1][materials])
                                                        {
                                                            img_item_AM24.setImageResource(img_Required_Materials[materials]);
                                                            break;
                                                        }
                                                    }
                                                    break;

                                                case 8:
                                                    EditItemAM23.setText("x"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;
                                            }
                                            //endregion
                                            break;
                                        case 3:
                                            //region switch j
                                            switch (j) {
                                                case 0://QP
                                                    EditQP04.setText("\n"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;

                                                case 1:
                                                    for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                                    {
                                                        if (str_RequiredMaterials[GetValue][j + (i * 9)]==str_LanguageRequired_Materials[1][materials])
                                                        {
                                                            img_item_AM31.setImageResource(img_Required_Materials[materials]);
                                                            break;
                                                        }
                                                    }
                                                    break;

                                                case 2:
                                                    EditItemAM30.setText("x"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;

                                                case 3:
                                                    for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                                    {
                                                        if (str_RequiredMaterials[GetValue][j + (i * 9)]==str_LanguageRequired_Materials[1][materials])
                                                        {
                                                            img_item_AM32.setImageResource(img_Required_Materials[materials]);
                                                            break;
                                                        }
                                                    }
                                                    break;

                                                case 4:
                                                    EditItemAM31.setText("x"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;

                                                case 5:
                                                    for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                                    {
                                                        if (str_RequiredMaterials[GetValue][j + (i * 9)]==str_LanguageRequired_Materials[1][materials])
                                                        {
                                                            img_item_AM33.setImageResource(img_Required_Materials[materials]);
                                                            break;
                                                        }
                                                    }
                                                    break;

                                                case 6:
                                                    EditItemAM32.setText("x"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;

                                                case 7:
                                                    for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                                    {
                                                        if (str_RequiredMaterials[GetValue][j + (i * 9)]==str_LanguageRequired_Materials[1][materials])
                                                        {
                                                            img_item_AM34.setImageResource(img_Required_Materials[materials]);
                                                            break;
                                                        }
                                                    }
                                                    break;

                                                case 8:
                                                    EditItemAM33.setText("x"+str_RequiredMaterials[GetValue][j + (i * 9)]);
                                                    break;
                                            }
                                            //endregion
                                            break;

                                    }

                                }
                            }
                        }
                    }
                    //endregion
                }
                catch (Exception e)
                {
                    Log.d("靈基素材判斷", "run: 靈基素材判斷");
                }

            }
        }).start();


        new Thread(new Runnable() {
            public void run() {
                try{
                    //region 技能素材判斷

                    //region LV1-LV2
                    if (str_SkillRequiredMaterials_part1[GetValue][0]!=null)
                    {
                        for (int j = 0; j < 9; j++)//靈基1組9筆資料
                        {
                            if (str_SkillRequiredMaterials_part1[GetValue][j] != null)
                            {
                                //region switch j
                                switch (j) {
                                    case 0://QP
                                        Edit_SkillQP0.setText("\n"+str_SkillRequiredMaterials_part1[GetValue][j]);
                                        break;

                                    case 1:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part1[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials00.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 2:
                                        Edit_SkillMaterials00.setText("x"+str_SkillRequiredMaterials_part1[GetValue][j]);
                                        break;

                                    case 3:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part1[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials01.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 4:
                                        Edit_SkillMaterials01.setText("x"+str_SkillRequiredMaterials_part1[GetValue][j]);
                                        break;

                                    case 5:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part1[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials02.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 6:
                                        Edit_SkillMaterials02.setText("x"+str_SkillRequiredMaterials_part1[GetValue][j]);
                                        break;

                                    case 7:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part1[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials03.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 8:
                                        Edit_SkillMaterials03.setText("x"+str_SkillRequiredMaterials_part1[GetValue][j]);
                                        break;
                                }

                            }
                        }
                    }
                    //endregion

                    //region LV2-LV3
                    if (str_SkillRequiredMaterials_part2[GetValue][0]!=null)
                    {
                        for (int j = 0; j < 9; j++)//靈基1組9筆資料
                        {
                            if (str_SkillRequiredMaterials_part2[GetValue][j] != null)
                            {
                                //region switch j
                                switch (j) {
                                    case 0://QP
                                        Edit_SkillQP1.setText("\n"+str_SkillRequiredMaterials_part2[GetValue][j]);
                                        break;

                                    case 1:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part2[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials10.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 2:
                                        Edit_SkillMaterials10.setText("x"+str_SkillRequiredMaterials_part2[GetValue][j]);
                                        break;

                                    case 3:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part2[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials11.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 4:
                                        Edit_SkillMaterials11.setText("x"+str_SkillRequiredMaterials_part2[GetValue][j]);
                                        break;

                                    case 5:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part2[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials12.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 6:
                                        Edit_SkillMaterials12.setText("x"+str_SkillRequiredMaterials_part2[GetValue][j]);
                                        break;

                                    case 7:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part2[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials13.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 8:
                                        Edit_SkillMaterials13.setText("x"+str_SkillRequiredMaterials_part2[GetValue][j]);
                                        break;
                                }
                            }
                        }
                    }
                    //endregion

                    //region LV3-LV4
                    if (str_SkillRequiredMaterials_part3[GetValue][0]!=null)
                    {
                        for (int j = 0; j < 9; j++)//靈基1組9筆資料
                        {
                            if (str_SkillRequiredMaterials_part3[GetValue][j] != null)
                            {
                                //region switch j
                                switch (j) {
                                    case 0://QP
                                        Edit_SkillQP2.setText("\n"+str_SkillRequiredMaterials_part3[GetValue][j]);
                                        break;

                                    case 1:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part3[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials20.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 2:
                                        Edit_SkillMaterials20.setText("x"+str_SkillRequiredMaterials_part3[GetValue][j]);
                                        break;

                                    case 3:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part3[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials21.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 4:
                                        Edit_SkillMaterials21.setText("x"+str_SkillRequiredMaterials_part3[GetValue][j]);
                                        break;

                                    case 5:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part3[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials22.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 6:
                                        Edit_SkillMaterials22.setText("x"+str_SkillRequiredMaterials_part3[GetValue][j]);
                                        break;

                                    case 7:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part3[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials23.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;
                                    case 8:
                                        Edit_SkillMaterials23.setText("x"+str_SkillRequiredMaterials_part3[GetValue][j]);
                                        break;
                                }
                            }
                        }
                    }
                    //endregion

                    //region LV4-LV5
                    if (str_SkillRequiredMaterials_part4[GetValue][0]!=null)
                    {
                        for (int j = 0; j < 9; j++)//靈基1組9筆資料
                        {
                            if (str_SkillRequiredMaterials_part4[GetValue][j] != null)
                            {
                                //region switch j
                                switch (j) {
                                    case 0://QP
                                        Edit_SkillQP3.setText("\n"+str_SkillRequiredMaterials_part4[GetValue][j]);
                                        break;

                                    case 1:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part4[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials30.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 2:
                                        Edit_SkillMaterials30.setText("x"+str_SkillRequiredMaterials_part4[GetValue][j]);
                                        break;

                                    case 3:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part4[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials31.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 4:
                                        Edit_SkillMaterials31.setText("x"+str_SkillRequiredMaterials_part4[GetValue][j]);
                                        break;

                                    case 5:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part4[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials32.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 6:
                                        Edit_SkillMaterials32.setText("x"+str_SkillRequiredMaterials_part4[GetValue][j]);
                                        break;

                                    case 7:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part4[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials33.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 8:
                                        Edit_SkillMaterials33.setText("x"+str_SkillRequiredMaterials_part4[GetValue][j]);
                                        break;
                                }
                            }
                        }
                    }
                    //endregion

                    //region LV5-LV6
                    if (str_SkillRequiredMaterials_part5[GetValue][0]!=null)
                    {
                        for (int j = 0; j < 9; j++)//靈基1組9筆資料
                        {
                            if (str_SkillRequiredMaterials_part5[GetValue][j] != null)
                            {
                                //region switch j
                                switch (j) {
                                    case 0://QP
                                        Edit_SkillQP4.setText("\n"+str_SkillRequiredMaterials_part5[GetValue][j]);
                                        break;

                                    case 1:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part5[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials40.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 2:
                                        Edit_SkillMaterials40.setText("x"+str_SkillRequiredMaterials_part5[GetValue][j]);
                                        break;

                                    case 3:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part5[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials41.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 4:
                                        Edit_SkillMaterials41.setText("x"+str_SkillRequiredMaterials_part5[GetValue][j]);
                                        break;

                                    case 5:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part5[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials42.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 6:
                                        Edit_SkillMaterials42.setText("x"+str_SkillRequiredMaterials_part5[GetValue][j]);
                                        break;

                                    case 7:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part5[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials43.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 8:
                                        Edit_SkillMaterials43.setText("x"+str_SkillRequiredMaterials_part5[GetValue][j]);
                                        break;
                                }

                            }
                        }
                    }
                    //endregion

                    //region LV6-LV7
                    if (str_SkillRequiredMaterials_part6[GetValue][0]!=null)
                    {
                        for (int j = 0; j < 9; j++)//靈基1組9筆資料
                        {
                            if (str_SkillRequiredMaterials_part6[GetValue][j] != null)
                            {
                                //region switch j
                                switch (j) {
                                    case 0://QP
                                        Edit_SkillQP5.setText("\n"+str_SkillRequiredMaterials_part6[GetValue][j]);
                                        break;

                                    case 1:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part6[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials50.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 2:
                                        Edit_SkillMaterials50.setText("x"+str_SkillRequiredMaterials_part6[GetValue][j]);
                                        break;

                                    case 3:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part6[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials51.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 4:
                                        Edit_SkillMaterials51.setText("x"+str_SkillRequiredMaterials_part6[GetValue][j]);
                                        break;

                                    case 5:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part6[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials52.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 6:
                                        Edit_SkillMaterials52.setText("x"+str_SkillRequiredMaterials_part6[GetValue][j]);
                                        break;

                                    case 7:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part6[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials53.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 8:
                                        Edit_SkillMaterials53.setText("x"+str_SkillRequiredMaterials_part6[GetValue][j]);
                                        break;
                                }

                            }
                        }
                    }
                    //endregion

                    //region LV7-LV8
                    if (str_SkillRequiredMaterials_part7[GetValue][0]!=null)
                    {
                        for (int j = 0; j < 9; j++)//靈基1組9筆資料
                        {
                            if (str_SkillRequiredMaterials_part7[GetValue][j] != null)
                            {
                                //region switch j
                                switch (j) {
                                    case 0://QP
                                        Edit_SkillQP6.setText("\n"+str_SkillRequiredMaterials_part7[GetValue][j]);
                                        break;

                                    case 1:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part7[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials60.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 2:
                                        Edit_SkillMaterials60.setText("x"+str_SkillRequiredMaterials_part7[GetValue][j]);
                                        break;

                                    case 3:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part7[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials61.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 4:
                                        Edit_SkillMaterials61.setText("x"+str_SkillRequiredMaterials_part7[GetValue][j]);
                                        break;

                                    case 5:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part7[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials62.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 6:
                                        Edit_SkillMaterials62.setText("x"+str_SkillRequiredMaterials_part7[GetValue][j]);
                                        break;

                                    case 7:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part7[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials63.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 8:
                                        Edit_SkillMaterials63.setText("x"+str_SkillRequiredMaterials_part7[GetValue][j]);
                                        break;
                                }

                            }
                        }
                    }
                    //endregion

                    //region LV8-LV9
                    if (str_SkillRequiredMaterials_part8[GetValue][0]!=null)
                    {
                        for (int j = 0; j < 9; j++)//靈基1組9筆資料
                        {
                            if (str_SkillRequiredMaterials_part8[GetValue][j] != null)
                            {
                                //region switch j
                                switch (j) {
                                    case 0://QP
                                        Edit_SkillQP7.setText("\n"+str_SkillRequiredMaterials_part8[GetValue][j]);
                                        break;

                                    case 1:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part8[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials70.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 2:
                                        Edit_SkillMaterials70.setText("x"+str_SkillRequiredMaterials_part8[GetValue][j]);
                                        break;

                                    case 3:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part8[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials71.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 4:
                                        Edit_SkillMaterials71.setText("x"+str_SkillRequiredMaterials_part8[GetValue][j]);
                                        break;

                                    case 5:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part8[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials72.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 6:
                                        Edit_SkillMaterials72.setText("x"+str_SkillRequiredMaterials_part8[GetValue][j]);
                                        break;

                                    case 7:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part8[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials73.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 8:
                                        Edit_SkillMaterials73.setText("x"+str_SkillRequiredMaterials_part8[GetValue][j]);
                                        break;
                                }

                            }
                        }
                    }
                    //endregion

                    //region LV9-LV10
                    if (str_SkillRequiredMaterials_part9[GetValue][0]!=null)
                    {
                        for (int j = 0; j < 9; j++)//靈基1組9筆資料
                        {
                            if (str_SkillRequiredMaterials_part9[GetValue][j] != null)
                            {
                                //region switch j
                                switch (j) {
                                    case 0://QP
                                        Edit_SkillQP8.setText("\n"+str_SkillRequiredMaterials_part9[GetValue][j]);
                                        break;

                                    case 1:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part9[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials80.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 2:
                                        Edit_SkillMaterials80.setText("x"+str_SkillRequiredMaterials_part9[GetValue][j]);
                                        break;

                                    case 3:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part9[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials81.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 4:
                                        Edit_SkillMaterials81.setText("x"+str_SkillRequiredMaterials_part9[GetValue][j]);
                                        break;

                                    case 5:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part9[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials82.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 6:
                                        Edit_SkillMaterials82.setText("x"+str_SkillRequiredMaterials_part9[GetValue][j]);
                                        break;

                                    case 7:
                                        for (int materials=0;materials<str_LanguageRequired_Materials[1].length;materials++)
                                        {
                                            if (str_SkillRequiredMaterials_part9[GetValue][j]==str_LanguageRequired_Materials[1][materials])
                                            {
                                                img_SkillMaterials83.setImageResource(img_Required_Materials[materials]);
                                                break;
                                            }
                                        }
                                        break;

                                    case 8:
                                        Edit_SkillMaterials83.setText("x"+str_SkillRequiredMaterials_part9[GetValue][j]);
                                        break;
                                }
                            }
                        }
                    }
                    //endregion


                    //endregion
                }
                catch (Exception e)
                {
                    Log.d("技能素材判斷", "run: 技能素材判斷");
                }




            }
        }).start();


        //endregion



        //endregion
    }

    private class MyAsyncTask extends AsyncTask<String, Void, Bitmap> {
        // new MyAsyncTask().execute("URL");
        protected Bitmap doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch(IOException e) {
                Log.d("DoInBackground",e.toString());
                return null;
            }
        }

        protected void onPostExecute(Bitmap result) {
            //do what you want with your bitmap result on the UI thread
            ImageView img_AF= findViewById(R.id.image_servent_stage);
            ImageView img_BS= findViewById(R.id.image_servent_BStage);
            if (selectedradio!=0 && AF)
            {
                //img_AF.setImageBitmap();
                img_AF.setImageBitmap(result);
                AF=false;
            }
            else if (selectedradio!=0 && BS)
            {
                img_BS.setImageBitmap(result);
                BS=false;
            }
            mpg.dismiss();
            result=null;
        }
    }

    private class MaterialAsyncTask extends AsyncTask<String, Void, Bitmap> {
        // new MaterialAsyncTask().execute("URL");
        protected Bitmap doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch(IOException e) {
                Log.d("---MaterialAsyncTask---",e.toString());
                return null;
            }
        }

        protected void onPostExecute(Bitmap result) {
            //do what you want with your bitmap result on the UI thread

            if (result!=null)
            {
                ImageView material01=(ImageView) findViewById(R.id.img_item_AM01);
                ImageView material02=(ImageView) findViewById(R.id.img_item_AM02);
                ImageView material03=(ImageView) findViewById(R.id.img_item_AM03);
                ImageView material04=(ImageView) findViewById(R.id.img_item_AM04);
                material01.setImageBitmap(result);
                material02.setImageBitmap(result);
                material03.setImageBitmap(result);
                material04.setImageBitmap(result);
            }
            mpg.dismiss();
        }
    }

    private void Advertise()
    {
        MobileAds.initialize(this, "ca-app-pub-8418426477328402~2027922183");
        AdView mAdView = (AdView) findViewById(R.id.ad_ServentQuery_View);
        //AdView mAdView1 = (AdView) findViewById(R.id.ad_ServentQuery_View1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public String createImageFromBitmap(Bitmap bitmap) {
        String fileName = "myImage";//no .png or .jpg needed
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            FileOutputStream fo = openFileOutput(fileName, Context.MODE_PRIVATE);
            fo.write(bytes.toByteArray());
            // remember close file output
            fo.close();
        } catch (Exception e) {
            e.printStackTrace();
            fileName = null;
        }
        return fileName;
    }
}