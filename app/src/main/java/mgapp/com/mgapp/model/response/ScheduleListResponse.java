package mgapp.com.mgapp.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import mgapp.com.mgapp.model.data.Holiday;
import mgapp.com.mgapp.model.data.Schedule;


/**
 * @author mudeleon
 * @since 06/04/2018
 */

public class ScheduleListResponse {


    private String result;

    public String getResult() {
        return result;
    }


    public void setResult(String result) {
        this.result = result;
    }





    public List<Schedule> getData() {
        return data;
    }

    public void setData(List<Schedule> data) {
        this.data = data;
    }

    @SerializedName("data")
    private List<Schedule> data;


    public List<Holiday> getData2() {
        return data2;
    }

    public void setData2(List<Holiday> data2) {
        this.data2 = data2;
    }

    @SerializedName("data2")
    private List<Holiday> data2;

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    @SerializedName("schedcheck")
    private String checker;


}
