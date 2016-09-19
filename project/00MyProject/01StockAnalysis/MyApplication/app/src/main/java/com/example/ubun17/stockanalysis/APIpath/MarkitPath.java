package com.example.ubun17.stockanalysis.APIpath;

import com.example.ubun17.stockanalysis.APIObject.CompanyLookUp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ubun17 on 9/17/16.
 */
public interface MarkitPath {
    @GET("/json")
    Call<CompanyLookUp> getCompany(@Query("input") String jsonInput);
}
