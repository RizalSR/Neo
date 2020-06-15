package com.example.neo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("errnum")
    @Expose
    private int errnum;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private String data;

    public LoginResponse() {
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
