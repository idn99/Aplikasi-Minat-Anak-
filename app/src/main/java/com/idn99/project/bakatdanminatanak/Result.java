package com.idn99.project.bakatdanminatanak;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Result extends AppCompatActivity {

    private RelativeLayout layout;
    private ImageView imgKar;
    private TextView tvNamaUmur, tvKep, tvSifat, tvBakat, tvKet, tvCaraBel;
    private Button btnBackHome;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        inisial();

        Bundle bundle = getIntent().getExtras();
        Karakter karakter = bundle.getParcelable("result");

        layout.setBackground(getDrawable(karakter.getWarnaKarater()));
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
    }



}
