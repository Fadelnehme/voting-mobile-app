package com.example.fadel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Voters extends AppCompatActivity {
TextView voter;
DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voters);
        databaseHelper=new DatabaseHelper(this);
        voter = (TextView)findViewById(R.id.voter);
    }
    public void show(View view)
    {
        voter.setText(databaseHelper.getallv());
    }
}
