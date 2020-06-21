package com.idn99.project.bakatdanminatanak.model;

public class ModelBakat {
    private int id_bakat;
    private String nama_bakat;
    private String ket_bakat;

    public ModelBakat(int id_bakat, String nama_bakat, String ket_bakat) {
        this.id_bakat = id_bakat;
        this.nama_bakat = nama_bakat;
        this.ket_bakat = ket_bakat;
    }

    public void setId_bakat(int id_bakat) {
        this.id_bakat = id_bakat;
    }

    public void setNama_bakat(String nama_bakat) {
        this.nama_bakat = nama_bakat;
    }

    public void setKet_bakat(String ket_bakat) {
        this.ket_bakat = ket_bakat;
    }

    public int getId_bakat() {
        return id_bakat;
    }

    public String getNama_bakat() {
        return nama_bakat;
    }

    public String getKet_bakat() {
        return ket_bakat;
    }
}
