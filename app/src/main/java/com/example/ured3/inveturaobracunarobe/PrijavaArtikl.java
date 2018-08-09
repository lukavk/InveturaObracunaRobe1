package com.example.ured3.inveturaobracunarobe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.system.Os;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ured3.inveturaobracunarobe.Data.DatabaseHelper;

public class PrijavaArtikl extends AppCompatActivity {

    EditText editNaziv,editCijena,editPDV,editZaliha,editProdano,editIznos,editOstatak,editUkupnop,editDonos;
    Button btnAdd,btnView;
   DatabaseHelper myDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prijava_artikl);
        editNaziv = (EditText) findViewById(R.id.editNaziv);
        editCijena = (EditText) findViewById(R.id.editCijena);
        editPDV = (EditText) findViewById(R.id.editPDV);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        editIznos = (EditText) findViewById(R.id.editIznos);
        editZaliha = (EditText) findViewById(R.id.editZaliha);
        editUkupnop = (EditText) findViewById(R.id.editUkupno);
        editOstatak = (EditText) findViewById(R.id.editOstatak);
        editProdano = (EditText) findViewById(R.id.editProdano);
        editDonos = (EditText) findViewById(R.id.editDonos);
        myDB = new DatabaseHelper(this);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrijavaArtikl.this,ViewListContents.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NazivAr = editNaziv.getText().toString();
                String CijenaAr = editCijena.getText().toString();
                String PDVAr= editPDV.getText().toString();
                String ZalihaAr = editZaliha.getText().toString();
                String DonosAr = editDonos.getText().toString();
                String UkupnoAr = editUkupnop.getText().toString();
                String OstatakAr = editOstatak.getText().toString();
                String ProdanoAr = editProdano.getText().toString();
                String IznosAr = editIznos.getText().toString();
                if(NazivAr.length() != 0 && CijenaAr.length() != 0 && PDVAr.length() != 0 && ZalihaAr.length() != 0 && DonosAr.length() != 0 && UkupnoAr.length() != 0  && OstatakAr.length() != 0 && ProdanoAr.length() != 0 && IznosAr.length() != 0 ){
                    AddData(NazivAr,CijenaAr, PDVAr,ZalihaAr,DonosAr,UkupnoAr, OstatakAr,ProdanoAr,IznosAr);
                    editNaziv.setText("");
                    editCijena.setText("");
                    editPDV.setText("");
                    editZaliha.setText("");
                    editDonos.setText("");
                    editOstatak.setText("");
                    editUkupnop.setText("");
                    editProdano.setText("");
                    editIznos.setText("");
                }else{
                    Toast.makeText(PrijavaArtikl.this,"You must put something in the text field!",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void AddData(String NazivAr,String CijenaAr, String PDVAr, String ZalihaA, String DonosA,String UkupnoA,String OstatakA, String ProdanoA, String IznosA ){
        boolean insertData = myDB.addData(NazivAr,CijenaAr,PDVAr, ZalihaA, DonosA,UkupnoA,OstatakA,ProdanoA,IznosA);

        if(insertData==true){
            Toast.makeText(PrijavaArtikl.this,"Successfully Entered Data!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(PrijavaArtikl.this,"Something went wrong :(.",Toast.LENGTH_LONG).show();
        }
    }
}
