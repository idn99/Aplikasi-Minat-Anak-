package com.idn99.project.bakatdanminatanak.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.idn99.project.bakatdanminatanak.DBHelper;
import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.adapter.KarakterListAdapter;
import com.idn99.project.bakatdanminatanak.model.ModelKarakter;

import java.util.ArrayList;

public class PengenalanKarakter extends AppCompatActivity {

    RecyclerView rvKarakter;
    DBHelper dbHelper;
    ArrayList<ModelKarakter> getKar = new ArrayList<>();
    KarakterListAdapter karakterListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengenalan_karakter);

        rvKarakter = findViewById(R.id.rv_karakter);

        dbHelper = new DBHelper(getApplicationContext());

        getKar = dbHelper.getAllRecordKarakter();
        karakterListAdapter = new KarakterListAdapter(getKar, getApplicationContext());
        rvKarakter.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvKarakter.setAdapter(karakterListAdapter);

    }
}
