package com.example.fadel;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class History extends AppCompatActivity {
TextView history;
EditText year;
DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        databaseHelper=new DatabaseHelper(this);
        history=(TextView)findViewById(R.id.history);
        year = (EditText)findViewById(R.id.year);

    }
    public void showMessage(String title, String message) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(message);
        b.show();
    }
    public void show(View view) {
        if(year.getText().toString().trim()==""){
            showMessage("ERROR","insert a year");
        }else {
            if(databaseHelper.selectyear(Integer.parseInt(year.getText().toString()))==1){
            history.setText(databaseHelper.getalle(Integer.parseInt(year.getText().toString().trim())));
        }else{
            showMessage("ERROR","wrong year");}
        }
        }

}
