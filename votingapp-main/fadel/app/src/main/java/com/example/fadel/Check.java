package com.example.fadel;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Check extends AppCompatActivity {
    EditText user;
    EditText bdate;
    TextView vuser;
    TextView vpass;
    Button btnshow;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        databaseHelper = new DatabaseHelper(this);
        user = (EditText) findViewById(R.id.username);
        bdate = (EditText) findViewById(R.id.bdate);
       vuser=(TextView) findViewById(R.id.user);
        vpass=(TextView) findViewById(R.id.vpass);
        btnshow = (Button) findViewById(R.id.show);
    }
    public void showMessage(String title, String message) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(message);
        b.show();
    }
    public void shows(View view){

        if(databaseHelper.check(Integer.parseInt(user.getText().toString().trim()),bdate.getText().toString().trim()) == 1){
vuser.setText(databaseHelper.getcheck(Integer.parseInt(user.getText().toString().trim())));
vpass.setText(databaseHelper.getcheck1(Integer.parseInt(user.getText().toString().trim())));
        }else{
            showMessage("ERROR","invalid informations");
        }

    }
}
