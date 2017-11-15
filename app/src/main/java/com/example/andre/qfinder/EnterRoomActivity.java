package com.example.andre.qfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EnterRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_room);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String room_code = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView5);
        textView.setText("Room Code: " + room_code);
    }

    // Start the quiz
    public void startQuiz(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Swipe.class);
        startActivity(intent);
    }
}
