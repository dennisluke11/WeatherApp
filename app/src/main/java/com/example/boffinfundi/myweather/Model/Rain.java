package com.example.boffinfundi.myweather.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Rain implements Serializable {

    private static final long serialVersionUID = 9094269182935483578L;


    @Expose
    @SerializedName("3h")
    private Double _3h;

    public Double get_3h() {
        return _3h;
    }

    public void set_3h(Double _3h) {
        this._3h = _3h;
    }
}
