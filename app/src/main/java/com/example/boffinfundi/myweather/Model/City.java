package com.example.boffinfundi.myweather.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class City implements Serializable {



    @Expose
    @SerializedName("id")
    private Integer id;
    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("coord")
    private Coord coord;

    @Expose
    @SerializedName("country")
    private String country;
    @Expose
    @SerializedName("population")
    private Integer population;
    private final static long serialVersionUID = 8596915616915576279L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }


}

