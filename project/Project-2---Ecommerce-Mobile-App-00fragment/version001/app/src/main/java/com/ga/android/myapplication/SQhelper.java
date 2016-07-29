package com.ga.android.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by wanmac on 7/20/16.
 */
public class SQhelper extends SQLiteOpenHelper {
    private static final String TAG = "SQhelper///";
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

    public ArrayList<DaIndiItem> returnAllArrayList() {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor;
        cursor = this.getAllItem();

        ArrayList<DaIndiItem> arrayList = new ArrayList<>();

        cursor.moveToFirst();
        while (cursor.isAfterLast()==false) {
            String itemTitle = cursor.getString(cursor.getColumnIndex(DataEntryItem
                    .COLUMN_TITLE));
            String itemPrice = cursor.getString(cursor.getColumnIndex(DataEntryItem
                    .COLUMN_PRICE));
            int intItemPrice = Integer.parseInt(itemPrice);
            DaIndiItem itemDetail = new DaIndiItem();
            itemDetail.setIteTitle(itemTitle);
            itemDetail.setItePrice(intItemPrice);
            Log.d(TAG, String.valueOf(itemDetail));
            arrayList.add(itemDetail);
            cursor.moveToNext();
        }

        return arrayList;
    }
    ///////////////////////////////////////
    public Cursor getAllItem() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DataEntryItem.TABLE_NAME,
                COLUMN_NAMES,
                null, null, null, null, null, null);
        return cursor;
    }

    public Cursor serachTitle(String query){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DataEntryItem.TABLE_NAME,
                COLUMN_NAMES,
                DataEntryItem.COLUMN_TITLE + " LIKE ?",
                new String[] {"%"+ query + "%"},
                null, null, null, null);
        return cursor;
    }
}

