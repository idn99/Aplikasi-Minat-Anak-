package com.idn99.project.bakatdanminatanak.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.idn99.project.bakatdanminatanak.DBHelper;
import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.model.ModelHasil;

public class Result extends AppCompatActivity {

    private LinearLayout layout;
    private ImageView imgKar;
    private TextView tvNama, tvUmur, tvKep, tvSifat, tvBakat, tvKet, tvCaraBel;

    DBHelper dbHelper;
    ModelHasil modelHasil;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        inisial();

        Bundle bundle = getIntent().getExtras();
        int idAnak = bundle.getInt("id_anak");

        dbHelper = new DBHelper(getApplicationContext());
        modelHasil = dbHelper.getRecordHasil(idAnak);

        Resources res = getResources();
        int resID = res.getIdentifier(modelHasil.getGambar_bakat() , "drawable", getPackageName());
        Drawable drawable = res.getDrawable(resID );
        imgKar.setImageDrawable(drawable );

        layout.setBackgroundColor(Color.parseColor(modelHasil.getWarnaKarakter()));
        tvNama.setText(modelHasil.getNama_anak());
        tvUmur.setText(modelHasil.getUmur_anak()+" tahun");
        tvSifat.setText(modelHasil.getNama_bakat());
        tvKep.setText(modelHasil.getNama_kar());
        tvBakat.setText(modelHasil.getKet_bakat());
        tvKet.setText(modelHasil.getKet_karakter());
        tvCaraBel.setText(modelHasil.getCara_belajar());
    }

    private void inisial(){
        layout = findViewById(R.id.layout_result);
        imgKar = findViewById(R.id.image_kep);
        tvNama = findViewById(R.id.tv_name);
        tvUmur = findViewById(R.id.tv_age);
        tvKep = findViewById(R.id.tv_kepribadian);
        tvSifat = findViewById(R.id.tv_sifat);
        tvBakat = findViewById(R.id.tv_bakat);
        tvKet = findViewById(R.id.tv_ket);
        tvCaraBel = findViewById(R.id.tv_cara_belajar);
    }



}
