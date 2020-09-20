package com.iamvickyav.jarvis.mobileno_data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface MobileDataService {

    @GET("/getInfo")
    Call<MobileData> getMobileData(@Header("X-Mashape-Key") String header, @Query("mobno") String number);
}
