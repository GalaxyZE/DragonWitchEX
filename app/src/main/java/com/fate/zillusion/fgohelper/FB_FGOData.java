package com.fate.zillusion.fgohelper;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;
//FireBase Realtime Database Read & Write
//  DatabaseReference database = FirebaseDatabase.getInstance().getReference();
//  DatabaseReference ref=database.child("Servant").child("NO_"+str_selectedno);
//  ValueEventListener postListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // Get Post object and use the values to update the UI
//                try{
//                    FB_FGOData FGODataRead = dataSnapshot.getValue(FB_FGOData.class);
//
//                  //Log.d("DataRead", "onDataChange: "+FGODataRead.getLevelMaterial_11()+":"+FGODataRead.getRequireQuantity11()+"\n");
//
//                }catch (Exception e)
//                {
//                    Log.d("DataRead","Error:"+e.toString());
//                }
//
//                // ...
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // Getting Post failed, log a message
//                Log.w("DataRead", "loadPost:onCancelled", databaseError.toException());
//                // ...
//            }
//        };
//        ref.addValueEventListener(postListener);
//

public class FB_FGOData {
    //region Define Valuable
    private String NameCH,NameEN,NameJP,NameChina;
    private int Rarity,Class,StatusATKLV1,Status_HPLV1,StatusATKFinal,Status_HPFinal,StatusATKLV100,Status_HPLV100,COST,MAX_LV;
    private String Class_Describe1,Class_Describe2,Class_Describe3,Class_Describe4;
    private int Command_Buster,Command_Arts,Command_Quick;
    private String Skill_Describe1,Skill_Describe2,Skill_Describe3,Skill_Describe4,Skill_Describe5,Skill_Describe6;
    private String Skill_1_Effect1,Skill_1_Effect2,Skill_1_Effect3,Skill_1_Effect4,Skill_1_Effect5,Skill_1_Effect6,Skill_1_Effect7,Skill_1_Effect8,Skill_1_Effect9,Skill_1_Effect10;
    private String Skill_2_Effect1,Skill_2_Effect2,Skill_2_Effect3,Skill_2_Effect4,Skill_2_Effect5,Skill_2_Effect6,Skill_2_Effect7,Skill_2_Effect8,Skill_2_Effect9,Skill_2_Effect10;
    private String Skill_3_Effect1,Skill_3_Effect2,Skill_3_Effect3,Skill_3_Effect4,Skill_3_Effect5,Skill_3_Effect6,Skill_3_Effect7,Skill_3_Effect8,Skill_3_Effect9,Skill_3_Effect10;
    private int NP_CardColor;private String NP_Name1, NP_Describe,NP_Describe_Rank1, NP_Describe_Target,NP_1_Effect1,NP_1_Effect2,NP_1_Effect3,NP_1_Effect4,NP_1_Effect5,
    NP_Name2,NP_Rank2,NP_2_Effect1,NP_2_Effect2,NP_2_Effect3,NP_2_Effect4,NP_2_Effect5;
    //region Level Required Material
    private String LevelMaterial_11,LevelMaterial_12,LevelMaterial_13,LevelMaterial_14;
    private String RequireQuantity11,RequireQuantity12,RequireQuantity13,RequireQuantity14;
    private String LevelMaterial_21,LevelMaterial_22,LevelMaterial_23,LevelMaterial_24;
    private String RequireQuantity21,RequireQuantity22,RequireQuantity23,RequireQuantity24;
    private String LevelMaterial_31,LevelMaterial_32,LevelMaterial_33,LevelMaterial_34;
    private String RequireQuantity31,RequireQuantity32,RequireQuantity33,RequireQuantity34;
    private String LevelMaterial_41,LevelMaterial_42,LevelMaterial_43,LevelMaterial_44;
    private String RequireQuantity41,RequireQuantity42,RequireQuantity43,RequireQuantity44;
    private String LevelMaterialQP_1,LevelMaterialQP_2,LevelMaterialQP_3,LevelMaterialQP_4;
    //endregion
    //region Skill_Level UP_Material
    private String Skill_Material21,Skill_Material22,Skill_Material23,Skill_Material24,Skill_QP2;
    private String Skill_Material31,Skill_Material32,Skill_Material33,Skill_Material34,Skill_QP3;
    private String Skill_Material41,Skill_Material42,Skill_Material43,Skill_Material44,Skill_QP4;
    private String Skill_Material51,Skill_Material52,Skill_Material53,Skill_Material54,Skill_QP5;
    private String Skill_Material61,Skill_Material62,Skill_Material63,Skill_Material64,Skill_QP6;
    private String Skill_Material71,Skill_Material72,Skill_Material73,Skill_Material74,Skill_QP7;
    private String Skill_Material81,Skill_Material82,Skill_Material83,Skill_Material84,Skill_QP8;
    private String Skill_Material91,Skill_Material92,Skill_Material93,Skill_Material94,Skill_QP9;
    private String Skill_Material101,Skill_Material102,Skill_Material103,Skill_Material104,Skill_QP10;
    private String Skill_RequireQuantity21,Skill_RequireQuantity22,Skill_RequireQuantity23,Skill_RequireQuantity24;
    private String Skill_RequireQuantity31,Skill_RequireQuantity32,Skill_RequireQuantity33,Skill_RequireQuantity34;
    private String Skill_RequireQuantity41,Skill_RequireQuantity42,Skill_RequireQuantity43,Skill_RequireQuantity44;
    private String Skill_RequireQuantity51,Skill_RequireQuantity52,Skill_RequireQuantity53,Skill_RequireQuantity54;
    private String Skill_RequireQuantity61,Skill_RequireQuantity62,Skill_RequireQuantity63,Skill_RequireQuantity64;
    private String Skill_RequireQuantity71,Skill_RequireQuantity72,Skill_RequireQuantity73,Skill_RequireQuantity74;
    private String Skill_RequireQuantity81,Skill_RequireQuantity82,Skill_RequireQuantity83,Skill_RequireQuantity84;
    private String Skill_RequireQuantity91,Skill_RequireQuantity92,Skill_RequireQuantity93,Skill_RequireQuantity94;
    private String Skill_RequireQuantity101,Skill_RequireQuantity102,Skill_RequireQuantity103,Skill_RequireQuantity104;

    //endregion

    //endregion

    public FB_FGOData() {
    }
    public FB_FGOData(String namech, String nameen, String namejp, String namechina){
        this.NameCH=namech;
        this.NameEN=nameen;
        this.NameJP=namejp;
        this.NameChina=namechina;

    }//Servant_Name

    public FB_FGOData(String namech, String nameen, String namejp, String namechina, int rarity, int Class, int StatusATKLV1, int Status_HPLV1,
                      int StatusATKFinal, int Status_HPFinal, int StatusATKLV100, int Status_HPLV100, int Cost, int max_LV){
        // Define Line 2.
        this.NameCH=namech;
        this.NameEN=nameen;
        this.NameJP=namejp;
        this.NameChina=namechina;
        //int
        this.Rarity=rarity;
        this.Class=Class;
        this.StatusATKLV1=StatusATKLV1;
        this.Status_HPLV1=Status_HPLV1;

        this.StatusATKFinal=StatusATKFinal;
        this.Status_HPFinal=Status_HPFinal;

        this.StatusATKLV100=StatusATKLV100;
        this.Status_HPLV100=Status_HPLV100;
        this.COST=Cost;
        this.MAX_LV=max_LV;
    }//Servant_Name + Servant_Rarity & Information Status

    public FB_FGOData(String namech, String nameen, String namejp, String namechina, int rarity, int Class, int StatusATKLV1, int Status_HPLV1,
                      int StatusATKFinal, int Status_HPFinal, int StatusATKLV100, int Status_HPLV100, int Cost, int max_LV,
                      String class_describe1, String class_describe2, String class_describe3, String class_describe4
    ){
        // Define Line 2.
        this.NameCH=namech;
        this.NameEN=nameen;
        this.NameJP=namejp;
        this.NameChina=namechina;
        //int
        this.Rarity=rarity;
        this.Class=Class;
        this.StatusATKLV1=StatusATKLV1;
        this.Status_HPLV1=Status_HPLV1;
        this.StatusATKFinal=StatusATKFinal;
        this.Status_HPFinal=Status_HPFinal;
        this.StatusATKLV100=StatusATKLV100;
        this.Status_HPLV100=Status_HPLV100;
        this.COST=Cost;
        this.MAX_LV=max_LV;
        //Class Describe
        this.Class_Describe1=class_describe1;
        this.Class_Describe2=class_describe2;
        this.Class_Describe3=class_describe3;
        this.Class_Describe4=class_describe4;

    }//Servant_Name + Servant_Rarity & Information Status + Class Describe(1-4)

    public FB_FGOData(String namech, String nameen, String namejp, String namechina, int rarity, int Class, int StatusATKLV1, int Status_HPLV1,
                      int StatusATKFinal, int Status_HPFinal, int StatusATKLV100, int Status_HPLV100, int Cost, int max_LV,
                      String class_describe1, String class_describe2, String class_describe3, String class_describe4,
                      int Command_Buster, int Command_Arts, int Command_Quick
    ){
        // Define Line 2.
        this.NameCH=namech;
        this.NameEN=nameen;
        this.NameJP=namejp;
        this.NameChina=namechina;
        //int
        this.Rarity=rarity;
        this.Class=Class;
        this.StatusATKLV1=StatusATKLV1;
        this.Status_HPLV1=Status_HPLV1;
        this.StatusATKFinal=StatusATKFinal;
        this.Status_HPFinal=Status_HPFinal;
        this.StatusATKLV100=StatusATKLV100;
        this.Status_HPLV100=Status_HPLV100;
        this.COST=Cost;
        this.MAX_LV=max_LV;
        //Class Describe
        this.Class_Describe1=class_describe1;
        this.Class_Describe2=class_describe2;
        this.Class_Describe3=class_describe3;
        this.Class_Describe4=class_describe4;
        //CommandCard
        this.Command_Buster=Command_Buster;
        this.Command_Arts=Command_Arts;
        this.Command_Quick=Command_Quick;


    }//Servant_Name + Servant_Rarity & Information Status + Class Describe(1-4) + CommandCard

