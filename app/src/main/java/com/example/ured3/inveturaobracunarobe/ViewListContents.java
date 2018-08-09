package com.example.ured3.inveturaobracunarobe;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ured3.inveturaobracunarobe.Data.DatabaseHelper;

import java.util.ArrayList;

public class ViewListContents extends AppCompatActivity {
private static final String TAG = "ViewListContents";
        DatabaseHelper myDB;
        ArrayList<Artikli> artikloList;
        ListView listView;
        Artikli artikl;

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);

        myDB = new DatabaseHelper(this);

        artikloList = new ArrayList<>();
        Cursor data = myDB.getListContents();
        int numRows = data.getCount();
        if (numRows == 0) {
        Toast.makeText(ViewListContents.this, "The Database is empty  :(.", Toast.LENGTH_LONG).show();
        } else {
        int i = 0;
        while (data.moveToNext()) {
        artikl = new Artikli(data.getString(1), data.getString(2), data.getString(3), (data.getString(4)),(data.getString(5)),(data.getString(6)),(data.getString(7)),(data.getString(8)),(data.getString(9)));
        artikloList.add(i, artikl);
        System.out.println(data.getString(1) + " " + data.getString(2) + " " + data.getString(3) + " " + data.getString(4) + " " + data.getString(5) + " " + data.getString(6) + " " + data.getString(7) + " " + (data.getString(8) + " ") +(data.getString(9)));
        System.out.println(artikloList.get(i).getNazivA());
        i++;
        }
        ThreeColumn_ListAdapter adapter = new ThreeColumn_ListAdapter(this, R.layout.list_adapter_view, artikloList);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        } }}
   /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int a, long l) {
           String NazivA = adapterView.getItemAtPosition(a).toString();

            Log.d(TAG, "onItemClick: YouClicked on" + NazivA);
            Cursor data = myDB.getItemID(NazivA);
            int itemID = -1;
            while(data.moveToNext())  {
                itemID = data.getInt(0);
            }
            if(itemID > -1) {
                Log.d(TAG, "onItemClick:The ID is"  + itemID);
                Intent editScreenIntent = new Intent(ViewListContents.this,EditDataActivity.class);
                editScreenIntent.putExtra("id",itemID);
                editScreenIntent.putExtra("Naziv",NazivA);
                startActivity(editScreenIntent);
            }
            else {
                toastMessage("No ID associated with that name");
            }
        }


    });

    }
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}  */

