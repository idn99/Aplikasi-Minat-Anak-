package com.idn99.project.bakatdanminatanak.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.idn99.project.bakatdanminatanak.DBHelper;
import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.adapter.CBListAdapter;
import com.idn99.project.bakatdanminatanak.model.ModelBakat;
import com.idn99.project.bakatdanminatanak.model.ModelCiriBakat;

import java.util.ArrayList;

public class KeteranganBakat extends AppCompatActivity {

    RecyclerView rvCiriBakat;
    DBHelper dbHelper;
    CBListAdapter cbListAdapter;
    ArrayList<ModelCiriBakat> getCB = new ArrayList<>();

    private TextView tvNama, tvKet;
    private ModelBakat bakat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keterangan_bakat);

        Bundle bundle = getIntent().getExtras();
        int idBakat = bundle.getInt("id");

        rvCiriBakat = findViewById(R.id.rv_ket_bakat);
        tvNama = findViewById(R.id.tv_ket_nama_bakat);
        tvKet = findViewById(R.id.bakat_ket_bakat);

        dbHelper = new DBHelper(getApplicationContext());
        getCB = dbHelper.getAllRecordCBKondisi(idBakat);
        bakat = dbHelper.getRecordBakat(getCB.get(0).getId_bakat());

        tvNama.setText(bakat.getNama_bakat());
        tvKet.setText(bakat.getKet_bakat());

        cbListAdapter = new CBListAdapter(getCB, getApplicationContext());
        rvCiriBakat.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvCiriBakat.setAdapter(cbListAdapter);

    }

}
