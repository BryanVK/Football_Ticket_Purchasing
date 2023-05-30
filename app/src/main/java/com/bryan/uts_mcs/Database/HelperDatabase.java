package com.bryan.uts_mcs.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;

public class HelperDatabase extends SQLiteOpenHelper {

    public static final String DBNAME = "data.db";

    public HelperDatabase(@Nullable Context context) {
        super(context, "data.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tiket( tiketId LONG primary key, email TEXT, history TEXT)");
        db.execSQL("CREATE TABLE users( username TEXT, email TEXT primary key, password TEXT, history INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS tiket");
        db.execSQL("DROP TABLE IF EXISTS users");
    }




    public Boolean insertData(String username, String email, String password, Integer history){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("email", email);
        values.put("password", password);
        values.put("history", history);

        long result = db.insert("users", null, values);

        if(result == -1){
            return false;
        }else {
            return true;
        }
    }

    public Boolean checkEmail(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM users WHERE  email = ?", new String[]{email});

        if (cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }
    }



    public Boolean checkEmailPassword(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE email = ? AND password = ?", new String[]{email, password});


        if (cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }

    }

    public Boolean insertTicket(Long tiketId, String email, String history){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tiketId", tiketId);
        values.put("history", history);
        values.put("email", email);
        long result = db.insert("tiket", null, values);

        if(result == -1){
            return false;
        }else {
            return true;
        }
    }


    public Boolean checkHistory(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM tiket WHERE  email = ?", new String[]{email});

        if (cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }


    }
    public Cursor readAllData(String email){

        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM tiket WHERE  email = ?", new String[]{email});
        return cursor;

    }
}


