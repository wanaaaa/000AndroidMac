
package com.example;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Close {

    @SerializedName("min")
    @Expose
    private Double min;
    @SerializedName("max")
    @Expose
    private Double max;
    @SerializedName("maxDate")
    @Expose
    private String maxDate;
    @SerializedName("minDate")
    @Expose
    private String minDate;
    @SerializedName("values")
    @Expose
    private List<Double> values = new ArrayList<Double>();

    /**
     * 
     * @return
     *     The min
     */
    public Double getMin() {
        return min;
    }

    /**
     * 
     * @param min
     *     The min
     */
    public void setMin(Double min) {
        this.min = min;
    }

    /**
     * 
     * @return
     *     The max
     */
    public Double getMax() {
        return max;
    }

    /**
     * 
     * @param max
     *     The max
     */
    public void setMax(Double max) {
        this.max = max;
    }

    /**
     * 
     * @return
     *     The maxDate
     */
    public String getMaxDate() {
        return maxDate;
    }

    /**
     * 
     * @param maxDate
     *     The maxDate
     */
    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }

    /**
     * 
     * @return
     *     The minDate
     */
    public String getMinDate() {
        return minDate;
    }

    /**
     * 
     * @param minDate
     *     The minDate
     */
    public void setMinDate(String minDate) {
        this.minDate = minDate;
    }

    /**
     * 
     * @return
     *     The values
     */
    public List<Double> getValues() {
        return values;
    }

    /**
     * 
     * @param values
     *     The values
     */
    public void setValues(List<Double> values) {
        this.values = values;
    }

}
