package com.example.pruebarapido;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdaptadorCoches extends ArrayAdapter {

    private Activity context;
    private ArrayList<Coche> coches;

    public AdaptadorCoches(Activity context, ArrayList<Coche> coches) {
        super(context, R.layout.list_view_coches, coches);
        this.context = context;
        this.coches = coches;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.list_view_coches, null);

        TextView tvMarca = item.findViewById(R.id.marcaCoches);
        tvMarca.setText(coches.get(position).getMarca());

        return item;
    }
}
