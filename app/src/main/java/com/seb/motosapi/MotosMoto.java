package com.seb.motosapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import com.seb.motosapi.ApiManager.RetrofitClient;
import com.seb.motosapi.models.Moto;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MotosMoto extends AppCompatActivity  {

    Moto myMoto;

    private String idM1;
    private String idM2;
    private String idM3;

    TextView tvValorMoto;
    TextView tvMarcaMoto;
    TextView tvModeloMoto;
    TextView tvAnoModeloMoto;
    TextView tvCombustivelMoto;
    TextView tvCodigoFipeMoto;
    TextView tvMesReferenciaMoto;
    TextView tvTipoVeiculoMoto;
    TextView tvSiglaCombustivelMoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motos_moto);

        Bundle in = getIntent().getExtras();
        idM1 = in.getString("idMar");
        idM2 = in.getString("idMod");
        idM3 = in.getString("idAno");

        tvValorMoto = findViewById(R.id.tvValorMoto);
        tvMarcaMoto = findViewById(R.id.tvMarcaMoto);
        tvModeloMoto = findViewById(R.id.tvModeloMoto);
        tvAnoModeloMoto = findViewById(R.id.tvAnoModeloMoto);
        tvCombustivelMoto = findViewById(R.id.tvCombustivelMoto);
        tvCodigoFipeMoto = findViewById(R.id.tvCodigoFipeMoto);
        tvMesReferenciaMoto = findViewById(R.id.tvMesReferenciaMoto);
        tvTipoVeiculoMoto = findViewById(R.id.tvTipoVeiculoMoto);
        tvSiglaCombustivelMoto = findViewById(R.id.tvSiglaCombustivelMoto);


        getFromInternetMoto(idM1, idM2, idM3);
    }

    private void getFromInternetMoto(String idM1, String idM2, String idM3) {
        Call<Moto> call = RetrofitClient.getInstance().getMyApi().getMoto(idM1,idM2,idM3);
        call.enqueue(new Callback<Moto>() {

            @Override
            public void onResponse(Call<Moto> call, Response<Moto> response) {
                myMoto = response.body();
                String message = "";
                tvValorMoto.setText(myMoto.getTvValorMoto());
                tvMarcaMoto.setText(myMoto.getTvMarcaMoto());
                tvModeloMoto.setText(myMoto.getTvModeloMoto());
                tvAnoModeloMoto.setText(myMoto.getTvAnoModeloMoto());
                tvCombustivelMoto.setText(myMoto.getTvCombustivelMoto());
                tvCodigoFipeMoto.setText(myMoto.getTvCodigoFipeMoto());
                tvMesReferenciaMoto.setText(myMoto.getTvMesReferenciaMoto());
                tvTipoVeiculoMoto.setText(myMoto.getTvTipoVeiculoMoto());
                tvSiglaCombustivelMoto.setText(myMoto.getTvSiglaCombustivelMoto());
            }

            @Override
            public void onFailure(Call<Moto> call, Throwable t) {
                tvMarcaMoto.setText(t.getMessage());
                Toast.makeText(MotosMoto.this, "Ocurrio un error" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}