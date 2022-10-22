package com.example.myapplication.database_helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class  DataBase_Helper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "UserManager.db";

    public DataBase_Helper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (username Text primary key,gmail Text,password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists users");
        onCreate(db);
    }

    // FOR INSERT DATA INTO DATABASE

    public Boolean insertData ( String username , String password,String gmail) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("gmail",gmail);
        long result = myDB.insert("users", null, contentValues);
        return result != -1;
//        if (result == -1) {
//            return false;
//        }
//        else {
//            return true;
//        }
//    }
    }

// USER NAME EXISTS OR NOT
public boolean check_user_name(String username){
    SQLiteDatabase MyDB = this.getWritableDatabase();
    @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
//    cursor.close();
    return cursor.getCount() > 0;
//    if (cursor.getCount()>0){
//        return true;
///    }
//    else {
//        return false;
//    }
}

    // NOW CHECK GMAIL IS USED OR NOT OR ALREADY EXISTS OR NOT
    // FOR THIS WE WILL USE BOOLEAN DATA TYPE

    public  boolean check_gmail(String gmail){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = sqLiteDatabase.rawQuery("select * from users where gmail = ?",new String[] {gmail});
        int coursor_count = cursor.getCount();
//        cursor.close();
        return coursor_count > 0;
//        if (coursor_count>0){
//            return true;
// /       }
//        else {
//            return false;
//        }
    }


// this is for login activity to verify to check gmail and pass word are matching or not

    //      THIS IS FOR LOGIN PAGE
    public  boolean check_gmail_password(String gmail, String password){

        SQLiteDatabase MyDB = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("Select * from users where gmail = ? and password = ?",new String[] {gmail,password} );
//        cursor.close();
        return cursor.getCount() > 0;
//        if (cursor.getCount()>0){
//            return true;
// /       }
//        else {
//            return false;
//        }
    }
}


