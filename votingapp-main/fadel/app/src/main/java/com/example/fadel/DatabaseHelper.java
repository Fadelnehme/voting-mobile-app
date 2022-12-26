package com.example.fadel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper  extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "VOTINGAPP";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_VOTER = "voter";
    public static final String TABLE_CANDIDATE = "candidate";
    public static final String TABLE_CITIES = "cities";
    public static final String TABLE_LIST = "list";
    public static final String TABLE_NOMANATION = "nomanation";
    public static final String TABLE_ELECTIONCYCLE = "electioncycle";
    public static final String KEY_VID = "vid";
    public static final String KEY_VIDC = "vidc";
    public static final String KEY_Vfname = "vfname";
    public static final String KEY_Vmname = "vmname";
    public static final String KEY_Vlname = "vlname";
    public static final String KEY_VBD = "vbrithdate";
    public static final String KEY_Vphn = "vphonenumber";
    public static final String KEY_Vgeneder = "vgender";
    public static final String KEY_Vemail = "vemail";
    public static final String KEY_Vusern = "username";
    public static final String KEY_Vpass = "password";
    public static final String KEY_Voted = "voted";
    public static final String KEY_VTYPE = "Type";
    // entity for voter
    public static final String KEY_CID = "cid";
    public static final String KEY_CIDC = "cidc";
    public static final String KEY_CIDL = "cidl";
    public static final String KEY_Cfname = "cfname";
    public static final String KEY_Cmname = "cmname";
    public static final String KEY_Clname = "clname";
    public static final String KEY_CBD = "cbrithdate";
    public static final String KEY_Cphn = "cphonenumber";
    public static final String KEY_Cgeneder = "cgender";
    public static final String KEY_Cemail = "cemail";
    public static final String KEY_Cusern = "username";
    public static final String KEY_Cpass = "password";
    public static final String KEY_Cpur = "purpose";
    public static final String KEY_TYPE = "Type";
    public static final String KEY_SEAT = "seat";
    public static final String KEY_WIN = "winner";
    // entity for candidate
    public static final String KEY_IDC = "idc";
    public static final String KEY_nameC = "cityname";
    public static final String KEY_GOV = "governorate";
    public static final String KEY_NUMEMBER = "numberofmember";
    // entity for cities
    public static final String KEY_LID = "lid";
    public static final String KEY_Lname = "listname";
    // entity for list
    public static final String KEY_NID = "nid";
    public static final String KEY_NIDC = "nidc";
    public static final String KEY_NCID = "ncid";
    public static final String KEY_Nnvotes = "numberofvotes";

    // entity for nomanation
    public static final String KEY_EID = "eid";
    public static final String KEY_Eyear = "electionyear";
    final String CREATE_TABLE_CITIES = "CREATE TABLE "
            + TABLE_CITIES + "(" + KEY_IDC
            + " INTEGER PRIMARY KEY, " + KEY_nameC + " TEXT, " + KEY_GOV + " TEXT, " + KEY_NUMEMBER + " INTEGER);";
    // entity for cities
    final String CREATE_TABLE_LIST = "CREATE TABLE "
            + TABLE_LIST + "(" + KEY_LID
            + " INTEGER PRIMARY KEY, " + KEY_Lname + " TEXT);";
    // entity for list
    final String CREATE_TABLE_VOTER = "CREATE TABLE "
            + TABLE_VOTER + "(" + KEY_VID
            + " INTEGER PRIMARY KEY, " + KEY_VIDC + " INTEGER, " + KEY_Vfname + " TEXT, " + KEY_Vmname + " TEXT, "
            + KEY_Vlname + " TEXT, " + KEY_VBD + " TEXT, " + KEY_Vphn + " INTEGER, " + KEY_Vemail
            + " TEXT, " + KEY_Vgeneder + " TEXT, " + KEY_Vusern + " TEXT, " + KEY_Vpass + " TEXT, " + KEY_Voted + " TEXT, "+ KEY_VTYPE + " TEXT, " + " FOREIGN KEY (" + KEY_VIDC + ") REFERENCES " + TABLE_CITIES + "(" + KEY_IDC + ") );";
    // entity for voter
    final String CREATE_TABLE_CANDIDATE = "CREATE TABLE "
                + TABLE_CANDIDATE + "(" + KEY_CID
              + " INTEGER PRIMARY KEY , " + KEY_CIDC + " INTEGER, " + KEY_CIDL + " INTEGER, " + KEY_Cfname + " TEXT, " + KEY_Cmname +
               " TEXT, " + KEY_Clname + " TEXT, " + KEY_CBD + " TEXT, " + KEY_Cphn + " INTEGER, " +
               KEY_Cemail + " TEXT, " + KEY_Cgeneder + " TEXT, " + KEY_Cusern + " TEXT, " + KEY_Cpass + " TEXT, " + KEY_Cpur + " TEXT, " + KEY_TYPE + " TEXT, " + KEY_SEAT + " TEXT, "
              + KEY_WIN + " TEXT, " + " FOREIGN KEY (" + KEY_CIDC + ") REFERENCES " + TABLE_CITIES + "(" + KEY_IDC + ")," + " FOREIGN KEY (" + KEY_CIDL + ") REFERENCES " + TABLE_LIST + "(" + KEY_LID + "));";
       // entity for candidate

    final String CREATE_TABLE_NOMANATION = "CREATE TABLE "
            + TABLE_NOMANATION + "(" + KEY_NID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NIDC + " INTEGER, " + KEY_NCID + " INTEGER, " + KEY_Nnvotes + " INTEGER, " + " FOREIGN KEY (" + KEY_NIDC + ") REFERENCES " + TABLE_CITIES + "(" + KEY_IDC + ")," + " FOREIGN KEY (" + KEY_NCID + ") REFERENCES " + TABLE_CANDIDATE + "(" + KEY_CID + "));";
    // entity for nomanation

    final String CREATE_TABLE_ELECTIONCYCLE = "CREATE TABLE "
            + TABLE_ELECTIONCYCLE + "(" + KEY_EID
            + " INTEGER PRIMARY KEY, " + KEY_Eyear + " TEXT );";

    // entity for electioncycle


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // entity for electioncycle


        db.execSQL(CREATE_TABLE_CITIES);
        db.execSQL(CREATE_TABLE_LIST);
        db.execSQL(CREATE_TABLE_VOTER);
        db.execSQL(CREATE_TABLE_CANDIDATE);
        db.execSQL(CREATE_TABLE_NOMANATION);
        db.execSQL(CREATE_TABLE_ELECTIONCYCLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_CITIES + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_LIST + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_VOTER + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_CANDIDATE + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_NOMANATION + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_ELECTIONCYCLE + "'");
        onCreate(db);
    }

    public void addcity(int idc, String cityname, String governorate, int numberofmember) {


        SQLiteDatabase db = this.getWritableDatabase();
        //adding  city in CITY table

        ContentValues valuescity = new ContentValues();
        valuescity.put(KEY_IDC, idc);
        valuescity.put(KEY_nameC, cityname);
        valuescity.put(KEY_GOV, governorate);
        valuescity.put(KEY_NUMEMBER, numberofmember);
        //db.insert(TABLE_VOTER, null, values);
        db.insert(TABLE_CITIES, null, valuescity);

    }

    public void addLIST(int lid, String listname) {
        SQLiteDatabase db = this.getWritableDatabase();
        //adding voter in voter table
        ContentValues valueslist = new ContentValues();

        valueslist.put(KEY_LID, lid);
        valueslist.put(KEY_Lname, listname);

        db.insert(TABLE_LIST, null, valueslist);

    }

    public void addvoter(int vid, int idc, String vfname, String vmname, String vlname, String vbd, int vphonenumber, String vemail, String vgender, String username, String password, String voted,String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        //adding voter in voter table
        ContentValues valuesvoter = new ContentValues();
        valuesvoter.put(KEY_VID, vid);
        valuesvoter.put(KEY_VIDC, idc);
        valuesvoter.put(KEY_Vfname, vfname);
        valuesvoter.put(KEY_Vmname, vmname);
        valuesvoter.put(KEY_Vlname, vlname);
        valuesvoter.put(KEY_VBD, vbd);
        valuesvoter.put(KEY_Vphn, vphonenumber);
        valuesvoter.put(KEY_Vgeneder, vgender);
        valuesvoter.put(KEY_Vemail, vemail);
        valuesvoter.put(KEY_Vusern, username);
        valuesvoter.put(KEY_Vpass, password);
        valuesvoter.put(KEY_Voted, voted);
        valuesvoter.put(KEY_VTYPE, type);
        db.insert(TABLE_VOTER, null, valuesvoter);

    }

    public void addcan(int cid, int cidc, int cidl, String cfname, String cmname, String clname, String cbrithdate, int cphonenumber, String cemail, String cgender, String username, String password, String purpose, String type, String seat, String winner) {
        SQLiteDatabase db = this.getWritableDatabase();
        //adding candidate in candidate table
        ContentValues valuescandidate = new ContentValues();
        valuescandidate.put(KEY_CID, cid);
        valuescandidate.put(KEY_CIDC, cidc);
        valuescandidate.put(KEY_CIDL, cidl);
        valuescandidate.put(KEY_Cfname, cfname);
        valuescandidate.put(KEY_Cmname, cmname);
        valuescandidate.put(KEY_Clname, clname);
        valuescandidate.put(KEY_CBD, cbrithdate);
        valuescandidate.put(KEY_Cphn, cphonenumber);
        valuescandidate.put(KEY_Cemail, cemail);
        valuescandidate.put(KEY_Cgeneder, cgender);

        valuescandidate.put(KEY_Cusern, username);
        valuescandidate.put(KEY_Cpass, password);
        valuescandidate.put(KEY_Cpur, purpose);
        valuescandidate.put(KEY_TYPE, type);
        valuescandidate.put(KEY_SEAT, seat);
        valuescandidate.put(KEY_WIN, winner);

        db.insert(TABLE_CANDIDATE, null, valuescandidate);


    }

    public void addnom(int idc, int cid, int numberofvotes) {
        SQLiteDatabase db = this.getWritableDatabase();
        //adding nomanation in nomanation table
        ContentValues valuesnomanation = new ContentValues();

        valuesnomanation.put(KEY_NIDC, idc);
        valuesnomanation.put(KEY_NCID, cid);
        valuesnomanation.put(KEY_Nnvotes, numberofvotes);

        db.insert(TABLE_NOMANATION, null, valuesnomanation);

    }

    public void addelec(int eid, String electionyear) {
        SQLiteDatabase db = this.getWritableDatabase();
//adding electioncycle in electioncycle table
        ContentValues valueselectioncycle = new ContentValues();
        valueselectioncycle.put(KEY_EID, eid);
        valueselectioncycle.put(KEY_Eyear, electionyear);
        db.insert(TABLE_ELECTIONCYCLE, null, valueselectioncycle);

    }

    public boolean updatecity(int idc, String cityname, String governorate, int numberofmember) {

        SQLiteDatabase db = this.getWritableDatabase();


        //upadte city in CITY table
        ContentValues valuescity = new ContentValues();
        valuescity.put(KEY_IDC, idc);
        valuescity.put(KEY_nameC, cityname);
        valuescity.put(KEY_GOV, governorate);
        valuescity.put(KEY_NUMEMBER, numberofmember);
        // db.insert(TABLE_cittes, null, values);


        db.update(TABLE_CITIES, valuescity, KEY_IDC + " = ?", new String[]{String.valueOf(idc)});

        return true;

    }

    public boolean updateLIST(int lid, String listname) {
        SQLiteDatabase db = this.getWritableDatabase();
        //update list in list table
        ContentValues valueslist = new ContentValues();
        valueslist.put(KEY_LID, lid);
        valueslist.put(KEY_Lname, listname);

        db.update(TABLE_LIST, valueslist, KEY_LID + " = ?", new String[]{String.valueOf(lid)});
        return true;
    }

    public boolean upadtevoter(int vid, int idc, String vfname, String vmname, String vlname, String vbrithdate, int vphonenumber, String vemail, String vgender, String username, String password, String voted,String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        //update voter in voter table
        ContentValues valuesvoter = new ContentValues();
        valuesvoter.put(KEY_VID, vid);
        valuesvoter.put(KEY_VIDC, idc);
        valuesvoter.put(KEY_Vfname, vfname);
        valuesvoter.put(KEY_Vmname, vmname);
        valuesvoter.put(KEY_Vlname, vlname);
        valuesvoter.put(KEY_VBD, vbrithdate);
        valuesvoter.put(KEY_Vphn, vphonenumber);
        valuesvoter.put(KEY_Vgeneder, vgender);
        valuesvoter.put(KEY_Vemail, vemail);
        valuesvoter.put(KEY_Vusern, username);
        valuesvoter.put(KEY_Vpass, password);
        valuesvoter.put(KEY_Voted, voted);
        valuesvoter.put(KEY_VTYPE, type);
        db.update(TABLE_VOTER, valuesvoter, KEY_VID + " = ?", new String[]{String.valueOf(vid)});

        return true;
    }

    public boolean updatecan(int cid, int idc, int cidl, String cfname, String cmname, String clname, String cbrithdate, int cphonenumber, String cemail, String cgender, String username, String password, String purpose, String type, String seat, String winner) {
        SQLiteDatabase db = this.getWritableDatabase();
        //update candidate in candidate table
        ContentValues valuescandidate = new ContentValues();
        valuescandidate.put(KEY_CID, cid);
        valuescandidate.put(KEY_CIDC, idc);
        valuescandidate.put(KEY_CIDL, cidl);
        valuescandidate.put(KEY_Cfname, cfname);
        valuescandidate.put(KEY_Cmname, cmname);
        valuescandidate.put(KEY_Clname, clname);
        valuescandidate.put(KEY_CBD, cbrithdate);
        valuescandidate.put(KEY_Cphn, cphonenumber);
        valuescandidate.put(KEY_Cgeneder, cgender);
        valuescandidate.put(KEY_Cemail, cemail);
        valuescandidate.put(KEY_Cusern, username);
        valuescandidate.put(KEY_Cpass, password);
        valuescandidate.put(KEY_Cpur, purpose);
        valuescandidate.put(KEY_TYPE, type);
        valuescandidate.put(KEY_SEAT, seat);
        valuescandidate.put(KEY_WIN, winner);

        db.update(TABLE_CANDIDATE, valuescandidate, KEY_CID + " = ?", new String[]{String.valueOf(cid)});

        return true;
    }

    public boolean updatenom(int nid, int idc, int cid, int nomnumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        //update nomanation in nomanation table
        ContentValues valuesnomanation = new ContentValues();
        valuesnomanation.put(KEY_NID, nid);
        valuesnomanation.put(KEY_NIDC, idc);
        valuesnomanation.put(KEY_NCID, cid);
        valuesnomanation.put(KEY_Nnvotes, nomnumber);

        db.update(TABLE_NOMANATION, valuesnomanation, KEY_NID + " = ?", new String[]{String.valueOf(nid)});

        return true;
    }

    public boolean updateelec(int eid, int electionyear) {
        SQLiteDatabase db = this.getWritableDatabase();
//update electioncycle in electioncycle table
        ContentValues valueselectioncycle = new ContentValues();
        valueselectioncycle.put(KEY_EID, eid);
        valueselectioncycle.put(KEY_Eyear, electionyear);

        db.update(TABLE_ELECTIONCYCLE, valueselectioncycle, KEY_EID + " = ?", new String[]{String.valueOf(eid)});

        return true;
    }

    public void deletcity(int idc) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_CITIES, KEY_IDC + " = ?", new String[]{String.valueOf(idc)});

    }

    public void deletLIST(int lid) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_LIST, KEY_LID + " = ?", new String[]{String.valueOf(lid)});
    }

    public void deletvoter(int vid) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_VOTER, KEY_VID + " = ?", new String[]{String.valueOf(vid)});


    }

    public void deletcan(int cid) {
        SQLiteDatabase db = this.getWritableDatabase();


        db.delete(TABLE_CANDIDATE, KEY_CID + " = ?", new String[]{String.valueOf(cid)});

    }

    public void deletnom(int idc) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NOMANATION, KEY_NID + "=?", new String[]{String.valueOf(idc)});

        //db.delete(TABLE_NOMANATION, KEY_NID+"=?", new String[]{String.valueOf(b)});

    }

    public void deletelec(int eid) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_ELECTIONCYCLE, KEY_EID + " = ?", new String[]{String.valueOf(eid)});
    }

    public String getnomr(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from nomanation where ncid='" + id + "'", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(0) + "\n");

        }
        return b.toString();
    }

    public int selectCity(int idc) {
        String seletcity = "SELECT * FROM " + TABLE_CITIES + " WHERE " + KEY_IDC + "=" + idc;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(seletcity, null);
        if (c.getCount() == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public int selectList(int idc) {
        String seletlist = "SELECT * FROM " + TABLE_LIST + " WHERE " + KEY_LID + "=" + idc;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(seletlist, null);
        if (c.getCount() == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public int selectVoter(int idc) {
        String seletvoter = "SELECT * FROM " + TABLE_VOTER + " WHERE " + KEY_VID + "=" + idc;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(seletvoter, null);
        if (c.getCount() == 0) {
            return 0;
        } else {
            return 1;
        }
    }


    public int selectCan(int idc) {
        String seletcan = "SELECT * FROM " + TABLE_CANDIDATE + " WHERE " + KEY_CID + "=" + idc;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(seletcan, null);
        if (c.getCount() == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public int selectuser(String user, String pass) {
        //String seletcan = "SELECT vid FROM voter WHERE username=" + user +" AND password = "+pass;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select vid from voter where username='" + user + "' and password='" + pass + "'", null);
        if (c.getCount() == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    public int selectuser1(String user, String pass) {
        //String seletcan = "SELECT vid FROM voter WHERE username=" + user +" AND password = "+pass;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select cid from candidate where username='" + user + "' and password='" + pass + "'", null);
        if (c.getCount() == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    public int changepass(String user, String bd) {
        //String seletcan = "SELECT vid FROM voter WHERE username=" + user +" AND password = "+pass;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select vid from voter where username='" + user + "' and vbrithdate='" + bd + "'", null);
        if (c.getCount() == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    public int check(int id, String bd) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select vid from voter where vid='" + id + "' and vbrithdate='" + bd + "'", null);
        if (c.getCount() == 0) {
            return 0;
        } else {

            return 1;
        }

    }

    public String getcheck(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from voter where vid='" + id + "'", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append("username :" + c.getString(9) + "\n");


        }

        return b.toString();
    }

    public String getcheck1(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from voter where vid='" + id + "'", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {

            b.append("password :" + c.getString(10) + "\n");

        }

        return b.toString();
    }

    public String getid(String user, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select vid from voter where username='" + user + "' and password='" + pass + "'", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {

            b.append(c.getString(0) + "\n");

        }

        return b.toString();
    }

    public String getidc(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from voter where vid='" + id + "'", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {

            b.append(c.getString(0) + "\n");
        }

        return b.toString();
    }

    public String getidc1(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from voter where vid='" + id + "'", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(1) + "\n");
        }

        return b.toString();
    }

    public int selectidc(int idc) {
        //String seletcan = "SELECT vid FROM voter WHERE username=" + user +" AND password = "+pass;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select cid from candidate where cidc='" + idc + "'", null);
        if (c.getCount() == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    public int selectcanwin(String user, String pass) {
        //String seletcan = "SELECT vid FROM voter WHERE username=" + user +" AND password = "+pass;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select cid from candidate where username='" + user + "' and password='" + pass + "' and winner = 'winner' ", null);
        if (c.getCount() == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    public String getcan1(int id, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where cidc='" + id + "' and type = '" + type + "' and cidl = '1' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(0) + "\n");
        }

        return b.toString();
    }


    public String getcanname1(int id, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where cidc='" + id + "' and type = '" + type + "' and cidl = '1' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(3));
            b.append(c.getString(4));
            b.append(c.getString(5));
        }

        return b.toString();
    }

    public String getnom(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from nomanation where ncid='" + id + "'", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(0) + "\n");
        }

        return b.toString();
    }

    public String getnb(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from nomanation where ncid='" + id + "'", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(3) + "\n");

        }
        return b.toString();
    }


    public String getcan2(int id, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where cidc='" + id + "' and type = '" + type + "' and cidl = '2' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(0) + "\n");
        }

        return b.toString();
    }


    public String getcanname2(int id, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where cidc='" + id + "' and type = '" + type + "' and cidl = '2' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(3));
            b.append(c.getString(4));
            b.append(c.getString(5));
        }

        return b.toString();
    }

    public String getcan3(int id, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where cidc='" + id + "' and type = '" + type + "' and cidl = '3' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(0) + "\n");
        }

        return b.toString();
    }


    public String getcanname3(int id, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where cidc='" + id + "' and type = '" + type + "' and cidl = '3' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(3));
            b.append(c.getString(4));
            b.append(c.getString(5));
        }

        return b.toString();
    }

    public String getcan4(int id, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where cidc='" + id + "' and type = '" + type + "' and cidl = '4' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(0) + "\n");
        }

        return b.toString();
    }


    public String getcanname4(int id, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where cidc='" + id + "' and type = '" + type + "' and cidl = '4' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(3));
            b.append(c.getString(4));
            b.append(c.getString(5));
        }

        return b.toString();
    }

    public String getcan5(int id, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where cidc='" + id + "' and type = '" + type + "' and cidl = '5' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(0) + "\n");
        }

        return b.toString();
    }


    public String getcanname5(int id, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where cidc='" + id + "' and type = '" + type + "' and cidl = '5' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(3));
            b.append(c.getString(4));
            b.append(c.getString(5));
        }

        return b.toString();
    }

    public String getcan6(int id, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where cidc='" + id + "' and type = '" + type + "' and cidl = '6' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(0) + "\n");
        }

        return b.toString();
    }


    public String getcanname6(int id, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where cidc='" + id + "' and type = '" + type + "' and cidl = '6' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(3));
            b.append(c.getString(4));
            b.append(c.getString(5));
        }

        return b.toString();
    }

    public int selectnid(int nid) {
        //String seletcan = "SELECT vid FROM voter WHERE username=" + user +" AND password = "+pass;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from nomanation where ncid='" + nid + "'", null);
        if (c.getCount() == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    public boolean upadtevoter1(int vid) {
        SQLiteDatabase db = this.getWritableDatabase();
        //update voter in voter table
        ContentValues valuesvoter = new ContentValues();
        valuesvoter.put(KEY_VID, vid);
        valuesvoter.put(KEY_Voted, "voted");
        db.update(TABLE_VOTER, valuesvoter, KEY_VID + " = ?", new String[]{String.valueOf(vid)});

        return true;
    }

    public int selectvoted(int id) {
        //String seletcan = "SELECT vid FROM voter WHERE username=" + user +" AND password = "+pass;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from voter where vid='" + id + "' and voted = 'notvoted' ", null);
        if (c.getCount() == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    public int selectnid1(String id) {
        //String seletcan = "SELECT vid FROM voter WHERE username=" + user +" AND password = "+pass;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from nomanation where nid='" + id + "'", null);
        if (c.getCount() == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    public String getpre1(String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where type = '" + type + "' and cidl = '1' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(0) + "\n");
        }

        return b.toString();
    }


    public String getprename1(String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where  type = '" + type + "' and cidl = '1' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(3));
            b.append(c.getString(4));
            b.append(c.getString(5));
        }

        return b.toString();
    }

    public String getpre2(String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where type = '" + type + "' and cidl = '2' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(0) + "\n");
        }

        return b.toString();
    }


    public String getprename2(String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where  type = '" + type + "' and cidl = '2' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(3));
            b.append(c.getString(4));
            b.append(c.getString(5));
        }

        return b.toString();
    }

    public String getpre3(String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where type = '" + type + "' and cidl = '3' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(0) + "\n");
        }

        return b.toString();
    }


    public String getprename3(String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where  type = '" + type + "' and cidl = '3' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(3));
            b.append(c.getString(4));
            b.append(c.getString(5));
        }

        return b.toString();
    }

    public String getpre4(String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where type = '" + type + "' and cidl = '4' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(0) + "\n");
        }

        return b.toString();
    }


    public String getprename4(String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where  type = '" + type + "' and cidl = '4' ", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(3));
            b.append(c.getString(4));
            b.append(c.getString(5));
        }

        return b.toString();
    }

    public String getcid(String user, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where username='" + user + "' and password='" + pass + "'", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {

            b.append(c.getString(0) + "\n");

        }

        return b.toString();
    }


    public String gettype(String user, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where username='" + user + "' and password='" + pass + "'", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {
            b.append(c.getString(13) + "\n");
        }
        return b.toString();
    }

    public boolean upadtecan1(int vid) {
        SQLiteDatabase db = this.getWritableDatabase();
        //update voter in voter table
        ContentValues valuesvoter = new ContentValues();
        valuesvoter.put(KEY_CID, vid);
        valuesvoter.put(KEY_WIN, "notwinner");
        db.update(TABLE_CANDIDATE, valuesvoter, KEY_CID + " = ?", new String[]{String.valueOf(vid)});

        return true;
    }

    public int selecttype1(int id) {
        //String seletcan = "SELECT vid FROM voter WHERE username=" + user +" AND password = "+pass;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from voter where vid='"+id+"' and Type='organization'", null);
        if (c.getCount() == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public int selecttyp2(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from voter where vid='"+id+"' and Type='municipalities'", null);
        if (c.getCount() == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public int selecttyp3(int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from voter where vid='"+id+"' and Type='parliamentary'", null);
        if (c.getCount() == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    public int selectwin(int id) {
        //String seletcan = "SELECT vid FROM voter WHERE username=" + user +" AND password = "+pass;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where cid='" + id + "' and winner = 'winner' ", null);
        if (c.getCount() == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    public String getall(int id, String type) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor d = db.rawQuery("select nid,nidc,ncid,cfname,cmname,clname,numberofvotes,type,cidc,cid from nomanation,candidate where ncid=cid and  nidc='"+id+"' and Type='"+type+"'", null);
        StringBuffer b = new StringBuffer();

        while (d.moveToNext()) {
            b.append("nid :" + d.getString(0) + "\n");
            b.append("cityId :" + d.getString(1) + "\n");
            b.append("candidate Id :" + d.getString(2) + "\n");
            b.append("full name :" + d.getString(3));
            b.append(d.getString(4));
            b.append(d.getString(5) + "\n");
            b.append("nomination number :" + d.getString(6) + "\n");
        }

        return b.toString();
    }
    public String getall1() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor d = db.rawQuery("select nid,nidc,ncid,cfname,cmname,clname,numberofvotes,type,cidc,cid from nomanation,candidate where ncid=cid ", null);
        StringBuffer b = new StringBuffer();

        while (d.moveToNext()) {
            b.append("nid :" + d.getString(0) + "\n");
            b.append("cityId :" + d.getString(1) + "\n");
            b.append("candidate Id :" + d.getString(2) + "\n");
            b.append("full name :" + d.getString(3));
            b.append(d.getString(4));
            b.append(d.getString(5) + "\n");
            b.append("nomination number :" + d.getString(6) + "\n");
        }

        return b.toString();
    }
    public String getidc12(String user, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from candidate where username='" + user + "' and password='" + pass + "'", null);
        StringBuffer b = new StringBuffer();
        while (c.moveToNext()) {

            b.append(c.getString(1) + "\n");
        }

        return b.toString();
    }
    public String getalle(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor d = db.rawQuery("select * from electioncycle where eid='"+id+"'", null);
        StringBuffer b = new StringBuffer();
        while(d.moveToNext()){
            b.append(d.getString(1));
        }
        return  b.toString();
    }
    public boolean Deletevoter(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_VOTER,null,null);
        return true;
    }
    public boolean Deletecan(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_CANDIDATE,null,null);
        return true;
    }
    public boolean Deletenom(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NOMANATION,null,null);
        return true;
    }
    public int selectyear(int id) {
        //String seletcan = "SELECT vid FROM voter WHERE username=" + user +" AND password = "+pass;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from electioncycle where eid='" + id + "'", null);
        if (c.getCount() == 0) {
            return 0;
        } else {
            return 1;
        }

    }
    public String getallc() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor d = db.rawQuery("select * from cities ", null);
        StringBuffer b = new StringBuffer();

        while (d.moveToNext()) {
            b.append("Cityid :" + d.getString(0) + "\n");
            b.append("Cityname :" + d.getString(1) + "\n");
            b.append("Govornate :" + d.getString(2) + "\n");
            b.append("number of member :" + d.getString(3)+"\n");


        }

        return b.toString();
    }
    public String getalli() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor d = db.rawQuery("select * from list ", null);
        StringBuffer b = new StringBuffer();

        while (d.moveToNext()) {
            b.append("Listid :" + d.getString(0) + "\n");
            b.append("Listname :" + d.getString(1) + "\n");
        }
        return b.toString();
    }
    public String getallv() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor d = db.rawQuery("select * from voter ", null);
        StringBuffer b = new StringBuffer();

        while (d.moveToNext()) {
            b.append("voter id :" + d.getString(0) + "\n");
            b.append("City id :" + d.getString(1) + "\n");
            b.append("First name :" + d.getString(2) + "\n");
            b.append("Middle name :" + d.getString(3) + "\n");
            b.append("Last name :" + d.getString(4) + "\n");
            b.append("Birthdate :" + d.getString(5) + "\n");
            b.append("Phone number :" + d.getString(6) + "\n");
            b.append("Email :" + d.getString(7) + "\n");
            b.append("Gender :" + d.getString(8) + "\n");
            b.append("Username :" + d.getString(9) + "\n");
            b.append("Password :" + d.getString(10) + "\n");
            b.append("Voted or not :" + d.getString(11) + "\n");
            b.append("Type :" + d.getString(12) + "\n");
        }
        return b.toString();
    }
    public String getallca() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor d = db.rawQuery("select * from candidate ", null);
        StringBuffer b = new StringBuffer();

        while (d.moveToNext()) {
            b.append("Candidate id :" + d.getString(0) + "\n");
            b.append("City id :" + d.getString(1) + "\n");
            b.append("List id :" + d.getString(2) + "\n");
            b.append("First name :" + d.getString(3) + "\n");
            b.append("Middle name :" + d.getString(4) + "\n");
            b.append("Last name :" + d.getString(5) + "\n");
            b.append("Birthdate :" + d.getString(6) + "\n");
            b.append("Phone number :" + d.getString(7) + "\n");
            b.append("Email :" + d.getString(8) + "\n");
            b.append("Gender :" + d.getString(9) + "\n");
            b.append("Username :" + d.getString(10) + "\n");
            b.append("Password :" + d.getString(11) + "\n");
            b.append("Purpose :" + d.getString(12) + "\n");
            b.append("Type :" + d.getString(13) + "\n");
            b.append("Seat :" + d.getString(14) + "\n");
            b.append("Winner not winner :" + d.getString(15) + "\n");
        }
        return b.toString();
    }

}
