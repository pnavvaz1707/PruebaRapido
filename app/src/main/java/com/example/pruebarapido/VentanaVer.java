package com.example.pruebarapido;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class VentanaVer extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_window);


        Bundle bundle = getIntent().getExtras();

        TableLayout listaPersonal = findViewById(R.id.listaPersonal);
        ArrayList<Personal> datosPersonal = bundle.getParcelableArrayList("personal");

        for (Personal personal : datosPersonal) {
            TableRow filaPersonal = new TableRow(this);
            filaPersonal.setPadding(2,2,2,2);


            TextView tvNombre = new TextView(this);
            tvNombre.setText(personal.getNombre());
            filaPersonal.addView(tvNombre);

            TextView tvCargo = new TextView(this);
            tvCargo.setText(personal.getCargo());
            filaPersonal.addView(tvCargo);

            TextView tvSueldo = new TextView(this);
            tvSueldo.setText(String.valueOf(personal.getSueldo()));
            filaPersonal.addView(tvSueldo);

            listaPersonal.addView(filaPersonal);
        }

        TableLayout listaCoches = findViewById(R.id.listaCoches);
        ArrayList<Coche> datosCoche = bundle.getParcelableArrayList("coches");
        for (Coche coche : datosCoche) {
            TableRow filaCoche = new TableRow(this);
            filaCoche.setPadding(2,2,2,2);

            TextView tvMarca = new TextView(this);
            tvMarca.setText(coche.getMarca());
            filaCoche.addView(tvMarca);

            TextView tvColor = new TextView(this);
            tvColor.setText(coche.getColor());
            filaCoche.addView(tvColor);

            listaCoches.addView(filaCoche);
        }

        Button btnVolver = (Button) findViewById(R.id.btn_volver);
        btnVolver.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

}
