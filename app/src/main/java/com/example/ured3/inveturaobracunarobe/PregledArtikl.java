package com.example.ured3.inveturaobracunarobe;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ured3.inveturaobracunarobe.Data.DatabaseHelper;

import java.util.ArrayList;

public class PregledArtikl extends ArrayAdapter<Artikli> {
    private LayoutInflater mInflater1;
    private ArrayList<Artikli> artikli;
    private int mViewResourceId;


    public PregledArtikl(Context context, int textViewResourceId, ArrayList<Artikli> artikli) {
        super(context, textViewResourceId, artikli);
        this.artikli = artikli;
        mInflater1 = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

}
