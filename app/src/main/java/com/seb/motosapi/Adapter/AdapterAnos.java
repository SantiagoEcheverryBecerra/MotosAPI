package com.seb.motosapi.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.seb.motosapi.R;
import com.seb.motosapi.models.Anos;
import com.seb.motosapi.models.Marcas;

import java.util.List;

public class AdapterAnos extends BaseAdapter {

    protected Activity activity;
    protected List<Anos> myAnos;

    public AdapterAnos(Activity activity, List<Anos> anosList){
        this.activity = activity;
        this.myAnos = anosList;
    }

    @Override
    public int getCount() {
        return myAnos.size();
    }

    @Override
    public Object getItem(int position) {
        return myAnos.get(position);
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
            v = inf.inflate(R.layout.anos_lista,null);
        }

        Anos anos = myAnos.get(position);
        TextView nameAnos = v.findViewById(R.id.tvNameAno);
        nameAnos.setText(anos.getTvNameAnos());

        TextView idAnos = v.findViewById(R.id.tvCodigoAno);
        idAnos.setText(anos.getTvIdAnos());

        return v;
    }
}

