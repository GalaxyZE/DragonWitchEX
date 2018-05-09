package com.fate.zillusion.fgohelper;

/**
 * Created by ZIllusion on 2018/3/26.
 */

public class FGO_RelateData_04 {
    //region 靈基再臨 & 技能升級

    public static Integer [] img_Required_Materials={
            R.drawable.item_skill_00,R.drawable.item_qp,
            R.drawable.item_class_01,R.drawable.item_class_02,R.drawable.item_class_03,R.drawable.item_class_04,R.drawable.item_class_05,R.drawable.item_class_06,R.drawable.item_class_07,
            R.drawable.item_class_08,R.drawable.item_class_09,R.drawable.item_class_10,R.drawable.item_class_11,R.drawable.item_class_12,R.drawable.item_class_13,R.drawable.item_class_14,
            R.drawable.item_skill_01,R.drawable.item_skill_02,R.drawable.item_skill_03,R.drawable.item_skill_04,R.drawable.item_skill_05,R.drawable.item_skill_06,R.drawable.item_skill_07,
            R.drawable.item_skill_08,R.drawable.item_skill_09,R.drawable.item_skill_10,R.drawable.item_skill_11,R.drawable.item_skill_12,R.drawable.item_skill_13,R.drawable.item_skill_14,
            R.drawable.item_skill_15,R.drawable.item_skill_16,R.drawable.item_skill_17,R.drawable.item_skill_18,R.drawable.item_skill_19,R.drawable.item_skill_20,R.drawable.item_skill_21,
            R.drawable.item_material_01,R.drawable.item_material_02,R.drawable.item_material_03,R.drawable.item_material_04,R.drawable.item_material_05,R.drawable.item_material_06,R.drawable.item_material_07,
            R.drawable.item_material_08,R.drawable.item_material_09,R.drawable.item_material_10,R.drawable.item_material_11,R.drawable.item_material_12,R.drawable.item_material_13,R.drawable.item_material_14,
            R.drawable.item_material_15,R.drawable.item_material_16,R.drawable.item_material_17,R.drawable.item_material_18,R.drawable.item_material_19,R.drawable.item_material_20,R.drawable.item_material_21,
            R.drawable.item_material_22,R.drawable.item_material_23,R.drawable.item_material_24,R.drawable.item_material_25,R.drawable.item_material_26,R.drawable.item_material_27,R.drawable.item_material_28,
            R.drawable.item_material_29,R.drawable.item_material_30,R.drawable.item_material_31,R.drawable.item_material_32,R.drawable.item_material_33,R.drawable.item_material_34,
    };

    public static Integer[] img_Required_EventMaterials={
            R.drawable.item_eventmaterial_001,R.drawable.item_eventmaterial_002,R.drawable.item_eventmaterial_003,R.drawable.item_eventmaterial_004,
            R.drawable.item_eventmaterial_005,R.drawable.item_eventmaterial_006,R.drawable.item_eventmaterial_007,R.drawable.item_eventmaterial_008,
            R.drawable.item_eventmaterial_009,R.drawable.item_eventmaterial_010,R.drawable.item_eventmaterial_011,R.drawable.item_eventmaterial_012,
            R.drawable.item_eventmaterial_013,R.drawable.item_eventmaterial_014,R.drawable.item_eventmaterial_015,R.drawable.item_eventmaterial_016,

    };


    //Language: 0日文、1中文
    //一行7組資料
    //region 素材資料對表
    public static String [][]str_LanguageRequired_Materials ={
            {
                "伝承結晶","QP",
                "セイバーピース","アーチャーピース","ランサーピース","ライダーピース","キャスターピース","アサシンピース","バーサーカーピース",
                "セイバーモニュメント","アーチャーモニュメント","ランサーモニュメント","ライダーモニュメント","キャスターモニュメント","アサシンモニュメント","バーサーカーモニュメント",
                "剣の輝石","弓の輝石","槍の輝石","騎の輝石","術の輝石","殺の輝石","狂の輝石",
                "剣の魔石","弓の魔石","槍の魔石","騎の魔石","術の魔石","殺の魔石","狂の魔石",
                "剣の秘石","弓の秘石","槍の秘石","騎の秘石","術の秘石","殺の秘石","狂の秘石",
                "鳳凰の羽根","世界樹の種","英雄の証","虚影の塵","竜の逆鱗","混沌の爪","ゴーストランタン",
                "蛇の宝玉","無間の歯車","禁断の頁","竜の牙","隕蹄鉄","ホムンクルスベビー","八連双晶",
                "凶骨","蛮神の心臓","精霊根","戦馬の幼角","血の涙石","黒獣脂","愚者の鎖",
                "封魔のランプ","大騎士勲章","智慧のスカラベ","追憶の貝殻","万死の毒針","原初の産毛","呪獣胆石",
                "魔術髄液","奇奇神酒","枯淡勾玉","宵哭きの鉄杭","永遠結冰","励振火薬",
            },

            {
                "傳承結晶","QP",
                "劍兵銀棋","弓兵銀棋","槍兵銀棋","騎兵銀棋","法師銀棋","暗殺者銀棋","狂戰士銀棋",
                "劍兵金棋","弓兵金棋","槍兵金棋","騎兵金棋","法師金棋","暗殺者金棋","狂戰士金棋",
                "劍的輝石","弓的輝石","槍的輝石","騎的輝石","術的輝石","殺的輝石","狂的輝石",
                "劍的魔石","弓的魔石","槍的魔石","騎的魔石","術的魔石","殺的魔石","狂的魔石",
                "劍的秘石","弓的秘石","槍的秘石","騎的秘石","術的秘石","殺的秘石","狂的秘石",
                "鳳凰之羽","世界樹種子","英雄之證","虛影之塵","龍的逆鱗","渾沌之爪","鬼魂提燈",
                "蛇眼寶玉","無間的齒輪","禁斷書頁","龍牙","隕蹄鐵","人造生命","八連雙晶",
                "兇骨","蠻神心臟","精靈根","戰馬幼角","血之淚石","黑獸油脂","愚者之鎖",
                "封魔神燈","騎士勳章","智慧聖甲蟲","回憶的貝殼","萬死毒針","原初產毛","咒獸膽石",
                "魔術髓液","奇奇神酒","枯鎖勾玉","宵哭的鐵釘","結冰","火藥",
            },
            //Event Materials
            {
                "棒棒糖","黃金骷髏","炸雞桶","小刀","水晶球","打火機","樹枝","項鍊","龍珠","娃娃","盒子","緞帶","蘆葦",
                "方塊","鬍子","樹葉",
            },
    };
    //endregion




}
