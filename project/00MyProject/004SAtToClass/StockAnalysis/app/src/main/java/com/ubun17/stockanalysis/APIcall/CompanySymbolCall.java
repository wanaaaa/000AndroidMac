package com.ubun17.stockanalysis.APIcall;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ubun17.stockanalysis.APIObject.FindCompanySymbol.LookUpCompanies;
import com.ubun17.stockanalysis.MainActivity;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by ubun17 on 9/18/16.
 */
public class CompanySymbolCall extends MainActivity {

    String stSearchCompany;
    ArrayList<String> mArryList;
    Activity mActivity;

    public CompanySymbolCall (String str, Activity activity) {
        stSearchCompany = str;
        mArryList = new ArrayList<String>();
        mActivity = activity;
    }

    public ArrayList<String> ComSymbolAPI() {
        final String asd = "asdfsf";
        final ArrayList<String> arrayLitforView = new ArrayList<String>();
       // arrayLitforView.a =mArryListl
        String baseUrl = "http://dev.markitondemand.com/MODApis/Api/v2/Lookup/json?input=";
        String stURL = baseUrl+ stSearchCompany;

        OkHttpClient client = new OkHttpClient();

        final Request apirequest = new Request.Builder()
                .url(stURL).build();
        client.newCall(apirequest).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Log.i("asdf", "failrue");
            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                if (!response.isSuccessful()) {
                    Log.d("connection", "failure");
                } else {
                    String stBody = response.body().string();

                    stBody = stBody.replace("[{", "{\"companies\": [{");
                    stBody = stBody.replace("}]", "}]}");
                    Gson gson = new Gson();
                    LookUpCompanies lookUpCompanies = gson.fromJson(stBody, LookUpCompanies.class);
                    arrayLitforView.clear();
                    int num = lookUpCompanies.getCompanies().size();
                    for (int i = 0; i < num; i++) {
                        String stSymbol = lookUpCompanies.getCompanies().get(i).getSymbol();
                        mArryList.add(stSymbol);
                        arrayLitforView.add(stSymbol);
                        Log.d("response", arrayLitforView.get(0)+"  sssssssss");
                    }
                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("array before return", arrayLitforView.get(0)+"aaaaaaaaaaaaaaaaaaaaaaaapple");
                            Toast.makeText(mActivity.getApplicationContext(),
                                    "make toast", Toast.LENGTH_LONG).show();
                            //return arrayLitforView;
                        }
                    });

//                    MainActivity.this.runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//
//                        }
//                    });
                }
            }//End On Response
        });//End of client
        //Log.d("array before return", mArryList.get(0)+"////////////////////////////////");
        return arrayLitforView;
    }//End of ComSymbolAPI

}
