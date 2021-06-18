package com.seb.motosapi.models;

import com.google.gson.annotations.SerializedName;

public class MarcasCarro {

    @SerializedName("nome")
    private String tvNameMarcaCarro;

    @SerializedName("codigo")
    private String tvIdMarcaCarro;

    public String getTvNameMarcaCarro() {
        return tvNameMarcaCarro;
    }

    public void setTvNameMarcaCarro(String tvNameMarcaCarro) {
        this.tvNameMarcaCarro = tvNameMarcaCarro;
    }

    public String getTvIdMarcaCarro() {
        return tvIdMarcaCarro;
    }

    public void setTvIdMarcaCarro(String tvIdMarcaCarro) {
        this.tvIdMarcaCarro = tvIdMarcaCarro;
    }
}
