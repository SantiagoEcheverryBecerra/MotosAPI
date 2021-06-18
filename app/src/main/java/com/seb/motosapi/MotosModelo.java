package com.seb.motosapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.seb.motosapi.Adapter.AdapterModelo;
import com.seb.motosapi.ApiManager.RetrofitClient;
import com.seb.motosapi.models.Modelo;
import com.seb.motosapi.models.Modelos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MotosModelo extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listModelos;
    Modelos myModelos;
    String idModelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motos_modelo);

        Bundle in = getIntent().getExtras();
        idModelo = in.getString("codigo");
        //Toast.makeText(this, id, Toast.LENGTH_LONG).show();

        listModelos = findViewById(R.id.ListModelos);
        getFromInternetModelos();
        listModelos.setOnItemClickListener(this);



    }

    private void getFromInternetModelos() {

            Call<Modelos> call = RetrofitClient.getInstance().getMyApi().getModelos(idModelo);
            call.enqueue(new Callback<Modelos>() {
                @Override
                public void onResponse(Call<Modelos> call, Response<Modelos> response) {
                    myModelos = response.body();
                    String message = "";
                    AdapterModelo adapter = new AdapterModelo(MotosModelo.this, myModelos.getModelosList());
                    listModelos.setAdapter(adapter);

                }
                @Override
                public void onFailure(Call<Modelos> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Ocurrio un error", Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent in = new Intent(this, MotosAnos.class);
        String num = idModelo;
        String num1 = myModelos.getModelosList().get(position).getTvId();
        in.putExtra("idMar", num);
        in.putExtra("idMod", num1);
        startActivity(in);
    }
}