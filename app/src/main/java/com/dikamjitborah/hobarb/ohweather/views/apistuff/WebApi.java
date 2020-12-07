package com.dikamjitborah.hobarb.ohweather.views.apistuff;

import com.dikamjitborah.hobarb.ohweather.views.fragment.cities.model.WeatherBeans;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebApi {

/*
    @GET("current?")
    Call<WeatherBeans>getWeather(@Query("access_key") String key,
                                 @Query("query") String location);*/


    @GET("/v2.0/forecast/daily?")
    Call<WeatherBeans>getWeather(@Query("lat") String lat, @Query("lon") String lon, @Query("key") String key);

}
