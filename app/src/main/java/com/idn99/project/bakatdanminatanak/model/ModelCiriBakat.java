package com.idn99.project.bakatdanminatanak.model;

public class ModelCiriBakat {
    private int id_cb;
    private int id_bakat;
    private String soal_cb;

    public ModelCiriBakat(int id_cb, int id_bakat, String soal_cb) {
        this.id_cb = id_cb;
        this.id_bakat = id_bakat;
        this.soal_cb = soal_cb;
    }

    public void setId_cb(int id_cb) {
        this.id_cb = id_cb;
    }

    public void setId_bakat(int id_bakat) {
        this.id_bakat = id_bakat;
    }

    public void setSoal_cb(String soal_cb) {
        this.soal_cb = soal_cb;
    }

    public int getId_cb() {
        return id_cb;
    }

    public int getId_bakat() {
        return id_bakat;
    }

    public String getSoal_cb() {
        return soal_cb;
    }
}
