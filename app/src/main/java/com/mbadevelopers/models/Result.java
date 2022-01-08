package com.mbadevelopers.models;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("success")
    private Boolean success;

    @SerializedName("status")
    private int status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private Data data;

    public Result(Boolean success, int status, String message, Data data) {
        this.success = success;
        this.message = message;
        this.data = data;
}

    public Boolean getSuccess() {
        return success;
    }

    public int getStatus(){ return status; }

    public String getMessage() {
        return message;
    }

    public Data getData() {
        return data;
    }
}
