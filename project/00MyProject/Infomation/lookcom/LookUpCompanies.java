
package lookcom;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
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
