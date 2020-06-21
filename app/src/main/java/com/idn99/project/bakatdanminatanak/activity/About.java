package com.idn99.project.bakatdanminatanak.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.idn99.project.bakatdanminatanak.adapter.AboutListAdapter;
import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.model.Anggota;

import java.util.ArrayList;

public class About extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Anggota> anggotas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        recyclerView = findViewById(R.id.rv_anggota);
        addAnggota();

        AboutListAdapter adapter = new AboutListAdapter(anggotas);
        recyclerView.setLayoutManager(new LinearLayoutManager(About.this));
        recyclerView.setAdapter(adapter);
    }

    private void addAnggota(){
        Anggota maul = new Anggota(R.drawable.l5, "ACHMAD MAULANA", "171011402610");
        anggotas.add(maul);
        Anggota fahri = new Anggota(R.drawable.l6, "FAHRI ANDI MUHAMMAD HAMZAH", "171011402576");
        anggotas.add(fahri);
        Anggota ilham = new Anggota(R.drawable.l2, "ILHAM DWI NUGRAHA", "171011402136");
        anggotas.add(ilham);
    }
}
