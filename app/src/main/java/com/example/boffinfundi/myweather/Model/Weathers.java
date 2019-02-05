package com.example.boffinfundi.myweather.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Weathers implements Serializable {

    private static final long serialVersionUID = 9094269182535483578L;

    @Expose
    @SerializedName("id")
    int id;
    @Expose
    @SerializedName("main")
    String main;
    @Expose
    @SerializedName("description")
    String description;
    @Expose
    @SerializedName("icon")
    String icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
