
package com.ubun17.stockanalysis.APIObject.FindCompanySymbol;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class LookUpCompanies {

    @SerializedName("companies")
    @Expose
    private List<Company> companies = new ArrayList<Company>();

    /**
     * 
     * @return
     *     The companies
     */
    public List<Company> getCompanies() {
        return companies;
    }

    /**
     * 
     * @param companies
     *     The companies
     */
    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

}
