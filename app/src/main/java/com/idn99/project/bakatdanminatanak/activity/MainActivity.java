package com.idn99.project.bakatdanminatanak.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.model.Anak;
import com.idn99.project.bakatdanminatanak.model.Karakter;
import com.idn99.project.bakatdanminatanak.model.Pertanyaan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pertanyaan> pertanyaan = new ArrayList<>();
    private ArrayList<Karakter> daftarKarakters = new ArrayList<>();
    private Karakter resultKarakters;
    private Anak anak;
    private ArrayList<Integer> jawaban = new ArrayList<>();
    Button btnNxt;
    private TextView tvSoal, tvNoSoal, tvKategoriSoal;
    private RadioGroup radioGroup;
    private int n;
    private double k1,k2,k3,k4;
    private Boolean isEmpty = true;
    private String nama, umur;
    InputStream inputFileSoal, inputFileHistory;
    private String fileJsonSoal, fileJsonHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNxt = findViewById(R.id.btn_next);
        radioGroup = findViewById(R.id.rd_group);
        tvKategoriSoal = findViewById(R.id.jenis_tes);
        tvNoSoal = findViewById(R.id.tv_soal_ke);
        tvSoal = findViewById(R.id.tv_soal);

        Bundle bundle = getIntent().getExtras();
        nama = bundle.getString("nama");
        umur = bundle.getString("usia");

        inputFileSoal= getResources().openRawResource(R.raw.soal);
        fileJsonSoal = loadJSONFromRaw(inputFileSoal);
//        fileJsonKar = loadJSONFromRaw(inputFileSoal);
        getJsonSoal(fileJsonSoal);
//        getJsonKriteria(fileJsonKar);
        setContent();
        btnNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isiJawaban();
                if (!isEmpty){
                    setContent();
                }else {
                    Toast.makeText(MainActivity.this, "Pilihlah Salah Satu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void isiJawaban(){
        if (radioGroup.getCheckedRadioButtonId()==R.id.rd_yes){
            jawaban.add(1);
            isEmpty = false;
        }else if (radioGroup.getCheckedRadioButtonId()==R.id.rd_no){
            jawaban.add(0);
            isEmpty = false;
        }else {
            isEmpty = true;
        }
    }

    private void setContent(){
        pertanyaan.size();
        if (n>=pertanyaan.size()){
            analisaKarakter();
            anak = new Anak(
                    nama,
                    Integer.parseInt(umur),
                    resultKarakters.getWarnaKarakter(),
                    resultKarakters.getNamKarakter(),
                    "Bakat",
                    resultKarakters.getSifatKarakter(),
                    "Ket. bakat",
                    resultKarakters.getCaraBelajar()
            );
            Intent intent = new Intent(this, Result.class);
            intent.putExtra("result",anak);
            finish();
            startActivity(intent);
        }else{
            tvKategoriSoal.setText(pertanyaan.get(n).getKategoriSoal());
            tvNoSoal.setText("Soal Ke "+pertanyaan.get(n).getNoSoal()+" dari "+pertanyaan.size()+" soal");
            tvSoal.setText(pertanyaan.get(n).getSoal());
//            radioGroup.clearCheck();
        }
        n++;
    }

    private void analisaJawaban(){
        for (int i=0;i<jawaban.size();i++){
            if (i<6){
                k1 = k1 + jawaban.get(i);
            }else if (i>=6 && i<13){
                k2 = k2 + jawaban.get(i);
            }else if (i>=13 && i<18) {
                k3 = k3 + jawaban.get(i);
            }else  if(i>=18 && i<22){
                k4 = k4 + jawaban.get(i);
            }
        }
    }

    private void analisaKarakter(){
        analisaJawaban();
        if (k1>=k2 && k1>=k3 && k1>=k4){
            resultKarakters = daftarKarakters.get(0);
        }else if (k2>=k1 && k2>=k3 && k2>=k4){
            resultKarakters = daftarKarakters.get(1);
        }else if (k3>=k1 && k3>=k1 && k3>=k4){
            resultKarakters = daftarKarakters.get(2);
        }else if(k4>=k1 && k4>=k2 && k4>=k3){
            resultKarakters = daftarKarakters.get(3);
        }
    }

    public void getJsonSoal(String jsonFile){
        try {
            JSONObject jsonObject = new JSONObject(jsonFile);
            JSONArray jsonSoal = jsonObject.getJSONArray("soal");
            for (int j=0;j<jsonSoal.length();j++){
                JSONObject jsonIsi = jsonSoal.getJSONObject(j);
                int noSoal = jsonIsi.getInt("noSoal");
                String catSoal = jsonIsi.getString("kategoriSoal");
                String soal = jsonIsi.getString("soal");
                pertanyaan.add(new Pertanyaan(noSoal, catSoal, soal));
            }
            JSONArray jsonKarakter = jsonObject.getJSONArray("karakter");
            for (int j=0;j<jsonKarakter.length();j++){
                JSONObject jsonIsi = jsonKarakter.getJSONObject(j);
                int noKarakter = jsonIsi.getInt("noKarakter");
                String warna = jsonIsi.getString("warnaKarakter");
                String namaKar = jsonIsi.getString("namaKarakter");
                String caraBelajar = jsonIsi.getString("caraBelajar");
                String ketKar = jsonIsi.getString("sifatKarakter");
                daftarKarakters.add(new Karakter(noKarakter, warna, namaKar, caraBelajar, ketKar));
            }
        }catch (JSONException ex){
            ex.printStackTrace();
        }
    }

    public String loadJSONFromRaw(InputStream inputStream) {
        String json = null;
        try {
            InputStream is = inputStream;
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
