package com.idn99.project.bakatdanminatanak.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Kriteria implements Parcelable {
    
    private int noKriteria;
    private String bakatAnak;
    private String keteranganBakat;

    public Kriteria(int noKriteria, String bakatAnak, String keteranganBakat) {
        this.noKriteria = noKriteria;
        this.bakatAnak = bakatAnak;
        this.keteranganBakat = keteranganBakat;
    }

    protected Kriteria(Parcel in) {
        noKriteria = in.readInt();
        bakatAnak = in.readString();
        keteranganBakat = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(noKriteria);
        dest.writeString(bakatAnak);
        dest.writeString(keteranganBakat);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Kriteria> CREATOR = new Creator<Kriteria>() {
        @Override
        public Kriteria createFromParcel(Parcel in) {
            return new Kriteria(in);
        }

        @Override
        public Kriteria[] newArray(int size) {
            return new Kriteria[size];
        }
    };

    public int getNoKriteria() {
        return noKriteria;
    }

    public String getBakatAnak() {
        return bakatAnak;
    }

    public String getKeteranganBakat() {
        return keteranganBakat;
    }
}