    public FB_FGOData(String namech, String nameen, String namejp, String namechina, int rarity, int Class, int StatusATKLV1, int Status_HPLV1,
                      int StatusATKFinal, int Status_HPFinal, int StatusATKLV100, int Status_HPLV100, int Cost, int max_LV,
                      String class_describe1, String class_describe2, String class_describe3, String class_describe4,
                      int Command_Buster, int Command_Arts, int Command_Quick,
                      String Skill_Describe1, String Skill_Describe2, String Skill_Describe3, String Skill_Describe4, String Skill_Describe5, String Skill_Describe6
    ){
        // Define Line 2.
        this.NameCH=namech;
        this.NameEN=nameen;
        this.NameJP=namejp;
        this.NameChina=namechina;
        //int
        this.Rarity=rarity;
        this.Class=Class;
        this.StatusATKLV1=StatusATKLV1;
        this.Status_HPLV1=Status_HPLV1;
        this.StatusATKFinal=StatusATKFinal;
        this.Status_HPFinal=Status_HPFinal;
        this.StatusATKLV100=StatusATKLV100;
        this.Status_HPLV100=Status_HPLV100;
        this.COST=Cost;
        this.MAX_LV=max_LV;
        //Class Describe
        this.Class_Describe1=class_describe1;
        this.Class_Describe2=class_describe2;
        this.Class_Describe3=class_describe3;
        this.Class_Describe4=class_describe4;
        //CommandCard
        this.Command_Buster=Command_Buster;
        this.Command_Arts=Command_Arts;
        this.Command_Quick=Command_Quick;
        //Skill Describe
        this.Skill_Describe1=Skill_Describe1;
        this.Skill_Describe2=Skill_Describe2;
        this.Skill_Describe3=Skill_Describe3;
        this.Skill_Describe4=Skill_Describe4;
        this.Skill_Describe5=Skill_Describe5;
        this.Skill_Describe6=Skill_Describe6;

    }//Servant_Name + Servant_Rarity & Information Status + Class Describe(1-4) + CommandCard + SkillDescribe

    public FB_FGOData(String namech, String nameen, String namejp, String namechina, int rarity, int Class, int StatusATKLV1, int Status_HPLV1,
                      int StatusATKFinal, int Status_HPFinal, int StatusATKLV100, int Status_HPLV100, int Cost, int max_LV,
                      String class_describe1, String class_describe2, String class_describe3, String class_describe4,
                      int Command_Buster, int Command_Arts, int Command_Quick,
                      String Skill_Describe1, String Skill_Describe2, String Skill_Describe3, String Skill_Describe4, String Skill_Describe5, String Skill_Describe6,
                      String Skill_1_Effect1, String Skill_1_Effect2, String Skill_1_Effect3, String Skill_1_Effect4, String Skill_1_Effect5, String Skill_1_Effect6,
                      String Skill_1_Effect7, String Skill_1_Effect8, String Skill_1_Effect9, String Skill_1_Effect10,
                      String Skill_2_Effect1, String Skill_2_Effect2, String Skill_2_Effect3, String Skill_2_Effect4, String Skill_2_Effect5, String Skill_2_Effect6,
                      String Skill_2_Effect7, String Skill_2_Effect8, String Skill_2_Effect9, String Skill_2_Effect10,
                      String Skill_3_Effect1, String Skill_3_Effect2, String Skill_3_Effect3, String Skill_3_Effect4, String Skill_3_Effect5, String Skill_3_Effect6,
                      String Skill_3_Effect7, String Skill_3_Effect8, String Skill_3_Effect9, String Skill_3_Effect10
    ){
        // Define Line 2.
        this.NameCH=namech;
        this.NameEN=nameen;
        this.NameJP=namejp;
        this.NameChina=namechina;
        //int
        this.Rarity=rarity;
        this.Class=Class;
        this.StatusATKLV1=StatusATKLV1;
        this.Status_HPLV1=Status_HPLV1;
        this.StatusATKFinal=StatusATKFinal;
        this.Status_HPFinal=Status_HPFinal;
        this.StatusATKLV100=StatusATKLV100;
        this.Status_HPLV100=Status_HPLV100;
        this.COST=Cost;
        this.MAX_LV=max_LV;
        //Class Describe
        this.Class_Describe1=class_describe1;
        this.Class_Describe2=class_describe2;
        this.Class_Describe3=class_describe3;
        this.Class_Describe4=class_describe4;
        //CommandCard
        this.Command_Buster=Command_Buster;
        this.Command_Arts=Command_Arts;
        this.Command_Quick=Command_Quick;
        //Skill Describe
        this.Skill_Describe1=Skill_Describe1;
        this.Skill_Describe2=Skill_Describe2;
        this.Skill_Describe3=Skill_Describe3;
        this.Skill_Describe4=Skill_Describe4;
        this.Skill_Describe5=Skill_Describe5;
        this.Skill_Describe6=Skill_Describe6;
        //Skill Effect
        this.Skill_1_Effect1=Skill_1_Effect1;
        this.Skill_1_Effect2=Skill_1_Effect2;
        this.Skill_1_Effect3=Skill_1_Effect3;
        this.Skill_1_Effect4=Skill_1_Effect4;
        this.Skill_1_Effect5=Skill_1_Effect5;
        this.Skill_1_Effect6=Skill_1_Effect6;
        this.Skill_1_Effect7=Skill_1_Effect7;
        this.Skill_1_Effect8=Skill_1_Effect8;
        this.Skill_1_Effect9=Skill_1_Effect9;
        this.Skill_1_Effect10=Skill_1_Effect10;
        this.Skill_2_Effect1=Skill_2_Effect1;
        this.Skill_2_Effect2=Skill_2_Effect2;
        this.Skill_2_Effect3=Skill_2_Effect3;
        this.Skill_2_Effect4=Skill_2_Effect4;
        this.Skill_2_Effect5=Skill_2_Effect5;
        this.Skill_2_Effect6=Skill_2_Effect6;
        this.Skill_2_Effect7=Skill_2_Effect7;
        this.Skill_2_Effect8=Skill_2_Effect8;
        this.Skill_2_Effect9=Skill_2_Effect9;
        this.Skill_2_Effect10=Skill_2_Effect10;
        this.Skill_3_Effect1=Skill_3_Effect1;
        this.Skill_3_Effect2=Skill_3_Effect2;
        this.Skill_3_Effect3=Skill_3_Effect3;
        this.Skill_3_Effect4=Skill_3_Effect4;
        this.Skill_3_Effect5=Skill_3_Effect5;
        this.Skill_3_Effect6=Skill_3_Effect6;
        this.Skill_3_Effect7=Skill_3_Effect7;
        this.Skill_3_Effect8=Skill_3_Effect8;
        this.Skill_3_Effect9=Skill_3_Effect9;
        this.Skill_3_Effect10=Skill_3_Effect10;

    }//Servant_Name + Servant_Rarity & Information Status + Class Describe(1-4) + CommandCard + SkillDescribe + Skill_Effect

    public FB_FGOData(String namech, String nameen, String namejp, String namechina, int rarity, int Class, int StatusATKLV1, int Status_HPLV1,
                      int StatusATKFinal, int Status_HPFinal, int StatusATKLV100, int Status_HPLV100, int Cost, int max_LV,
                      String class_describe1, String class_describe2, String class_describe3, String class_describe4,
                      int Command_Buster, int Command_Arts, int Command_Quick,
                      String Skill_Describe1, String Skill_Describe2, String Skill_Describe3, String Skill_Describe4, String Skill_Describe5, String Skill_Describe6,
                      String Skill_1_Effect1, String Skill_1_Effect2, String Skill_1_Effect3, String Skill_1_Effect4, String Skill_1_Effect5, String Skill_1_Effect6,
                      String Skill_1_Effect7, String Skill_1_Effect8, String Skill_1_Effect9, String Skill_1_Effect10,
                      String Skill_2_Effect1, String Skill_2_Effect2, String Skill_2_Effect3, String Skill_2_Effect4, String Skill_2_Effect5, String Skill_2_Effect6,
                      String Skill_2_Effect7, String Skill_2_Effect8, String Skill_2_Effect9, String Skill_2_Effect10,
                      String Skill_3_Effect1, String Skill_3_Effect2, String Skill_3_Effect3, String Skill_3_Effect4, String Skill_3_Effect5, String Skill_3_Effect6,
                      String Skill_3_Effect7, String Skill_3_Effect8, String Skill_3_Effect9, String Skill_3_Effect10,
                      int NP_CardColor, String NP_Name1, String NP_Describe, String NP_Describe_Rank1, String NP_Describe_Target, String NP_1_Effect1,
                      String NP_1_Effect2, String NP_1_Effect3, String NP_1_Effect4, String NP_1_Effect5, String NP_Name2, String NP_Rank2,
                      String NP_2_Effect1, String NP_2_Effect2, String NP_2_Effect3, String NP_2_Effect4, String NP_2_Effect5

    ){
        //region Compelete
        // Define Line 2.
        this.NameCH=namech;
        this.NameEN=nameen;
        this.NameJP=namejp;
        this.NameChina=namechina;
        //int
        this.Rarity=rarity;
        this.Class=Class;
        this.StatusATKLV1=StatusATKLV1;
        this.Status_HPLV1=Status_HPLV1;
        this.StatusATKFinal=StatusATKFinal;
        this.Status_HPFinal=Status_HPFinal;
        this.StatusATKLV100=StatusATKLV100;
        this.Status_HPLV100=Status_HPLV100;
        this.COST=Cost;
        this.MAX_LV=max_LV;
        //Class Describe
        this.Class_Describe1=class_describe1;
        this.Class_Describe2=class_describe2;
        this.Class_Describe3=class_describe3;
        this.Class_Describe4=class_describe4;
        //CommandCard
        this.Command_Buster=Command_Buster;
        this.Command_Arts=Command_Arts;
        this.Command_Quick=Command_Quick;
        //Skill Describe
        this.Skill_Describe1=Skill_Describe1;
        this.Skill_Describe2=Skill_Describe2;
        this.Skill_Describe3=Skill_Describe3;
        this.Skill_Describe4=Skill_Describe4;
        this.Skill_Describe5=Skill_Describe5;
        this.Skill_Describe6=Skill_Describe6;
        //Skill Effect
        this.Skill_1_Effect1=Skill_1_Effect1;
        this.Skill_1_Effect2=Skill_1_Effect2;
        this.Skill_1_Effect3=Skill_1_Effect3;
        this.Skill_1_Effect4=Skill_1_Effect4;
        this.Skill_1_Effect5=Skill_1_Effect5;
        this.Skill_1_Effect6=Skill_1_Effect6;
        this.Skill_1_Effect7=Skill_1_Effect7;
        this.Skill_1_Effect8=Skill_1_Effect8;
        this.Skill_1_Effect9=Skill_1_Effect9;
        this.Skill_1_Effect10=Skill_1_Effect10;
        this.Skill_2_Effect1=Skill_2_Effect1;
        this.Skill_2_Effect2=Skill_2_Effect2;
        this.Skill_2_Effect3=Skill_2_Effect3;
        this.Skill_2_Effect4=Skill_2_Effect4;
        this.Skill_2_Effect5=Skill_2_Effect5;
        this.Skill_2_Effect6=Skill_2_Effect6;
        this.Skill_2_Effect7=Skill_2_Effect7;
        this.Skill_2_Effect8=Skill_2_Effect8;
        this.Skill_2_Effect9=Skill_2_Effect9;
        this.Skill_2_Effect10=Skill_2_Effect10;
        this.Skill_3_Effect1=Skill_3_Effect1;
        this.Skill_3_Effect2=Skill_3_Effect2;
        this.Skill_3_Effect3=Skill_3_Effect3;
        this.Skill_3_Effect4=Skill_3_Effect4;
        this.Skill_3_Effect5=Skill_3_Effect5;
        this.Skill_3_Effect6=Skill_3_Effect6;
        this.Skill_3_Effect7=Skill_3_Effect7;
        this.Skill_3_Effect8=Skill_3_Effect8;
        this.Skill_3_Effect9=Skill_3_Effect9;
        this.Skill_3_Effect10=Skill_3_Effect10;
        //endregion

        //region NP Describe
        this.NP_CardColor=NP_CardColor;
        this.NP_Name1=NP_Name1;
        this.NP_Describe=NP_Describe;
        this.NP_Describe_Rank1=NP_Describe_Rank1;
        this.NP_Describe_Target=NP_Describe_Target;
        this.NP_1_Effect1=NP_1_Effect1;
        this.NP_1_Effect2=NP_1_Effect2;
        this.NP_1_Effect3=NP_1_Effect3;
        this.NP_1_Effect4=NP_1_Effect4;
        this.NP_1_Effect5=NP_1_Effect5;
        this.NP_Name2=NP_Name2;
        this.NP_Rank2=NP_Rank2;
        this.NP_2_Effect1=NP_2_Effect1;
        this.NP_2_Effect2=NP_2_Effect2;
        this.NP_2_Effect3=NP_2_Effect3;
        this.NP_2_Effect4=NP_2_Effect4;
        this.NP_2_Effect5=NP_2_Effect5;
        //endregion

    }//Servant_Name + Servant_Rarity & Information Status + Class Describe(1-4) + CommandCard + SkillDescribe + Skill_Effect+
     //NP_Describe

