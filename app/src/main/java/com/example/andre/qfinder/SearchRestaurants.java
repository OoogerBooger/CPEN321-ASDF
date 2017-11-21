package com.example.andre.qfinder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;


public class SearchRestaurants extends AppCompatActivity {
    private ArrayList<Integer> results;

    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchrestaurants);
        Intent intent = getIntent();
        final String room_code = intent.getStringExtra("room");
        //TODO search algorithm

        Intent intent2 = new Intent(context, Results.class);
        intent2.putExtra("room",room_code);
        startActivity(intent2);


    }
}
