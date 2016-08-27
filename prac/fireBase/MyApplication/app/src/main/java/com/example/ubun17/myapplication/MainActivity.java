package com.example.ubun17.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    DatabaseReference dbRef;
    EditText userInput;
    Button sendButton;
    ListView listView;
    DatabaseReference mFirebaseRootRef;

    ArrayList<String> mMessages;

    private  ArrayAdapter<String> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        userInput = (EditText) findViewById(R.id.editText) ;
        sendButton = (Button) findViewById(R.id.button);
        listView = (ListView) findViewById(R.id.listView);

//        dataList = new ArrayList<>();
//
//        dbRef = FirebaseDatabase.getInstance().getReference();
//
//       final DatabaseReference objectRef = dbRef.child("first_firebase_object");
//
//
//        objectRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                String childString = dataSnapshot.getValue(String.class);
//                textView.setText(childString);
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

//        objectRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String objectString = dataSnapshot.child("first_item").getValue().toString();
//                textView.setText(objectString);
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

        mFirebaseRootRef = FirebaseDatabase.getInstance().getReference();

       // final DatabaseReference firebaseCurrentTextRef = mFirebaseRootRef.child("currentText");

        final DatabaseReference firebaseMessageRef = mFirebaseRootRef.child("messages");

        mMessages = new ArrayList<>();

//        firebaseMessageRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String text = dataSnapshot.getValue(String.class);
//                textView.setText(text);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });


        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //objectRef.child("first_item").setValue(userInput.getText().toString());
                firebaseMessageRef.push().setValue(userInput.getText().toString());
                //firebaseCurrentTextRef.push().setValue(userInput.getText().toString());
            }
        });

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this
                , android.R.layout.simple_list_item_1, mMessages);
        listView.setAdapter(adapter);

        firebaseMessageRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String message = dataSnapshot.getValue(String.class);
                mMessages.add(message);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
