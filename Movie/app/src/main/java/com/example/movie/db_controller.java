package com.example.movie;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class db_controller extends SQLiteOpenHelper {


    public db_controller(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Movie.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE movies(INT INTEGER PRIMARY KEY AUTOINCREMENT,moviename TEXT UNIQUE,movietime TEXT );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS STUDENTS");
        onCreate(db);

    }
    public void insert_movie(String moviename,String movietime)
    {
        ContentValues contentvalues=new ContentValues();
        contentvalues.put("MovieName",moviename);
        contentvalues.put("MovieTime",movietime);
        this.getWritableDatabase().insertOrThrow("movies","",contentvalues);
    }
    public void delete_movie(String moviename)
    {
        this.getWritableDatabase().delete("movies","MovieName='"+moviename+"'",null );
    }
    public void update_movie(String old_moviename, String new_moviename)
    {
        this.getWritableDatabase().execSQL("UPDATE  movies SET moviename='"+new_moviename+"' WHERE moviename='"+old_moviename+"'");
    }
    public String list_all_movie(TextView txtview)
    {
        Cursor cursor=this.getReadableDatabase().rawQuery("SELECT * FROM movies",null);
        txtview.setText("");
        while(cursor.moveToNext())
        {
            txtview.append(cursor.getString(1)+""+cursor.getString(2)+"\n");
        }
        return null;
    }
}

