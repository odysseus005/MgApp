package mymgconnect.com.mgapp.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import mymgconnect.com.mgapp.model.data.PastAppointment;


/**
 * @author mudeleon
 * @since 06/04/2018
 */

public class PastAppointmentListResponse {


    private String result;

    public String getResult() {
        return result;
    }


    public void setResult(String result) {
        this.result = result;
    }




    public List<PastAppointment> getData() {
        return data;
    }

    public void setData(List<PastAppointment> data) {
        this.data = data;
    }

    @SerializedName("data")
    private List<PastAppointment> data;


}
