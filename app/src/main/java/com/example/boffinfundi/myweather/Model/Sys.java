package com.example.boffinfundi.myweather.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sys implements Serializable {

    private static final long serialVersionUID = 9094269182935483575L;


    @Expose
    @SerializedName("pod")
     private String pod;


     public String getPod() {
        return pod;
    }

     public void setPod(String pod) {
        this.pod = pod;
    }
}
