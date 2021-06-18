package com.seb.motosapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.seb.motosapi.Adapter.AdapterMarca;
import com.seb.motosapi.Adapter.AdapterModelo;
import com.seb.motosapi.ApiManager.RetrofitClient;
import com.seb.motosapi.models.Marcas;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MotosMarca extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listMarcas;
    List<Marcas> myMarcas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motos_marca);

        listMarcas = findViewById(R.id.ListMarcas);
        getFromInternetMarca();
        listMarcas.setOnItemClickListener(this);
    }

    private void getFromInternetMarca() {
        Call<List<Marcas>> call = RetrofitClient.getInstance().getMyApi().getMarcas();
        call.enqueue(new Callback<List<Marcas>>() {

            @Override
            public void onResponse(Call<List<Marcas>> call, Response<List<Marcas>> response) {
                myMarcas = response.body();
                String message = "";
                AdapterMarca adapter = new AdapterMarca(MotosMarca.this, myMarcas);
                listMarcas.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Marcas>> call, Throwable t) {
                Toast.makeText(MotosMarca.this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent in = new Intent(this, MotosModelo.class);
        String num = myMarcas.get(position).getTvIdMarca();
        in.putExtra("codigo", num);
        Toast.makeText(this, num, Toast.LENGTH_LONG).show();
        startActivity(in);
    }
}