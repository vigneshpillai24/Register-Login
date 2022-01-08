package com.mbadevelopers.models;

import android.os.Build;

import com.mbadevelopers.registerlogin.BuildConfig;

public class Data {

    private int id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String gender;
    private String dob;
    private String pcode;
    private String pnumber;
    private String image;
    private String devicetype;
    private String devicetoken;
    private String appversion;
    private String osversion;
    private String devicemodel;
    private String newletter;




    public Data(String email, String password, String fname, String lname, String gender, String dob, String pcode, String pnumber, String newletter) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.dob = dob;
        this.pcode = pcode;
        this.pnumber = pnumber;
        this.image = "";
        this.devicetype = Build.DEVICE;
        this.devicetoken = "devicetoken";
        this.appversion = BuildConfig.VERSION_NAME;
        this.osversion = String.valueOf(Build.VERSION.SDK_INT);
        this.devicemodel = Build.MODEL;
        this.newletter = newletter;
    }

    public int getId() {
        return id;
    }

    public String getFName() {
        return fname;
    }

    public String getLName() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getPcode() {
        return pcode;
    }

    public String getPnumber() {
        return pnumber;
    }

    public String getImage() {
        return image;
    }



    public String getDevicetype() {
        return devicetype;
    }

    public String getDevicetoken() {
        return devicetoken;
    }

    public String getAppversion() {
        return appversion;
    }

    public String getOsversion() {
        return osversion;
    }

    public String getDevicemodel() {
        return devicemodel;
    }

    public String getNewletter() {
        return newletter;
    }
}

