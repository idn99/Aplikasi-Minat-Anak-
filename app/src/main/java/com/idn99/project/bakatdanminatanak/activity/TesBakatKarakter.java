package com.idn99.project.bakatdanminatanak.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.idn99.project.bakatdanminatanak.DBHelper;
import com.idn99.project.bakatdanminatanak.R;
import com.idn99.project.bakatdanminatanak.model.ModelAnak;
import com.idn99.project.bakatdanminatanak.model.ModelBakat;
import com.idn99.project.bakatdanminatanak.model.ModelCiriBakat;
import com.idn99.project.bakatdanminatanak.model.ModelCiriKarakter;
import com.idn99.project.bakatdanminatanak.model.ModelHasil;
import com.idn99.project.bakatdanminatanak.model.ModelKarakter;

import java.util.ArrayList;

public class TesBakatKarakter extends AppCompatActivity {

    private Button btnNxt;
    private TextView tvSoal, tvNoSoal, tvKategoriSoal;
    private RadioGroup radioGroup;

    DBHelper dbHelper;
    ArrayList<ModelCiriKarakter> ciriKarakters = new ArrayList<>();
    ArrayList<ModelCiriBakat> ciriBakats = new ArrayList<>();
    ArrayList<ModelBakat> bakats = new ArrayList<>();
    ArrayList<ModelKarakter> karakters = new ArrayList<>();

    private int koleris=0, melankolis=0, plegmanis=0, sanguinis=0;
    private int bktIntelek, bktAkademik, bktKreativ, bktPemimpin, bktSeni, bktPsikomotor;

    private Boolean isEmpty;
    private int noIdAnak;

    private int idxKar, idxBkt, idxIsBkt, idxIsKar;

    private int idHasil, idAnak, idBakat, idKar, umurAnak;
    private String namaAnak, genderAnak, namaBakat, ketBakat, namaKar, warnaKar, ketKar, caraBelajar, gambarBakat;

