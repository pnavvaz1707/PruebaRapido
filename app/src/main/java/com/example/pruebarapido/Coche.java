package com.example.pruebarapido;

import android.os.Parcel;
import android.os.Parcelable;

public class Coche implements Parcelable {
    private String marca;
    private String color;

    public Coche(String marca, String color) {
        this.marca = marca;
        this.color = color;
    }

    protected Coche(Parcel in) {
        marca = in.readString();
        color = in.readString();
    }

    public static final Creator<Coche> CREATOR = new Creator<Coche>() {
        @Override
        public Coche createFromParcel(Parcel in) {
            return new Coche(in);
        }

        @Override
        public Coche[] newArray(int size) {
            return new Coche[size];
        }
    };

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(marca);
        parcel.writeString(color);
    }
}
