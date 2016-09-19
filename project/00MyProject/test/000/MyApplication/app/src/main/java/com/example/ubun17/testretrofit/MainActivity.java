package com.example.ubun17.testretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ubun17.testretrofit.APIObject.LookUpCompanies;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MainActivity extends AppCompatActivity {

    Button buTest01, butest02;
    private static String baseUrl = "http://dev.markitondemand.com/MODApis/Api/v2/Lookup/";
    private static String okURL = "http://dev.markitondemand.com/MODApis/Api/v2/Lookup/json?input=apple";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buTest01 = (Button) findViewById(R.id.buTest01);
        butest02 = (Button) findViewById(R.id.buTest02);

        buTest01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               // getComanyLookUP();
                Log.d("buton 1", "clicked/////////");
                OkHttpClient client = new OkHttpClient();

                final Request apirequest = new Request.Builder()
                         .url(okURL).build();
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
                           //JSONArray jArray = response.body();
                            stBody = stBody.replace("[{", "{\"companies\": [{");
                            stBody = stBody.replace("}]", "}]}");

                            Gson gson = new Gson();
                            LookUpCompanies lookUpCompanies = gson.fromJson(stBody, LookUpCompanies.class);
                            String asdf = lookUpCompanies.getCompanies().get(1).getSymbol();
                            Log.d("response", asdf);

                        }
                    }
                });

            }
        });

    }//End of onCreate


    ////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////
//    protected void getComanyLookUP() {
//
//        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
//        if (networkInfo != null && networkInfo.isConnected()) {
//
//            Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
//                    .addConverterFactory(GsonConverterFactory.create()).build();
//
//            MarkitPath service = retrofit.create(MarkitPath.class);
//            String ddd = "apple";
//            Call<CompanyLookUp> call = service.getCompany(ddd);
//
//            Log.d("before", "calling enqueuemmmmmmmmmmmmmmmmmm");
//
//            call.enqueue(new Callback<CompanyLookUp>() {
//
//                @Override
//                public void onResponse(Call<CompanyLookUp> call, Response<CompanyLookUp> response) {
//                    Log.d("bofore try", "mmmmmmmmmmmmmmmmmm");
//                    try {
//                        Log.d("before", "coming Symbol//////////////");
//                        CompanyLookUp asd = response.body();
//                        //String comingSymbol = response.body().getSymbol();
//                        Log.d("retrofit.coming", String.valueOf(response.body()));
//                        Toast.makeText(MainActivity.this, "No network connection", Toast.LENGTH_LONG).show();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        Log.d("retrofit.coming", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<CompanyLookUp> call, Throwable t) {
//                    Log.d("calling failed", "?????????????????????????????????");
//                }
//            });
//        } else {
//            Toast.makeText(MainActivity.this, "No network connection", Toast.LENGTH_LONG).show();
//        }
//    }
}
