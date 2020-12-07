package com.dikamjitborah.hobarb.ohweather.views.apistuff;

import com.dikamjitborah.hobarb.ohweather.views.apistuff.handler.WeatherHandler;
import com.dikamjitborah.hobarb.ohweather.views.fragment.cities.model.WeatherBeans;
import com.dikamjitborah.hobarb.ohweather.views.utilities.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServices {

    WebServices webServices;
    Gson gson;
    WebApi webApi;
    WebServices(){
        webServices = this;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
       OkHttpClient okHttpClient = new OkHttpClient.Builder()
               .addInterceptor(httpLoggingInterceptor)
               .callTimeout(5, TimeUnit.MINUTES)
               .readTimeout(5, TimeUnit.MINUTES)
               .build();


       gson = new GsonBuilder().setLenient().create();

       webApi = new Retrofit.Builder()
               .baseUrl(Constants.WEATHER_API_URL)
               .addConverterFactory(GsonConverterFactory.create(gson))
               .client(okHttpClient)
               .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
               .build().create(WebApi.class);
    }

    public  static WebServices getInstance()
    {
        return new WebServices();
    }

    public void getWeatherData(final WeatherHandler weatherHandler, String latitude, String longitude, String key, String city) {
        Call<WeatherBeans> call = webApi.getWeather(latitude, longitude, key);
        call.enqueue(new Callback<WeatherBeans>() {
            @Override
            public void onResponse(Call<WeatherBeans> call, Response<WeatherBeans> response) {
                if(response.body()!=null)
                {
                    weatherHandler.onSuccess(response.body());
                }
                else
                {
                    weatherHandler.onError(response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<WeatherBeans> call, Throwable t) {
                weatherHandler.onError(t.getMessage().toString());
            }
        });
    }
}
