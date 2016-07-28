package com.ga.android.myapplication;

/**
 * Created by wanmac on 7/20/16.
 */
public class DaIndiItem {
    String mIteTitle, mIteDescrip, mIteImgURL, mUserName;
    int mItePrice;
    boolean mQIteCart;

    public DaIndiItem(){
        mIteDescrip = "description asdf";
        mIteImgURL = "url asf";
        mUserName = "Wan";
        //mItePrice = 2345;
        mQIteCart = false;
    }

    public DaIndiItem(String iteTitle, int price){
        mIteTitle = iteTitle;
        mItePrice = price;
    }

    public String getIteTitle() {
        return mIteTitle;
    }

    public void setIteTitle(String str) {
        mIteTitle = str;
    }

    public int getItePrice() {
        return  mItePrice;
    }
    public void setItePrice(int price) {
        mItePrice = price;
    }
}
