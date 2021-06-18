package com.seb.motosapi.models;

import com.google.gson.annotations.SerializedName;

public class Marcas {
    @SerializedName("nome")
    private String tvNameMarca;

    @SerializedName("codigo")
    private String tvIdMarca;

    public String getTvNameMarca() {
        return tvNameMarca;
    }

    public void setTvNameMarca(String tvNameMarca) {
        this.tvNameMarca = tvNameMarca;
    }

    public String getTvIdMarca() {
        return tvIdMarca;
    }

    public void setTvIdMarca(String tvIdMarca) {
        this.tvIdMarca = tvIdMarca;
    }
}
