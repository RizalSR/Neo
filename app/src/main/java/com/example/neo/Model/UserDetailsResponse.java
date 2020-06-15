package com.example.neo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDetailsResponse {

    @SerializedName("errnum")
    @Expose
    private int errnum;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private DataUser dataUser;

    public UserDetailsResponse(int errnum, String message, DataUser dataUser) {
        this.errnum = errnum;
        this.message = message;
        this.dataUser = dataUser;
    }

    public int getErrnum() {
        return errnum;
    }

    public void setErrnum(int errnum) {
        this.errnum = errnum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataUser getDataUser() {
        return dataUser;
    }

    public void setDataUser(DataUser dataUser) {
        this.dataUser = dataUser;
    }
}
