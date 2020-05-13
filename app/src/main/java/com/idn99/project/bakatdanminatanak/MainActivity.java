package com.idn99.project.bakatdanminatanak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pertanyaan> pertanyaan = new ArrayList<>();
    private Button btnNxt;
    private RadioGroup radioGroup;
    private RadioButton rbPilihan1 , rbPilihan2, rbPilihan3, rbPilihan4;
    private Karakter karakter;
    private int n;
    private double k1,k2,k3,k4;
    private Boolean isEmpty = true;
    private String nama, umur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNxt = findViewById(R.id.btn_next);
        radioGroup = findViewById(R.id.rd_group);
        rbPilihan1 = findViewById(R.id.rb_p1);
        rbPilihan2 = findViewById(R.id.rb_p2);
        rbPilihan3 = findViewById(R.id.rb_p3);
        rbPilihan4 = findViewById(R.id.rb_p4);

        Bundle bundle = getIntent().getExtras();
        nama = bundle.getString("nama");
        umur = bundle.getString("usia");

        isiSoal();
        setContent();
        btnNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isiJawaban();
                if (!isEmpty){
                    setContent();
                }else {
                    Toast.makeText(MainActivity.this, "Pilihlah Salah Satu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void isiSoal(){
        Pertanyaan p1 = new Pertanyaan(R.string.s1p1, R.string.s1p2,R.string.s1p3,R.string.s1p4);
        pertanyaan.add(p1);
        Pertanyaan p2 = new Pertanyaan(R.string.s2p1, R.string.s2p2,R.string.s2p3,R.string.s2p4);
        pertanyaan.add(p2);
        Pertanyaan p3 = new Pertanyaan(R.string.s3p1, R.string.s3p2,R.string.s3p3,R.string.s3p4);
        pertanyaan.add(p3);
        Pertanyaan p4 = new Pertanyaan(R.string.s4p1, R.string.s4p2,R.string.s4p3,R.string.s4p4);
        pertanyaan.add(p4);
        Pertanyaan p5 = new Pertanyaan(R.string.s5p1, R.string.s5p2,R.string.s5p3,R.string.s5p4);
        pertanyaan.add(p5);
        Pertanyaan p6 = new Pertanyaan(R.string.s6p1, R.string.s6p2,R.string.s6p3,R.string.s6p4);
        pertanyaan.add(p6);
        Pertanyaan p7 = new Pertanyaan(R.string.s7p1, R.string.s7p2,R.string.s7p3,R.string.s7p4);
        pertanyaan.add(p7);
        Pertanyaan p8 = new Pertanyaan(R.string.s8p1, R.string.s8p2,R.string.s8p3,R.string.s8p4);
        pertanyaan.add(p8);
        Pertanyaan p9 = new Pertanyaan(R.string.s9p1, R.string.s9p2,R.string.s9p3,R.string.s9p4);
        pertanyaan.add(p9);
        Pertanyaan p10 = new Pertanyaan(R.string.s10p1, R.string.s10p2,R.string.s10p3,R.string.s10p4);
        pertanyaan.add(p10);
        Pertanyaan p11 = new Pertanyaan(R.string.s11p1, R.string.s11p2,R.string.s11p3,R.string.s11p4);
        pertanyaan.add(p11);
        Pertanyaan p12 = new Pertanyaan(R.string.s12p1, R.string.s12p2,R.string.s12p3,R.string.s12p4);
        pertanyaan.add(p12);
    }

    private void isiJawaban(){
        if (radioGroup.getCheckedRadioButtonId()==R.id.rb_p1){
            k1 = k1 + 1;
            isEmpty = false;
        }else if(radioGroup.getCheckedRadioButtonId()==R.id.rb_p2){
            k2 = k2 + 1;
            isEmpty = false;
        }else if(radioGroup.getCheckedRadioButtonId()==R.id.rb_p3) {
            k3 = k3 + 1;
            isEmpty = false;
        }else if(radioGroup.getCheckedRadioButtonId()==R.id.rb_p4) {
            k4 = k4 + 1;
            isEmpty = false;
        }else{
            isEmpty = true;
        }
    }

    private void setContent(){
        pertanyaan.size();
        if (n>=pertanyaan.size()){
            analisaBakat();
            Intent intent = new Intent(this, Result.class);
            intent.putExtra("result",karakter);
            finish();
            startActivity(intent);
        }else{
            rbPilihan1.setText(pertanyaan.get(n).getPilihan1());
            rbPilihan2.setText(pertanyaan.get(n).getPilihan2());
            rbPilihan3.setText(pertanyaan.get(n).getPilihan3());
            rbPilihan4.setText(pertanyaan.get(n).getPilihan4());
            radioGroup.clearCheck();
        }
        n++;
    }

    private void analisaBakat(){
        if (k1>=k2 && k1>=k3 && k1>=k4){
            karakter = new Karakter(
                    Color.parseColor("#f58e8e"),
                    R.drawable.chol,
                    nama,
                    umur,
                    R.string.kep1,
                    R.string.c1,
                    R.string.minat1,
                    R.string.ket1,
                    R.string.cb1
            );
        }else if (k2>=k1 && k2>=k3 && k2>=k4){
            karakter = new Karakter(
                    Color.parseColor("#8ea4f5"),
                    R.drawable.mel,
                    nama,
                    umur,
                    R.string.kep2,
                    R.string.c2,
                    R.string.minat2,
                    R.string.ket2,
                    R.string.cb2
            );
        }else if (k3>=k1 && k3>=k1 && k3>=k4){
            karakter = new Karakter(
                    Color.parseColor("#f5f38e"),
                    R.drawable.pleg,
                    nama,
                    umur,
                    R.string.kep3,
                    R.string.c3,
                    R.string.minat3,
                    R.string.ket3,
                    R.string.cb3
            );
        }else if(k4>=k1 && k4>=k2 && k4>=k3){
            karakter = new Karakter(
                    Color.parseColor("#8ef59d"),
                    R.drawable.sang,
                    nama,
                    umur,
                    R.string.kep4,
                    R.string.c4,
                    R.string.minat4,
                    R.string.ket4,
                    R.string.cb4
            );
        }
    }
}
