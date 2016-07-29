package com.ga.android.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by wanmac on 7/20/16.
 */
public class WomansFragment extends Fragment {
    private static final String TAG = "MyActivity";
    Button BuGoToSearch;
    RecyclerView mRecyclerView;


    //SQhelper helper  ;

    //This is a blank fragment
    //Implement your own version of Fragments for this lab
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SQhelper helper;
        helper = SQhelper.getInstance(getActivity());

        View rootView = inflater.inflate(R.layout.woman, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewAllItems);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL,false));
////////////////////////////////////////////////////////////////////
        ArrayList<DaIndiItem> data = helper.returnAllArrayList();

        AdapterItemAll adapter = new AdapterItemAll(data);
        //adapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //For ListView
        //listView = (ListView) rootView.findViewById(R.id.listview_aboutMe);


        BuGoToSearch = (Button) rootView.findViewById(R.id.goToSearh);
        BuGoToSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToSearch = new Intent(view.getContext(),
                        MmSearchActivity.class);

                view.getContext().startActivity(goToSearch);
            }
        });

        return rootView;

    }


    @Override
    public void onResume() {
        super.onResume();
        SQhelper helper;
        helper = SQhelper.getInstance(getActivity());
        ArrayList<DaIndiItem> data = helper.returnAllArrayList();
        AdapterItemAll adapter = new AdapterItemAll(data);
        //adapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

//        helper = SQhelper.getInstance(getActivity());
//        Cursor cursor;
//        cursor = helper.getAllItem();
//        cursor.moveToFirst();
//
//        ArrayList<String> arrayList = new ArrayList<>();
//        while (cursor.isAfterLast()==false) {
//            String itemDetail = cursor.getString(cursor.getColumnIndex(SQhelper.DataEntryItem.COLUMN_TITLE));
//            Log.d(TAG,itemDetail);
//            arrayList.add(itemDetail);
//            cursor.moveToNext();
//        }
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),
//                android.R.layout.simple_list_item_1, arrayList);
//
//        listView.setAdapter(arrayAdapter);

    }
}
