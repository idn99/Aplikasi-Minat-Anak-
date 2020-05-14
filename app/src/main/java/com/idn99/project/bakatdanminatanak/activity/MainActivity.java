package com.idn99.project.bakatdanminatanak.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.adapter.SoalAdapter;
import com.idn99.project.bakatdanminatanak.model.Jawaban;
import com.idn99.project.bakatdanminatanak.model.Karakter;
import com.idn99.project.bakatdanminatanak.model.Pertanyaan;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pertanyaan> pertanyaan = new ArrayList<>();
    private Button btnNxt;
    private RecyclerView rvSoal;
    private Karakter karakter;
    private SoalAdapter adapter;
    private int n;
    private String nama, umur;
    private int kar1,kar2,kar3,kar4,bakat1,bakat2,bakat3,bakat4,bakat5;
    private ArrayList<Jawaban> jawaban = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNxt = findViewById(R.id.btn_next);
        rvSoal = findViewById(R.id.rv_soal);

        Bundle bundle = getIntent().getExtras();
        nama = bundle.getString("nama");
        umur = bundle.getString("usia");

        isiSoal();
        setContent();
        btnNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (!adapter.getIsEmpty()){
                    setContent();
//                }else {
//                    Toast.makeText(MainActivity.this, "Jawaban Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
//                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogeTheme);

        builder.setTitle("Peringatan");
        builder.setMessage("Kembali Ke Halaman Utama?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("NO", null);

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void isiSoal(){
        pertanyaan.add(new Pertanyaan(1, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(2, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(3, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(4, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(5, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(6, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(7, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(8, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(9, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(10, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(1, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(2, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(3, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(4, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(5, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(6, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(7, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(8, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(9, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(10, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(9, "Anak Berdiri Sediri"));
        pertanyaan.add(new Pertanyaan(10, "Anak Berdiri Sediri"));
    }

    private void setContent(){
        pertanyaan.size();
        if (n>2){
            analisaBakat();
            Toast.makeText(this, jawaban.toString(), Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(this, Result.class);
//            intent.putExtra("result",karakter);
//            finish();
//            startActivity(intent);
        }else{
            ArrayList<Pertanyaan> prt = new ArrayList<>();
            if (n==0){
                for (int i=0;i<10;i++){
                    prt.add(pertanyaan.get(i));
                }
            }else if(n==1){
                for (int i=10;i<20;i++){
                    prt.add(pertanyaan.get(i));
                }
            }else if (n==2){
                for (int i=20;i<pertanyaan.size();i++){
                    prt.add(pertanyaan.get(i));
                }
            }
            adapter = new SoalAdapter(prt, getApplicationContext());
            rvSoal.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            rvSoal.setAdapter(adapter);

            jawaban.add(adapter.getJawaban());
        }
        n++;
    }


    private void analisaBakat(){
        for (int i=0;i<jawaban.size();i++){
            if (i<6){
                kar1 = kar1 + jawaban.get(i).getJawaban();
            }else if (i>6 && i<13){
                kar2 = kar2 + jawaban.get(i).getJawaban();
            }else if (i>13 && i<18){
                kar3 = kar3 + jawaban.get(i).getJawaban();
            }else if (i>18 && i<22){
                kar3 = kar3 + jawaban.get(i).getJawaban();
            }
        }

        if (kar1>=kar2 && kar1>=kar3 && kar1>=kar4){
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
        }else if (kar2>=kar1 && kar2>=kar3 && kar2>=kar4){
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
        }else if (kar3>=kar1 && kar3>=kar2 && kar3>=kar4){
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
        }else if(kar4>=kar1 && kar4>=kar2 && kar4>=kar3){
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
