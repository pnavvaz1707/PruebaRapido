package com.example.pruebarapido;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Personal> datosPersonal;
    ArrayList<Coche> datosCoches;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_window);

        datosPersonal = new ArrayList<>();
        datosCoches = new ArrayList<>();

        recogerDatos();

        AdaptadorPersonal adaptadorPersonal = new AdaptadorPersonal(this, datosPersonal, datosCoches);
        ListView lstViewPersonal = findViewById(R.id.lstViewPersonal);
        lstViewPersonal.setAdapter(adaptadorPersonal);

        Button btnVer = findViewById(R.id.btn_ver);
        btnVer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, VentanaVer.class);
        Bundle bundle = new Bundle();

        bundle.putParcelableArrayList("personal", datosPersonal);
        bundle.putParcelableArrayList("coches", datosCoches);
        i.putExtras(bundle);
        startActivity(i);

    }

    private void recogerDatos() {
        recogerDatosPersonal();
        recogerDatosCoches();
    }

    private void recogerDatosPersonal() {
        ArrayList<String> nombresPersonal = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.personalNombres)));
        ArrayList<String> cargosPersonal = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.personalCargos)));
        ArrayList<String> sueldoPersonal = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.personalSueldo)));

        for (int i = 0; i < nombresPersonal.size(); i++) {
            String nombre = nombresPersonal.get(i);
            String cargo = cargosPersonal.get(i);
            int sueldo = Integer.parseInt(sueldoPersonal.get(i));

            datosPersonal.add(new Personal(nombre, cargo, sueldo));
        }
    }

    private void recogerDatosCoches() {
        String[] marcasCoche = getResources().getStringArray(R.array.cochesMarca);
        String[] coloresCoche = getResources().getStringArray(R.array.cochesColor);

        for (int i = 0; i < marcasCoche.length; i++) {
            String marca = marcasCoche[i];
            String color = coloresCoche[i];

            datosCoches.add(new Coche(marca, color));
        }
    }


}
