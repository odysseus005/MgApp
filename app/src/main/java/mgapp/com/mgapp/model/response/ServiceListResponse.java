package mgapp.com.mgapp.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import mgapp.com.mgapp.model.data.Service;


/**
 * @author mudeleon
 * @since 06/04/2018
 */

public class ServiceListResponse {


    private String result;

    public String getResult() {
        return result;
    }


    public void setResult(String result) {
        this.result = result;
    }




    public List<Service> getData() {
        return data;
    }

    public void setData(List<Service> data) {
        this.data = data;
    }

    @SerializedName("data")
    private List<Service> data;


}
