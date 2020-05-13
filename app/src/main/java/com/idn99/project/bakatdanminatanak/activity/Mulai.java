package com.idn99.project.bakatdanminatanak.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.idn99.project.bakatdanminatanak.R;

public class Mulai extends AppCompatActivity {

    private EditText edtName, edtUsia;
    private Button btnNext;
    private Boolean isEmpty = true;
    private String nama , usia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulai);

        edtName = findViewById(R.id.edt_name);
        edtUsia = findViewById(R.id.edt_usia);
        btnNext = findViewById(R.id.btn_lanjut);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = nullEdt(edtName);
                usia = nullEdt(edtUsia);

                if (!isEmpty){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("nama", nama);
                    intent.putExtra("usia", usia);
                    finish();
                    startActivity(intent);
                }
            }
        });


    }

    private String nullEdt(EditText edt){
        String hasil = null;
        if (edt.getText().toString().isEmpty()){
            edt.setError("Mohon Diisi");
            isEmpty = true;
        }else{
            hasil = edt.getText().toString();
            isEmpty = false;
        }
        return hasil;
    }
}
