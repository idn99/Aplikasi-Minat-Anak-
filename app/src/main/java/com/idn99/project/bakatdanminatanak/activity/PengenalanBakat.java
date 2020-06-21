package com.idn99.project.bakatdanminatanak.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.idn99.project.bakatdanminatanak.DBHelper;
import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.adapter.BakatListAdapter;
import com.idn99.project.bakatdanminatanak.model.ModelBakat;

import java.util.ArrayList;

public class PengenalanBakat extends AppCompatActivity {

    RecyclerView rvBakat;
    BakatListAdapter bakatListAdapter;
    DBHelper dbHelper;
    ArrayList<ModelBakat> getBakats = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengenalan_bakat);

        rvBakat = findViewById(R.id.rv_bakat);

        dbHelper = new DBHelper(getApplicationContext());


        getBakats = dbHelper.getAllRecordBakat();
        bakatListAdapter = new BakatListAdapter(getBakats, getApplicationContext());
        rvBakat.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvBakat.setAdapter(bakatListAdapter);

    }
}
