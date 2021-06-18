package com.seb.motosapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.seb.motosapi.Adapter.AdapterAnos;
import com.seb.motosapi.Adapter.AdapterMarca;
import com.seb.motosapi.ApiManager.RetrofitClient;
import com.seb.motosapi.models.Anos;
import com.seb.motosapi.models.Marcas;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MotosAnos extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listAnos;
    List<Anos> myAnos;

    String id1;
    String id2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motos_anos);

        Bundle in = getIntent().getExtras();
        id1 = in.getString("idMar");
        id2 = in.getString("idMod");
        //Toast.makeText(this, idModelo, Toast.LENGTH_LONG).show();
        //Toast.makeText(this, id2, Toast.LENGTH_LONG).show();

        listAnos = findViewById(R.id.ListAnos);
        getFromInternetAnos();
        listAnos.setOnItemClickListener(this);
    }

    private void getFromInternetAnos() {
        Call<List<Anos>> call = RetrofitClient.getInstance().getMyApi().getAnos(id1 ,id2);
        call.enqueue(new Callback<List<Anos>>() {

            @Override
            public void onResponse(Call<List<Anos>> call, Response<List<Anos>> response) {
                myAnos = response.body();
                String message = "";
                AdapterAnos adapter = new AdapterAnos(MotosAnos.this, myAnos);
                listAnos.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Anos>> call, Throwable t) {
                Toast.makeText(MotosAnos.this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent in = new Intent(this, MotosMoto.class);
        String num = id1;
        String num1 = id2;
        String num2 = myAnos.get(position).getTvIdAnos();
        in.putExtra("idMar", num);
        in.putExtra("idMod", num1);
        in.putExtra("idAno", num2);
        startActivity(in);
    }
}