package com.idn99.project.bakatdanminatanak.model;

import java.util.ArrayList;

public class AnakColls {
    ArrayList<Anak> result = new ArrayList<>();

    public AnakColls(ArrayList<Anak> result) {
        this.result = result;
    }

    public ArrayList<Anak> getResult() {
        return result;
    }

    public void addAnak(Anak h ) {
        this.result.add( h );
    }
}
