package com.example.upclubapp.api;


import com.example.upclubapp.api.dto.UserDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/api/user/")
    Call<List<UserDto>> getUsers();

    @GET("/api/user/{id}")
    Call<UserDto> getUserById(@Path("id") int id);
}