    ModelHasil modelHasil;
    ModelAnak modelAnak;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_bakat_karakter);

        btnNxt = findViewById(R.id.btns_next);
        radioGroup = findViewById(R.id.rds_group);
        tvKategoriSoal = findViewById(R.id.jeniss_tes);
        tvNoSoal = findViewById(R.id.tvs_soal_ke);
        tvSoal = findViewById(R.id.tvs_soal);

        Bundle bundle = getIntent().getExtras();
        noIdAnak = bundle.getInt("id_anak");

        dbHelper = new DBHelper(getApplicationContext());
        ciriKarakters = dbHelper.getAllRecordCK();
        ciriBakats = dbHelper.getAllRecordCB();
        modelAnak = dbHelper.getRecordAnak(noIdAnak);
        bakats = dbHelper.getAllRecordBakat();
        karakters = dbHelper.getAllRecordKarakter();

        setSoalKar();
        btnNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ruleKar();
                if (!isEmpty){
                    setSoalKar();
                }else {
                    Toast.makeText(getApplicationContext(), "Pilihlah Salah Satu", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogeTheme);

        builder.setTitle("Peringatan");
        builder.setMessage("Apakah Ingin Membatalkan Tes ?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("NO", null);

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void setSoalKar(){
        if (idxKar>=ciriKarakters.size()){
            setSoalBakat();
            btnNxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ruleBakat();
                    if (!isEmpty){
                        setSoalBakat();
                    }else {
                        Toast.makeText(getApplicationContext(), "Pilihlah Salah Satu", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else{
            tvKategoriSoal.setText("Tes Analisa Karakter Anak");
            tvNoSoal.setText(String.valueOf(ciriKarakters.get(idxKar).getId_ck()));
            tvSoal.setText(ciriKarakters.get(idxKar).getSoal_ck());
            radioGroup.clearCheck();
        }
        idxIsKar = idxKar;
        idxKar++;
    }

    private void setSoalBakat(){
        if (idxBkt>=ciriBakats.size()){
            analisisHasilBakat();
            analisisHasilKar();
            setDataAnak();
            dbHelper.addRecordHasil(modelHasil);

            Intent intent = new Intent(getApplicationContext(), Result.class);
            intent.putExtra("id_anak", noIdAnak);
            finish();
            startActivity(intent);

        }else{
            tvKategoriSoal.setText("Tes Analisa Bakat Anak");
            tvNoSoal.setText(String.valueOf(ciriBakats.get(idxBkt).getId_cb()));
            tvSoal.setText(ciriBakats.get(idxBkt).getSoal_cb());
            radioGroup.clearCheck();
        }
        idxIsBkt = idxBkt;
        idxBkt++;
    }

    private void ruleBakat(){
        if (radioGroup.getCheckedRadioButtonId()==R.id.rds_yes){
            if (ciriBakats.get(idxIsBkt).getId_bakat() == 1){
                bktIntelek = bktIntelek + 1;
            }else if(ciriBakats.get(idxIsBkt).getId_bakat() == 2){
                bktAkademik = bktAkademik + 1;
            }else if(ciriBakats.get(idxIsBkt).getId_bakat() == 3){
                bktKreativ = bktKreativ + 1;
            }else if (ciriBakats.get(idxIsBkt).getId_bakat() == 4){
                bktPemimpin = bktPemimpin + 1;
            }else if(ciriBakats.get(idxIsBkt).getId_bakat() == 5){
                bktSeni = bktSeni + 1;
            }else if (ciriBakats.get(idxIsBkt).getId_bakat() == 6){
                bktPsikomotor = bktPsikomotor + 1;
            }
            isEmpty = false;
        }else if (radioGroup.getCheckedRadioButtonId()==R.id.rds_no){
            isEmpty = false;
        }else {
            isEmpty = true;
        }
    }

    private void ruleKar(){
        if (radioGroup.getCheckedRadioButtonId()==R.id.rds_yes){
            if (ciriKarakters.get(idxIsKar).getId_karakter() == 1){
                koleris = koleris + 1;
            }else if(ciriKarakters.get(idxIsKar).getId_karakter() == 2){
                melankolis = melankolis + 1;
            }else if(ciriKarakters.get(idxIsKar).getId_karakter() == 3){
                plegmanis = plegmanis + 1;
            }else if (ciriKarakters.get(idxIsKar).getId_karakter() == 4){
                sanguinis = sanguinis + 1;
            }
            isEmpty = false;
        }else if (radioGroup.getCheckedRadioButtonId()==R.id.rds_no){
            isEmpty = false;
        }else {
            isEmpty = true;
        }
    }

    private void analisisHasilKar(){
        koleris = (koleris/6)*10;
        melankolis = (melankolis/7)*10;
        plegmanis = (plegmanis/5)*10;
        sanguinis = (sanguinis/4)*10;

        if (koleris>=melankolis && koleris>=plegmanis && koleris>=sanguinis){

            idKar = karakters.get(0).getId_karakter();
            warnaKar = karakters.get(0).getWarna_karakter();
            namaKar = karakters.get(0).getNama_karakter();
            ketKar = karakters.get(0).getKet_karakter();
            caraBelajar = karakters.get(0).getCara_belajar();

        }else if (melankolis>=plegmanis && melankolis>=sanguinis){

            idKar = karakters.get(1).getId_karakter();
            warnaKar = karakters.get(1).getWarna_karakter();
            namaKar = karakters.get(1).getNama_karakter();
            ketKar = karakters.get(1).getKet_karakter();
            caraBelajar = karakters.get(1).getCara_belajar();

        }else if (plegmanis>=sanguinis){

            idKar = karakters.get(2).getId_karakter();
            warnaKar = karakters.get(2).getWarna_karakter();
            namaKar = karakters.get(2).getNama_karakter();
            ketKar = karakters.get(2).getKet_karakter();
            caraBelajar = karakters.get(2).getCara_belajar();

        }else {

            idKar = karakters.get(3).getId_karakter();
            warnaKar = karakters.get(3).getWarna_karakter();
            namaKar = karakters.get(3).getNama_karakter();
            ketKar = karakters.get(3).getKet_karakter();
            caraBelajar = karakters.get(3).getCara_belajar();

        }
    }

    private void analisisHasilBakat(){
        bktIntelek = (bktIntelek/14)*10;
        bktAkademik = (bktAkademik/11)*10;
        bktKreativ = (bktKreativ/23)*10;
        bktPemimpin = (bktPemimpin/16)*10;
        bktSeni = (bktSeni/7)*10;
        bktPsikomotor = (bktPsikomotor/6)*10;

        if (bktIntelek>=bktAkademik && bktIntelek>=bktKreativ && bktIntelek>=bktPemimpin && bktIntelek>=bktSeni && bktIntelek>=bktPsikomotor){

            idBakat = bakats.get(0).getId_bakat();
            namaBakat = bakats.get(0).getNama_bakat();
            ketBakat = bakats.get(0).getKet_bakat();

        }else if(bktAkademik>=bktKreativ && bktAkademik>=bktPemimpin && bktAkademik>=bktSeni && bktAkademik>=bktPsikomotor){

            idBakat = bakats.get(1).getId_bakat();
            namaBakat = bakats.get(1).getNama_bakat();
            ketBakat = bakats.get(1).getKet_bakat();

        }else if(bktKreativ>=bktPemimpin && bktKreativ>=bktSeni && bktKreativ>=bktPsikomotor){

            idBakat = bakats.get(2).getId_bakat();
            namaBakat = bakats.get(2).getNama_bakat();
            ketBakat = bakats.get(2).getKet_bakat();

        }else if(bktPemimpin>=bktSeni && bktPemimpin>=bktPsikomotor){

            idBakat = bakats.get(3).getId_bakat();
            namaBakat = bakats.get(3).getNama_bakat();
            ketBakat = bakats.get(3).getKet_bakat();

        }else if(bktSeni>=bktPsikomotor){

            idBakat = bakats.get(4).getId_bakat();
            namaBakat = bakats.get(4).getNama_bakat();
            ketBakat = bakats.get(4).getKet_bakat();

        }else{

            idBakat = bakats.get(5).getId_bakat();
            namaBakat = bakats.get(5).getNama_bakat();
            ketBakat = bakats.get(5).getKet_bakat();;

        }
    }

    private void setDataAnak(){
        idHasil = 1;
        idAnak = modelAnak.getId_anak();
        namaAnak = modelAnak.getNama_anak();
        umurAnak = modelAnak.getUmur_anak();
        genderAnak = modelAnak.getGender_anak();
        setGambarBakat();
        modelHasil = new ModelHasil(idHasil, idAnak, idBakat, idKar, gambarBakat, namaAnak, umurAnak, genderAnak, namaBakat, ketBakat, namaKar, warnaKar, ketKar, caraBelajar);
    }

    private void setGambarBakat(){
        if (genderAnak.equalsIgnoreCase("Perempuan")){
            if (idBakat == 1){
                gambarBakat = "p1";
            }else if (idBakat == 2){
                gambarBakat = "p2";
            }else if (idBakat == 3){
                gambarBakat = "p3";
            }else if (idBakat == 4){
                gambarBakat = "p4";
            }else if (idBakat == 5){
                gambarBakat = "p5";
            }else if (idBakat == 6){
                gambarBakat = "p6";
            }
        }else{
            if (idBakat == 1){
                gambarBakat = "l1";
            }else if (idBakat == 2){
                gambarBakat = "l2";
            }else if (idBakat == 3){
                gambarBakat = "l3";
            }else if (idBakat == 4){
                gambarBakat = "l4";
            }else if (idBakat == 5){
                gambarBakat = "l5";
            }else if (idBakat == 6){
                gambarBakat = "l6";
            }
        }
    }

}
