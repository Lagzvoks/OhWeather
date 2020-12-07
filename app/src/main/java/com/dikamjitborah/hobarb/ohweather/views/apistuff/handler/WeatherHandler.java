package com.dikamjitborah.hobarb.ohweather.views.apistuff.handler;

import com.dikamjitborah.hobarb.ohweather.views.fragment.cities.model.WeatherBeans;

public interface WeatherHandler extends BaseHandler{

    void onSuccess(WeatherBeans weatherBeans);
}

