package com.idn99.project.bakatdanminatanak.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.model.Karakter;

public class Result extends AppCompatActivity {

    private RelativeLayout layout;
    private ImageView imgKar;
    private TextView tvNamaUmur, tvKep, tvSifat, tvBakat, tvKet, tvCaraBel;
    private Button btnBackHome, btnExit;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        inisial();

        Karakter karakter = getIntent().getParcelableExtra("result");

        layout.setBackgroundColor(karakter.getWarnaKarater());
        imgKar.setImageResource(karakter.getGambararakter());
        tvNamaUmur.setText(karakter.getNama()+" - "+karakter.getUmur()+" Tahun");
        tvKep.setText(karakter.getKepribadian());
        tvSifat.setText(karakter.getSifat());
        tvBakat.setText(karakter.getMinat());
        tvKet.setText(karakter.getKeterangan());
        tvCaraBel.setText(karakter.getCaraBelajar());
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HalamanAwal.class);
                finish();
                startActivity(intent);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Result.this, R.style.DialogeTheme);

                builder.setTitle("Keluar");
                builder.setMessage("Apakah Anda Ingin Keluar Aplikasi?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                builder.setNegativeButton("NO", null);

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    private void inisial(){
        layout = findViewById(R.id.layout_result);
        imgKar = findViewById(R.id.image_kep);
        tvNamaUmur = findViewById(R.id.tv_name_age);
        tvKep = findViewById(R.id.tv_kepribadian);
        tvSifat = findViewById(R.id.tv_sifat);
        tvBakat = findViewById(R.id.tv_bakat);
        tvKet = findViewById(R.id.tv_ket);
        tvCaraBel = findViewById(R.id.tv_cara_belajar);
        btnBackHome = findViewById(R.id.btn_back_home);
        btnExit = findViewById(R.id.btn_exit);
    }



}
