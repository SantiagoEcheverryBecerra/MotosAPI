package com.seb.motosapi.ApiManager;

import com.seb.motosapi.models.Anos;
import com.seb.motosapi.models.Marcas;
import com.seb.motosapi.models.MarcasCarro;
import com.seb.motosapi.models.Modelos;
import com.seb.motosapi.models.Moto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    String BASE_URL= "https://parallelum.com.br/fipe/api/v1/";

    @GET("motos/marcas")
    Call<List<Marcas>> getMarcas();

    @GET("motos/marcas/{id}/modelos")
    Call<Modelos> getModelos(@Path("id") String id);

    @GET("motos/marcas/{idModelo}/modelos/{id2}/anos")
    Call<List<Anos>> getAnos(@Path("idModelo") String idModelo, @Path("id2") String id2);

    @GET("motos/marcas/{idM1}/modelos/{idM2}/anos/{idM3}")
    Call<Moto> getMoto(@Path("idM1") String idM1, @Path("idM2") String idM2, @Path("idM3") String idM3);

    @GET("carro/marcas")
    Call<List<MarcasCarro>> getMarcasCarro();


}
