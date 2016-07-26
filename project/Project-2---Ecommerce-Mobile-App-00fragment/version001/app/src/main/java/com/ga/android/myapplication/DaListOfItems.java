package com.ga.android.myapplication;

import java.util.ArrayList;

/**
 * Created by wanmac on 7/20/16.
 */
public class DaListOfItems {
    private static DaListOfItems daListOfItems = null;
    ArrayList<DaIndiItem> itemArray;

    private DaListOfItems() {
        itemArray = new ArrayList<DaIndiItem>();
    }


}
