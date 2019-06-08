package com.example.upclubapp;

import android.app.Application;

import com.example.upclubapp.api.ApiService;
import com.example.upclubapp.api.ApiUtils;

public class UpClubApp extends Application {

    private static UpClubApp instance;

    private ApiService apiService;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        apiService = ApiUtils.create();
    }

    public ApiService getApiService() {
        return apiService;
    }

    public static UpClubApp getInstance() {
        return instance;
    }
}
