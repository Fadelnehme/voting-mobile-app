package com.example.fadel;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Municipalities extends AppCompatActivity {
    TextView idvotm;
    TextView idcim;
    TextView mun;
    TextView mok;
    TextView cidm1;
    TextView nidm1;
    TextView nbm1;
    TextView cidm2;
    TextView nidm2;
    TextView nbm2;
    TextView cidm3;
    TextView nidm3;
    TextView nbm3;
    TextView cidm4;
    TextView nidm4;
    TextView nbm4;
    TextView cidm5;
    TextView nidm5;
    TextView nbm5;
    TextView cidm6;
    TextView nidm6;
    TextView nbm6;
    CheckBox chlist1;
    TextView can1;
    CheckBox  chlist2;
    TextView can2;
    CheckBox  chlist3;
    TextView can3;
    CheckBox  chlist4;
    TextView can4;
    CheckBox  chlist5;
    TextView can5;
    CheckBox  chlist6;
    TextView can6;
    Button btnvote;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipalities);
        databaseHelper=new DatabaseHelper(this);
        mun=(TextView)findViewById(R.id.mun);
        mok=(TextView)findViewById(R.id.mok);
        cidm1 = (TextView) findViewById(R.id.cidm1);
        nidm1 = (TextView) findViewById(R.id.nidm1);
        nbm1 = (TextView) findViewById(R.id.nbm1);
        cidm2 = (TextView) findViewById(R.id.cidm2);
        nidm2 = (TextView) findViewById(R.id.nidm2);
        nbm2 = (TextView) findViewById(R.id.nbm2);
        cidm3 = (TextView) findViewById(R.id.cidm3);
        nidm3 = (TextView) findViewById(R.id.nidm3);
        nbm3 = (TextView) findViewById(R.id.nbm3);
        cidm4 = (TextView) findViewById(R.id.cidm4);
        nidm4 = (TextView) findViewById(R.id.nidm4);
        nbm4 = (TextView) findViewById(R.id.nbm4);
        cidm5 = (TextView) findViewById(R.id.cidm5);
        nidm5 = (TextView) findViewById(R.id.nidm5);
        nbm5= (TextView) findViewById(R.id.nbm5);
        cidm6 = (TextView) findViewById(R.id.cidm6);
        nidm6 = (TextView) findViewById(R.id.nidm6);
        nbm6= (TextView) findViewById(R.id.nbm6);
        chlist1=(CheckBox)findViewById(R.id.list1);
        chlist2=(CheckBox)findViewById(R.id.list2);
        chlist3=(CheckBox)findViewById(R.id.list3);
        chlist4=(CheckBox)findViewById(R.id.list4);
        chlist5=(CheckBox)findViewById(R.id.list5);
        chlist6=(CheckBox)findViewById(R.id.list6);
        can1=(TextView)findViewById(R.id.can1);
        can2=(TextView)findViewById(R.id.can2);
        can3=(TextView)findViewById(R.id.can3);
        can4=(TextView)findViewById(R.id.can4);
        can5=(TextView)findViewById(R.id.can5);
        can6=(TextView)findViewById(R.id.can6);
        btnvote=(Button)findViewById(R.id.vote);
        Intent y = getIntent();
        String  idv = y.getStringExtra("IDV");
        String idc = y.getStringExtra("IDC");

        idvotm=(TextView)findViewById(R.id.idvotm);
        idcim=(TextView)findViewById(R.id.idcim);
        idvotm.setText(idv);

        idcim.setText(idc);
        idvotm.setVisibility(View.GONE);
        idcim.setVisibility(View.GONE);
        mun.setVisibility(View.GONE);
        mok.setVisibility(View.GONE);
        for (int i = 1; i <= 6; i++) {
            if (databaseHelper.selectidc(Integer.parseInt(idcim.getText().toString().trim())) == 1) {
                cidm1.setText(databaseHelper.getcan1(Integer.parseInt(idcim.getText().toString().trim()), mun.getText().toString().trim()));
                can1.setText(databaseHelper.getcanname1(Integer.parseInt(idcim.getText().toString().trim()), mun.getText().toString().trim()));

                nidm1.setText(databaseHelper.getnom(String.valueOf(cidm1.getText().toString().trim())));

                //if (databaseHelper.selectidc(Integer.parseInt(idci.getText().toString().trim())) == 1) {
                cidm2.setText(databaseHelper.getcan2(Integer.parseInt(idcim.getText().toString().trim()), mun.getText().toString().trim()));
                can2.setText(databaseHelper.getcanname2(Integer.parseInt(idcim.getText().toString().trim()), mun.getText().toString().trim()));

                nidm2.setText(databaseHelper.getnom(String.valueOf(cidm2.getText().toString().trim())));

                // if (databaseHelper.selectidc(Integer.parseInt(idci.getText().toString().trim())) == 1) {

                cidm3.setText(databaseHelper.getcan3(Integer.parseInt(idcim.getText().toString().trim()), mun.getText().toString().trim()));
                can3.setText(databaseHelper.getcanname3(Integer.parseInt(idcim.getText().toString().trim()), mun.getText().toString().trim()));

                nidm3.setText(databaseHelper.getnom(String.valueOf(cidm3.getText().toString().trim())));

                // }
                // if (databaseHelper.selectidc(Integer.parseInt(idci.getText().toString().trim())) == 1) {
                cidm4.setText(databaseHelper.getcan4(Integer.parseInt(idcim.getText().toString().trim()), mun.getText().toString().trim()));
                can4.setText(databaseHelper.getcanname4(Integer.parseInt(idcim.getText().toString().trim()), mun.getText().toString().trim()));

                nidm4.setText(databaseHelper.getnom(String.valueOf(cidm4.getText().toString().trim())));

                cidm5.setText(databaseHelper.getcan1(Integer.parseInt(idcim.getText().toString().trim()), mok.getText().toString().trim()));
                can5.setText(databaseHelper.getcanname1(Integer.parseInt(idcim.getText().toString().trim()), mok.getText().toString().trim()));

                nidm5.setText(databaseHelper.getnom(String.valueOf(cidm5.getText().toString().trim())));

                // if (databaseHelper.selectidc(Integer.parseInt(idci.getText().toString().trim())) == 1) {
                cidm6.setText(databaseHelper.getcan2(Integer.parseInt(idcim.getText().toString().trim()), mok.getText().toString().trim()));
                can6.setText(databaseHelper.getcanname2(Integer.parseInt(idcim.getText().toString().trim()), mok.getText().toString().trim()));

                nidm6.setText(databaseHelper.getnom(String.valueOf(cidm6.getText().toString().trim())));
            }
        }

        cidm1.setVisibility(View.GONE);
        nidm1.setVisibility(View.GONE);
        nbm1.setVisibility(View.GONE);
        cidm2.setVisibility(View.GONE);
        nidm2.setVisibility(View.GONE);
        nbm2.setVisibility(View.GONE);
        cidm3.setVisibility(View.GONE);
        nidm3.setVisibility(View.GONE);
        nbm3.setVisibility(View.GONE);
        cidm4.setVisibility(View.GONE);
        nidm4.setVisibility(View.GONE);
        nbm4.setVisibility(View.GONE);
        cidm5.setVisibility(View.GONE);
        nidm5.setVisibility(View.GONE);
        nbm5.setVisibility(View.GONE);
        cidm6.setVisibility(View.GONE);
        nidm6.setVisibility(View.GONE);
        nbm6.setVisibility(View.GONE);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pre, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.f:
                Intent j = new Intent(this, about.class);
                startActivity(j);
                return true;
            case R.id.e:
                Intent i = new Intent(this, presidentelection.class);
                startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void showMessage(String title, String message) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(message);
        b.show();
    }
    public void votes(View view) {
        if (databaseHelper.selectvoted(Integer.parseInt(idvotm.getText().toString().trim())) == 1) {
            if (chlist1.isChecked()) {
                if (databaseHelper.selectnid(Integer.parseInt(cidm1.getText().toString().trim())) == 1) {

                    String z = databaseHelper.getnb(Integer.parseInt(cidm1.getText().toString().trim()));
                    nbm1.setText(z);
                    int x = Integer.parseInt(nbm1.getText().toString().trim()) + 1;
                    databaseHelper.updatenom(Integer.parseInt(nidm1.getText().toString().trim()), Integer.parseInt(idcim.getText().toString().trim()), Integer.parseInt(cidm1.getText().toString().trim()), x);


                }

            }

            if (chlist2.isChecked()) {
                if (databaseHelper.selectnid(Integer.parseInt(cidm2.getText().toString().trim())) == 1) {
                    String z = databaseHelper.getnb(Integer.parseInt(cidm2.getText().toString().trim()));
                    nbm2.setText(z);
                    int x = Integer.parseInt(nbm2.getText().toString().trim()) + 1;
                    databaseHelper.updatenom(Integer.parseInt(nidm2.getText().toString().trim()), Integer.parseInt(idcim.getText().toString().trim()), Integer.parseInt(cidm2.getText().toString().trim()), x);

                }
            }

            if(chlist3.isChecked()) {
                if (databaseHelper.selectnid(Integer.parseInt(cidm3.getText().toString().trim())) == 1) {
                    String z = databaseHelper.getnb(Integer.parseInt(cidm3.getText().toString().trim()));
                    nbm3.setText(z);
                    int x = Integer.parseInt(nbm3.getText().toString().trim()) + 1;
                    databaseHelper.updatenom(Integer.parseInt(nidm3.getText().toString().trim()), Integer.parseInt(idcim.getText().toString().trim()), Integer.parseInt(cidm3.getText().toString().trim()), x);


                }
            }

            if (chlist4.isChecked()) {
                if(databaseHelper.selectnid(Integer.parseInt(cidm4.getText().toString().trim()))==1) {
                    String z = databaseHelper.getnb(Integer.parseInt(cidm4.getText().toString().trim()));
                    nbm4.setText(z);
                    int x = Integer.parseInt(nbm4.getText().toString().trim()) + 1;
                    databaseHelper.updatenom(Integer.parseInt(nidm4.getText().toString().trim()), Integer.parseInt(idcim.getText().toString().trim()), Integer.parseInt(cidm4.getText().toString().trim()), x);


                }
            } if (chlist5.isChecked()) {
                if(databaseHelper.selectnid(Integer.parseInt(cidm5.getText().toString().trim()))==1) {
                    String z = databaseHelper.getnb(Integer.parseInt(cidm5.getText().toString().trim()));
                    nbm5.setText(z);
                    int x = Integer.parseInt(nbm5.getText().toString().trim()) + 1;
                    databaseHelper.updatenom(Integer.parseInt(nidm5.getText().toString().trim()), Integer.parseInt(idcim.getText().toString().trim()), Integer.parseInt(cidm5.getText().toString().trim()), x);


                }
            } if (chlist6.isChecked()) {
                if(databaseHelper.selectnid(Integer.parseInt(cidm6.getText().toString().trim()))==1) {
                    String z = databaseHelper.getnb(Integer.parseInt(cidm6.getText().toString().trim()));
                    nbm6.setText(z);
                    int x = Integer.parseInt(nbm6.getText().toString().trim()) + 1;
                    databaseHelper.updatenom(Integer.parseInt(nidm6.getText().toString().trim()), Integer.parseInt(idcim.getText().toString().trim()), Integer.parseInt(cidm6.getText().toString().trim()), x);


                }
            }
            showMessage("SUCCESS", "vote recorded");
            databaseHelper.upadtevoter1(Integer.parseInt(idvotm.getText().toString().trim()));
        }

        else{
            showMessage("ERROR","you can not vote again");}
    }
}
