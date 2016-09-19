
package com.example;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Element {

    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("TimeStamp")
    @Expose
    private Object timeStamp;
    @SerializedName("Symbol")
    @Expose
    private String symbol;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("DataSeries")
    @Expose
    private DataSeries dataSeries;

    /**
     * 
     * @return
     *     The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 
     * @param currency
     *     The Currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 
     * @return
     *     The timeStamp
     */
    public Object getTimeStamp() {
        return timeStamp;
    }

    /**
     * 
     * @param timeStamp
     *     The TimeStamp
     */
    public void setTimeStamp(Object timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * 
     * @return
     *     The symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * 
     * @param symbol
     *     The Symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The Type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The dataSeries
     */
    public DataSeries getDataSeries() {
        return dataSeries;
    }

    /**
     * 
     * @param dataSeries
     *     The DataSeries
     */
    public void setDataSeries(DataSeries dataSeries) {
        this.dataSeries = dataSeries;
    }

}
