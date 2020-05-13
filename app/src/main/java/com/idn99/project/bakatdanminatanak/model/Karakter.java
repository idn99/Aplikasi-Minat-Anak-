package com.idn99.project.bakatdanminatanak.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Karakter implements Parcelable {
    private int warnaKarater;
    private int gambararakter;
    private String nama;
    private String umur;
    private int kepribadian;
    private int sifat;
    private int minat;
    private int keterangan;
    private int caraBelajar;

    public Karakter(int warnaKarater, int gambararakter, String nama, String umur, int kepribadian, int sifat, int minat, int keterangan, int caraBelajar) {
        this.warnaKarater = warnaKarater;
        this.gambararakter = gambararakter;
        this.nama = nama;
        this.umur = umur;
        this.kepribadian = kepribadian;
        this.sifat = sifat;
        this.minat = minat;
        this.keterangan = keterangan;
        this.caraBelajar = caraBelajar;
    }

    public int getWarnaKarater() {
        return warnaKarater;
    }

    public int getGambararakter() {
        return gambararakter;
    }

    public String getNama() {
        return nama;
    }

    public String getUmur() {
        return umur;
    }

    public int getKepribadian() {
        return kepribadian;
    }

    public int getSifat() {
        return sifat;
    }

    public int getMinat() {
        return minat;
    }

    public int getKeterangan() {
        return keterangan;
    }

    public int getCaraBelajar() {
        return caraBelajar;
    }

    public static Creator<Karakter> getCREATOR() {
        return CREATOR;
    }

    protected Karakter(Parcel in) {
        warnaKarater = in.readInt();
        gambararakter = in.readInt();
        nama = in.readString();
        umur = in.readString();
        kepribadian = in.readInt();
        sifat = in.readInt();
        minat = in.readInt();
        keterangan = in.readInt();
        caraBelajar = in.readInt();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(warnaKarater);
        dest.writeInt(gambararakter);
        dest.writeString(nama);
        dest.writeString(umur);
        dest.writeInt(kepribadian);
        dest.writeInt(sifat);
        dest.writeInt(minat);
        dest.writeInt(keterangan);
        dest.writeInt(caraBelajar);
    }
}
