package com.example.boffinfundi.myweather.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class WeatherClass implements Serializable {

    private static final long serialVersionUID = 9094269182535483578L;

    @Expose
    @SerializedName("cod")
    private String cod;
    @Expose
    @SerializedName("message")
    private Double message;

    @Expose
    @SerializedName("cnt")
    private Integer cnt;
    @Expose
    @SerializedName("list")
    private java.util.List<List> list;

    @Expose
    @SerializedName("city")
    private City city;


    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public java.util.List<List> getList() {
        return list;
    }

    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
