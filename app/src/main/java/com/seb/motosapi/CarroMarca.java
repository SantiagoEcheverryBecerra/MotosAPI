package com.seb.motosapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.seb.motosapi.Adapter.AdapterMarca;
import com.seb.motosapi.Adapter.AdapterMarcaCarro;
import com.seb.motosapi.ApiManager.RetrofitClient;
import com.seb.motosapi.models.Marcas;
import com.seb.motosapi.models.MarcasCarro;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarroMarca extends AppCompatActivity {

    ListView listMarcasCarro;
    List<MarcasCarro> myMarcasCarro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carro_marca);

        listMarcasCarro = findViewById(R.id.ListaMarcaCarro);
        getFromInternetMarcaCarro();
    }

    private void getFromInternetMarcaCarro() {
        Call<List<MarcasCarro>> call = RetrofitClient.getInstance().getMyApi().getMarcasCarro();
        call.enqueue(new Callback<List<MarcasCarro>>() {

            @Override
            public void onResponse(Call<List<MarcasCarro>> call, Response<List<MarcasCarro>> response) {
                myMarcasCarro = response.body();
                String message = "";
                AdapterMarcaCarro adapter = new AdapterMarcaCarro(CarroMarca.this, myMarcasCarro);
                listMarcasCarro.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<MarcasCarro>> call, Throwable t) {
                Toast.makeText(CarroMarca.this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}