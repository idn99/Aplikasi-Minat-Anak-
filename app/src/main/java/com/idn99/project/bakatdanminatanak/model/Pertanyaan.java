package com.idn99.project.bakatdanminatanak.model;

public class Pertanyaan {
    private int noSoal;
    private String kategoriSoal;
    private String soal;

    public Pertanyaan(int noSoal, String kategoriSoal, String soal) {
        this.noSoal = noSoal;
        this.kategoriSoal = kategoriSoal;
        this.soal = soal;
    }

    public int getNoSoal() {
        return noSoal;
    }

    public String getKategoriSoal() {
        return kategoriSoal;
    }

    public String getSoal() {
        return soal;
    }
}
