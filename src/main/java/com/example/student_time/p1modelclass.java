package com.example.student_time;

public class p1modelclass {
    public int imageview1;
    public String textview1;
    public String textview2;
    public String textview3;
    public String divider;

    p1modelclass(int imageview1,String textview1,String textview2,String textview3,String divider)
    {
        this.imageview1=imageview1;
        this.textview1=textview1;
        this.textview2=textview2;
        this.textview3=textview3;
        this.divider=divider;

    }

    public int getImageview1() {
        return imageview1;
    }

    public String getTextview1() {
        return textview1;
    }

    public String getTextview2() {
        return textview2;
    }

    public String getTextview3() {
        return textview3;
    }

    public String getDivider() {
        return divider;
    }
}
