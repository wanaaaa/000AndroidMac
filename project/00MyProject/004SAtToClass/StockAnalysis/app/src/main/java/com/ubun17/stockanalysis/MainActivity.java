package com.ubun17.stockanalysis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.ubun17.stockanalysis.APIcall.CompanySymbolCall;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button buTest01, butest02, buSearch;
    EditText searchTerm;

    ListView mListView;
    ArrayAdapter<String> mAdapter;
    ArrayList<String> mArrayList;

    private static String baseUrl = "http://dev.markitondemand.com/MODApis/Api/v2/Lookup/json?input=";
    private static String okURL = "http://dev.markitondemand.com/MODApis/Api/v2/Lookup/json?input=apple";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buTest01 = (Button) findViewById(R.id.buTest01);
        butest02 = (Button) findViewById(R.id.buTest02);
        buSearch = (Button) findViewById(R.id.buSearchTerm);

        searchTerm = (EditText) findViewById(R.id.inputSearch);

        buTest01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {

            }
        });//End of Buton01

        buSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("buton search", "clicked/////////");
                String stSearchTerm = searchTerm.getText().toString();
                CompanySymbolCall symAPI = new CompanySymbolCall(stSearchTerm);
                mArrayList.clear();
               // mArrayList = symAPI.ComSymbolAPI();
//                Log.d("mArrayList", symAPI.ComSymbolAPI().get(0)+"aaaaaaaaaaaaaaaa" );
                mAdapter.notifyDataSetChanged();

            }//End of onClick
        });//End of BuSearch



        mArrayList = new ArrayList<String>();
        mListView = (ListView) findViewById(R.id.listView);
        mAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, mArrayList);
        mListView.setAdapter(mAdapter);


        butest02.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent goToMap = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(goToMap);
            }
        });

    }//End of onCreate
}
