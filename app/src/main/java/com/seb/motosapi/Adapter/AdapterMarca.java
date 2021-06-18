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

import java.util.ArrayList;
import java.util.List;

public class AdapterMarca extends BaseAdapter {

    protected Activity activity;
    protected List<Marcas> myMarcas;

    public AdapterMarca(Activity activity, List<Marcas> marcasList){
        this.activity = activity;
        this.myMarcas = marcasList;
    }

    @Override
    public int getCount() {
        return myMarcas.size();
    }

    @Override
    public Object getItem(int position) {
        return myMarcas.get(position);
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
            v = inf.inflate(R.layout.marcas_lista ,null);
        }

        Marcas marcas = myMarcas.get(position);
        TextView nameMarca = v.findViewById(R.id.tvNameMarca);
        nameMarca.setText(marcas.getTvNameMarca());

        TextView idMarca = v.findViewById(R.id.tvCodigoMarca);
        idMarca.setText(marcas.getTvIdMarca());

        return v;
    }
}
