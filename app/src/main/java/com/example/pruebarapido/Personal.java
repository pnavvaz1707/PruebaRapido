package com.example.pruebarapido;

import android.os.Parcel;
import android.os.Parcelable;

public class Personal implements Parcelable {
    private String nombre;
    private String cargo;
    private int sueldo;

    public Personal(String nombre, String cargo, int sueldo) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    protected Personal(Parcel in) {
        nombre = in.readString();
        cargo = in.readString();
        sueldo = in.readInt();
    }

    public static final Creator<Personal> CREATOR = new Creator<Personal>() {
        @Override
        public Personal createFromParcel(Parcel in) {
            return new Personal(in);
        }

        @Override
        public Personal[] newArray(int size) {
            return new Personal[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(cargo);
        parcel.writeInt(sueldo);
    }
}
