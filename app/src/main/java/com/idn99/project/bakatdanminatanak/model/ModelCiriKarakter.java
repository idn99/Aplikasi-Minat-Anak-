package com.idn99.project.bakatdanminatanak.model;

public class ModelCiriKarakter {
    private int id_ck;
    private int id_karakter;
    private String soal_ck;

    public ModelCiriKarakter(int id_ck, int id_karakter, String soal_ck) {
        this.id_ck = id_ck;
        this.id_karakter = id_karakter;
        this.soal_ck = soal_ck;
    }

    public void setId_ck(int id_ck) {
        this.id_ck = id_ck;
    }

    public void setId_karakter(int id_karakter) {
        this.id_karakter = id_karakter;
    }

    public void setSoal_ck(String soal_ck) {
        this.soal_ck = soal_ck;
    }

    public int getId_ck() {
        return id_ck;
    }

    public int getId_karakter() {
        return id_karakter;
    }

    public String getSoal_ck() {
        return soal_ck;
    }
}
