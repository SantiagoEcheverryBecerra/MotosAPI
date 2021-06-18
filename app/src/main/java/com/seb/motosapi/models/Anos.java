package com.seb.motosapi.models;

import com.google.gson.annotations.SerializedName;

public class Anos {

    @SerializedName("nome")
    private String tvNameAnos;

    @SerializedName("codigo")
    private String tvIdAnos;

    public String getTvNameAnos() {
        return tvNameAnos;
    }

    public void setTvNameAnos(String tvNameAnos) {
        this.tvNameAnos = tvNameAnos;
    }

    public String getTvIdAnos() {
        return tvIdAnos;
    }

    public void setTvIdAnos(String tvIdAnos) {
        this.tvIdAnos = tvIdAnos;
    }
}
