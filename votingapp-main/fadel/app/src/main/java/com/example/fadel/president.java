package com.example.fadel;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class president extends AppCompatActivity {
    TextView idvotpe;
    TextView idcp;
    TextView pe;
    TextView cid1;
    TextView nid1;
    TextView nb1;
    TextView cid2;
    TextView nid2;
    TextView nb2;
    TextView cid3;
    TextView nid3;
    TextView nb3;
    TextView cid4;
    TextView nid4;
    TextView nb4;
    CheckBox chlist1;
    TextView can1;
    CheckBox chlist2;
    TextView can2;
    CheckBox chlist3;
    TextView can3;
    CheckBox chlist4;
    TextView can4;
    Button btnvote;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_president);
        idvotpe = (TextView) findViewById(R.id.idvotpe);
        databaseHelper = new DatabaseHelper(this);
        pe = (TextView) findViewById(R.id.pe);
        idcp = (TextView) findViewById(R.id.idcp);
        cid1 = (TextView) findViewById(R.id.cid1);
        nid1 = (TextView) findViewById(R.id.nid1);
        nb1 = (TextView) findViewById(R.id.nb1);
        cid2 = (TextView) findViewById(R.id.cid2);
        nid2 = (TextView) findViewById(R.id.nid2);
        nb2 = (TextView) findViewById(R.id.nb2);
        cid3 = (TextView) findViewById(R.id.cid3);
        nid3 = (TextView) findViewById(R.id.nid3);
        nb3 = (TextView) findViewById(R.id.nb3);
        cid4 = (TextView) findViewById(R.id.cid4);
        nid4 = (TextView) findViewById(R.id.nid4);
        nb4 = (TextView) findViewById(R.id.nb4);
        chlist1 = (CheckBox) findViewById(R.id.list1);
        chlist2 = (CheckBox) findViewById(R.id.list2);
        chlist3 = (CheckBox) findViewById(R.id.list3);
        chlist4 = (CheckBox) findViewById(R.id.list4);
        can1 = (TextView) findViewById(R.id.can1);
        can2 = (TextView) findViewById(R.id.can2);
        can3 = (TextView) findViewById(R.id.can3);
        can4 = (TextView) findViewById(R.id.can4);
        btnvote = (Button) findViewById(R.id.vote);
        Intent y = getIntent();
        String idv = y.getStringExtra("IDV");
        String idc = y.getStringExtra("IDC");
String id = y.getStringExtra("ID");

        idvotpe.setText(idv);
