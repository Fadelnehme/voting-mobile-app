package com.example.fadel;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Type extends AppCompatActivity {
    TextView idvo;
    Button btnorg;
    Button btnmun;
    Button btnpar;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);
        databaseHelper = new DatabaseHelper(this);
        Intent y = getIntent();

        String  id = y.getStringExtra("ID");
        idvo = (TextView) findViewById(R.id.idvo);
        idvo.setTextSize(20);
        idvo.setText(id);
        btnorg = (Button) findViewById(R.id.org);
        btnmun = (Button) findViewById(R.id.mun);
        btnpar = (Button) findViewById(R.id.par);
        idvo.setVisibility(View.GONE);

    }
    public void showMessage(String title, String message) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(message);
        b.show();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.d:
                Intent j = new Intent(this, about.class);
                startActivity(j);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void orgin(View view) {
        String message;

if(databaseHelper.selecttype1(Integer.parseInt(idvo.getText().toString().trim()))==1) {
    Intent y = new Intent(this, Organization.class);
    y.putExtra("IDV", databaseHelper.getidc(Integer.parseInt(idvo.getText().toString().trim())));
    y.putExtra("IDC", databaseHelper.getidc1(Integer.parseInt(idvo.getText().toString().trim())));
    startActivity(y);
}else{
    showMessage("ERROR","no elections now");
}
    }
    public void munici(View view) {

        String message;
        if(databaseHelper.selecttyp2(Integer.parseInt(idvo.getText().toString().trim()))==1) {
            Intent y = new Intent(this, Municipalities.class);
            y.putExtra("IDV", databaseHelper.getidc(Integer.parseInt(idvo.getText().toString().trim())));
            y.putExtra("IDC", databaseHelper.getidc1(Integer.parseInt(idvo.getText().toString().trim())));
            startActivity(y);
        }else{
            showMessage("ERROR","no elections now");
        }
    }
    public void parli(View view) {

        String message;
        if(databaseHelper.selecttyp3(Integer.parseInt(idvo.getText().toString().trim()))==1) {
            Intent y = new Intent(this, Parliamentary.class);
            y.putExtra("IDV", databaseHelper.getidc(Integer.parseInt(idvo.getText().toString().trim())));


            y.putExtra("IDC", databaseHelper.getidc1(Integer.parseInt(idvo.getText().toString().trim())));
            startActivity(y);
        }else{
            showMessage("ERROR","no elections now");
        }
    }
}
