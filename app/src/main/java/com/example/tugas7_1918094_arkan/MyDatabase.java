package com.example.tugas7_1918094_arkan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_distribusi";
    private static final String tb_musik = "tb_musik";
    private static final String tb_musik_id = "id";
    private static final String tb_musik_musik = "musik";
    private static final String tb_musik_artist = "artist";
    private static final String tb_musik_genre = "genre";
    private static final String CREATE_TABLE_MUSIK = "CREATE TABLE " + tb_musik +"("
            + tb_musik_id + " INTEGER PRIMARY KEY ,"
            + tb_musik_musik + " TEXT ,"
            + tb_musik_artist + " TEXT ,"
            + tb_musik_genre + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MUSIK);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateMusik(Musik data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_musik_id, data.get_id());
        values.put(tb_musik_musik, data.get_musik());
        values.put(tb_musik_artist, data.get_artist());
        values.put(tb_musik_genre, data.get_genre());
        db.insert(tb_musik, null, values);
        db.close();
    }
    public List<Musik> ReadMusik() {
        List<Musik> listMhs = new ArrayList<Musik>();
        String selectQuery = "SELECT * FROM " + tb_musik;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Musik data = new Musik();
                data.set_id(cursor.getString(0));
                data.set_musik(cursor.getString(1));
                data.set_artist(cursor.getString(2));
                data.set_genre(cursor.getString(3));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }
    public int UpdateMusik (Musik data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_musik_musik, data.get_musik());
        values.put(tb_musik_artist, data.get_artist());
        values.put(tb_musik_genre, data.get_genre());
        return db.update(tb_musik, values, tb_musik_id + " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteMusik(Musik data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_musik,tb_musik_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}

