package com.mbadevelopers.api;

import com.mbadevelopers.models.Data;
import com.mbadevelopers.models.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @FormUrlEncoded
    @POST("register")
    Call<Result> createUser(

            @Field("email") String email,
            @Field("password") String password,
            @Field("first_name") String fname,
            @Field("last_name") String lname,
            @Field("gender") String gender,
            @Field("dob") String dob,
            @Field("phone_code") String pcode,
            @Field("phone") String phone,
            @Field("image") String image,
            @Field("device_type") String devicetype,
            @Field("device_token") String devicetoken,
            @Field("app_version") String appversion,
            @Field("os_version") String osversion,
            @Field("device_model") String devicemodel,
            @Field("newsletter_subscribed") String newletter);

    @FormUrlEncoded
    @POST("login")
    Call<Result> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );


}
