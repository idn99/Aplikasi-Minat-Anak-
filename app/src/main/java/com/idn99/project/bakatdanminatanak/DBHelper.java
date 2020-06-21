package com.idn99.project.bakatdanminatanak;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.idn99.project.bakatdanminatanak.model.ModelAnak;
import com.idn99.project.bakatdanminatanak.model.ModelBakat;
import com.idn99.project.bakatdanminatanak.model.ModelCiriBakat;
import com.idn99.project.bakatdanminatanak.model.ModelCiriKarakter;
import com.idn99.project.bakatdanminatanak.model.ModelHasil;
import com.idn99.project.bakatdanminatanak.model.ModelKarakter;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "data";
    public static final String TB_ANAK = "tb_anak";
    public static final String ID_ANAK = "id_anak";
    public static final String NAMA_ANAK = "nama_anak";
    public static final String UMUR_ANAK = "umur_anak";
    public static final String GENDER_ANAK = "gender_anak";
    public static final String CREATE_TB_ANAK = "CREATE TABLE tb_anak(" +
            "id_anak INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nama_anak TEXT NOT NULL, " +
            "umur_anak INTEGER NOT NULL, " +
            "gender_anak TEXT NOT NULL);";

    public static final String TB_BAKAT = "tb_bakat";
    public static final String ID_BAKAT = "id_bakat";
    public static final String NAMA_BAKAT = "nama_bakat";
    public static final String KET_BAKAT = "ket_bakat";
    public static final String CREATE_TB_BAKAT = "CREATE TABLE tb_bakat(" +
            "id_bakat INTEGER PRIMARY KEY ," +
            "nama_bakat TEXT NOT NULL, " +
            "ket_bakat TEXT NOT NULL);";

    public static final String TB_KARAKTER = "tb_karakter";
    public static final String ID_KAR = "id_karakter";
    public static final String WARNA_KAR = "warna_karakter";
    public static final String NAMA_KAR = "nama_karakter";
    public static final String KET_KAR = "ket_karakter";
    public static final String CARA_BELAJAR = "cara_belajar";
    public static final String CREATE_TB_KAR = "CREATE TABLE tb_karakter(" +
            "id_karakter INTEGER PRIMARY KEY, " +
            "warna_karakter TEXT NOT NULL," +
            "nama_karakter TEXT NOT NULL, " +
            "ket_karakter TEXT NOT NULL, " +
            "cara_belajar TEXT NOT NULL);";

    public static final String TB_HASIL = "tb_hasil";
    public static final String ID_HASIL = "id_hasil";
    public static final String GAMBAR_BAKAT = "gambar_bakat";
    public static final String CREATE_TB_HASIL = "CREATE TABLE tb_hasil(" +
            "id_hasil INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "id_anak INTERGER NOT NULL, " +
            "id_bakat INTERGER NOT NULL, " +
            "id_karakter INTERGER NOT NULL, " +
            "gambar_bakat TEXT NOT NULL," +
            "nama_anak TEXT NOT NULL, " +
            "umur_anak INTEGER NOT NULL, " +
            "gender_anak TEXT NOT NULL," +
            "nama_bakat TEXT NOT NULL, " +
            "ket_bakat TEXT NOT NULL," +
            "nama_karakter TEXT NOT NULL, " +
            "warna_karakter TEXT NOT NULL," +
            "ket_karakter TEXT NOT NULL," +
            "cara_belajar TEXT NOT NULL," +
            "FOREIGN KEY(id_anak) REFERENCES tb_anak(id_anak), " +
            "FOREIGN KEY(id_bakat) REFERENCES tb_bakat(id_bakat), " +
            "FOREIGN KEY(id_anak) REFERENCES tb_karakter(id_karakter)" +
            ");";

    public static final String TB_CIRI_BAKAT = "tb_ciri_bakat";
    public static final String ID_PB = "id_cb";
    public static final String PER_BAKAT = "pernyataan_bakat";
    public static final String CREATE_TB_CIRI_BAKAT = "CREATE TABLE tb_ciri_bakat(" +
            "id_cb INTEGER PRIMARY KEY, " +
            "id_bakat INTEGER NOT NULL, " +
            "pernyataan_bakat TEXT NOT NULL, " +
            "FOREIGN KEY(id_bakat) REFERENCES tb_bakat(id_bakat))";

    public static final String TB_CIRI_KAR = "tb_ciri_karakter";
    public static final String ID_CK = "id_ck";
    public static final String PER_KAR = "pernyataan_karakter";
    public static final String CREATE_TB_CIRI_KAR = "CREATE TABLE tb_ciri_karakter(" +
            "id_ck INTEGER PRIMARY KEY, " +
            "id_karakter INTEGER NOT NULL, " +
            "pernyataan_karakter TEXT NOT NULL, " +
            "FOREIGN KEY(id_karakter) REFERENCES tb_karakter(id_karakter))";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try
        {
            db.execSQL(CREATE_TB_ANAK);
            db.execSQL(CREATE_TB_BAKAT);
            db.execSQL(CREATE_TB_KAR);
            db.execSQL(CREATE_TB_HASIL);
            db.execSQL(CREATE_TB_CIRI_BAKAT);
            db.execSQL(CREATE_TB_CIRI_KAR);
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TB_ANAK);
        db.execSQL("DROP TABLE IF EXISTS "+TB_BAKAT);
        db.execSQL("DROP TABLE IF EXISTS "+TB_KARAKTER);
        db.execSQL("DROP TABLE IF EXISTS "+TB_HASIL);
        db.execSQL("DROP TABLE IF EXISTS "+TB_CIRI_BAKAT);
        db.execSQL("DROP TABLE IF EXISTS "+TB_CIRI_KAR);
        onCreate(db);
    }

    public void addRecordAnak(ModelAnak anak){
        SQLiteDatabase db  = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAMA_ANAK, anak.getNama_anak());
        values.put(UMUR_ANAK, anak.getUmur_anak());
        values.put(GENDER_ANAK, anak.getGender_anak());

        db.insert(TB_ANAK, null, values);
        db.close();
    }

    public void addRecordBakat(ModelBakat bakat){
        SQLiteDatabase db  = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ID_BAKAT, bakat.getId_bakat());
        values.put(NAMA_BAKAT, bakat.getNama_bakat());
        values.put(KET_BAKAT, bakat.getKet_bakat());

        db.insert(TB_BAKAT, null, values);
        db.close();
    }

    public void addRecordKarakter(ModelKarakter karakter){
        SQLiteDatabase db  = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ID_KAR, karakter.getId_karakter());
        values.put(WARNA_KAR, karakter.getWarna_karakter());
        values.put(NAMA_KAR, karakter.getNama_karakter());
        values.put(KET_KAR, karakter.getKet_karakter());
        values.put(CARA_BELAJAR, karakter.getCara_belajar());

        db.insert(TB_KARAKTER, null, values);
        db.close();
    }

    public void addRecordHasil(ModelHasil hasil){
        SQLiteDatabase db  = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ID_ANAK, hasil.getId_anak());
        values.put(ID_BAKAT, hasil.getId_bakat());
        values.put(ID_KAR, hasil.getId_karakter());
        values.put(GAMBAR_BAKAT, hasil.getGambar_bakat());
        values.put(NAMA_ANAK, hasil.getNama_anak());
        values.put(UMUR_ANAK, hasil.getUmur_anak());
        values.put(GENDER_ANAK, hasil.getGender_anak());
        values.put(NAMA_BAKAT, hasil.getNama_bakat());
        values.put(KET_BAKAT, hasil.getKet_bakat());
        values.put(NAMA_KAR, hasil.getNama_kar());
        values.put(WARNA_KAR, hasil.getWarnaKarakter());
        values.put(KET_KAR, hasil.getKet_karakter());
        values.put(CARA_BELAJAR, hasil.getCara_belajar());

        db.insert(TB_HASIL, null, values);
        db.close();
    }

    public void addRecordCiriBakat(ModelCiriBakat ciriBakat){
        SQLiteDatabase db  = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ID_PB, ciriBakat.getId_cb());
        values.put(ID_BAKAT, ciriBakat.getId_bakat());
        values.put(PER_BAKAT, ciriBakat.getSoal_cb());

        db.insert(TB_CIRI_BAKAT, null, values);
        db.close();
    }

    public void addRecordCiriKarakter(ModelCiriKarakter ciriKarakter){
        SQLiteDatabase db  = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ID_CK, ciriKarakter.getId_ck());
        values.put(ID_KAR, ciriKarakter.getId_karakter());
        values.put(PER_KAR, ciriKarakter.getSoal_ck());

        db.insert(TB_CIRI_KAR, null, values);
        db.close();
    }

    public ModelAnak getRecordAnak(int idAnak) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TB_ANAK, new String[] { ID_ANAK,
                        NAMA_ANAK, UMUR_ANAK, GENDER_ANAK }, ID_ANAK + "=?",
                new String[] { String.valueOf(idAnak) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ModelAnak modelAnak = new ModelAnak(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                Integer.parseInt(cursor.getString(2)),
                cursor.getString(3)
                );
        // return contact
        return modelAnak;
    }

    public ModelBakat getRecordBakat(int idBakat) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TB_BAKAT, new String[] { ID_BAKAT,
                        NAMA_BAKAT, KET_BAKAT }, ID_BAKAT + "=?",
                new String[] { String.valueOf(idBakat) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ModelBakat userModels = new ModelBakat(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2)
        );
        // return contact
        return userModels;
    }

    public ModelKarakter getRecordKarakter(int idKar) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TB_KARAKTER, new String[] { ID_KAR,
                        WARNA_KAR, NAMA_KAR, KET_KAR, CARA_BELAJAR }, ID_KAR + "=?",
                new String[] { String.valueOf(idKar) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ModelKarakter userModels = new ModelKarakter(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4)
        );
        // return contact
        return userModels;
    }

    public ModelHasil getRecordHasil(int idAnak) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TB_HASIL, new String[] { ID_HASIL, ID_ANAK, ID_BAKAT, ID_KAR, GAMBAR_BAKAT,
                        NAMA_ANAK, UMUR_ANAK, GENDER_ANAK,
                        NAMA_BAKAT, KET_BAKAT, NAMA_KAR, WARNA_KAR, KET_KAR, CARA_BELAJAR
                        }, ID_ANAK + "=?",
                new String[] { String.valueOf(idAnak) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ModelHasil modelHasil = new ModelHasil(
                Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)),
                Integer.parseInt(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)),
                cursor.getString(4),
                cursor.getString(5),
                Integer.parseInt(cursor.getString(6)),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getString(9),
                cursor.getString(10),
                cursor.getString(11),
                cursor.getString(12),
                cursor.getString(13)
        );

        return modelHasil;
    }

    public ArrayList<ModelHasil> getAllRecordHasil() {
        ArrayList<ModelHasil> hasilList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TB_HASIL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ModelHasil modelHasil = new ModelHasil(
                        Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        Integer.parseInt(cursor.getString(2)),
                        Integer.parseInt(cursor.getString(3)),
                        cursor.getString(4),
                        cursor.getString(5),
                        Integer.parseInt(cursor.getString(6)),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9),
                        cursor.getString(10),
                        cursor.getString(11),
                        cursor.getString(12),
                        cursor.getString(13)
                );
                hasilList.add(modelHasil);
            } while (cursor.moveToNext());
        }

        // return contact list
        return hasilList;
    }

    public ArrayList<ModelAnak> getAllRecordAnak() {
        ArrayList<ModelAnak> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TB_ANAK + " ORDER BY "+ ID_ANAK +" DESC ";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ModelAnak userModels = new ModelAnak(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        Integer.parseInt(cursor.getString(2)),
                        cursor.getString(3)
                );
                contactList.add(userModels);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    public ArrayList<ModelBakat> getAllRecordBakat() {
        ArrayList<ModelBakat> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TB_BAKAT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ModelBakat userModels = new ModelBakat(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2)
                );
                contactList.add(userModels);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    public ArrayList<ModelKarakter> getAllRecordKarakter() {
        ArrayList<ModelKarakter> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TB_KARAKTER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ModelKarakter userModels = new ModelKarakter(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );
                contactList.add(userModels);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    public ArrayList<ModelCiriBakat> getAllRecordCB() {
        ArrayList<ModelCiriBakat> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TB_CIRI_BAKAT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ModelCiriBakat userModels = new ModelCiriBakat(
                        Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        cursor.getString(2)
                );
                contactList.add(userModels);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    public ArrayList<ModelCiriBakat> getAllRecordCBKondisi(int idBakat) {
        ArrayList<ModelCiriBakat> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TB_CIRI_BAKAT +" WHERE id_bakat = "+idBakat;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ModelCiriBakat userModels = new ModelCiriBakat(
                        Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        cursor.getString(2)
                );
                contactList.add(userModels);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    public ArrayList<ModelCiriKarakter> getAllRecordCK() {
        ArrayList<ModelCiriKarakter> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TB_CIRI_KAR;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ModelCiriKarakter userModels = new ModelCiriKarakter(
                        Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        cursor.getString(2)
                );
                contactList.add(userModels);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    public ArrayList<ModelCiriKarakter> getAllRecordCKKondisi(int id_kar) {
        ArrayList<ModelCiriKarakter> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TB_CIRI_KAR +" WHERE id_karakter = "+id_kar;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ModelCiriKarakter userModels = new ModelCiriKarakter(
                        Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        cursor.getString(2)
                );
                contactList.add(userModels);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    public void deleteModel(ModelHasil hasil) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TB_HASIL, ID_HASIL + " = ?",
                new String[] { String.valueOf(hasil.getId_hasil()) });
        db.close();
    }

}
