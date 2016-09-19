package com.example.ubun17.stockanalysis;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ubun17.stockanalysis.APIObject.CompanyLookUp;
import com.example.ubun17.stockanalysis.APIpath.MarkitPath;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button buTest01, butest02;
    private static String baseUrl = "http://dev.markitondemand.com/MODApis/Api/v2/Lookup/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buTest01 = (Button) findViewById(R.id.buTest01);
        butest02 = (Button) findViewById(R.id.buTest02);


        buTest01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getComanyLookUP();
                Log.d("buton 1", "clicked/////////");

            }
        });

        butest02.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });


//        Intent asdf = new Intent(MainActivity.this, MapsActivity.class);
//        startActivity(asdf);
    }//End of onCreate

    protected void getComanyLookUP() {

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build();

            MarkitPath service = retrofit.create(MarkitPath.class);
            String ddd = "apple";
            Call<CompanyLookUp> call = service.getCompany(ddd);

            Log.d("before", "calling enqueuemmmmmmmmmmmmmmmmmm");

            call.enqueue(new Callback<CompanyLookUp>() {

                @Override
                public void onResponse(Call<CompanyLookUp> call, Response<CompanyLookUp> response) {
                    Log.d("bofore try", "mmmmmmmmmmmmmmmmmm");
                    try {
                        Log.d("before", "coming Symbol//////////////");
                        String comingSymbol = response.body().getSymbol();
                        Log.d("retrofit.coming", String.valueOf(response.body()));
                        Toast.makeText(MainActivity.this, "No network connection", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<CompanyLookUp> call, Throwable t) {

                }
            });
        } else {
            Toast.makeText(MainActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }
    }
}
