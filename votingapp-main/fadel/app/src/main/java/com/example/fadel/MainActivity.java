package com.example.fadel;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText user;
    EditText pass;
    Button btnlog;
    Button btnnom;

DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper=new DatabaseHelper(this);

        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.pass);
        btnlog = (Button) findViewById(R.id.login);
        btnnom = (Button) findViewById(R.id.nom);
    }
    public void showMessage(String title,String message){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(message);
        b.show();
    }
    public void clearText(){
        user.setText("");
        pass.setText("");

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

           case R.id.a:
                Intent i = new Intent(this, Check.class);
                startActivity(i);
                return true;
            case R.id.b:
                Intent j = new Intent(this, about.class);
                startActivity(j);
                return true;
            case R.id.c:
                Intent z = new Intent(this, changepass.class);
                startActivity(z);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void login(View view) {

        if (user.getText().toString().equals("admin") && pass.getText().toString().equals("admin")) {
            Intent i = new Intent(this, register.class);
            startActivity(i);
            clearText();
        } else if (databaseHelper.selectuser(user.getText().toString().trim(),pass.getText().toString().trim())==1){

            Intent y = new Intent(this,Type.class);
            y.putExtra("ID",databaseHelper.getid(user.getText().toString().trim(),pass.getText().toString().trim()));
            startActivity(y);
            clearText();
        }
        https://gitlab.com/Ahmadmohammadjabak/votingapp.git
        else{
            showMessage("ERROR","put your username and password");
            return;
        }

    }
    public void nom(View view) {
        if (user.getText().toString().equals("admin") && pass.getText().toString().equals("admin")) {
            Intent i = new Intent(this, nomination.class);
            startActivity(i);
            clearText();
        }else if (databaseHelper.selectuser1(user.getText().toString().trim(),pass.getText().toString().trim())==1){
            Intent y = new Intent(this,nomination.class);
            y.putExtra("ID",databaseHelper.getidc12(user.getText().toString().trim(),pass.getText().toString().trim()));

            y.putExtra("Type",databaseHelper.gettype(user.getText().toString().trim(),pass.getText().toString().trim()));
            startActivity(y);
            clearText();
        }
        else{
            showMessage("ERROR","put your username and password");
            return;
        }

    }

}