package mymgconnect.com.mgapp.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import mymgconnect.com.mgapp.model.data.Advisor;


/**
 * @author mudeleon
 * @since 06/04/2018
 */

public class AdvisorListResponse {


    private String result;

    public String getResult() {
        return result;
    }


    public void setResult(String result) {
        this.result = result;
    }




    public List<Advisor> getData() {
        return data;
    }

    public void setData(List<Advisor> data) {
        this.data = data;
    }

    @SerializedName("data")
    private List<Advisor> data;


}