idcp.setText(id);
        pe.setText(idc);
        idvotpe.setVisibility(View.GONE);
        idcp.setVisibility(View.GONE);
         pe.setVisibility(View.GONE);
        for (int i = 1; i <= 4; i++) {
            if (databaseHelper.selectidc(Integer.parseInt(idcp.getText().toString().trim())) == 1) {
                cid1.setText(databaseHelper.getcan1(Integer.parseInt(idcp.getText().toString().trim()), pe.getText().toString().trim()));
                can1.setText(databaseHelper.getcanname1(Integer.parseInt(idcp.getText().toString().trim()), pe.getText().toString().trim()));

                nid1.setText(databaseHelper.getnom(String.valueOf(cid1.getText().toString().trim())));

                // if (databaseHelper.selectidc(Integer.parseInt(idci.getText().toString().trim())) == 1) {
                cid2.setText(databaseHelper.getcan2(Integer.parseInt(idcp.getText().toString().trim()), pe.getText().toString().trim()));
                can2.setText(databaseHelper.getcanname2(Integer.parseInt(idcp.getText().toString().trim()), pe.getText().toString().trim()));

                nid2.setText(databaseHelper.getnom(String.valueOf(cid2.getText().toString().trim())));

                // if (databaseHelper.selectidc(Integer.parseInt(idci.getText().toString().trim())) == 1) {

                cid3.setText(databaseHelper.getcan3(Integer.parseInt(idcp.getText().toString().trim()), pe.getText().toString().trim()));
                can3.setText(databaseHelper.getcanname3(Integer.parseInt(idcp.getText().toString().trim()), pe.getText().toString().trim()));

                nid3.setText(databaseHelper.getnom(String.valueOf(cid3.getText().toString().trim())));

                // }
                // if (databaseHelper.selectidc(Integer.parseInt(idci.getText().toString().trim())) == 1) {
                cid4.setText(databaseHelper.getcan4(Integer.parseInt(idcp.getText().toString().trim()), pe.getText().toString().trim()));
                can4.setText(databaseHelper.getcanname4(Integer.parseInt(idcp.getText().toString().trim()), pe.getText().toString().trim()));

                nid4.setText(databaseHelper.getnom(String.valueOf(cid4.getText().toString().trim())));


            }
        }

        cid1.setVisibility(View.GONE);
        nid1.setVisibility(View.GONE);
        nb1.setVisibility(View.GONE);
        cid2.setVisibility(View.GONE);
        nid2.setVisibility(View.GONE);
        nb2.setVisibility(View.GONE);
        cid3.setVisibility(View.GONE);
        nid3.setVisibility(View.GONE);
        nb3.setVisibility(View.GONE);
        cid4.setVisibility(View.GONE);
        nid4.setVisibility(View.GONE);
        nb4.setVisibility(View.GONE);
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(message);
        b.show();
    }

    public void votes(View view) {
        if (databaseHelper.selectwin(Integer.parseInt(idvotpe.getText().toString().trim())) == 1) {
            if (chlist1.isChecked()) {
                if (databaseHelper.selectnid(Integer.parseInt(cid1.getText().toString().trim())) == 1) {

                    String z = databaseHelper.getnb(Integer.parseInt(cid1.getText().toString().trim()));
                    nb1.setText(z);
                    int x = Integer.parseInt(nb1.getText().toString().trim()) + 1;
                    databaseHelper.updatenom(Integer.parseInt(nid1.getText().toString().trim()), Integer.parseInt(idcp.getText().toString().trim()), Integer.parseInt(cid1.getText().toString().trim()), x);


                }

            }

            if (chlist2.isChecked()) {
                if (databaseHelper.selectnid(Integer.parseInt(cid2.getText().toString().trim())) == 1) {
                    String z = databaseHelper.getnb(Integer.parseInt(cid2.getText().toString().trim()));
                    nb2.setText(z);
                    int x = Integer.parseInt(nb2.getText().toString().trim()) + 1;
                    databaseHelper.updatenom(Integer.parseInt(nid2.getText().toString().trim()), Integer.parseInt(idcp.getText().toString().trim()), Integer.parseInt(cid2.getText().toString().trim()), x);

                }
            }

            if (chlist3.isChecked()) {
                if (databaseHelper.selectnid(Integer.parseInt(cid3.getText().toString().trim())) == 1) {
                    String z = databaseHelper.getnb(Integer.parseInt(cid3.getText().toString().trim()));
                    nb3.setText(z);
                    int x = Integer.parseInt(nb3.getText().toString().trim()) + 1;
                    databaseHelper.updatenom(Integer.parseInt(nid3.getText().toString().trim()), Integer.parseInt(idcp.getText().toString().trim()), Integer.parseInt(cid3.getText().toString().trim()), x);


                }
            }

            if (chlist4.isChecked()) {
                if (databaseHelper.selectnid(Integer.parseInt(cid4.getText().toString().trim())) == 1) {
                    String z = databaseHelper.getnb(Integer.parseInt(cid4.getText().toString().trim()));
                    nb3.setText(z);
                    int x = Integer.parseInt(nb4.getText().toString().trim()) + 1;
                    databaseHelper.updatenom(Integer.parseInt(nid4.getText().toString().trim()), Integer.parseInt(idcp.getText().toString().trim()), Integer.parseInt(cid4.getText().toString().trim()), x);


                }
            }
            showMessage("SUCCESS", "vote recorded");
            databaseHelper.upadtecan1(Integer.parseInt(idvotpe.getText().toString().trim()));
        } else{
            showMessage("ERROR","you can not vote again");
        }

    }
}