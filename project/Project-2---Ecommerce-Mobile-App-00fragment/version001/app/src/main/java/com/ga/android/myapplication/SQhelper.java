package com.ga.android.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by wanmac on 7/20/16.
 */
public class SQhelper extends SQLiteOpenHelper {
    public SQhelper(Context context) {
        super(context, "db", null, 1);
    }

    private static SQhelper INSTANCE;

    public static synchronized SQhelper getInstance(Context context){
        if (INSTANCE == null)
            INSTANCE = new SQhelper(context.getApplicationContext());
        return INSTANCE;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES_ITEMS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_ENTRIES_ITEMS);
        onCreate(db);
    }

    public static abstract class DataEntryItem implements BaseColumns {
        public static final String TABLE_NAME = "items";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_PRICE = "price";
    }

    public static final String SQL_CREATE_ENTRIES_ITEMS = "CREATE TABLE " +
            DataEntryItem.TABLE_NAME + " (" +
            DataEntryItem._ID + " INTEGER PRIMARY KEY, "+
            DataEntryItem.COLUMN_TITLE + " TEXT, " +
            DataEntryItem.COLUMN_PRICE + " INTEGER )";

    public static final String SQL_DELETE_ENTRIES_ITEMS = "DROP TABLE IF EXISTS " +
            DataEntryItem.TABLE_NAME;

    public static final String[] COLUMN_NAMES = {DataEntryItem._ID, DataEntryItem.COLUMN_TITLE,
        DataEntryItem.COLUMN_PRICE};

    public void inserRow(DaIndiItem indiItem) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DataEntryItem.COLUMN_TITLE, indiItem.getIteTitle());
        values.put(DataEntryItem.COLUMN_PRICE, indiItem.getItePrice());

        db.insertOrThrow(DataEntryItem.TABLE_NAME, null, values);
    }

    public void resetData(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(SQL_DELETE_ENTRIES_ITEMS);
        db.execSQL(SQL_CREATE_ENTRIES_ITEMS);
    }
    ///////////////////////////////////////
    public Cursor getAllItem() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DataEntryItem.TABLE_NAME,
                COLUMN_NAMES,
                null, null, null, null, null, null);
        return cursor;
    }

}

