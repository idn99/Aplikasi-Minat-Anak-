package com.idn99.project.bakatdanminatanak;

public class Anggota {
    private int fotoAnggota;
    private String namaAnggota;
    private String nimAnggota;

    public Anggota(int fotoAnggota, String namaAnggota, String nimAnggota) {
        this.fotoAnggota = fotoAnggota;
        this.namaAnggota = namaAnggota;
        this.nimAnggota = nimAnggota;
    }

    public int getFotoAnggota() {
        return fotoAnggota;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public String getNimAnggota() {
        return nimAnggota;
    }
}