    public FB_FGOData(String namech, String nameen, String namejp, String namechina, int rarity, int Class, int StatusATKLV1, int Status_HPLV1,
                      int StatusATKFinal, int Status_HPFinal, int StatusATKLV100, int Status_HPLV100, int Cost, int max_LV,
                      String class_describe1, String class_describe2, String class_describe3, String class_describe4,
                      int Command_Buster, int Command_Arts, int Command_Quick,
                      String Skill_Describe1, String Skill_Describe2, String Skill_Describe3, String Skill_Describe4, String Skill_Describe5, String Skill_Describe6,
                      String Skill_1_Effect1, String Skill_1_Effect2, String Skill_1_Effect3, String Skill_1_Effect4, String Skill_1_Effect5, String Skill_1_Effect6,
                      String Skill_1_Effect7, String Skill_1_Effect8, String Skill_1_Effect9, String Skill_1_Effect10,
                      String Skill_2_Effect1, String Skill_2_Effect2, String Skill_2_Effect3, String Skill_2_Effect4, String Skill_2_Effect5, String Skill_2_Effect6,
                      String Skill_2_Effect7, String Skill_2_Effect8, String Skill_2_Effect9, String Skill_2_Effect10,
                      String Skill_3_Effect1, String Skill_3_Effect2, String Skill_3_Effect3, String Skill_3_Effect4, String Skill_3_Effect5, String Skill_3_Effect6,
                      String Skill_3_Effect7, String Skill_3_Effect8, String Skill_3_Effect9, String Skill_3_Effect10,
                      int NP_CardColor, String NP_Name1, String NP_Describe, String NP_Describe_Rank1, String NP_Describe_Target, String NP_1_Effect1,
                      String NP_1_Effect2, String NP_1_Effect3, String NP_1_Effect4, String NP_1_Effect5, String NP_Name2, String NP_Rank2,
                      String NP_2_Effect1, String NP_2_Effect2, String NP_2_Effect3, String NP_2_Effect4, String NP_2_Effect5,
                      String LevelMaterialQP_1, String LevelMaterial_11, String RequireQuantity11, String LevelMaterial_12, String RequireQuantity12, String LevelMaterial_13, String RequireQuantity13, String LevelMaterial_14, String RequireQuantity14,
                      String LevelMaterialQP_2, String LevelMaterial_21, String RequireQuantity21, String LevelMaterial_22, String RequireQuantity22, String LevelMaterial_23, String RequireQuantity23, String LevelMaterial_24, String RequireQuantity24,
                      String LevelMaterialQP_3, String LevelMaterial_31, String RequireQuantity31, String LevelMaterial_32, String RequireQuantity32, String LevelMaterial_33, String RequireQuantity33, String LevelMaterial_34, String RequireQuantity34,
                      String LevelMaterialQP_4, String LevelMaterial_41, String RequireQuantity41, String LevelMaterial_42, String RequireQuantity42, String LevelMaterial_43, String RequireQuantity43, String LevelMaterial_44, String RequireQuantity44

    ){
        //region Compelete
        // Define Line 2.
        this.NameCH=namech;
        this.NameEN=nameen;
        this.NameJP=namejp;
        this.NameChina=namechina;
        //int
        this.Rarity=rarity;
        this.Class=Class;
        this.StatusATKLV1=StatusATKLV1;
        this.Status_HPLV1=Status_HPLV1;
        this.StatusATKFinal=StatusATKFinal;
        this.Status_HPFinal=Status_HPFinal;
        this.StatusATKLV100=StatusATKLV100;
        this.Status_HPLV100=Status_HPLV100;
        this.COST=Cost;
        this.MAX_LV=max_LV;
        //Class Describe
        this.Class_Describe1=class_describe1;
        this.Class_Describe2=class_describe2;
        this.Class_Describe3=class_describe3;
        this.Class_Describe4=class_describe4;
        //CommandCard
        this.Command_Buster=Command_Buster;
        this.Command_Arts=Command_Arts;
        this.Command_Quick=Command_Quick;
        //Skill Describe
        this.Skill_Describe1=Skill_Describe1;
        this.Skill_Describe2=Skill_Describe2;
        this.Skill_Describe3=Skill_Describe3;
        this.Skill_Describe4=Skill_Describe4;
        this.Skill_Describe5=Skill_Describe5;
        this.Skill_Describe6=Skill_Describe6;
        //Skill Effect
        this.Skill_1_Effect1=Skill_1_Effect1;
        this.Skill_1_Effect2=Skill_1_Effect2;
        this.Skill_1_Effect3=Skill_1_Effect3;
        this.Skill_1_Effect4=Skill_1_Effect4;
        this.Skill_1_Effect5=Skill_1_Effect5;
        this.Skill_1_Effect6=Skill_1_Effect6;
        this.Skill_1_Effect7=Skill_1_Effect7;
        this.Skill_1_Effect8=Skill_1_Effect8;
        this.Skill_1_Effect9=Skill_1_Effect9;
        this.Skill_1_Effect10=Skill_1_Effect10;
        this.Skill_2_Effect1=Skill_2_Effect1;
        this.Skill_2_Effect2=Skill_2_Effect2;
        this.Skill_2_Effect3=Skill_2_Effect3;
        this.Skill_2_Effect4=Skill_2_Effect4;
        this.Skill_2_Effect5=Skill_2_Effect5;
        this.Skill_2_Effect6=Skill_2_Effect6;
        this.Skill_2_Effect7=Skill_2_Effect7;
        this.Skill_2_Effect8=Skill_2_Effect8;
        this.Skill_2_Effect9=Skill_2_Effect9;
        this.Skill_2_Effect10=Skill_2_Effect10;
        this.Skill_3_Effect1=Skill_3_Effect1;
        this.Skill_3_Effect2=Skill_3_Effect2;
        this.Skill_3_Effect3=Skill_3_Effect3;
        this.Skill_3_Effect4=Skill_3_Effect4;
        this.Skill_3_Effect5=Skill_3_Effect5;
        this.Skill_3_Effect6=Skill_3_Effect6;
        this.Skill_3_Effect7=Skill_3_Effect7;
        this.Skill_3_Effect8=Skill_3_Effect8;
        this.Skill_3_Effect9=Skill_3_Effect9;
        this.Skill_3_Effect10=Skill_3_Effect10;
        //endregion

        //region NP Describe
        this.NP_CardColor=NP_CardColor;
        this.NP_Name1=NP_Name1;
        this.NP_Describe=NP_Describe;
        this.NP_Describe_Rank1=NP_Describe_Rank1;
        this.NP_Describe_Target=NP_Describe_Target;
        this.NP_1_Effect1=NP_1_Effect1;
        this.NP_1_Effect2=NP_1_Effect2;
        this.NP_1_Effect3=NP_1_Effect3;
        this.NP_1_Effect4=NP_1_Effect4;
        this.NP_1_Effect5=NP_1_Effect5;
        this.NP_Name2=NP_Name2;
        this.NP_Rank2=NP_Rank2;
        this.NP_2_Effect1=NP_2_Effect1;
        this.NP_2_Effect2=NP_2_Effect2;
        this.NP_2_Effect3=NP_2_Effect3;
        this.NP_2_Effect4=NP_2_Effect4;
        this.NP_2_Effect5=NP_2_Effect5;
        //endregion

        //region Level Required Material
        this.LevelMaterialQP_1=LevelMaterialQP_1;this.LevelMaterialQP_2=LevelMaterialQP_2;this.LevelMaterialQP_3=LevelMaterialQP_3;this.LevelMaterialQP_4=LevelMaterialQP_4;
        this.LevelMaterial_11=LevelMaterial_11;this.LevelMaterial_12=LevelMaterial_12;this.LevelMaterial_13=LevelMaterial_13;this.LevelMaterial_14=LevelMaterial_14;
        this.RequireQuantity11=RequireQuantity11;this.RequireQuantity12=RequireQuantity12;this.RequireQuantity13=RequireQuantity13;this.RequireQuantity14=RequireQuantity14;
        this.LevelMaterial_21=LevelMaterial_21;this.LevelMaterial_22=LevelMaterial_22;this.LevelMaterial_23=LevelMaterial_23;this.LevelMaterial_24=LevelMaterial_24;
        this.RequireQuantity21=RequireQuantity21;this.RequireQuantity22=RequireQuantity22;this.RequireQuantity23=RequireQuantity23;this.RequireQuantity24=RequireQuantity24;
        this.LevelMaterial_31=LevelMaterial_31;this.LevelMaterial_32=LevelMaterial_32;this.LevelMaterial_33=LevelMaterial_33;this.LevelMaterial_34=LevelMaterial_34;
        this.RequireQuantity31=RequireQuantity31;this.RequireQuantity32=RequireQuantity32;this.RequireQuantity33=RequireQuantity33;this.RequireQuantity24=RequireQuantity34;
        this.LevelMaterial_41=LevelMaterial_41;this.LevelMaterial_42=LevelMaterial_42;this.LevelMaterial_43=LevelMaterial_43;this.LevelMaterial_44=LevelMaterial_44;
        this.RequireQuantity41=RequireQuantity41;this.RequireQuantity42=RequireQuantity42;this.RequireQuantity43=RequireQuantity43;this.RequireQuantity44=RequireQuantity44;

        //endregion
    }//Servant_Name + Servant_Rarity & Information Status + Class Describe(1-4) + CommandCard + SkillDescribe + Skill_Effect+
    //NP_Describe

