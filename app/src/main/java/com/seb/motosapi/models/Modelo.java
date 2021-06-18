package com.seb.motosapi.models;

import com.google.gson.annotations.SerializedName;

public class Modelo {

    @SerializedName("codigo")
    private String tvId;

    @SerializedName("nome")
    private String tvName;

    public String getTvId() {
        return tvId;
    }

    public void setTvId(String tvId) {
        this.tvId = tvId;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }
}
