package mymgconnect.com.mgapp.model.response;


import com.google.gson.annotations.SerializedName;

import mymgconnect.com.mgapp.model.data.User;


public class LoginResponse {

    @SerializedName("user")
    private User user;

    public User getUser() {
        return user;
    }



    public void setUser(User user) {
        this.user = user;
    }


    private String result;

    public String getResult() {
        return result;
    }


    public void setResult(String result) {
        this.result = result;
    }



}
