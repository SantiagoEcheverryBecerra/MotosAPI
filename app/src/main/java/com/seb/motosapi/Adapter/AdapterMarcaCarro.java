package com.seb.motosapi.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.seb.motosapi.R;
import com.seb.motosapi.models.MarcasCarro;

import java.util.List;

public class AdapterMarcaCarro extends BaseAdapter {
    protected Activity activity;
    protected List<MarcasCarro> myMarcasCarro;

    public AdapterMarcaCarro(Activity activity, List<MarcasCarro> marcasCarroList){
        this.activity = activity;
        this.myMarcasCarro = marcasCarroList;
    }

    @Override
    public int getCount() {
        return myMarcasCarro.size();
    }

    @Override
    public Object getItem(int position) {
        return myMarcasCarro.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.marca_carro_lista, null);
        }

        MarcasCarro marcasCarro = myMarcasCarro.get(position);
        TextView nameMarcaCarro = v.findViewById(R.id.tvNameMarcaCarro);
        nameMarcaCarro.setText(marcasCarro.getTvNameMarcaCarro());

        TextView idMarcaCarro = v.findViewById(R.id.tvCodigoMarcaCarro);
        idMarcaCarro.setText(marcasCarro.getTvIdMarcaCarro());

        return v;
    }
}