    public FB_FGOData(String namech, String nameen, String namejp, String namechina, int rarity, int Class, int StatusATKLV1, int Status_HPLV1,
                      int StatusATKFinal, int Status_HPFinal, int StatusATKLV100, int Status_HPLV100, int Cost, int max_LV,
                      String class_describe1, String class_describe2, String class_describe3, String class_describe4,
                      int Command_Buster, int Command_Arts, int Command_Quick,
                      String Skill_Describe1, String Skill_Describe2, String Skill_Describe3, String Skill_Describe4, String Skill_Describe5, String Skill_Describe6,
                      String Skill_1_Effect1, String Skill_1_Effect2, String Skill_1_Effect3, String Skill_1_Effect4, String Skill_1_Effect5, String Skill_1_Effect6,
                      String Skill_1_Effect7, String Skill_1_Effect8, String Skill_1_Effect9, String Skill_1_Effect10,
                      String Skill_2_Effect1, String Skill_2_Effect2, String Skill_2_Effect3, String Skill_2_Effect4, String Skill_2_Effect5, String Skill_2_Effect6,
                      String Skill_2_Effect7, String Skill_2_Effect8, String Skill_2_Effect9, String Skill_2_Effect10,
                      String Skill_3_Effect1, String Skill_3_Effect2, String Skill_3_Effect3, String Skill_3_Effect4, String Skill_3_Effect5, String Skill_3_Effect6,
                      String Skill_3_Effect7, String Skill_3_Effect8, String Skill_3_Effect9, String Skill_3_Effect10,
                      int NP_CardColor, String NP_Name1, String NP_Describe, String NP_Describe_Rank1, String NP_Describe_Target, String NP_1_Effect1,
                      String NP_1_Effect2, String NP_1_Effect3, String NP_1_Effect4, String NP_1_Effect5, String NP_Name2, String NP_Rank2,
                      String NP_2_Effect1, String NP_2_Effect2, String NP_2_Effect3, String NP_2_Effect4, String NP_2_Effect5,
                      String LevelMaterialQP_1, String LevelMaterial_11, String RequireQuantity11, String LevelMaterial_12, String RequireQuantity12, String LevelMaterial_13, String RequireQuantity13, String LevelMaterial_14, String RequireQuantity14,
                      String LevelMaterialQP_2, String LevelMaterial_21, String RequireQuantity21, String LevelMaterial_22, String RequireQuantity22, String LevelMaterial_23, String RequireQuantity23, String LevelMaterial_24, String RequireQuantity24,
                      String LevelMaterialQP_3, String LevelMaterial_31, String RequireQuantity31, String LevelMaterial_32, String RequireQuantity32, String LevelMaterial_33, String RequireQuantity33, String LevelMaterial_34, String RequireQuantity34,
                      String LevelMaterialQP_4, String LevelMaterial_41, String RequireQuantity41, String LevelMaterial_42, String RequireQuantity42, String LevelMaterial_43, String RequireQuantity43, String LevelMaterial_44, String RequireQuantity44,
                      String Skill_QP2, String Skill_Material21, String Skill_RequireQuantity21, String Skill_Material22, String Skill_RequireQuantity22, String Skill_Material23, String Skill_RequireQuantity23, String Skill_Material24, String Skill_RequireQuantity24,
                      String Skill_QP3, String Skill_Material31, String Skill_RequireQuantity31, String Skill_Material32, String Skill_RequireQuantity32, String Skill_Material33, String Skill_RequireQuantity33, String Skill_Material34, String Skill_RequireQuantity34,
                      String Skill_QP4, String Skill_Material41, String Skill_RequireQuantity41, String Skill_Material42, String Skill_RequireQuantity42, String Skill_Material43, String Skill_RequireQuantity43, String Skill_Material44, String Skill_RequireQuantity44,
                      String Skill_QP5, String Skill_Material51, String Skill_RequireQuantity51, String Skill_Material52, String Skill_RequireQuantity52, String Skill_Material53, String Skill_RequireQuantity53, String Skill_Material54, String Skill_RequireQuantity54,
                      String Skill_QP6, String Skill_Material61, String Skill_RequireQuantity61, String Skill_Material62, String Skill_RequireQuantity62, String Skill_Material63, String Skill_RequireQuantity63, String Skill_Material64, String Skill_RequireQuantity64,
                      String Skill_QP7, String Skill_Material71, String Skill_RequireQuantity71, String Skill_Material72, String Skill_RequireQuantity72, String Skill_Material73, String Skill_RequireQuantity73, String Skill_Material74, String Skill_RequireQuantity74,
                      String Skill_QP8, String Skill_Material81, String Skill_RequireQuantity81, String Skill_Material82, String Skill_RequireQuantity82, String Skill_Material83, String Skill_RequireQuantity83, String Skill_Material84, String Skill_RequireQuantity84,
                      String Skill_QP9, String Skill_Material91, String Skill_RequireQuantity91, String Skill_Material92, String Skill_RequireQuantity92, String Skill_Material93, String Skill_RequireQuantity93, String Skill_Material94, String Skill_RequireQuantity94,
                      String Skill_QP10, String Skill_Material101, String Skill_RequireQuantity101, String Skill_Material102, String Skill_RequireQuantity102, String Skill_Material103, String Skill_RequireQuantity103, String Skill_Material104, String Skill_RequireQuantity104

    ){
        //region Compelete
        // Define Line 2.
        this.NameCH=namech;
        this.NameEN=nameen;
        this.NameJP=namejp;
        this.NameChina=namechina;
        //int
        this.Rarity=rarity;
        this.Class=Class;
        this.StatusATKLV1=StatusATKLV1;
        this.Status_HPLV1=Status_HPLV1;
        this.StatusATKFinal=StatusATKFinal;
        this.Status_HPFinal=Status_HPFinal;
        this.StatusATKLV100=StatusATKLV100;
        this.Status_HPLV100=Status_HPLV100;
        this.COST=Cost;
        this.MAX_LV=max_LV;
        //Class Describe
        this.Class_Describe1=class_describe1;
        this.Class_Describe2=class_describe2;
        this.Class_Describe3=class_describe3;
        this.Class_Describe4=class_describe4;
        //CommandCard
        this.Command_Buster=Command_Buster;
        this.Command_Arts=Command_Arts;
        this.Command_Quick=Command_Quick;
        //Skill Describe
        this.Skill_Describe1=Skill_Describe1;
        this.Skill_Describe2=Skill_Describe2;
        this.Skill_Describe3=Skill_Describe3;
        this.Skill_Describe4=Skill_Describe4;
        this.Skill_Describe5=Skill_Describe5;
        this.Skill_Describe6=Skill_Describe6;
        //Skill Effect
        this.Skill_1_Effect1=Skill_1_Effect1;
        this.Skill_1_Effect2=Skill_1_Effect2;
        this.Skill_1_Effect3=Skill_1_Effect3;
        this.Skill_1_Effect4=Skill_1_Effect4;
        this.Skill_1_Effect5=Skill_1_Effect5;
        this.Skill_1_Effect6=Skill_1_Effect6;
        this.Skill_1_Effect7=Skill_1_Effect7;
        this.Skill_1_Effect8=Skill_1_Effect8;
        this.Skill_1_Effect9=Skill_1_Effect9;
        this.Skill_1_Effect10=Skill_1_Effect10;
        this.Skill_2_Effect1=Skill_2_Effect1;
        this.Skill_2_Effect2=Skill_2_Effect2;
        this.Skill_2_Effect3=Skill_2_Effect3;
        this.Skill_2_Effect4=Skill_2_Effect4;
        this.Skill_2_Effect5=Skill_2_Effect5;
        this.Skill_2_Effect6=Skill_2_Effect6;
        this.Skill_2_Effect7=Skill_2_Effect7;
        this.Skill_2_Effect8=Skill_2_Effect8;
        this.Skill_2_Effect9=Skill_2_Effect9;
        this.Skill_2_Effect10=Skill_2_Effect10;
        this.Skill_3_Effect1=Skill_3_Effect1;
        this.Skill_3_Effect2=Skill_3_Effect2;
        this.Skill_3_Effect3=Skill_3_Effect3;
        this.Skill_3_Effect4=Skill_3_Effect4;
        this.Skill_3_Effect5=Skill_3_Effect5;
        this.Skill_3_Effect6=Skill_3_Effect6;
        this.Skill_3_Effect7=Skill_3_Effect7;
        this.Skill_3_Effect8=Skill_3_Effect8;
        this.Skill_3_Effect9=Skill_3_Effect9;
        this.Skill_3_Effect10=Skill_3_Effect10;
        //endregion
        //region NP Describe
        this.NP_CardColor=NP_CardColor;
        this.NP_Name1=NP_Name1;
        this.NP_Describe=NP_Describe;
        this.NP_Describe_Rank1=NP_Describe_Rank1;
        this.NP_Describe_Target=NP_Describe_Target;
        this.NP_1_Effect1=NP_1_Effect1;
        this.NP_1_Effect2=NP_1_Effect2;
        this.NP_1_Effect3=NP_1_Effect3;
        this.NP_1_Effect4=NP_1_Effect4;
        this.NP_1_Effect5=NP_1_Effect5;
        this.NP_Name2=NP_Name2;
        this.NP_Rank2=NP_Rank2;
        this.NP_2_Effect1=NP_2_Effect1;
        this.NP_2_Effect2=NP_2_Effect2;
        this.NP_2_Effect3=NP_2_Effect3;
        this.NP_2_Effect4=NP_2_Effect4;
        this.NP_2_Effect5=NP_2_Effect5;
        //endregion
        //region Level Required Material
        this.LevelMaterialQP_1=LevelMaterialQP_1;this.LevelMaterialQP_2=LevelMaterialQP_2;this.LevelMaterialQP_3=LevelMaterialQP_3;this.LevelMaterialQP_4=LevelMaterialQP_4;
        this.LevelMaterial_11=LevelMaterial_11;this.LevelMaterial_12=LevelMaterial_12;this.LevelMaterial_13=LevelMaterial_13;this.LevelMaterial_14=LevelMaterial_14;
        this.RequireQuantity11=RequireQuantity11;this.RequireQuantity12=RequireQuantity12;this.RequireQuantity13=RequireQuantity13;this.RequireQuantity14=RequireQuantity14;
        this.LevelMaterial_21=LevelMaterial_21;this.LevelMaterial_22=LevelMaterial_22;this.LevelMaterial_23=LevelMaterial_23;this.LevelMaterial_24=LevelMaterial_24;
        this.RequireQuantity21=RequireQuantity21;this.RequireQuantity22=RequireQuantity22;this.RequireQuantity23=RequireQuantity23;this.RequireQuantity24=RequireQuantity24;
        this.LevelMaterial_31=LevelMaterial_31;this.LevelMaterial_32=LevelMaterial_32;this.LevelMaterial_33=LevelMaterial_33;this.LevelMaterial_34=LevelMaterial_34;
        this.RequireQuantity31=RequireQuantity31;this.RequireQuantity32=RequireQuantity32;this.RequireQuantity33=RequireQuantity33;this.RequireQuantity24=RequireQuantity34;
        this.LevelMaterial_41=LevelMaterial_41;this.LevelMaterial_42=LevelMaterial_42;this.LevelMaterial_43=LevelMaterial_43;this.LevelMaterial_44=LevelMaterial_44;
        this.RequireQuantity41=RequireQuantity41;this.RequireQuantity42=RequireQuantity42;this.RequireQuantity43=RequireQuantity43;this.RequireQuantity44=RequireQuantity44;

        //endregion

        //region Skill Material
        this.Skill_QP2=Skill_QP2;this.Skill_QP3=Skill_QP3;this.Skill_QP4=Skill_QP4;this.Skill_QP5=Skill_QP5;this.Skill_QP6=Skill_QP6;this.Skill_QP7=Skill_QP7;this.Skill_QP8=Skill_QP8;this.Skill_QP9=Skill_QP9;this.Skill_QP10=Skill_QP10;
        this.Skill_Material21=Skill_Material21;this.Skill_Material22=Skill_Material22;this.Skill_Material23=Skill_Material23;this.Skill_Material24=Skill_Material24;
        this.Skill_Material31=Skill_Material31;this.Skill_Material32=Skill_Material32;this.Skill_Material33=Skill_Material33;this.Skill_Material34=Skill_Material34;
        this.Skill_Material41=Skill_Material41;this.Skill_Material42=Skill_Material42;this.Skill_Material43=Skill_Material43;this.Skill_Material44=Skill_Material44;
        this.Skill_Material51=Skill_Material51;this.Skill_Material52=Skill_Material52;this.Skill_Material53=Skill_Material53;this.Skill_Material54=Skill_Material54;
        this.Skill_Material61=Skill_Material61;this.Skill_Material62=Skill_Material62;this.Skill_Material63=Skill_Material63;this.Skill_Material64=Skill_Material64;
        this.Skill_Material71=Skill_Material71;this.Skill_Material72=Skill_Material72;this.Skill_Material73=Skill_Material73;this.Skill_Material74=Skill_Material74;
        this.Skill_Material81=Skill_Material81;this.Skill_Material82=Skill_Material82;this.Skill_Material83=Skill_Material83;this.Skill_Material84=Skill_Material84;
        this.Skill_Material91=Skill_Material91;this.Skill_Material92=Skill_Material92;this.Skill_Material93=Skill_Material93;this.Skill_Material94=Skill_Material94;
        this.Skill_Material101=Skill_Material101;this.Skill_Material102=Skill_Material102;this.Skill_Material103=Skill_Material103;this.Skill_Material104=Skill_Material104;

        this.Skill_RequireQuantity21=Skill_RequireQuantity21;this.Skill_RequireQuantity22=Skill_RequireQuantity22;this.Skill_RequireQuantity23=Skill_RequireQuantity23;this.Skill_RequireQuantity24=Skill_RequireQuantity24;
        this.Skill_RequireQuantity31=Skill_RequireQuantity31;this.Skill_RequireQuantity32=Skill_RequireQuantity32;this.Skill_RequireQuantity33=Skill_RequireQuantity33;this.Skill_RequireQuantity34=Skill_RequireQuantity34;
        this.Skill_RequireQuantity41=Skill_RequireQuantity41;this.Skill_RequireQuantity42=Skill_RequireQuantity42;this.Skill_RequireQuantity43=Skill_RequireQuantity43;this.Skill_RequireQuantity44=Skill_RequireQuantity44;
        this.Skill_RequireQuantity51=Skill_RequireQuantity51;this.Skill_RequireQuantity52=Skill_RequireQuantity52;this.Skill_RequireQuantity53=Skill_RequireQuantity53;this.Skill_RequireQuantity54=Skill_RequireQuantity54;
        this.Skill_RequireQuantity61=Skill_RequireQuantity61;this.Skill_RequireQuantity62=Skill_RequireQuantity62;this.Skill_RequireQuantity63=Skill_RequireQuantity63;this.Skill_RequireQuantity64=Skill_RequireQuantity64;
        this.Skill_RequireQuantity71=Skill_RequireQuantity71;this.Skill_RequireQuantity72=Skill_RequireQuantity72;this.Skill_RequireQuantity73=Skill_RequireQuantity73;this.Skill_RequireQuantity74=Skill_RequireQuantity74;
        this.Skill_RequireQuantity81=Skill_RequireQuantity81;this.Skill_RequireQuantity82=Skill_RequireQuantity82;this.Skill_RequireQuantity83=Skill_RequireQuantity83;this.Skill_RequireQuantity84=Skill_RequireQuantity84;
        this.Skill_RequireQuantity91=Skill_RequireQuantity91;this.Skill_RequireQuantity92=Skill_RequireQuantity92;this.Skill_RequireQuantity93=Skill_RequireQuantity93;this.Skill_RequireQuantity94=Skill_RequireQuantity94;
        this.Skill_RequireQuantity101=Skill_RequireQuantity101;this.Skill_RequireQuantity102=Skill_RequireQuantity102;this.Skill_RequireQuantity103=Skill_RequireQuantity103;this.Skill_RequireQuantity104=Skill_RequireQuantity104;

        //endregion
    }//Servant_Name + Servant_Rarity & Information Status + Class Describe(1-4) + CommandCard + SkillDescribe + Skill_Effect+
    //NP_Describe + Skill_Material_(1-10)

