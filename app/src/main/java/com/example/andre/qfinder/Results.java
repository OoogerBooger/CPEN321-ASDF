package com.example.andre.qfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;


public class Results extends AppCompatActivity {
    private ArrayList<Integer> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        results = getIntent().getIntegerArrayListExtra("results");

    }
}
