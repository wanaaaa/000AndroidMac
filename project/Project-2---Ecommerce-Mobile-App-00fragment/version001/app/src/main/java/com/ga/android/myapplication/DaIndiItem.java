package com.ga.android.myapplication;

/**
 * Created by wanmac on 7/20/16.
 */
public class DaIndiItem {
    String iteTitle, iteDescrip, iteImgURL, userName;
    int itePrice;
    boolean qIteCart;

    public DaIndiItem(){
        iteDescrip = "description asdf";
        iteImgURL = "url asf";
        userName = "Wan";
        itePrice = 2345;
        qIteCart = false;
    }

    public DaIndiItem(String iteTitle, int price){
        this.iteTitle = iteTitle;
        this.itePrice = price;
    }

    public String getIteTitle() {
        return iteTitle;
    }

    public void setIteTitle(String str) {
        iteTitle = str;
    }

    public int getItePrice() {
        return  itePrice;
    }
    public void setItePrice(int price) {
        this.itePrice = price;
    }
}
