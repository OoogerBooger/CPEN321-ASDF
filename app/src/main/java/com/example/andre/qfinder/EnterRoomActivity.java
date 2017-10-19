package com.example.andre.qfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EnterRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_room);


    }

    // Start the quiz
    public void startQuiz(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Swipe.class);
        startActivity(intent);
    }
}
