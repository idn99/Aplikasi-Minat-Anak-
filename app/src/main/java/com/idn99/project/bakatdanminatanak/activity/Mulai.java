package com.idn99.project.bakatdanminatanak.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.idn99.project.bakatdanminatanak.DBHelper;
import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.model.ModelAnak;

import java.util.ArrayList;

public class Mulai extends AppCompatActivity {

    private EditText edtName, edtUsia;
    private Button btnNext;
    private RadioGroup rdgJk;
    private Boolean isEmpty;
    private String nama , usia, jenisKelamin;
    private int idAnak;
    ArrayList<ModelAnak> modelAnaks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulai);

        edtName = findViewById(R.id.edt_name);
        edtUsia = findViewById(R.id.edt_usia);
        rdgJk = findViewById(R.id.rdg_jk);
        btnNext = findViewById(R.id.btn_lanjut);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = edtName.getText().toString();
                usia = edtUsia.getText().toString();
                cekRd();
                if (nama.isEmpty()){
                    edtName.setError("Tidak Boleh Kosong");
                }else if (usia.isEmpty()){
                    edtUsia.setError("Tidak Boleh Kosong");
                }else if (isEmpty){
                    Toast.makeText(Mulai.this, "Pilih Jenis Kelamin", Toast.LENGTH_SHORT).show();
                }else{
                    DBHelper dbHelper = new DBHelper(getApplicationContext());

                    ModelAnak modelAnak = new ModelAnak(1,nama, Integer.parseInt(usia),jenisKelamin);
                    dbHelper.addRecordAnak(modelAnak);

                    modelAnaks = dbHelper.getAllRecordAnak();

                    idAnak = modelAnaks.get(0).getId_anak();

                    Intent intent = new Intent(getApplicationContext(), TesBakatKarakter.class);
                    intent.putExtra("id_anak", idAnak);
                    finish();
                    startActivity(intent);

                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogeTheme);

        builder.setTitle("Peringatan");
        builder.setMessage("Apakah Anda Ingin Kembali ?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("NO", null);

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void cekRd(){
        if (rdgJk.getCheckedRadioButtonId() == R.id.rd_lk){
            jenisKelamin = "Laki - Laki";
            isEmpty = false;
        }else if(rdgJk.getCheckedRadioButtonId() == R.id.rd_pr){
            jenisKelamin = "Perempuan";
            isEmpty = false;
        }else {
            isEmpty = true;
        }
    }
}
