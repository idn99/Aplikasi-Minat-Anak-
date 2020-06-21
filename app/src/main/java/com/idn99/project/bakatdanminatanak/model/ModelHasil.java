package com.idn99.project.bakatdanminatanak.model;

public class ModelHasil {
    private int id_hasil;
    private int id_anak;
    private int id_bakat;
    private int id_karakter;
    private String gambar_bakat;
    private String nama_anak;
    private int umur_anak;
    private String gender_anak;
    private String nama_bakat;
    private String ket_bakat;
    private String nama_kar;
    private String warnaKarakter;
    private String ket_karakter;
    private String cara_belajar;

    public ModelHasil(int id_hasil, int id_anak, int id_bakat, int id_karakter, String gambar_bakat, String nama_anak, int umur_anak, String gender_anak, String nama_bakat, String ket_bakat, String nama_kar, String warnaKarakter, String ket_karakter, String cara_belajar) {
        this.id_hasil = id_hasil;
        this.id_anak = id_anak;
        this.id_bakat = id_bakat;
        this.id_karakter = id_karakter;
        this.gambar_bakat = gambar_bakat;
        this.nama_anak = nama_anak;
        this.umur_anak = umur_anak;
        this.gender_anak = gender_anak;
        this.nama_bakat = nama_bakat;
        this.ket_bakat = ket_bakat;
        this.nama_kar = nama_kar;
        this.warnaKarakter = warnaKarakter;
        this.ket_karakter = ket_karakter;
        this.cara_belajar = cara_belajar;
    }

    public int getId_hasil() {
        return id_hasil;
    }

    public int getId_anak() {
        return id_anak;
    }

    public int getId_bakat() {
        return id_bakat;
    }

    public int getId_karakter() {
        return id_karakter;
    }

    public String getGambar_bakat() {
        return gambar_bakat;
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

    public String getNama_bakat() {
        return nama_bakat;
    }

    public String getKet_bakat() {
        return ket_bakat;
    }

    public String getNama_kar() {
        return nama_kar;
    }

    public String getWarnaKarakter() {
        return warnaKarakter;
    }

    public String getKet_karakter() {
        return ket_karakter;
    }

    public String getCara_belajar() {
        return cara_belajar;
    }
}
