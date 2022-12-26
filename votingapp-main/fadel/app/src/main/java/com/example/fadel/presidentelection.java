package com.example.fadel;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class presidentelection extends AppCompatActivity {
    EditText user;
    EditText pass;
    Button btnlog;
DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presidentelection);
        databaseHelper = new DatabaseHelper(this);
        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.pass);
        btnlog = (Button) findViewById(R.id.login);

    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(message);
        b.show();
    }

    public void login(View view) {

        if (databaseHelper.selectcanwin(user.getText().toString().trim(),pass.getText().toString().trim())==1) {
            Intent y = new Intent(this,president.class);
            y.putExtra("IDV",databaseHelper.getcid(user.getText().toString().trim(),pass.getText().toString().trim()));
            y.putExtra("ID",databaseHelper.getidc12(user.getText().toString().trim(),pass.getText().toString().trim()));
            y.putExtra("IDC",databaseHelper.gettype(user.getText().toString().trim(),pass.getText().toString()));
            startActivity(y);
        } else {
            showMessage("ERROR", "put your username and password because you are not winner");
            return;
        }
    }
}
