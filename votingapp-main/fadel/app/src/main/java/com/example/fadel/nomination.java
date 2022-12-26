package com.example.fadel;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class nomination extends AppCompatActivity {
TextView idvot;
TextView type;
TextView year;
GridView grid;

DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomination);
        databaseHelper=new DatabaseHelper(this);
        year = (TextView)findViewById(R.id.year);
        Intent y = getIntent();

        String  id = y.getStringExtra("ID");
String types = y.getStringExtra("Type");
        idvot = (TextView)findViewById(R.id.idvot);
        idvot.setText(id);
        type = (TextView) findViewById(R.id.type);
        type.setText(types);
       grid = (GridView)findViewById(R.id.grid);
       idvot.setVisibility(View.GONE);
       type.setVisibility(View.GONE);
       if(idvot.getText().toString().trim()=="" && type.getText().toString().trim()==""){
           String[] data = {databaseHelper.getall1()};

           grid.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, data));

       }else{
           String[] data = {databaseHelper.getall(Integer.parseInt(idvot.getText().toString().trim()), type.getText().toString().trim())};

           grid.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, data));
       }
    }
    public void showMessage(String title, String message) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(message);
        b.show();
    }
    public void saves(View view) {
        if (year.getText().toString().trim() == "") {
            showMessage("ERROR", "please enter year");
        } else {
            if (idvot.getText().toString().trim() == "" && type.getText().toString().trim() == "") {
                if (databaseHelper.selectyear(Integer.parseInt(year.getText().toString().trim())) == 0) {

                    databaseHelper.addelec(Integer.parseInt(year.getText().toString().trim()), databaseHelper.getall1());
                    showMessage("SUCCESS", "All data entered");
                } else {
                    showMessage("ERROR", "year already exist");
                }
            } else {
                showMessage("ERROR", "only admin can save data");
            }

        }
    }
}
