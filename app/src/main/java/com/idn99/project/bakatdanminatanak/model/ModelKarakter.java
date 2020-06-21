package com.idn99.project.bakatdanminatanak.model;

public class ModelKarakter {
    private int id_karakter;
    private String warna_karakter;
    private String nama_karakter;
    private String ket_karakter;
    private String cara_belajar;

    public ModelKarakter(int id_karakter, String warna_karakter, String nama_karakter, String ket_karakter, String cara_belajar) {
        this.id_karakter = id_karakter;
        this.warna_karakter = warna_karakter;
        this.nama_karakter = nama_karakter;
        this.ket_karakter = ket_karakter;
        this.cara_belajar = cara_belajar;
    }

    public int getId_karakter() {
        return id_karakter;
    }

    public String getWarna_karakter() {
        return warna_karakter;
    }

    public String getNama_karakter() {
        return nama_karakter;
    }

    public String getKet_karakter() {
        return ket_karakter;
    }

    public String getCara_belajar() {
        return cara_belajar;
    }
}
