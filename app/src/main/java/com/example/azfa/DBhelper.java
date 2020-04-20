package com.example.azfa;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    public static final int VERSION = 1;
    public static final String Database_NAME = "Azfa";

    public DBhelper(@Nullable Context context) {
        super(context, Database_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL((SQL_DELETE_ENTRIES));
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + shipprof.ship.TABLE_NAME + " (" +
                    shipprof.ship._ID + " INTEGER PRIMARY KEY," +
                    shipprof.ship.COL_1 + " TEXT," +
                    shipprof.ship.COL_2 + " TEXT," +
                    shipprof.ship.COL_3 + " TEXT," +
                    shipprof.ship.COL_4 + " TEXT," +
                    shipprof.ship.COL_5 + " TEXT," +
                    shipprof.ship.COL_6 + " TEXT," +
                    shipprof.ship.COL_7 + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + shipprof.ship.TABLE_NAME;


    public long addInfo (String FirstName, String LastName, String Address, String Country,String PostalCode,String Telno,String Email){
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put( shipprof.ship.COL_1, FirstName);
        values.put( shipprof.ship.COL_2, LastName);
        values.put( shipprof.ship.COL_3, Address);
        values.put( shipprof.ship.COL_4, Country);
        values.put( shipprof.ship.COL_5, PostalCode);
        values.put( shipprof.ship.COL_6, Telno);
        values.put( shipprof.ship.COL_7, Email);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(shipprof.ship.TABLE_NAME, null, values);

        return newRowId;

    }
}
