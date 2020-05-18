package com.idn99.project.bakatdanminatanak.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Karakter implements Parcelable{
    private int noKarakter;
    private String warnaKarakter;

    @SerializedName("namaKarakter")
    private String namKarakter;
    private String caraBelajar;
    private String sifatKarakter;

    public Karakter(int noKarakter, String warnaKarakter, String namKarakter, String caraBelajar, String sifatKarakter) {
        this.noKarakter = noKarakter;
        this.warnaKarakter = warnaKarakter;
        this.namKarakter = namKarakter;
        this.caraBelajar = caraBelajar;
        this.sifatKarakter = sifatKarakter;
    }

    protected Karakter(Parcel in) {
        noKarakter = in.readInt();
        warnaKarakter = in.readString();
        namKarakter = in.readString();
        caraBelajar = in.readString();
        sifatKarakter = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(noKarakter);
        dest.writeString(warnaKarakter);
        dest.writeString(namKarakter);
        dest.writeString(caraBelajar);
        dest.writeString(sifatKarakter);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Karakter> CREATOR = new Creator<Karakter>() {
        @Override
        public Karakter createFromParcel(Parcel in) {
            return new Karakter(in);
        }

        @Override
        public Karakter[] newArray(int size) {
            return new Karakter[size];
        }
    };

    public int getNoKarakter() {
        return noKarakter;
    }

    public String getWarnaKarakter() {
        return warnaKarakter;
    }

    public String getNamKarakter() {
        return namKarakter;
    }

    public String getCaraBelajar() {
        return caraBelajar;
    }

    public String getSifatKarakter() {
        return sifatKarakter;
    }
}
