package com.example.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contact_db";
    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_TABLE = "CREATE TABLE " + ContactContract.ContactEntry.TABLE_NAME +
            "(" + ContactContract.ContactEntry.CONTACT_ID + " NUMBER," + ContactContract.ContactEntry.NAME + " TEXT," +
            ContactContract.ContactEntry.EMAIL + " TEXT);";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + ContactContract.ContactEntry.TABLE_NAME + ";";

    public ContactDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database operation", "Database created if not exist...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d("Database operation", "Table created...");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void addContact(int id, String name, String email, SQLiteDatabase db){
        ContentValues cv = new ContentValues();

        cv.put(ContactContract.ContactEntry.CONTACT_ID, id);
        cv.put(ContactContract.ContactEntry.NAME, name);
        cv.put(ContactContract.ContactEntry.EMAIL, email);

        db.insert(ContactContract.ContactEntry.TABLE_NAME, null, cv);
        Log.d("Database operation", "One row inserted...");

    }
}
