package com.example.fadel;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class changepass extends AppCompatActivity {
    EditText user;
    EditText bdate;
    TextView to;
    EditText issue;
    Button btnsend;
DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepass);
        databaseHelper = new DatabaseHelper(this);
        user = (EditText) findViewById(R.id.username);
        bdate = (EditText) findViewById(R.id.bdate);
        to = (TextView) findViewById(R.id.to);
        issue = (EditText) findViewById(R.id.issue);
        btnsend = (Button) findViewById(R.id.send);
        to.setVisibility(View.GONE);
    }
    public void showMessage(String title, String message) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(message);
        b.show();
    }
    public void clearText(){
        issue.setText("");
    }


    public void OnSend(View view){
        Intent it = new Intent(Intent.ACTION_SEND);
        if(databaseHelper.changepass(user.getText().toString().trim(),bdate.getText().toString().trim())==1) {

            it.putExtra(Intent.EXTRA_EMAIL, new String[]{to.getText().toString()});
            it.putExtra(Intent.EXTRA_TEXT, issue.getText());
            it.setType("message/rfc822");
            startActivity(Intent.createChooser(it, "Choose Mail App"));
            showMessage("success","Done");
            clearText();

        }else{
            showMessage("ERROR","invalid informations");
        }


    }

}
