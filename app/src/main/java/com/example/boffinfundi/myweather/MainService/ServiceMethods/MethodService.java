package com.example.boffinfundi.myweather.MainService.ServiceMethods;

import com.example.boffinfundi.myweather.Model.Weather;
import com.example.boffinfundi.myweather.Model.WeatherClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MethodService {


    @GET("forecast")
    Call<WeatherClass> getWeather(@Query("lat") String strlat,
                                  @Query("lon") String strLon,
                                  @Query("APPID")String appId);


}
