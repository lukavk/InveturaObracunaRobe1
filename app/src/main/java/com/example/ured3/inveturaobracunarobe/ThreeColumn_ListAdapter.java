package com.example.ured3.inveturaobracunarobe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ured3.inveturaobracunarobe.Artikli;
import com.example.ured3.inveturaobracunarobe.R;

import java.util.ArrayList;

public class ThreeColumn_ListAdapter extends ArrayAdapter<Artikli> {

    private LayoutInflater mInflater;
    private ArrayList<Artikli> artikli;
    private int mViewResourceId;

    public ThreeColumn_ListAdapter(Context context, int textViewResourceId, ArrayList<Artikli> artikli) {
        super(context, textViewResourceId, artikli);
        this.artikli = artikli;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        Artikli artikl = artikli.get(position);

        if (artikl != null) {
            TextView firstName = (TextView) convertView.findViewById(R.id.textFirstName);
            TextView lastName = (TextView) convertView.findViewById(R.id.textLastName);
            TextView favFood = (TextView) convertView.findViewById(R.id.textFavFood);
            TextView ZalihaAR = (TextView) convertView.findViewById(R.id.Zaliha);
            TextView Donos = (TextView) convertView.findViewById(R.id.Donos);
            TextView Ukupno = (TextView) convertView.findViewById(R.id.Ukpuno);
            TextView Ostatak = (TextView) convertView.findViewById(R.id.Ostatak);
            TextView Prodano = (TextView) convertView.findViewById(R.id.Prodano);
            TextView Cijena = (TextView) convertView.findViewById(R.id.Iznos);

            if (firstName != null) {
                firstName.setText(artikl.getNazivA());
            }
            if (lastName != null) {
                lastName.setText(artikl.getCijenaA());
            }
            if (favFood != null) {
                favFood.setText(artikl.getPDVA());
            }
            if (ZalihaAR != null) {
                ZalihaAR.setText(artikl.getZalihaA());
            }
            if (Donos != null) {
                Donos.setText(artikl.getDonosA());
            }
            if (Ukupno != null) {
                Ukupno.setText(artikl.getUkupnoA());
            }
            if (Ostatak != null) {
                Ostatak.setText(artikl.getOstatakA());
            }
            if (Prodano != null) {
                Prodano.setText(artikl.getProdanoA());
            }
            if (Cijena != null) {
                Cijena.setText(artikl.getIznosA());
            }











        }


        return convertView;
    }
}