package com.example.brain_hack_v1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "brain_hack";
    public static final String TABLE_NAME = "admin";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Name";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //to insert
    public boolean insertData(String id , Editable name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2, String.valueOf(name));
      long result = db.insert(TABLE_NAME,null ,contentValues);
     if (result == 1)
     return false;

     else
         return true;
    }

    //to show all data
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res  = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

   /* //to update
    public boolean updateData(String index_no , String name, String Address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,index_no);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,Address);
      long result1 =  db.update(TABLE_NAME,contentValues,"ID = ?", new String[]{index_no});
        if (result1 == 0)
            return false;

        else
            return true;

    }

*/

    //to delete
    public Integer deleteData (String id){
        SQLiteDatabase db = this.getWritableDatabase();
       return db.delete(TABLE_NAME,"ID = ?", new String[]{id});
    }

 }

