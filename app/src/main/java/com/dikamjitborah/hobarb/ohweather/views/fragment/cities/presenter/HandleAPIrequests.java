package com.dikamjitborah.hobarb.ohweather.views.fragment.cities.presenter;

import com.dikamjitborah.hobarb.ohweather.views.apistuff.WebServices;
import com.dikamjitborah.hobarb.ohweather.views.apistuff.handler.WeatherHandler;
import com.dikamjitborah.hobarb.ohweather.views.fragment.cities.model.WeatherBeans;
import com.dikamjitborah.hobarb.ohweather.views.fragment.cities.view.HandleFragmentEvents;

public class HandleAPIrequests implements HandleAPIrequestsInterface{

    HandleFragmentEvents handleFragmentEvents;

    public  HandleAPIrequests(HandleFragmentEvents handleFragmentEvents){
        this.handleFragmentEvents = handleFragmentEvents;
    }
    @Override
    public void getCurrentWeather(String latitude, String longitude, String key, String city) {
        handleFragmentEvents.showProgress();
        WebServices.getInstance().getWeatherData(new WeatherHandler(){
            @Override
            public void onSuccess(WeatherBeans weatherBeans) {
                handleFragmentEvents.hideProgress();
                handleFragmentEvents.onSuccess(weatherBeans);
            }
            @Override
            public void onError(String message) {
                handleFragmentEvents.hideProgress();
                handleFragmentEvents.showFeedback(message);

            }


        }, latitude, longitude, key, city);
    }
}
