package com.fate.zillusion.fgohelper;

public class OnlineData {
    private Long NO;
    private String NameCH;
    private String NameEN;
    private String NameJP;

    public  OnlineData(){}

    public OnlineData(Long NO,String NameCH, String NameEN, String NameJP) {
        this.NO=NO;
        this.NameCH = NameCH;
        this.NameEN = NameEN;
        this.NameJP = NameJP;
    }

    //region get
    public Long getNO()
    {
        return NO;
    }

    public String getNameCH()
    {
        return NameCH;
    }

    public String getNameEN()
    {
        return NameEN;
    }

    public String getNameJP()
    {
        return NameJP;
    }
    //endregion

    //region set
    public void setNO(Long NO)
    {
        this.NO=NO;
    }
    public  void setNameCH(String NameCH)
    {
        this.NameCH=NameCH;
    }
    public  void setNameEN(String NameEN)
    {
        this.NameEN=NameEN;
    }
    public void setNameJP(String NameHP)
    {
        this.NameJP=NameHP;
    }
    //endregion


}
