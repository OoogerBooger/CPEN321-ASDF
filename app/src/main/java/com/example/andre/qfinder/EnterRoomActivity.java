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
    private ArrayList<String> question_tags;
    private String question = "";
    private String tag;
    private int rand_int = 0;
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_room);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String room_code = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        quiz = new ArrayList<String>();

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView5);
        textView.setText("Room Code: " + room_code);

        for (int i = 0; i < QUIZ_SIZE; i ++){
            if (i == 0) {
                question = "Are you comfortable with spending over $15?";
                tag = "cheap"; //TODO change to appropriate tag
            }
            else if (i == 1) {
                question = "predefined q2"; //TODO: change this to the actual question
                tag = "tag2"; //TODO change to appropriate tag
            }
            else if (i > 1 && i < 4) {
                rand_int = r.nextInt(CULTURAL_Q_SIZE);
                question = Integer.toString(i); // dummy code
                //TODO question = get question from cultural q table
                while (question == quiz.get(i-1)){
                    rand_int = (rand_int + 1 ) % CULTURAL_Q_SIZE;
                    //TODO question = get question from cultural q table
                }
                tag = Integer.toString(i); //dummy code
                //tag = get the tag associated to question
            }
            else {
                rand_int = r.nextInt(RANDOM_Q_SIZE);
                question = Integer.toString(i); // dummy code
                //TODO question = get question from random q table
                while (question == quiz.get(i-1)){
                    rand_int = (rand_int + 1 ) % RANDOM_Q_SIZE;
                    //TODO question = get question from random q table       atch
                }
                tag = Integer.toString(i); //dummy code
                //TODO tag = get the tag associated to question use rand_int
            }
            quiz.add(question);
        }
        for (int i = 0; i < quiz.size(); i ++){
            //TODO send quiz.get(i) to the quiz table
        }

    }

    // Start the quiz
    public void startQuiz(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Swipe.class);
        startActivity(intent);
    }
}
