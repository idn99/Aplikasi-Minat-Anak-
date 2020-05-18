package com.idn99.project.bakatdanminatanak.model;

import android.os.Parcelable;

public class Bakat{
    private int noKriteria;
    private String bakatanak;
    private String keteranganBakat;

    public Bakat(int noKriteria, String bakatanak, String keteranganBakat) {
        this.noKriteria = noKriteria;
        this.bakatanak = bakatanak;
        this.keteranganBakat = keteranganBakat;
    }

    public int getNoKriteria() {
        return noKriteria;
    }

    public String getBakatanak() {
        return bakatanak;
    }

    public String getKeteranganBakat() {
        return keteranganBakat;
    }
}