    //region GetValue

    public String getNameCH()
    {
        return this.NameCH;
    }
    public String getNameEN()
    {
        return this.NameEN;
    }
    public String getNameJP()
    {
        return this.NameJP;
    }
    public String getNameChina()
    {
        return this.NameChina;
    }
    //getINT
    public int getRarity()
    {
        return this.Rarity;
    }
    public int getServantClass()
    {
        return this.Class;
    }
    public int getStatusATKLV1()
    {
        return this.StatusATKLV1;
    }
    public int getStatus_HPLV1(){
        return this.Status_HPLV1;
    }
    public int getStatusATKFinal(){
        return this.StatusATKFinal;
    }
    public int getStatus_HPFinal(){
        return this.Status_HPFinal;
    }
    public int getStatusATKLV100(){
        return this.StatusATKLV100;
    }
    public int getStatus_HPLV100(){
        return this.Status_HPLV100;
    }
    public int getCOST(){
        return this.COST;
    }
    public int getMAX_LV(){
        return this.MAX_LV;
    }
    //region Class Describe
    public String getClass_Describe1(){
        return this.Class_Describe1;
    }
    public String getClass_Describe2(){
        return this.Class_Describe2;
    }
    public String getClass_Describe3(){
        return this.Class_Describe3;
    }
    public String getClass_Describe4(){
        return this.Class_Describe4;
    }
    //endregion
    //region Skill Describe
    public String getSkill_Describe1(){
        return this.Skill_Describe1;
    }
    public String getSkill_Describe2(){
        return this.Skill_Describe2;
    }
    public String getSkill_Describe3(){
        return this.Skill_Describe3;
    }
    public String getSkill_Describe4(){
        return this.Skill_Describe4;
    }
    public String getSkill_Describe5(){
        return this.Skill_Describe5;
    }
    public String getSkill_Describe6(){
        return this.Skill_Describe6;
    }
    //rendregion
    //region CommandCard
    public int getCommand_Buster(){
        return this.Command_Buster;
    }
    public int getCommand_Arts(){
        return this.Command_Arts;
    }
    public int getCommand_Quick(){
        return this.Command_Quick;
    }
    //endregion
    //region NP_Describe
    public int getNP_CardColor(){return this.NP_CardColor;}
    public String getNP_Name1(){return this.NP_Name1;}
    public String getNP_Describe(){return this.NP_Describe;}
    public String getNP_Describe_Rank1(){return this.NP_Describe_Rank1;}
    public String getNP_Describe_Target(){return this.NP_Describe_Target;}
    public String getNP_1_Effect1(){return this.NP_1_Effect1;}
    public String getNP_1_Effect2(){return this.NP_1_Effect2;}
    public String getNP_1_Effect3(){return this.NP_1_Effect3;}
    public String getNP_1_Effect4(){return this.NP_1_Effect4;}
    public String getNP_1_Effect5(){return this.NP_1_Effect5;}
    public String getNP_Name2(){return this.NP_Name2;}
    public String getNP_Rank2(){return this.NP_Rank2;}
    public String getNP_2_Effect1(){return this.NP_2_Effect1;}
    public String getNP_2_Effect2(){return this.NP_2_Effect2;}
    public String getNP_2_Effect3(){return this.NP_2_Effect3;}
    public String getNP_2_Effect4(){return this.NP_2_Effect4;}
    public String getNP_2_Effect5(){return this.NP_2_Effect5;}


    //endregion
    //region Skill_Effect Info
    public String getSkill_1_Effect1(){return this.Skill_1_Effect1;}
    public String getSkill_1_Effect2(){return this.Skill_1_Effect2;}
    public String getSkill_1_Effect3(){return this.Skill_1_Effect3;}
    public String getSkill_1_Effect4(){return this.Skill_1_Effect4;}
    public String getSkill_1_Effect5(){return this.Skill_1_Effect5;}
    public String getSkill_1_Effect6(){return this.Skill_1_Effect6;}
    public String getSkill_1_Effect7(){return this.Skill_1_Effect7;}
    public String getSkill_1_Effect8(){return this.Skill_1_Effect8;}
    public String getSkill_1_Effect9(){return this.Skill_1_Effect9;}
    public String getSkill_1_Effect10(){return this.Skill_1_Effect10;}
    //2
    public String getSkill_2_Effect1(){return this.Skill_2_Effect1;}
    public String getSkill_2_Effect2(){return this.Skill_2_Effect2;}
    public String getSkill_2_Effect3(){return this.Skill_2_Effect3;}
    public String getSkill_2_Effect4(){return this.Skill_2_Effect4;}
    public String getSkill_2_Effect5(){return this.Skill_2_Effect5;}
    public String getSkill_2_Effect6(){return this.Skill_2_Effect6;}
    public String getSkill_2_Effect7(){return this.Skill_2_Effect7;}
    public String getSkill_2_Effect8(){return this.Skill_2_Effect8;}
    public String getSkill_2_Effect9(){return this.Skill_2_Effect9;}
    public String getSkill_2_Effect10(){return this.Skill_2_Effect10;}
    //3
    public String getSkill_3_Effect1(){return this.Skill_3_Effect1;}
    public String getSkill_3_Effect2(){return this.Skill_3_Effect2;}
    public String getSkill_3_Effect3(){return this.Skill_3_Effect3;}
    public String getSkill_3_Effect4(){return this.Skill_3_Effect4;}
    public String getSkill_3_Effect5(){return this.Skill_3_Effect5;}
    public String getSkill_3_Effect6(){return this.Skill_3_Effect6;}
    public String getSkill_3_Effect7(){return this.Skill_3_Effect7;}
    public String getSkill_3_Effect8(){return this.Skill_3_Effect8;}
    public String getSkill_3_Effect9(){return this.Skill_3_Effect9;}
    public String getSkill_3_Effect10(){return this.Skill_3_Effect10;}
    //endregion
    //region Level Required Material

