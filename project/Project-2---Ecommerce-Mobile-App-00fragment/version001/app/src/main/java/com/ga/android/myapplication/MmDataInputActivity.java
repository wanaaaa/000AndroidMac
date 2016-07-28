package com.ga.android.myapplication;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MmDataInputActivity extends AppCompatActivity {

    private static final String TAG = "MmDataInputActivity";
    ListView listView;

    EditText mTitleInput, mPriceInput;
    Button buDataReset;

    SQhelper helper  ;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mm_data_input);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        helper = SQhelper.getInstance(MmDataInputActivity.this);

        Cursor cursor;
        cursor = helper.getAllItem();
        listView = (ListView) findViewById(R.id.listview_allItem);

        ArrayList<String> arrayList = new ArrayList<>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MmDataInputActivity.this,
            android.R.layout.simple_list_item_1, arrayList);

        cursor.moveToFirst();
        while (cursor.isAfterLast()==false) {
            String itemDetail = cursor.getString(cursor.getColumnIndex(SQhelper.DataEntryItem.COLUMN_TITLE));
            String itemPrice = cursor.getString(cursor.getColumnIndex(SQhelper.DataEntryItem.COLUMN_PRICE));
            arrayList.add(itemDetail+"/"+itemPrice);
            cursor.moveToNext();
        }


        listView.setAdapter(arrayAdapter);

        buDataReset = (Button) findViewById(R.id.buResetData);
        buDataReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQhelper helper = SQhelper.getInstance(MmDataInputActivity.this);
                helper.resetData();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DaIndiItem indiItem = new DaIndiItem();
                mTitleInput = (EditText) findViewById(R.id.editInputTitle);
                mPriceInput = (EditText) findViewById(R.id.editInputPrice);

                String stringTitle = mTitleInput.getText().toString();
                int intPrice = Integer.valueOf(mPriceInput.getText().toString());

                indiItem.setIteTitle(stringTitle);
                indiItem.setItePrice(intPrice);

                SQhelper helper = SQhelper.getInstance(MmDataInputActivity.this);
                helper.inserRow(indiItem);

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MmDataInput Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.ga.android.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MmDataInput Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.ga.android.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
