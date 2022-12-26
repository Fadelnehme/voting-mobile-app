package com.example.fadel;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class City extends AppCompatActivity {

    EditText IDC;
    EditText gov;
    TextView city;
    EditText cityn;
    EditText numer;
    Button btnadd;
    Button btnupd;
    Button btndelet;
    private ProgressDialog progressDialog;
SQLiteDatabase db;

DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
      // databaseHelper = new DataBase();
         databaseHelper= new DatabaseHelper(this);
        IDC = (EditText) findViewById(R.id.IDC);
        gov = (EditText) findViewById(R.id.gov);
        cityn = (EditText) findViewById(R.id.cityn);
        numer = (EditText) findViewById(R.id.numer);
        city=(TextView)findViewById(R.id.city) ;
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
        IDC.setText("");
        gov.setText("");
        cityn.setText("");
        numer.setText("");
    }

 public void add(View view) {

     if (IDC.getText().toString().trim().length() == 0 ||
             gov.getText().toString().trim().length() == 0 ||
             cityn.getText().toString().trim().length() == 0 ||
             numer.getText().toString().trim().length() == 0) {
         showMessage("ERROR", "Please enter all values");
     } else {
if(databaseHelper.selectCity(Integer.parseInt(IDC.getText().toString().trim()))== 0) {

    databaseHelper.addcity(Integer.parseInt(IDC.getText().toString().trim()), cityn.getText().toString().trim(), gov.getText().toString().trim(), Integer.parseInt(numer.getText().toString().trim()));

    showMessage("success", "Record inserted!!");
    clearText();
}else{
    showMessage("ERROR","Id already exist");
}
         }

     }

     public void update(View view){
         if(IDC.getText().toString().trim().length()==0){
             showMessage("ERROR","Please enter an ID");
         }else{
    databaseHelper.updatecity(Integer.parseInt(IDC.getText().toString().trim()), cityn.getText().toString().trim(), gov.getText().toString().trim(), Integer.parseInt(numer.getText().toString().trim()));
    showMessage("success", "successfully updated");
    clearText();

}

         }

public void delete(View view){
        if(IDC.getText().toString().trim().length()==0){
            showMessage("ERROR","Please enter an ID");
        }else{
if(databaseHelper.selectCity(Integer.parseInt(IDC.getText().toString().trim()))== 1) {
    databaseHelper.deletcity(Integer.parseInt(IDC.getText().toString().trim()));
    showMessage("success", "successfully deleted");
    clearText();
}else{
    showMessage("ERROR","Id does not exist");
}
        }
        }
    public void show(View view){
        city.setText(databaseHelper.getallc());
    }
}










//}



