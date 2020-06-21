package com.idn99.project.bakatdanminatanak.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.idn99.project.bakatdanminatanak.DBHelper;
import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.adapter.CKListAdapter;
import com.idn99.project.bakatdanminatanak.model.ModelCiriKarakter;
import com.idn99.project.bakatdanminatanak.model.ModelKarakter;

import java.util.ArrayList;

public class KeteranganKarakter extends AppCompatActivity {

    CKListAdapter ckListAdapter;
    DBHelper dbHelper;
    RecyclerView rvCK;
    ArrayList<ModelCiriKarakter> getData = new ArrayList<>();

    private TextView tvNama, tvKet, tvCaraBelajar;
    ModelKarakter karakter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keterangan_karakter);

        Bundle bundle = getIntent().getExtras();
        int id_k = bundle.getInt("id");

        rvCK = findViewById(R.id.rv_ket_karakter);
        tvNama = findViewById(R.id.tv_ket_nama_kar);
        tvKet = findViewById(R.id.kar_ket_kar);
        tvCaraBelajar = findViewById(R.id.kar_cara_belajar);

        dbHelper = new DBHelper(getApplicationContext());
        getData = dbHelper.getAllRecordCKKondisi(id_k);
        karakter = dbHelper.getRecordKarakter(id_k);

        tvNama.setText(karakter.getNama_karakter());
        tvKet.setText(karakter.getKet_karakter());
        tvCaraBelajar.setText(karakter.getKet_karakter());

        ckListAdapter = new CKListAdapter(getData, getApplicationContext());
        rvCK.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvCK.setAdapter(ckListAdapter);

    }

}
