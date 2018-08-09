package com.example.ured3.inveturaobracunarobe.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ured3.inveturaobracunarobe.Artikli;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    public static final String DATABASE_NAME = "artikli.db";
    public static final String TABLE_NAME = "Artikli";
    public static final String COL1 = "ID";
    public static final String COL2 = "FIRSTNAME";
    public static final String COL3 = "LASTNAME";
    public static final String COL4 = "FAVFOOD";
    public static final String COL5 = "ZALIHA";
    public static final String COL6 = "DONOS";
    public static final String COL7 = "UKUPNO";
    public static final String COL8 = "OSTATAK";
    public static final String COL9 = "PRODANO";
    public static final String COL10 = "IZNOS";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " FIRSTNAME TEXT, LASTNAME TEXT, FAVFOOD TEXT, ZALIHA TEXT, DONOS TEXT, UKUPNO TEXT, OSTATAK TEXT, PRODANO TEXT, IZNOS TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String fName, String lName, String fFood,String zalihaA, String donosA, String ukupnoA, String ostatakA, String prodanoA, String IznosA) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, fName);
        contentValues.put(COL3, lName);
        contentValues.put(COL4, fFood);
        contentValues.put(COL5, zalihaA);
        contentValues.put(COL6, donosA);
        contentValues.put(COL7, ukupnoA);
        contentValues.put(COL8, ostatakA);
        contentValues.put(COL9, prodanoA);
        contentValues.put(COL10, IznosA);


        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //query for 1 week repeats
    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    //update baze
    public Cursor getItemID(String NazivA) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = " SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL2 + " = ' " + NazivA + " ' ";
        Cursor data = db.rawQuery(query, null);
        return data;

    }


    public void UpdateNaziv(String newNaziv, int ID, String oldNaziv) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = " UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = ' " + newNaziv + "' WHERE " + COL1 + " = ' " + ID + " ' " +
                " AND " + COL2 + " = ' " + oldNaziv + " ' ";
        Log.d(TAG, "updateNaziv: query:  " + query);
        Log.d(TAG, "UpdateNaziv: Setting name to" + newNaziv);
        db.execSQL(query);
    }

    public void deleteNaziv(int ID, String Naziv) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " +
                COL1 + " = " + ID + "' " +
                " AND " + COL2 + " = ' " + Naziv + " ' ";
        Log.d(TAG, "deleteNaziv: query:  " + query);
        Log.d(TAG, "deleteNaziv: Deleting " + Naziv + "from database");
        db.execSQL(query);


    }


}