package com.dikamjitborah.hobarb.ohweather.views.fragment.cities.view;

import com.dikamjitborah.hobarb.ohweather.views.fragment.cities.model.WeatherBeans;

public interface HandleFragmentEvents {

    void showProgress();
    void hideProgress();
    void onSuccess(WeatherBeans weatherBeans);
    void showFeedback(String message);


}
