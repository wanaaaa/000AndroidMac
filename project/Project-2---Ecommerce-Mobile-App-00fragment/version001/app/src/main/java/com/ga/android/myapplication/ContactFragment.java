package com.ga.android.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by wanmac on 7/19/16.
 */
public class ContactFragment extends Fragment {
    private static final String TAG = "ContactFragment";
    RecyclerView mRecyclerView;

//    FragmentTransaction ft = getFragmentManager().beginTransaction();
//    ft.detach(this).attach(this).commit();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.contact_me, container, false);


        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.cartRecycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL,false));

        Log.d(ContactFragment.class.getName(),"onCreateView");
        //start Data
        ////////////
        final DaCartList cartList = DaCartList.getInstance();
        ArrayList<DaIndiItem> data = cartList.getCartArray();

        AdapterItemAll adapter = new AdapterItemAll(data);
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d(ContactFragment.class.getName(),"onResume");
        final DaCartList cartList = DaCartList.getInstance();
        ArrayList<DaIndiItem> data = cartList.getCartArray();

        AdapterItemAll adapter = new AdapterItemAll(data);
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


//        SQhelper helper;
//        helper = SQhelper.getInstance(getActivity());
//        ArrayList<DaIndiItem> data = helper.returnAllArrayList();
//        AdapterItemAll adapter = new AdapterItemAll(data);
//        //adapter.notifyDataSetChanged();
//        mRecyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();

    }
}
