package com.iamvickyav.jarvis.ipaddress;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IPService {
    @GET("/?format=json")
    Call<IPAddress> getMyIp();
}
