package com.example.pruebarapido;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdaptadorPersonal extends ArrayAdapter {

    private ArrayList<Personal> personal;
    private ArrayList<Coche> coches;
    private Activity context;

    public AdaptadorPersonal(Activity context, ArrayList<Personal> personal, ArrayList<Coche> coches) {
        super(context, R.layout.list_view_personal, personal);
        this.context = context;
        this.personal = personal;
        this.coches = coches;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.list_view_personal, null);

        TextView tvNombre = item.findViewById(R.id.nombrePersonal);
        tvNombre.setText(personal.get(position).getNombre());

        TextView tvCargo = item.findViewById(R.id.cargoPersonal);
        tvCargo.setText(personal.get(position).getCargo());

        TextView tvSueldo = item.findViewById(R.id.sueldoPersonal);
        tvSueldo.setText(String.valueOf(personal.get(position).getSueldo()));

        ListView listViewCoches = item.findViewById(R.id.lstViewCoches);
        ArrayList<Coche> cochesPosibles = new ArrayList<>();

        for (Coche coche : coches) {
            if (personal.get(position).equals("Informático")) {
                cochesPosibles.add(coche);
            } else {

                if (personal.get(position).getSueldo() >= 2000) {

                    if (coche.getColor().equals("Negro") || coche.getColor().equals("Blanco")) {
                        cochesPosibles.add(coche);
                    }
                } else if (!(coche.getColor().equals("Negro")) && !(coche.getColor().equals("Blanco"))) {
                    cochesPosibles.add(coche);
                }
            }
        }

        AdaptadorCoches adaptadorCoches = new AdaptadorCoches(context, cochesPosibles);
        listViewCoches.setAdapter(adaptadorCoches);

        return item;
    }
}
