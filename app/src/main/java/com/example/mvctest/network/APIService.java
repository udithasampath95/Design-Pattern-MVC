package com.example.mvctest.network;

import com.example.mvctest.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET(".")
    Call<UserResponse> getUserList(@Query("results") int val);

    @GET(".")
    Call<UserResponse> getUserListPagination(@Query("page") int pageNumber,
                                             @Query("results") int resultValue,
                                             @Query("seed") String seed);
}
