package com.seb.motosapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageButton imgMotos;
    private ImageButton imgCarros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgMotos = findViewById(R.id.moto);
        imgCarros = findViewById(R.id.carro);
        imgMotos.setOnClickListener(this);
        imgCarros.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.carro){
            Intent in = new Intent(this, CarroMarca.class);
            startActivity(in);
        }

        if (v.getId() == R.id.moto){
            Intent Myintent = new Intent(this, MotosMarca.class);
            startActivity(Myintent);
        }
    }
}