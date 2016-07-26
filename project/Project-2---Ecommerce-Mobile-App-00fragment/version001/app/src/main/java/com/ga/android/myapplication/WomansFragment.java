package com.ga.android.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by wanmac on 7/20/16.
 */
public class WomansFragment extends Fragment {
    private static final String TAG = "MyActivity";
    ListView listView;

    RecyclerView mRecyclerView;
    AdapterItemAll adapter;

    SQhelper helper  ;

    //This is a blank fragment
    //Implement your own version of Fragments for this lab
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        helper = SQhelper.getInstance(getActivity());
        Cursor cursor;
        cursor = helper.getAllItem();
        //String[][] colunms = new String[][]{SQhelper.COLUMN_NAMES};


        View rootView = inflater.inflate(R.layout.woman, container, false);

        mRecyclerView = (RecyclerView) mRecyclerView.findViewById(R.id.recyclerViewAllItems);
        //For ListView
        //listView = (ListView) rootView.findViewById(R.id.listview_aboutMe);

        ArrayList<String> arrayList = new ArrayList<>();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, arrayList);

        cursor.moveToFirst();
        while (cursor.isAfterLast()==false) {
            String itemDetail = cursor.getString(cursor.getColumnIndex(SQhelper.DataEntryItem.COLUMN_TITLE));
            Log.d(TAG,itemDetail);
            arrayList.add(itemDetail);
            cursor.moveToNext();
        }
        ////////////////////////////////
        arrayList.add("android");
        arrayList.add("human");
        arrayList.add("phone");
        arrayList.add("food1");
        //////////////////////////////

        listView.setAdapter(arrayAdapter);
        return rootView;

    }

    @Override
    public void onResume() {
        super.onResume();

        helper = SQhelper.getInstance(getActivity());
        Cursor cursor;
        cursor = helper.getAllItem();
        cursor.moveToFirst();

        ArrayList<String> arrayList = new ArrayList<>();
        while (cursor.isAfterLast()==false) {
            String itemDetail = cursor.getString(cursor.getColumnIndex(SQhelper.DataEntryItem.COLUMN_TITLE));
            Log.d(TAG,itemDetail);
            arrayList.add(itemDetail);
            cursor.moveToNext();
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

    }
}
