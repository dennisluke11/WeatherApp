package com.example.boffinfundi.myweather.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class List implements Serializable {

    private static final long serialVersionUID = 9094269182535483578L;

    @Expose
    @SerializedName("dt")
    private Integer dt;

    @Expose
    @SerializedName("main")
    private Main main;

    @Expose
    @SerializedName("weather")
    private java.util.List<Weather> weather = null;

    @Expose
    @SerializedName("clouds")
    private Clouds clouds;

    @Expose
    @SerializedName("wind")
    private Wind wind;

    @Expose
    @SerializedName("sys")
    private Sys sys;
    @Expose
    @SerializedName("dt_txt")
    private String dtTxt;
    @Expose
    @SerializedName("rain")
    private Rain rain;


    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public java.util.List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

}