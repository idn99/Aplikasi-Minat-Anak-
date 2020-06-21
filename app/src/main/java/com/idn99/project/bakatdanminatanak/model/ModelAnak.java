package com.idn99.project.bakatdanminatanak.model;

public class ModelAnak {
    private int id_anak;
    private String nama_anak;
    private int umur_anak;
    private String gender_anak;

    public ModelAnak(int id_anak, String nama_anak, int umur_anak, String gender_anak) {
        this.id_anak = id_anak;
        this.nama_anak = nama_anak;
        this.umur_anak = umur_anak;
        this.gender_anak = gender_anak;
    }

    public void setId_anak(int id_anak) {
        this.id_anak = id_anak;
    }

    public void setNama_anak(String nama_anak) {
        this.nama_anak = nama_anak;
    }

    public void setUmur_anak(int umur_anak) {
        this.umur_anak = umur_anak;
    }

    public void setGender_anak(String gender_anak) {
        this.gender_anak = gender_anak;
    }

    public int getId_anak() {
        return id_anak;
    }

    public String getNama_anak() {
        return nama_anak;
    }

    public int getUmur_anak() {
        return umur_anak;
    }

    public String getGender_anak() {
        return gender_anak;
    }
}
