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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class register extends AppCompatActivity {
    EditText cid;
    EditText idc;
    EditText fname;
    EditText mname;
    EditText lname;
    EditText bd;
    EditText phone;
    EditText email;
    EditText user;
    EditText passw;
    EditText type;
    EditText seat;
    EditText listID;
    EditText purpose ;
    EditText win ;
    RadioButton male;
    RadioButton female;
    RadioButton voter;
    RadioButton cand;
    Button btnadd;
    Button btnupdate;
    TextView nbnomr;
    Button btndelete;
DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        databaseHelper = new DatabaseHelper(this);
         cid= (EditText)findViewById(R.id.cid);
        idc= (EditText)findViewById(R.id.idc);
        fname = (EditText)findViewById(R.id.fname);
        mname = (EditText)findViewById(R.id.mname);
        lname = (EditText)findViewById(R.id.lname);
        bd = (EditText)findViewById(R.id.bd);
        phone = (EditText)findViewById(R.id.phone);
        email = (EditText)findViewById(R.id.email);
        user = (EditText)findViewById(R.id.user);
        passw = (EditText)findViewById(R.id.passw);
        type = (EditText)findViewById(R.id.type);
        seat = (EditText)findViewById(R.id.seat);
        listID= (EditText)findViewById(R.id.listID);
        purpose = (EditText)findViewById(R.id.purpose);
        male = (RadioButton)findViewById(R.id.male);
        female = (RadioButton)findViewById(R.id.female);
        voter = (RadioButton)findViewById(R.id.voter);
        cand = (RadioButton)findViewById(R.id.cand);
        win = (EditText) findViewById(R.id.win);
        btnadd = (Button)findViewById(R.id.add);
        btnupdate = (Button)findViewById(R.id.update);
        nbnomr = (TextView)findViewById(R.id.nbnomr);
        btndelete = (Button)findViewById(R.id.delete);
        nbnomr.setVisibility(View.GONE);

    }
    public void showMessage(String title, String message) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(message);
        b.show();
    }
    public void clearTextv(){

        cid.setText("");
        idc.setText("");
        fname.setText("");
        mname.setText("");
        lname.setText("");
        bd.setText("");
        phone.setText("");
        email.setText("");
        user.setText("");
        passw.setText("");
        type.setText("");
    }
    public void clearTextc(){
        cid.setText("");
        idc.setText("");
        fname.setText("");
        mname.setText("");
        lname.setText("");
        bd.setText("");
        phone.setText("");
        email.setText("");
        user.setText("");
        passw.setText("");
        type.setText("");
        seat.setText("");
        listID.setText("");
        purpose.setText("");
        win.setText("");
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.register, menu);
        return true;
    }

    public void onCheck(View view){

            if(voter.isChecked()) {

                seat.setVisibility(View.GONE);
                purpose.setVisibility(View.GONE);
                listID.setVisibility(View.GONE);
                win.setVisibility(View.GONE);
                return;
            }
            else if(cand.isChecked()){

                seat.setVisibility(View.VISIBLE);
                purpose.setVisibility(View.VISIBLE);
                listID.setVisibility(View.VISIBLE);
                win.setVisibility(View.VISIBLE);
                return;
            }
}
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.g:
                Intent i = new Intent(this, City.class);
                startActivity(i);
                return true;
            case R.id.h:
                Intent j = new Intent(this, List.class);
                startActivity(j);
                return true;
            case R.id.z:
                Intent e = new Intent(this, History.class);
                startActivity(e);
                return true;
            case R.id.y:
                Intent y = new Intent(this, Voters.class);
                startActivity(y);
                return true;
            case R.id.l:
                Intent l = new Intent(this, Candidate.class);
                startActivity(l);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void addr(View view) {
        if (voter.isChecked()) {
            if (male.isChecked()) {

                if (cid.getText().toString().trim().length() == 0 ||
                        idc.getText().toString().trim().length() == 0 ||
                        fname.getText().toString().trim().length() == 0 ||
                        mname.getText().toString().trim().length() == 0 ||
                        lname.getText().toString().trim().length() == 0 ||
                        bd.getText().toString().trim().length() == 0 ||
                        phone.getText().toString().trim().length() == 0 ||
                        email.getText().toString().trim().length() == 0 ||
                        user.getText().toString().trim().length() == 0 ||
                        passw.getText().toString().trim().length() == 0) {
                    showMessage("ERROR", "Please enter all values");

                } else {
                    if (databaseHelper.selectVoter(Integer.parseInt(cid.getText().toString().trim())) == 0) {
                        databaseHelper.addvoter(Integer.parseInt(cid.getText().toString().trim()), Integer.parseInt(idc.getText().toString().trim()), fname.getText().toString().trim(), mname.getText().toString().trim(), lname.getText().toString().trim(), bd.getText().toString().trim(), Integer.parseInt(phone.getText().toString().trim()), email.getText().toString().trim(), "male", user.getText().toString().trim(), passw.getText().toString().trim(), "notvoted",type.getText().toString().trim());

                        showMessage("success", "Record inserted!!");
                        clearTextv();
                    } else {
                        showMessage("ERROR", "Id already exist");
                    }
                }
            } else if (female.isChecked()) {
                if (databaseHelper.selectVoter(Integer.parseInt(cid.getText().toString().trim())) == 0) {
                    databaseHelper.addvoter(Integer.parseInt(cid.getText().toString().trim()), Integer.parseInt(idc.getText().toString().trim()), fname.getText().toString().trim(), mname.getText().toString().trim(), lname.getText().toString().trim(), bd.getText().toString().trim(), Integer.parseInt(phone.getText().toString().trim()), email.getText().toString().trim(), "female", user.getText().toString().trim(), passw.getText().toString().trim(), "notvoted",type.getText().toString().trim());

                    showMessage("success", "Record inserted!!");
                    clearTextv();
                } else {
                    showMessage("ERROR", "Id already exist");
                }
            }
        } else if (cand.isChecked()) {
            if (male.isChecked()) {
                if (cid.getText().toString().trim().length() == 0 ||
                        idc.getText().toString().trim().length() == 0 ||
                        fname.getText().toString().trim().length() == 0 ||
                        mname.getText().toString().trim().length() == 0 ||
                        lname.getText().toString().trim().length() == 0 ||
                        bd.getText().toString().trim().length() == 0 ||
                        phone.getText().toString().trim().length() == 0 ||
                        email.getText().toString().trim().length() == 0 ||
                        user.getText().toString().trim().length() == 0 ||
                        passw.getText().toString().trim().length() == 0 ||
                        type.getText().toString().trim().length() == 0 ||
                        seat.getText().toString().trim().length() == 0 ||
                        listID.getText().toString().trim().length() == 0 ||
                        purpose.getText().toString().trim().length() == 0 ||
                        win.getText().toString().trim().length() == 0) {
                    showMessage("ERROR", "Please enter all values");

                } else {
                    if (databaseHelper.selectCan(Integer.parseInt(cid.getText().toString().trim())) == 0) {
                        databaseHelper.addcan(Integer.parseInt(cid.getText().toString().trim()), Integer.parseInt(idc.getText().toString().trim()), Integer.parseInt(listID.getText().toString().trim()), fname.getText().toString().trim(), mname.getText().toString().trim(), lname.getText().toString().trim(), bd.getText().toString().trim(), Integer.parseInt(phone.getText().toString().trim()), email.getText().toString().trim(), "male", user.getText().toString().trim(), passw.getText().toString().trim(), purpose.getText().toString().trim(), type.getText().toString().trim(), seat.getText().toString().trim(), win.getText().toString().trim());
databaseHelper.addnom(Integer.parseInt(idc.getText().toString().trim()),Integer.parseInt(cid.getText().toString().trim()),0);
                        showMessage("success", "Record inserted!!");
                        clearTextc();
                    } else {
                        showMessage("ERROR", "Id already exist");
                    }
                }
            } else if (female.isChecked()) {
                if (databaseHelper.selectCan(Integer.parseInt(cid.getText().toString().trim())) == 0) {
                    databaseHelper.addcan(Integer.parseInt(cid.getText().toString().trim()), Integer.parseInt(idc.getText().toString().trim()), Integer.parseInt(listID.getText().toString().trim()), fname.getText().toString().trim(), mname.getText().toString().trim(), lname.getText().toString().trim(), bd.getText().toString().trim(), Integer.parseInt(phone.getText().toString().trim()), email.getText().toString().trim(), "female", user.getText().toString().trim(), passw.getText().toString().trim(), purpose.getText().toString().trim(), type.getText().toString().trim(), seat.getText().toString().trim(), win.getText().toString().trim());
                    databaseHelper.addnom(Integer.parseInt(idc.getText().toString().trim()),Integer.parseInt(cid.getText().toString().trim()),0);
                    showMessage("success", "Record inserted!!");
                    clearTextc();
                } else {
                    showMessage("ERROR", "Id already exist");
                }
            }
        }
    }
    public void updater(View view){
        if(voter.isChecked()) {
            if(male.isChecked()) {
                if (cid.getText().toString().trim().length() == 0) {
                    showMessage("ERROR", "Please enter an ID");
                } else {
                    databaseHelper.upadtevoter(Integer.parseInt(cid.getText().toString().trim()),Integer.parseInt(idc.getText().toString().trim()), fname.getText().toString().trim(), mname.getText().toString().trim(), lname.getText().toString().trim(),bd.getText().toString().trim(),Integer.parseInt(phone.getText().toString().trim()),email.getText().toString().trim(),"male",user.getText().toString().trim(),passw.getText().toString().trim(),"notvoted",type.getText().toString().trim());
                    showMessage("success", "successfully updated");
                    clearTextv();

                }
            }else if(female.isChecked()){
                databaseHelper.upadtevoter(Integer.parseInt(cid.getText().toString().trim()),Integer.parseInt(idc.getText().toString().trim()), fname.getText().toString().trim(), mname.getText().toString().trim(), lname.getText().toString().trim(),bd.getText().toString().trim(),Integer.parseInt(phone.getText().toString().trim()),email.getText().toString().trim(),"female",user.getText().toString().trim(),passw.getText().toString().trim(),"notvoted",type.getText().toString().trim());
                showMessage("success", "successfully updated");
                clearTextv();
            }
        }else if(cand.isChecked()){
            if(male.isChecked()) {
                if (cid.getText().toString().trim().length() == 0) {
                    showMessage("ERROR", "Please enter an ID");
                } else {
                    databaseHelper.updatecan(Integer.parseInt(cid.getText().toString().trim()), Integer.parseInt(idc.getText().toString().trim()),Integer.parseInt(listID.getText().toString().trim()), fname.getText().toString().trim(), mname.getText().toString().trim(), lname.getText().toString().trim(), bd.getText().toString().trim(), Integer.parseInt(phone.getText().toString().trim()), email.getText().toString().trim(), "male", user.getText().toString().trim(), passw.getText().toString().trim(),purpose.getText().toString().trim(),type.getText().toString().trim(),seat.getText().toString().trim(),win.getText().toString().trim());
                    showMessage("success", "successfully updated");
                    clearTextc();

                }
            }else if(female.isChecked()){
                databaseHelper.updatecan(Integer.parseInt(cid.getText().toString().trim()), Integer.parseInt(idc.getText().toString().trim()),Integer.parseInt(listID.getText().toString().trim()), fname.getText().toString().trim(), mname.getText().toString().trim(), lname.getText().toString().trim(), bd.getText().toString().trim(), Integer.parseInt(phone.getText().toString().trim()), email.getText().toString().trim(), "female", user.getText().toString().trim(), passw.getText().toString().trim(),purpose.getText().toString().trim(),type.getText().toString().trim(),seat.getText().toString().trim(),win.getText().toString().trim());
                showMessage("success", "successfully updated");
                clearTextc();
            }
        }
    }

    public void deleter(View view){
        if (voter.isChecked()){
        if(cid.getText().toString().trim().length()==0){
            showMessage("ERROR","Please enter an ID");
        }else{
            if(databaseHelper.selectVoter(Integer.parseInt(cid.getText().toString().trim()))== 1) {
                databaseHelper.deletvoter(Integer.parseInt(cid.getText().toString().trim()));

                showMessage("success", "successfully deleted");
                clearTextv();
            }else{
                showMessage("ERROR","Id does not exist");
            }
        }
    }else if (cand.isChecked()){
            if(cid.getText().toString().trim().length()==0){
                showMessage("ERROR","Please enter an ID");
            }else{
                if(databaseHelper.selectCan(Integer.parseInt(cid.getText().toString().trim()))== 1) {
                    databaseHelper.deletcan(Integer.parseInt(cid.getText().toString().trim()));
                    nbnomr.setText(databaseHelper.getnomr(Integer.parseInt(cid.getText().toString().trim())));
                    databaseHelper.deletnom(Integer.parseInt(nbnomr.getText().toString().trim()));

                    showMessage("success", "successfully deleted");
                    clearTextc();
                }else{
                    showMessage("ERROR","Id does not exist");
                }

            }
}


    }
    public void deleteall(View view){
        if(voter.isChecked()){
            databaseHelper.Deletevoter();
            showMessage("SUCESS","all voters are deleted");
        }else if(cand.isChecked()){
            databaseHelper.Deletecan();
            databaseHelper.Deletenom();
            showMessage("SUCCESS","all ccandidates are deleted");
        }
    }
}
