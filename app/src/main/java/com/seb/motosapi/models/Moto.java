package com.seb.motosapi.models;

import com.google.gson.annotations.SerializedName;

public class Moto {
    @SerializedName("Valor")
    private String tvValorMoto;

    @SerializedName("Marca")
    private String tvMarcaMoto;

    @SerializedName("Modelo")
    private String tvModeloMoto;

    @SerializedName("AnoModelo")
    private String tvAnoModeloMoto;

    @SerializedName("Combustivel")
    private String tvCombustivelMoto;

    @SerializedName("CodigoFipe")
    private String tvCodigoFipeMoto;

    @SerializedName("MesReferencia")
    private String tvMesReferenciaMoto;

    @SerializedName("TipoVeiculo")
    private String tvTipoVeiculoMoto;

    @SerializedName("SiglaCombustivel")
    private String tvSiglaCombustivelMoto;

    public String getTvValorMoto() {
        return tvValorMoto;
    }

    public void setTvValorMoto(String tvValorMoto) {
        this.tvValorMoto = tvValorMoto;
    }

    public String getTvMarcaMoto() {
        return tvMarcaMoto;
    }

    public void setTvMarcaMoto(String tvMarcaMoto) {
        this.tvMarcaMoto = tvMarcaMoto;
    }

    public String getTvModeloMoto() {
        return tvModeloMoto;
    }

    public void setTvModeloMoto(String tvModeloMoto) {
        this.tvModeloMoto = tvModeloMoto;
    }

    public String getTvAnoModeloMoto() {
        return tvAnoModeloMoto;
    }

    public void setTvAnoModeloMoto(String tvAnoModeloMoto) {
        this.tvAnoModeloMoto = tvAnoModeloMoto;
    }

    public String getTvCombustivelMoto() {
        return tvCombustivelMoto;
    }

    public void setTvCombustivelMoto(String tvCombustivelMoto) {
        this.tvCombustivelMoto = tvCombustivelMoto;
    }

    public String getTvCodigoFipeMoto() {
        return tvCodigoFipeMoto;
    }

    public void setTvCodigoFipeMoto(String tvCodigoFipeMoto) {
        this.tvCodigoFipeMoto = tvCodigoFipeMoto;
    }

    public String getTvMesReferenciaMoto() {
        return tvMesReferenciaMoto;
    }

    public void setTvMesReferenciaMoto(String tvMesReferenciaMoto) {
        this.tvMesReferenciaMoto = tvMesReferenciaMoto;
    }

    public String getTvTipoVeiculoMoto() {
        return tvTipoVeiculoMoto;
    }

    public void setTvTipoVeiculoMoto(String tvTipoVeiculoMoto) {
        this.tvTipoVeiculoMoto = tvTipoVeiculoMoto;
    }

    public String getTvSiglaCombustivelMoto() {
        return tvSiglaCombustivelMoto;
    }

    public void setTvSiglaCombustivelMoto(String tvSiglaCombustivelMoto) {
        this.tvSiglaCombustivelMoto = tvSiglaCombustivelMoto;
    }
}
