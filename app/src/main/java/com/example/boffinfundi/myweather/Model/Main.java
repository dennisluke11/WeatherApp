package com.example.boffinfundi.myweather.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Main implements Serializable {

    private static final long serialVersionUID = 9094269182935483578L;


    @Expose
    @SerializedName("temp")
    Double temp;

    @Expose
    @SerializedName("temp_kf")
    Double temp_kf;

    @Expose
    @SerializedName("grnd_level")
    Double grnd_level;


    @Expose
    @SerializedName("sea_level")
    Double sea_level;

    @Expose
    @SerializedName("pressure")
    Double pressure;

    @Expose
    @SerializedName("humidity")
    Double humidity;

    @Expose
    @SerializedName("temp_min")
    Double temp_min;

    @Expose
    @SerializedName("temp_max")
    Double temp_max;

    public Double getTemp_kf() {
        return temp_kf;
    }

    public void setTemp_kf(Double temp_kf) {
        this.temp_kf = temp_kf;
    }

    public Double getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(Double grnd_level) {
        this.grnd_level = grnd_level;
    }

    public Double getSea_level() {
        return sea_level;
    }

    public void setSea_level(Double sea_level) {
        this.sea_level = sea_level;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Double temp_min) {
        this.temp_min = temp_min;
    }

    public Double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Double temp_max) {
        this.temp_max = temp_max;
    }
}
