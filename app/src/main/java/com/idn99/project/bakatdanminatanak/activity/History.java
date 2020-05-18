package com.idn99.project.bakatdanminatanak.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.adapter.AboutListAdapter;
import com.idn99.project.bakatdanminatanak.adapter.AdapterHistory;
import com.idn99.project.bakatdanminatanak.model.Anak;
import com.idn99.project.bakatdanminatanak.model.Karakter;
import com.idn99.project.bakatdanminatanak.model.Pertanyaan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class History extends AppCompatActivity {

    ArrayList<Anak> anak = new ArrayList<>();
    private RecyclerView rvHsitory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        rvHsitory = findViewById(R.id.rv_history);

        InputStream inputFileSoal= getResources().openRawResource(R.raw.result);
        String fileJsonSoal = loadJSONFromRaw(inputFileSoal);
        getJsonSoal(fileJsonSoal);

        AdapterHistory adapter = new AdapterHistory(anak);
        rvHsitory.setLayoutManager(new LinearLayoutManager(History.this));
        rvHsitory.setAdapter(adapter);
    }

    public void getJsonSoal(String jsonFile){
        try {
            JSONObject jsonObject = new JSONObject(jsonFile);
            JSONArray jsonSoal = jsonObject.getJSONArray("result");
            for (int j=0;j<jsonSoal.length();j++){
                JSONObject jsonIsi = jsonSoal.getJSONObject(j);
                String nama = jsonIsi.getString("nama");
                int umur = jsonIsi.getInt("umur");
                String warnaKarakter = jsonIsi.getString("warnaKarakter");
                String karakter = jsonIsi.getString("karakter");
                String bakat = jsonIsi.getString("bakat");
                String ketKarakter = jsonIsi.getString("ketKarakter");
                String ketBakat = jsonIsi.getString("ketBakat");
                String caraBelajar = jsonIsi.getString("caraBelajar");
                anak.add(new Anak(nama, umur, warnaKarakter, karakter, bakat, ketKarakter, ketBakat, caraBelajar));
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
