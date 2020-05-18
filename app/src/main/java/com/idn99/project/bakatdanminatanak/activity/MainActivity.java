package com.idn99.project.bakatdanminatanak.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.model.Anak;
import com.idn99.project.bakatdanminatanak.model.AnakColls;
import com.idn99.project.bakatdanminatanak.model.Bakat;
import com.idn99.project.bakatdanminatanak.model.Karakter;
import com.idn99.project.bakatdanminatanak.model.Pertanyaan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pertanyaan> pertanyaan = new ArrayList<>();
    private ArrayList<Karakter> daftarKarakters = new ArrayList<>();
    private ArrayList<Bakat> bakats = new ArrayList<>();
    private Karakter resultKarakters;
    private Bakat resultBakat;
    private Anak anak;
    private ArrayList<Integer> jawaban = new ArrayList<>();
    Button btnNxt;
    private TextView tvSoal, tvNoSoal, tvKategoriSoal;
    private RadioGroup radioGroup;
    private int n;
    private double k1,k2,k3,k4,b1,b2,b3,b4,b5,b6,tk1,tk2,tk3,tk4,tb1,tb2,tb3,tb4,tb5,tb6;
    private Boolean isEmpty = true;
    private String nama, umur;
    InputStream inputFileSoal;
    private String fileJsonSoal;

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
        getJsonSoal(fileJsonSoal);
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
                    resultBakat.getBakatanak(),
                    resultKarakters.getSifatKarakter(),
                    resultBakat.getKeteranganBakat(),
                    resultKarakters.getCaraBelajar()
            );
//            InputStream in = getResources().openRawResource(R.raw.result);
//            String file = loadJSONFromRaw(in);
//            writeToJson(anak, file);
            Intent intent = new Intent(this, Result.class);
            intent.putExtra("result",anak);
            finish();
            startActivity(intent);
        }else{
            tvKategoriSoal.setText(pertanyaan.get(n).getKategoriSoal());
            if (n<22){
                tvNoSoal.setText("Soal Ke "+pertanyaan.get(n).getNoSoal()+" dari 22 soal");
            }else {
                tvNoSoal.setText("Soal Ke "+pertanyaan.get(n).getNoSoal()+" dari 75 soal");
            }

            tvSoal.setText(pertanyaan.get(n).getSoal());
//            radioGroup.clearCheck();
        }
        n++;
    }

    private void analisaJawaban(){
        for (int i=0;i<jawaban.size();i++){
            if (i<6){
                k1 = k1 + 1;
            }else if (i>=6 && i<13){
                k2 = k2 + 1;
            }else if (i>=13 && i<18) {
                k3 = k3 + 1;
            }else  if(i>=18 && i<22){
                k4 = k4 + 1;
            }else if(i>=22 && i<36){
                b1 = b1 + 1;
            }else if (i>=36 && i<47){
                b2 = b2 + 1;
            }else if (i>=47 && i<70){
                b3 = b3 + 1;
            }else if (i>=70 && i<84){
                b4 = b4 + 1;
            }else if (i>84 && i<91){
                b5 = b5 + 1;
            }else if (i>91){
                b6 = b6 + 1;
            }

            tk1 = k1*16.67;
            tk2 = k2*14.29;
            tk3 = k3*20;
            tk4 = k4*25;

            tb1 = b1*7.14;
            tb2 = b2*9.1;
            tb3 = b3*4.35;
            tb4 = b4*7.14;
            tb5 = b5*14.29;
            tb6 = b6*16.67;
        }
    }

    private void analisaKarakter(){
        analisaJawaban();
        if (tk1>=tk2 && tk1>=tk3 && tk1>=tk4){
            resultKarakters = daftarKarakters.get(0);
        }else if (tk2>=tk1 && tk2>=tk3 && tk2>=tk4){
            resultKarakters = daftarKarakters.get(1);
        }else if (tk3>=tk1 && tk3>=tk1 && tk3>=tk4){
            resultKarakters = daftarKarakters.get(2);
        }else if(tk4>=tk1 && tk4>=tk2 && tk4>=tk3){
            resultKarakters = daftarKarakters.get(3);
        }

        if (tb1>=tb2 && tb1>=tb3 && tb1>=tb4 && tb1>=tb5 && tb1>=tb6){
            resultBakat = bakats.get(0);
        }else if (tb2>=tb1 && tb2>=tb3 && tb2>=tb4 && tb2>=tb5 && tb2>=tb6){
            resultBakat = bakats.get(1);
        }else if (tb3>=tb1 && tb3>=tb2 && tb3>=tb4 && tb3>=tb5 && tb3>=tb6){
            resultBakat = bakats.get(2);
        }else if (tb4>=tb1 && tb4>=tb2 && tb4>=tb3 && tb4>=tb5 && tb4>=tb6){
            resultBakat = bakats.get(3);
        }else if (tb5>=tb1 && tb5>=tb2 && tb5>=tb3 && tb5>=tb4 && tb5>=tb6){
            resultBakat = bakats.get(4);
        }else if (tb6>=tb1 && tb6>=tb2 && tb6>=tb3 && tb6>=tb4 && tb6>=tb5){
            resultBakat = bakats.get(5);
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
            JSONArray jsonBakat = jsonObject.getJSONArray("bakat");
            for (int j=0;j<jsonBakat.length();j++){
                JSONObject jsonIsi = jsonBakat.getJSONObject(j);
                int noKriteria = jsonIsi.getInt("noKriteria");
                String bakatAnak = jsonIsi.getString("bakatAnak");
                String keteranganBakat = jsonIsi.getString("keteranganBakat");
                bakats.add(new Bakat(noKriteria, bakatAnak, keteranganBakat));
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

//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    public void writeToJson(Anak h , String currentJsonString){
//        // I am assuming this string has the current Json. Get this from file.
//        Gson gson=new GsonBuilder().setPrettyPrinting().create();
//
//        AnakColls jsonColl = gson.fromJson( currentJsonString, AnakColls.class);
//        // Add your hisab to the collection.
//        jsonColl.addAnak(h);
//        // Now write this string to file
//        String newJsonString =gson.toJson( jsonColl );
//
//        gson.toJson(newJsonString);
//        System.out.print( newJsonString );
//
//
//
//    }

}

