package com.seb.motosapi.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.seb.motosapi.R;
import com.seb.motosapi.models.Marcas;
import com.seb.motosapi.models.Modelo;
import com.seb.motosapi.models.Modelos;

import java.util.ArrayList;
import java.util.List;

public class AdapterModelo extends BaseAdapter {

    protected Activity activity;
    protected List<Modelo> myModelo;


    public AdapterModelo(Activity activity, List<Modelo> modelosList) {
        this.activity = activity;
        this.myModelo = modelosList;
    }

    @Override
    public int getCount() {
        return myModelo.size();
    }

    @Override
    public Object getItem(int position) {
        return myModelo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.modelo_lista ,null);
        }

        Modelo modelo = myModelo.get(position);
        TextView nameModelo = v.findViewById(R.id.tvNameModelo);
        nameModelo.setText(modelo.getTvName());

        TextView idModelo = v.findViewById(R.id.tvCodigoModelo);
        idModelo.setText(modelo.getTvId());

        return v;
    }
}
