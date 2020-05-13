package com.idn99.project.bakatdanminatanak.model;

public class Pertanyaan {
    private int pilihan1;
    private int pilihan2;
    private int pilihan3;
    private int pilihan4;

    public Pertanyaan(int pilihan1, int pilihan2, int pilihan3, int pilihan4) {
        this.pilihan1 = pilihan1;
        this.pilihan2 = pilihan2;
        this.pilihan3 = pilihan3;
        this.pilihan4 = pilihan4;
    }

    public int getPilihan1() {
        return pilihan1;
    }

    public int getPilihan2() {
        return pilihan2;
    }

    public int getPilihan3() {
        return pilihan3;
    }

    public int getPilihan4() {
        return pilihan4;
    }
}
