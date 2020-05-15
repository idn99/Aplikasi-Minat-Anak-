package com.idn99.project.bakatdanminatanak.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Anak implements Parcelable {
    private String nama;
    private int umur;
    private String warnaKarakter;
    private String karakter;
    private String bakat;
    private String ketKarakter;
    private String ketBakat;
    private String caraBelajar;

    public Anak(String nama, int umur, String warnaKarakter, String karakter, String bakat, String ketKarakter, String ketBakat, String caraBelajar) {
        this.nama = nama;
        this.umur = umur;
        this.warnaKarakter = warnaKarakter;
        this.karakter = karakter;
        this.bakat = bakat;
        this.ketKarakter = ketKarakter;
        this.ketBakat = ketBakat;
        this.caraBelajar = caraBelajar;
    }

    protected Anak(Parcel in) {
        nama = in.readString();
        umur = in.readInt();
        warnaKarakter = in.readString();
        karakter = in.readString();
        bakat = in.readString();
        ketKarakter = in.readString();
        ketBakat = in.readString();
        caraBelajar = in.readString();
    }

    public static final Creator<Anak> CREATOR = new Creator<Anak>() {
        @Override
        public Anak createFromParcel(Parcel in) {
            return new Anak(in);
        }

        @Override
        public Anak[] newArray(int size) {
            return new Anak[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }

    public String getWarnaKarakter() {
        return warnaKarakter;
    }

    public String getKarakter() {
        return karakter;
    }

    public String getBakat() {
        return bakat;
    }

    public String getKetKarakter() {
        return ketKarakter;
    }

    public String getKetBakat() {
        return ketBakat;
    }

    public String getCaraBelajar() {
        return caraBelajar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeInt(umur);
        dest.writeString(warnaKarakter);
        dest.writeString(karakter);
        dest.writeString(bakat);
        dest.writeString(ketKarakter);
        dest.writeString(ketBakat);
        dest.writeString(caraBelajar);
    }
}