    public String getRequireQuantity11() {
        return this.RequireQuantity11;
    }

    public String getRequireQuantity12() {
        return this.RequireQuantity12;
    }

    public String getRequireQuantity13() {
        return this.RequireQuantity13;
    }

    public String getRequireQuantity14() {
        return this.RequireQuantity14;
    }

    public String getRequireQuantity21() {
        return this.RequireQuantity21;
    }

    public String getRequireQuantity22() {
        return this.RequireQuantity22;
    }

    public String getRequireQuantity23() {
        return this.RequireQuantity23;
    }

    public String getRequireQuantity24() {
        return this.RequireQuantity24;
    }

    public String getRequireQuantity31() {
        return this.RequireQuantity31;
    }

    public String getRequireQuantity32() {
        return this.RequireQuantity32;
    }

    public String getRequireQuantity33() {
        return this.RequireQuantity33;
    }

    public String getRequireQuantity34() {
        return this.RequireQuantity34;
    }

    public String getRequireQuantity41() {
        return this.RequireQuantity41;
    }

    public String getRequireQuantity42() {
        return this.RequireQuantity42;
    }

    public String getRequireQuantity43() {
        return this.RequireQuantity43;
    }

    public String getRequireQuantity44() {
        return this.RequireQuantity44;
    }

    public String getLevelMaterial_11() {
        return this.LevelMaterial_11;
    }

    public String getLevelMaterial_12() {
        return this.LevelMaterial_12;
    }

    public String getLevelMaterial_13() {
        return this.LevelMaterial_13;
    }

    public String getLevelMaterial_14() {
        return this.LevelMaterial_14;
    }

    public String getLevelMaterial_21() {
        return this.LevelMaterial_21;
    }

    public String getLevelMaterial_22() {
        return this.LevelMaterial_22;
    }

    public String getLevelMaterial_23() {
        return this.LevelMaterial_23;
    }

    public String getLevelMaterial_24() {
        return this.LevelMaterial_24;
    }

    public String getLevelMaterial_31() {
        return this.LevelMaterial_31;
    }

    public String getLevelMaterial_32() {
        return this.LevelMaterial_32;
    }

    public String getLevelMaterial_33() {
        return this.LevelMaterial_33;
    }

    public String getLevelMaterial_34() {
        return this.LevelMaterial_34;
    }

    public String getLevelMaterial_41() {
        return this.LevelMaterial_41;
    }

    public String getLevelMaterial_42() {
        return this.LevelMaterial_42;
    }

    public String getLevelMaterial_43() {
        return this.LevelMaterial_43;
    }

    public String getLevelMaterial_44() {
        return this.LevelMaterial_44;
    }

    public String getLevelMaterialQP_1() {
        return this.LevelMaterialQP_1;
    }

    public String getLevelMaterialQP_2() {
        return this.LevelMaterialQP_2;
    }

    public String getLevelMaterialQP_3() {
        return this.LevelMaterialQP_3;
    }

    public String getLevelMaterialQP_4() {
        return this.LevelMaterialQP_4;
    }

//endregion

//region Skill Material

    public String getSkill_Material21() {
        return Skill_Material21;
    }

    public void setSkill_Material21(String skill_Material21) {
        Skill_Material21 = skill_Material21;
    }

    public String getSkill_Material22() {
        return Skill_Material22;
    }

    public void setSkill_Material22(String skill_Material22) {
        Skill_Material22 = skill_Material22;
    }

    public String getSkill_Material23() {
        return Skill_Material23;
    }

    public void setSkill_Material23(String skill_Material23) {
        Skill_Material23 = skill_Material23;
    }

    public String getSkill_Material24() {
        return Skill_Material24;
    }

    public void setSkill_Material24(String skill_Material24) {
        Skill_Material24 = skill_Material24;
    }

    public String getSkill_QP2() {
        return Skill_QP2;
    }

    public void setSkill_QP2(String skill_QP2) {
        Skill_QP2 = skill_QP2;
    }

    public String getSkill_Material31() {
        return Skill_Material31;
    }

    public void setSkill_Material31(String skill_Material31) {
        Skill_Material31 = skill_Material31;
    }

    public String getSkill_Material32() {
        return Skill_Material32;
    }

    public void setSkill_Material32(String skill_Material32) {
        Skill_Material32 = skill_Material32;
    }

    public String getSkill_Material33() {
        return Skill_Material33;
    }

    public void setSkill_Material33(String skill_Material33) {
        Skill_Material33 = skill_Material33;
    }

    public String getSkill_Material34() {
        return Skill_Material34;
    }

    public void setSkill_Material34(String skill_Material34) {
        Skill_Material34 = skill_Material34;
    }

    public String getSkill_QP3() {
        return Skill_QP3;
    }

    public void setSkill_QP3(String skill_QP3) {
        Skill_QP3 = skill_QP3;
    }

    public String getSkill_Material41() {
        return Skill_Material41;
    }

    public void setSkill_Material41(String skill_Material41) {
        Skill_Material41 = skill_Material41;
    }

    public String getSkill_Material42() {
        return Skill_Material42;
    }

    public void setSkill_Material42(String skill_Material42) {
        Skill_Material42 = skill_Material42;
    }

    public String getSkill_Material43() {
        return Skill_Material43;
    }

    public void setSkill_Material43(String skill_Material43) {
        Skill_Material43 = skill_Material43;
    }

    public String getSkill_Material44() {
        return Skill_Material44;
    }

    public void setSkill_Material44(String skill_Material44) {
        Skill_Material44 = skill_Material44;
    }

    public String getSkill_QP4() {
        return Skill_QP4;
    }

    public void setSkill_QP4(String skill_QP4) {
        Skill_QP4 = skill_QP4;
    }

    public String getSkill_Material51() {
        return Skill_Material51;
    }

    public void setSkill_Material51(String skill_Material51) {
        Skill_Material51 = skill_Material51;
    }

    public String getSkill_Material52() {
        return Skill_Material52;
    }

    public void setSkill_Material52(String skill_Material52) {
        Skill_Material52 = skill_Material52;
    }

    public String getSkill_Material53() {
        return Skill_Material53;
    }

    public void setSkill_Material53(String skill_Material53) {
        Skill_Material53 = skill_Material53;
    }

    public String getSkill_Material54() {
        return Skill_Material54;
    }

    public void setSkill_Material54(String skill_Material54) {
        Skill_Material54 = skill_Material54;
    }

    public String getSkill_QP5() {
        return Skill_QP5;
    }

    public void setSkill_QP5(String skill_QP5) {
        Skill_QP5 = skill_QP5;
    }

    public String getSkill_Material61() {
        return Skill_Material61;
    }

    public void setSkill_Material61(String skill_Material61) {
        Skill_Material61 = skill_Material61;
    }

    public String getSkill_Material62() {
        return Skill_Material62;
    }

    public void setSkill_Material62(String skill_Material62) {
        Skill_Material62 = skill_Material62;
    }

    public String getSkill_Material63() {
        return Skill_Material63;
    }

    public void setSkill_Material63(String skill_Material63) {
        Skill_Material63 = skill_Material63;
    }

    public String getSkill_Material64() {
        return Skill_Material64;
    }

    public void setSkill_Material64(String skill_Material64) {
        Skill_Material64 = skill_Material64;
    }

    public String getSkill_QP6() {
        return Skill_QP6;
    }

    public void setSkill_QP6(String skill_QP6) {
        Skill_QP6 = skill_QP6;
    }

    public String getSkill_Material71() {
        return Skill_Material71;
    }

    public void setSkill_Material71(String skill_Material71) {
        Skill_Material71 = skill_Material71;
    }

    public String getSkill_Material72() {
        return Skill_Material72;
    }

    public void setSkill_Material72(String skill_Material72) {
        Skill_Material72 = skill_Material72;
    }

    public String getSkill_Material73() {
        return Skill_Material73;
    }

    public void setSkill_Material73(String skill_Material73) {
        Skill_Material73 = skill_Material73;
    }

    public String getSkill_Material74() {
        return Skill_Material74;
    }

    public void setSkill_Material74(String skill_Material74) {
        Skill_Material74 = skill_Material74;
    }

    public String getSkill_QP7() {
        return Skill_QP7;
    }

    public void setSkill_QP7(String skill_QP7) {
        Skill_QP7 = skill_QP7;
    }

    public String getSkill_Material81() {
        return Skill_Material81;
    }

    public void setSkill_Material81(String skill_Material81) {
        Skill_Material81 = skill_Material81;
    }

    public String getSkill_Material82() {
        return Skill_Material82;
    }

    public void setSkill_Material82(String skill_Material82) {
        Skill_Material82 = skill_Material82;
    }

    public String getSkill_Material83() {
        return Skill_Material83;
    }

    public void setSkill_Material83(String skill_Material83) {
        Skill_Material83 = skill_Material83;
    }

    public String getSkill_Material84() {
        return Skill_Material84;
    }

    public void setSkill_Material84(String skill_Material84) {
        Skill_Material84 = skill_Material84;
    }

    public String getSkill_QP8() {
        return Skill_QP8;
    }

    public void setSkill_QP8(String skill_QP8) {
        Skill_QP8 = skill_QP8;
    }

    public String getSkill_Material91() {
        return Skill_Material91;
    }

    public void setSkill_Material91(String skill_Material91) {
        Skill_Material91 = skill_Material91;
    }

    public String getSkill_Material92() {
        return Skill_Material92;
    }

    public void setSkill_Material92(String skill_Material92) {
        Skill_Material92 = skill_Material92;
    }

    public String getSkill_Material93() {
        return Skill_Material93;
    }

    public void setSkill_Material93(String skill_Material93) {
        Skill_Material93 = skill_Material93;
    }

    public String getSkill_Material94() {
        return Skill_Material94;
    }

    public void setSkill_Material94(String skill_Material94) {
        Skill_Material94 = skill_Material94;
    }

    public String getSkill_QP9() {
        return Skill_QP9;
    }

    public void setSkill_QP9(String skill_QP9) {
        Skill_QP9 = skill_QP9;
    }

    public String getSkill_Material101() {
        return Skill_Material101;
    }

    public void setSkill_Material101(String skill_Material101) {
        Skill_Material101 = skill_Material101;
    }

    public String getSkill_Material102() {
        return Skill_Material102;
    }

    public void setSkill_Material102(String skill_Material102) {
        Skill_Material102 = skill_Material102;
    }

    public String getSkill_Material103() {
        return Skill_Material103;
    }

    public void setSkill_Material103(String skill_Material103) {
        Skill_Material103 = skill_Material103;
    }

    public String getSkill_Material104() {
        return Skill_Material104;
    }

    public void setSkill_Material104(String skill_Material104) {
        Skill_Material104 = skill_Material104;
    }

    public String getSkill_QP10() {
        return Skill_QP10;
    }

