package com.example.andre.qfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;


public class Results extends AppCompatActivity {
    //private ArrayList<Integer> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent intent = getIntent();
        final String room_code = intent.getStringExtra("room");
        //results = getIntent().getIntegerArrayListExtra("results");
        //TODO pull the results from the server
        // TODO change the view of the results to a list view (not server related)

    }
}
