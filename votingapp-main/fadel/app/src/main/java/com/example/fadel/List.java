package com.example.fadel;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class List<A> extends AppCompatActivity {
    EditText lid;

    EditText liname;
    TextView list;
    Button btnadd;
    Button btnupd;
    Button btndelet;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        databaseHelper=new DatabaseHelper(this);
        lid = (EditText) findViewById(R.id.lid);
        liname = (EditText) findViewById(R.id.liname);
        list=(TextView)findViewById(R.id.list) ;
        btnadd = (Button) findViewById(R.id.add);
        btnupd = (Button) findViewById(R.id.upd);
        btndelet = (Button) findViewById(R.id.delet);
    }
    public void showMessage(String title, String message) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(message);
        b.show();
    }
    public void clearText(){
        lid.setText("");
        liname.setText("");
    }

    public void addl(View view) {

        if (lid.getText().toString().trim().length() == 0 ||
                liname.getText().toString().trim().length() == 0 ) {
            showMessage("ERROR", "Please enter all values");
        } else {
            if(databaseHelper.selectList(Integer.parseInt(lid.getText().toString().trim()))== 0) {

                databaseHelper.addLIST(Integer.parseInt(lid.getText().toString().trim()), liname.getText().toString().trim());

                showMessage("success", "Record inserted!!");
                clearText();
            }else{
                showMessage("ERROR","Id already exist");
            }
        }

    }

    public void updatel(View view){
        if(lid.getText().toString().trim().length()==0){
            showMessage("ERROR","Please enter an ID");
        }else{
            databaseHelper.updateLIST(Integer.parseInt(lid.getText().toString().trim()), liname.getText().toString().trim());
            showMessage("success", "successfully updated");
            clearText();

        }

    }

    public void deletel(View view){
        if(lid.getText().toString().trim().length()==0){
            showMessage("ERROR","Please enter an ID");
        }else{
            if(databaseHelper.selectList(Integer.parseInt(lid.getText().toString().trim()))== 1) {
                databaseHelper.deletLIST(Integer.parseInt(lid.getText().toString().trim()));
                showMessage("success", "successfully deleted");
                clearText();
            }else{
                showMessage("ERROR","Id does not exist");
            }
        }
    }
    public void show(View view){
        list.setText(databaseHelper.getalli());
    }

}