    public void setSkill_QP10(String skill_QP10) {
        Skill_QP10 = skill_QP10;
    }

    public String getSkill_RequireQuantity21() {
        return Skill_RequireQuantity21;
    }

    public void setSkill_RequireQuantity21(String skill_RequireQuantity21) {
        Skill_RequireQuantity21 = skill_RequireQuantity21;
    }

    public String getSkill_RequireQuantity22() {
        return Skill_RequireQuantity22;
    }

    public void setSkill_RequireQuantity22(String skill_RequireQuantity22) {
        Skill_RequireQuantity22 = skill_RequireQuantity22;
    }

    public String getSkill_RequireQuantity23() {
        return Skill_RequireQuantity23;
    }

    public void setSkill_RequireQuantity23(String skill_RequireQuantity23) {
        Skill_RequireQuantity23 = skill_RequireQuantity23;
    }

    public String getSkill_RequireQuantity24() {
        return Skill_RequireQuantity24;
    }

    public void setSkill_RequireQuantity24(String skill_RequireQuantity24) {
        Skill_RequireQuantity24 = skill_RequireQuantity24;
    }

    public String getSkill_RequireQuantity31() {
        return Skill_RequireQuantity31;
    }

    public void setSkill_RequireQuantity31(String skill_RequireQuantity31) {
        Skill_RequireQuantity31 = skill_RequireQuantity31;
    }

    public String getSkill_RequireQuantity32() {
        return Skill_RequireQuantity32;
    }

    public void setSkill_RequireQuantity32(String skill_RequireQuantity32) {
        Skill_RequireQuantity32 = skill_RequireQuantity32;
    }

    public String getSkill_RequireQuantity33() {
        return Skill_RequireQuantity33;
    }

    public void setSkill_RequireQuantity33(String skill_RequireQuantity33) {
        Skill_RequireQuantity33 = skill_RequireQuantity33;
    }

    public String getSkill_RequireQuantity34() {
        return Skill_RequireQuantity34;
    }

    public void setSkill_RequireQuantity34(String skill_RequireQuantity34) {
        Skill_RequireQuantity34 = skill_RequireQuantity34;
    }

    public String getSkill_RequireQuantity41() {
        return Skill_RequireQuantity41;
    }

    public void setSkill_RequireQuantity41(String skill_RequireQuantity41) {
        Skill_RequireQuantity41 = skill_RequireQuantity41;
    }

    public String getSkill_RequireQuantity42() {
        return Skill_RequireQuantity42;
    }

    public void setSkill_RequireQuantity42(String skill_RequireQuantity42) {
        Skill_RequireQuantity42 = skill_RequireQuantity42;
    }

    public String getSkill_RequireQuantity43() {
        return Skill_RequireQuantity43;
    }

    public void setSkill_RequireQuantity43(String skill_RequireQuantity43) {
        Skill_RequireQuantity43 = skill_RequireQuantity43;
    }

    public String getSkill_RequireQuantity44() {
        return Skill_RequireQuantity44;
    }

    public void setSkill_RequireQuantity44(String skill_RequireQuantity44) {
        Skill_RequireQuantity44 = skill_RequireQuantity44;
    }

    public String getSkill_RequireQuantity51() {
        return Skill_RequireQuantity51;
    }

    public void setSkill_RequireQuantity51(String skill_RequireQuantity51) {
        Skill_RequireQuantity51 = skill_RequireQuantity51;
    }

    public String getSkill_RequireQuantity52() {
        return Skill_RequireQuantity52;
    }

    public void setSkill_RequireQuantity52(String skill_RequireQuantity52) {
        Skill_RequireQuantity52 = skill_RequireQuantity52;
    }

    public String getSkill_RequireQuantity53() {
        return Skill_RequireQuantity53;
    }

    public void setSkill_RequireQuantity53(String skill_RequireQuantity53) {
        Skill_RequireQuantity53 = skill_RequireQuantity53;
    }

    public String getSkill_RequireQuantity54() {
        return Skill_RequireQuantity54;
    }

    public void setSkill_RequireQuantity54(String skill_RequireQuantity54) {
        Skill_RequireQuantity54 = skill_RequireQuantity54;
    }

    public String getSkill_RequireQuantity61() {
        return Skill_RequireQuantity61;
    }

    public void setSkill_RequireQuantity61(String skill_RequireQuantity61) {
        Skill_RequireQuantity61 = skill_RequireQuantity61;
    }

    public String getSkill_RequireQuantity62() {
        return Skill_RequireQuantity62;
    }

    public void setSkill_RequireQuantity62(String skill_RequireQuantity62) {
        Skill_RequireQuantity62 = skill_RequireQuantity62;
    }

    public String getSkill_RequireQuantity63() {
        return Skill_RequireQuantity63;
    }

    public void setSkill_RequireQuantity63(String skill_RequireQuantity63) {
        Skill_RequireQuantity63 = skill_RequireQuantity63;
    }

    public String getSkill_RequireQuantity64() {
        return Skill_RequireQuantity64;
    }

    public void setSkill_RequireQuantity64(String skill_RequireQuantity64) {
        Skill_RequireQuantity64 = skill_RequireQuantity64;
    }

    public String getSkill_RequireQuantity71() {
        return Skill_RequireQuantity71;
    }

    public void setSkill_RequireQuantity71(String skill_RequireQuantity71) {
        Skill_RequireQuantity71 = skill_RequireQuantity71;
    }

    public String getSkill_RequireQuantity72() {
        return Skill_RequireQuantity72;
    }

    public void setSkill_RequireQuantity72(String skill_RequireQuantity72) {
        Skill_RequireQuantity72 = skill_RequireQuantity72;
    }

    public String getSkill_RequireQuantity73() {
        return Skill_RequireQuantity73;
    }

    public void setSkill_RequireQuantity73(String skill_RequireQuantity73) {
        Skill_RequireQuantity73 = skill_RequireQuantity73;
    }

    public String getSkill_RequireQuantity74() {
        return Skill_RequireQuantity74;
    }

    public void setSkill_RequireQuantity74(String skill_RequireQuantity74) {
        Skill_RequireQuantity74 = skill_RequireQuantity74;
    }

    public String getSkill_RequireQuantity81() {
        return Skill_RequireQuantity81;
    }

    public void setSkill_RequireQuantity81(String skill_RequireQuantity81) {
        Skill_RequireQuantity81 = skill_RequireQuantity81;
    }

    public String getSkill_RequireQuantity82() {
        return Skill_RequireQuantity82;
    }

    public void setSkill_RequireQuantity82(String skill_RequireQuantity82) {
        Skill_RequireQuantity82 = skill_RequireQuantity82;
    }

    public String getSkill_RequireQuantity83() {
        return Skill_RequireQuantity83;
    }

    public void setSkill_RequireQuantity83(String skill_RequireQuantity83) {
        Skill_RequireQuantity83 = skill_RequireQuantity83;
    }

    public String getSkill_RequireQuantity84() {
        return Skill_RequireQuantity84;
    }

    public void setSkill_RequireQuantity84(String skill_RequireQuantity84) {
        Skill_RequireQuantity84 = skill_RequireQuantity84;
    }

    public String getSkill_RequireQuantity91() {
        return Skill_RequireQuantity91;
    }

    public void setSkill_RequireQuantity91(String skill_RequireQuantity91) {
        Skill_RequireQuantity91 = skill_RequireQuantity91;
    }

    public String getSkill_RequireQuantity92() {
        return Skill_RequireQuantity92;
    }

    public void setSkill_RequireQuantity92(String skill_RequireQuantity92) {
        Skill_RequireQuantity92 = skill_RequireQuantity92;
    }

    public String getSkill_RequireQuantity93() {
        return Skill_RequireQuantity93;
    }

    public void setSkill_RequireQuantity93(String skill_RequireQuantity93) {
        Skill_RequireQuantity93 = skill_RequireQuantity93;
    }

    public String getSkill_RequireQuantity94() {
        return Skill_RequireQuantity94;
    }

    public void setSkill_RequireQuantity94(String skill_RequireQuantity94) {
        Skill_RequireQuantity94 = skill_RequireQuantity94;
    }

    public String getSkill_RequireQuantity101() {
        return Skill_RequireQuantity101;
    }

    public void setSkill_RequireQuantity101(String skill_RequireQuantity101) {
        Skill_RequireQuantity101 = skill_RequireQuantity101;
    }

    public String getSkill_RequireQuantity102() {
        return Skill_RequireQuantity102;
    }

    public void setSkill_RequireQuantity102(String skill_RequireQuantity102) {
        Skill_RequireQuantity102 = skill_RequireQuantity102;
    }

    public String getSkill_RequireQuantity103() {
        return Skill_RequireQuantity103;
    }

    public void setSkill_RequireQuantity103(String skill_RequireQuantity103) {
        Skill_RequireQuantity103 = skill_RequireQuantity103;
    }

    public String getSkill_RequireQuantity104() {
        return Skill_RequireQuantity104;
    }

    public void setSkill_RequireQuantity104(String skill_RequireQuantity104) {
        Skill_RequireQuantity104 = skill_RequireQuantity104;
    }

    //endregion





    //endregion

    //region SetValue
    public void setNameCH(String NameCH)
    {
        this.NameCH=NameCH;
    }
    public void setNameEN(String NameEN)
    {
        this.NameEN=NameEN;
    }
    public void setNameJP(String NameJP)
    {
        this.NameJP=NameJP;
    }
    public void setNameChina(String NameChina)
    {
        this.NameChina=NameChina;
    }

    public void setRarity(int Rarity)
    {
        this.Rarity=Rarity;
    }
    public void setServantClass(int ServantClass)
    {
        this.Class=ServantClass;
    }
    public void setStatusATKLV1(int Status_ATK_LV1)
    {
        this.StatusATKLV1=Status_ATK_LV1;
    }
    public void setStatus_HPLV1(int Status_HPLV1)
    {
        this.Status_HPLV1=Status_HPLV1;
    }
    public void setStatusATKFinal(int StatusATKFinal)
    {
        this.StatusATKFinal=StatusATKFinal;
    }
    public void setStatus_HPFinal(int Status_HPFinal)
    {
        this.Status_HPFinal=Status_HPFinal;
    }
    public void setStatusATKLV100(int StatusATKLV100)
    {
        this.StatusATKLV100=StatusATKLV100;
    }
    public void  setStatus_HPLV100(int Status_HPLV100)
    {
        this.Status_HPLV100=Status_HPLV100;
    }
    public void setCOST(int cost)
    {
        this.COST=cost;
    }

