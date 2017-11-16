package com.example.andre.qfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class EnterRoomActivity extends AppCompatActivity {

    public static final int QUIZ_SIZE = 7;
    public static final int CULTURAL_Q_SIZE = 6;
    public static final int RANDOM_Q_SIZE = 4;
    private ArrayList<String> quiz;
    private String question = "";
    private int rand_int = 0;
    Random r = new Random();

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

        for (int i = 0; i < QUIZ_SIZE; i ++){
            if (i == 0)
                question = "Are you comfortable with spending over $15?";
            else if (i == 1)
                question = "predefined q2"; //TODO: change this to the actual question
            else if (i > 1 && i < 4) {
                rand_int = r.nextInt(CULTURAL_Q_SIZE);
                //question = get question from cultural q table         atch
                while (question == quiz.get(i-1)){
                    rand_int = (rand_int + 1 ) % CULTURAL_Q_SIZE;
                    //question = get question from cultural q table     atch
                }
            }
            else {
                rand_int = r.nextInt(RANDOM_Q_SIZE);
                //question = get question from random q table           atch
                while (question == quiz.get(i-1)){
                    rand_int = (rand_int + 1 ) % RANDOM_Q_SIZE;
                    //question = get question from random q table       atch
                }
            }
            quiz.add(question);
        }
        for (int i = 0; i < quiz.size(); i ++){
            //send quix.get(i) to the quiz table                        atch
        }

    }

    // Start the quiz
    public void startQuiz(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Swipe.class);
        startActivity(intent);
    }
}
