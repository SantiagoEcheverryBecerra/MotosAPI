package com.seb.motosapi.models;

import com.google.gson.annotations.SerializedName;


import java.util.List;


public class Modelos {

    @SerializedName("modelos")
    List<Modelo> modelosList;

    public List<Modelo> getModelosList() {
        return modelosList;
    }

    public void setModelosList(List<Modelo> modelosList) {
        this.modelosList = modelosList;
    }
}
