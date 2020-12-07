package com.dikamjitborah.hobarb.ohweather.views.fragment.cities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dikamjitborah.hobarb.ohweather.R;
import com.dikamjitborah.hobarb.ohweather.views.UniversalStuff;
import com.dikamjitborah.hobarb.ohweather.views.fragment.BaseFrag;
import com.dikamjitborah.hobarb.ohweather.views.fragment.cities.model.WeatherBeans;
import com.dikamjitborah.hobarb.ohweather.views.fragment.cities.presenter.HandleAPIrequests;
import com.dikamjitborah.hobarb.ohweather.views.fragment.cities.view.HandleFragmentEvents;
import com.dikamjitborah.hobarb.ohweather.views.utilities.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class  CityFragment extends BaseFrag implements HandleFragmentEvents {

    TextView temp, feels_like, visibilty, sunset, sunrise, info, pressure, coor, address;

    String latitude,longitude;

    ImageView imageView;

    HandleAPIrequests handleAPIrequests;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CityFragment() {
        // Required empty public constructor
    }

    public static CityFragment newInstance(String param1, String param2) {
        CityFragment fragment = new CityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = getView().findViewById(R.id.imageView_city_frag);
        temp = getView().findViewById(R.id.temp_city_frag);
        feels_like = getView().findViewById(R.id.feels_city_frag);
        info = getView().findViewById(R.id.info_city_frag);
        visibilty = getView().findViewById(R.id.visibility_city_frag);
        pressure = getView().findViewById(R.id.pressure_city_frag);
        sunrise = getView().findViewById(R.id.sunrise_city_frag);
        sunset = getView().findViewById(R.id.sunset_city_frag);

        Bundle bundle =getArguments();
        latitude = bundle.getString("LATITUDE");
        longitude = bundle.getString("LONGITUDE");
        String addr = bundle.getString("ADDRESS");
        String city = bundle.getString("CITY");

        coor = getView().findViewById(R.id.coor_city_frag);
        address = getView().findViewById(R.id.address_city_frag);
        coor.setText(latitude + ", " + longitude);
        address.setText(addr);

        handleAPIrequests = new HandleAPIrequests(this);
        handleAPIrequests.getCurrentWeather(latitude, longitude, Constants.WEATHER_API_KEY, city);




    }

    @Override
    public void showProgress() {
        showProgressBar();
    }

    @Override
    public void hideProgress() {
        hideProgressBar();
    }

    @Override
    public void onSuccess(WeatherBeans weatherBeans) {

        Toast.makeText(getActivity(),  "sufguigiug", Toast.LENGTH_LONG).show();
        String ImageUrl="https://www.weatherbit.io/static/img/icons/"+weatherBeans.getData().get(0).getWeather().getIcon()+".png";
        Glide.with(getActivity()).load(ImageUrl).into(imageView);
        temp.setText(""+ weatherBeans.getData().get(0).getTemp());
        Toast.makeText(getActivity(),  "suf" + weatherBeans, Toast.LENGTH_LONG).show();

    }

    @Override
    public void showFeedback(String message) {
        Toast.makeText(getActivity(), "" + message, Toast.LENGTH_SHORT).show();

    }
}