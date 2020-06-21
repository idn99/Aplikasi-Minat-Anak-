package com.idn99.project.bakatdanminatanak.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.idn99.project.bakatdanminatanak.DBHelper;
import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.adapter.HistoryListAdapter;
import com.idn99.project.bakatdanminatanak.model.ModelHasil;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    RecyclerView rvHistory;
    TextView tvEmpty;
    DBHelper dbHelper;
    HistoryListAdapter listAdapter;
    ArrayList<ModelHasil> getData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        rvHistory = findViewById(R.id.rv_history);
        tvEmpty = findViewById(R.id.empty);

        dbHelper = new DBHelper(getApplicationContext());
        getData = dbHelper.getAllRecordHasil();

        if (getData.isEmpty()){
            tvEmpty.setVisibility(View.VISIBLE);
        }else{
            tvEmpty.setVisibility(View.GONE);
            listAdapter = new HistoryListAdapter(getData, getApplicationContext());
            rvHistory.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            rvHistory.setAdapter(listAdapter);
        }
    }
}
