package com.ga.android.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by wanmac on 7/20/16.
 */
public class HomeFragment extends Fragment {
    private static final String TAG = "MyActivity";
    Button buttonDataInput;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home, container, false);

        buttonDataInput = (Button) rootView.findViewById(R.id.shoppingListInput);
        buttonDataInput.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent goToDataInput = new Intent(view.getContext(), MmDataInputActivity.class);
                view.getContext().startActivity(goToDataInput);
                Log.v(TAG, "asf");
            }
        });

        return rootView;
    }
}
