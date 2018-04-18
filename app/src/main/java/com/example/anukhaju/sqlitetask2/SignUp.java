package com.example.anukhaju.sqlitetask2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class SignUp extends SQLiteOpenHelper{

    SQLiteDatabase sqLiteDatabasel;

    public SignUp(Context context) {
        super(context, "UserInfo.db", null,1);
        sqLiteDatabasel=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table LoginDetail (Name text,Mobile text,Password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long save(String name, String mobile1, String pass1) {
        ContentValues contentValues=new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Mobile",mobile1);
        contentValues.put("Password",pass1);



       long data= sqLiteDatabasel.insert("LoginDetail",null,contentValues);
        return data;

    }


    public String get(String mob) {
        Cursor c;
        c=sqLiteDatabasel.query("LoginDetail",null,"Mobile=?",new String[]{mob},null,null,null);
        c.moveToFirst();
        if(c.getCount()<1){
            return "No User Found";
        }

        String Name=c.getString(c.getColumnIndex("Name"));
        String Pass=c.getString(c.getColumnIndex("Password"));
        return Pass;

    }

    public String gett(String mob) {
         Cursor c;
        c=sqLiteDatabasel.query("LoginDetail",null,"Mobile=?",new String[]{mob},null,null,null);
        c.moveToFirst();
        if(c.getCount()<1){
            return "No User Found";
        }

        String Name=c.getString(c.getColumnIndex("Name"));
        return Name;
    }
}
