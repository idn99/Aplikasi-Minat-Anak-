package com.idn99.project.bakatdanminatanak.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.idn99.project.bakatdanminatanak.R;

public class PengenalanBakatKarakter extends AppCompatActivity {

    Button btnBakat, btnKar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengenalan_bakat_karakter);

        btnBakat = findViewById(R.id.btn_pengenalan_bakat);
        btnKar = findViewById(R.id.btn_pengenalan_karakter);

        btnBakat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PengenalanBakat.class);
                startActivity(intent);
            }
        });

        btnKar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PengenalanKarakter.class);
                startActivity(intent);
            }
        });
    }
}
