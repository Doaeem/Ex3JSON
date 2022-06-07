package com.example.ex3json;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper {
    public static String DBNAME = "DBEMPLOYEE.db";
    public static String TBNAME = "EMPLOYEE";
    public static String COL1 = "nom";
    public static String COL2 = "matricule";
    public static String COL3 = "genre";
    public static String COL4 = "fonction";
    public static String COL5 = "naissance";
    public static String COL6 = "salaire";


    public MyDataBase(Context c){
        super(c,DBNAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + TBNAME + "(" + COL1 + " text primary key, " + COL2 + " text, " + COL3 + " text, " + COL4 + " text, " + COL5 + " text, " + COL6 + " double)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql=" DROP TABLE "+TBNAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public static long insertEmployee(SQLiteDatabase sqLiteDatabase, Employe e){
        ContentValues ct = new ContentValues();
        ct.put(COL1,e.getNom());
        ct.put(COL2,e.getMatricule());
        ct.put(COL3,e.getGenre());
        ct.put(COL4,e.getFonction());
        ct.put(COL5,e.getNaissance());
        ct.put(COL6,e.getSalaire());
        return sqLiteDatabase.insert(TBNAME,null,ct);
    }
}
