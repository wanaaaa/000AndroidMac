package com.ga.android.myapplication;

import java.util.ArrayList;

/**
 * Created by wanmac on 7/27/16.
 */
public class DaCartList {
    private static DaCartList daCartList = null;
    private static ArrayList<DaIndiItem> cartArray;

    private DaCartList() {
        cartArray = new ArrayList<DaIndiItem>();
    }

    public static DaCartList getInstance() {
        if (daCartList == null) {
            daCartList = new DaCartList();
        }
        return  daCartList;
    }

    public ArrayList<DaIndiItem> getCartArray() {
        return cartArray;
    }

    public int cartSize() {
        return cartArray.size();
    }

    public void addItem(DaIndiItem instance) {
        cartArray.add(instance);
    }

    public void removeAnItem(int i) {
        cartArray.remove(i);
    }

    public void removeAll() {
        cartArray.clear();
    }

}