    public void setMAX_LV(int max_lv)
    {
        this.MAX_LV=max_lv;
    }
    public void setClass_Describe1(String D1)
    {
        this.Class_Describe1=D1;
    }
    public void setClass_Describe2(String D2)
    {
        this.Class_Describe2=D2;
    }
    public void setClass_Describe3(String D3)
    {
        this.Class_Describe3=D3;
    }
    public void setClass_Describe4(String D4)
    {
        this.Class_Describe4=D4;
    }
    public void setCommand_Buster(int CommandBuster)
    {
        this.Command_Buster=CommandBuster;
    }
    public void setCommand_Arts(int CommandArts)
    {
        this.Command_Arts=CommandArts;
    }
    public void setCommand_Quick(int CommandQuick)
    {
        this.Command_Quick=CommandQuick;
    }
    public void setSkill_Describe1(String Skill_Describe1){
        this.Skill_Describe1=Skill_Describe1;
    }
    public void setSkill_Describe2(String Skill_Describe2){
        this.Skill_Describe2=Skill_Describe2;
    }
    public void setSkill_Describe3(String Skill_Describe3){
        this.Skill_Describe3=Skill_Describe3;
    }
    public void setSkill_Describe4(String Skill_Describe4){
        this.Skill_Describe4=Skill_Describe4;
    }
    public void setSkill_Describe5(String Skill_Describe5){
        this.Skill_Describe5=Skill_Describe5;
    }
    public void setSkill_Describe6(String Skill_Describe6){
        this.Skill_Describe6=Skill_Describe6;
    }

    //region Set Skill Effect
    public void setSkill_1_Effect1(String SkillEffect1){this.Skill_1_Effect1=SkillEffect1;}
    public void setSkill_1_Effect2(String SkillEffect2){this.Skill_1_Effect1=SkillEffect2;}
    public void setSkill_1_Effect3(String SkillEffect3){this.Skill_1_Effect1=SkillEffect3;}
    public void setSkill_1_Effect4(String SkillEffect4){this.Skill_1_Effect1=SkillEffect4;}
    public void setSkill_1_Effect5(String SkillEffect5){this.Skill_1_Effect1=SkillEffect5;}
    public void setSkill_1_Effect6(String SkillEffect6){this.Skill_1_Effect1=SkillEffect6;}
    public void setSkill_1_Effect7(String SkillEffect7){this.Skill_1_Effect1=SkillEffect7;}
    public void setSkill_1_Effect8(String SkillEffect8){this.Skill_1_Effect1=SkillEffect8;}
    public void setSkill_1_Effect9(String SkillEffect9){this.Skill_1_Effect1=SkillEffect9;}
    public void setSkill_1_Effect10(String SkillEffect10){this.Skill_1_Effect1=SkillEffect10;}
    public void setSkill_2_Effect1(String SkillEffect1){this.Skill_2_Effect1=SkillEffect1;}
    public void setSkill_2_Effect2(String SkillEffect2){this.Skill_2_Effect1=SkillEffect2;}
    public void setSkill_2_Effect3(String SkillEffect3){this.Skill_2_Effect1=SkillEffect3;}
    public void setSkill_2_Effect4(String SkillEffect4){this.Skill_2_Effect1=SkillEffect4;}
    public void setSkill_2_Effect5(String SkillEffect5){this.Skill_2_Effect1=SkillEffect5;}
    public void setSkill_2_Effect6(String SkillEffect6){this.Skill_2_Effect1=SkillEffect6;}
    public void setSkill_2_Effect7(String SkillEffect7){this.Skill_2_Effect1=SkillEffect7;}
    public void setSkill_2_Effect8(String SkillEffect8){this.Skill_2_Effect1=SkillEffect8;}
    public void setSkill_2_Effect9(String SkillEffect9){this.Skill_2_Effect1=SkillEffect9;}
    public void setSkill_2_Effect10(String SkillEffect10){this.Skill_2_Effect1=SkillEffect10;}
    public void setSkill_3_Effect1(String SkillEffect1){this.Skill_3_Effect1=SkillEffect1;}
    public void setSkill_3_Effect2(String SkillEffect2){this.Skill_3_Effect1=SkillEffect2;}
    public void setSkill_3_Effect3(String SkillEffect3){this.Skill_3_Effect1=SkillEffect3;}
    public void setSkill_3_Effect4(String SkillEffect4){this.Skill_3_Effect1=SkillEffect4;}
    public void setSkill_3_Effect5(String SkillEffect5){this.Skill_3_Effect1=SkillEffect5;}
    public void setSkill_3_Effect6(String SkillEffect6){this.Skill_3_Effect1=SkillEffect6;}
    public void setSkill_3_Effect7(String SkillEffect7){this.Skill_3_Effect1=SkillEffect7;}
    public void setSkill_3_Effect8(String SkillEffect8){this.Skill_3_Effect1=SkillEffect8;}
    public void setSkill_3_Effect9(String SkillEffect9){this.Skill_3_Effect1=SkillEffect9;}
    public void setSkill_3_Effect10(String SkillEffect10){this.Skill_3_Effect1=SkillEffect10;}
    //endregion

    //region Set NP Describe
    public void setNP_CardColor(int NP_CardColor){this.NP_CardColor=NP_CardColor;}
    public void setNP_Name1(String Name){this.NP_Name1=Name;}
    public void setNP_Describe(String NP_Describe){this.NP_Describe=NP_Describe;}
    public void setNP_Describe_Rank1(String Rank){this.NP_Describe_Rank1=Rank;}
    public void setNP_Describe_Target(String Target){this.NP_Describe_Target=Target;}
    public void setNP_1_Effect1(String Effect){this.NP_1_Effect1=Effect;}
    public void setNP_1_Effect2(String Effect){this.NP_1_Effect2=Effect;}
    public void setNP_1_Effect3(String Effect){this.NP_1_Effect3=Effect;}
    public void setNP_1_Effect4(String Effect){this.NP_1_Effect4=Effect;}
    public void setNP_1_Effect5(String Effect){this.NP_1_Effect5=Effect;}
    public void setNP_Name2(String Name){this.NP_Name2=Name;}
    public void setNP_Rank2(String Rank){this.NP_Rank2=Rank;}
    public void setNP_2_Effect1(String Effect){this.NP_2_Effect1=Effect;}
    public void setNP_2_Effect2(String Effect){this.NP_2_Effect2=Effect;}
    public void setNP_2_Effect3(String Effect){this.NP_2_Effect3=Effect;}
    public void setNP_2_Effect4(String Effect){this.NP_2_Effect4=Effect;}
    public void setNP_2_Effect5(String Effect){this.NP_2_Effect5=Effect;}
    //endregion

    //region Level Required Material

    public void setLevelMaterial_11(String levelMaterial_11) {
        LevelMaterial_11 = levelMaterial_11;
    }

    public void setLevelMaterial_12(String levelMaterial_12) {
        LevelMaterial_12 = levelMaterial_12;
    }

    public void setLevelMaterial_13(String levelMaterial_13) {
        LevelMaterial_13 = levelMaterial_13;
    }

    public void setLevelMaterial_14(String levelMaterial_14) {
        LevelMaterial_14 = levelMaterial_14;
    }

    public void setLevelMaterial_21(String levelMaterial_21) {
        LevelMaterial_21 = levelMaterial_21;
    }

    public void setLevelMaterial_22(String levelMaterial_22) {
        LevelMaterial_22 = levelMaterial_22;
    }

    public void setLevelMaterial_23(String levelMaterial_23) {
        LevelMaterial_23 = levelMaterial_23;
    }

    public void setLevelMaterial_24(String levelMaterial_24) {
        LevelMaterial_24 = levelMaterial_24;
    }

    public void setLevelMaterial_31(String levelMaterial_31) {
        LevelMaterial_31 = levelMaterial_31;
    }

    public void setLevelMaterial_32(String levelMaterial_32) {
        LevelMaterial_32 = levelMaterial_32;
    }

    public void setLevelMaterial_33(String levelMaterial_33) {
        LevelMaterial_33 = levelMaterial_33;
    }

    public void setLevelMaterial_34(String levelMaterial_34) {
        LevelMaterial_34 = levelMaterial_34;
    }

    public void setLevelMaterial_41(String levelMaterial_41) {
        LevelMaterial_41 = levelMaterial_41;
    }

    public void setLevelMaterial_42(String levelMaterial_42) {
        LevelMaterial_42 = levelMaterial_42;
    }

    public void setLevelMaterial_43(String levelMaterial_43) {
        LevelMaterial_43 = levelMaterial_43;
    }

    public void setLevelMaterial_44(String levelMaterial_44) {
        LevelMaterial_44 = levelMaterial_44;
    }

    public void setLevelMaterialQP_1(String levelMaterialQP_1) {
        LevelMaterialQP_1 = levelMaterialQP_1;
    }

    public void setLevelMaterialQP_2(String levelMaterialQP_2) {
        LevelMaterialQP_2 = levelMaterialQP_2;
    }

    public void setLevelMaterialQP_3(String levelMaterialQP_3) {
        LevelMaterialQP_3 = levelMaterialQP_3;
    }

    public void setLevelMaterialQP_4(String levelMaterialQP_4) {
        LevelMaterialQP_4 = levelMaterialQP_4;
    }

    public void setRequireQuantity11(String requireQuantity11) {
        RequireQuantity11 = requireQuantity11;
    }

    public void setRequireQuantity12(String requireQuantity12) {
        RequireQuantity12 = requireQuantity12;
    }

    public void setRequireQuantity13(String requireQuantity13) {
        RequireQuantity13 = requireQuantity13;
    }

    public void setRequireQuantity14(String requireQuantity14) {
        RequireQuantity14 = requireQuantity14;
    }

    public void setRequireQuantity21(String requireQuantity21) {
        RequireQuantity21 = requireQuantity21;
    }

    public void setRequireQuantity22(String requireQuantity22) {
        RequireQuantity22 = requireQuantity22;
    }

    public void setRequireQuantity23(String requireQuantity23) {
        RequireQuantity23 = requireQuantity23;
    }

    public void setRequireQuantity24(String requireQuantity24) {
        RequireQuantity24 = requireQuantity24;
    }

    public void setRequireQuantity31(String requireQuantity31) {
        RequireQuantity31 = requireQuantity31;
    }

    public void setRequireQuantity32(String requireQuantity32) {
        RequireQuantity32 = requireQuantity32;
    }

    public void setRequireQuantity33(String requireQuantity33) {
        RequireQuantity33 = requireQuantity33;
    }

    public void setRequireQuantity34(String requireQuantity34) {
        RequireQuantity34 = requireQuantity34;
    }

    public void setRequireQuantity41(String requireQuantity41) {
        RequireQuantity41 = requireQuantity41;
    }

    public void setRequireQuantity42(String requireQuantity42) {
        RequireQuantity42 = requireQuantity42;
    }

    public void setRequireQuantity43(String requireQuantity43) {
        RequireQuantity43 = requireQuantity43;
    }

    public void setRequireQuantity44(String requireQuantity44) {
        RequireQuantity44 = requireQuantity44;
    }

    //endregion
//endregion



    @Exclude
    public Map<String,Object> toMap(){
        HashMap<String,Object> result=new HashMap<>();
        result.put("NameCH",NameCH);
        result.put("NameEN",NameEN);
        result.put("NameJP",NameJP);
        result.put("NameChina",NameChina);
        return result;
    }
}
