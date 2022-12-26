package com.example.fadel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Candidate extends AppCompatActivity {
TextView can;
DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);
        can = (TextView)findViewById(R.id.can);
        databaseHelper=new DatabaseHelper(this);
    }
    public void show(View view)
    {
        can.setText(databaseHelper.getallca());
    }

}

