package com.example.andre.qfinder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class SwipeGuest extends AppCompatActivity {

    public static final int QUIZ_SIZE = 7;
    private ArrayList<String> quiz;
    private ArrayList<String> quiz_display;
    private ArrayList<Boolean> quiz_result;
    private ArrayAdapter<String> arrayAdapter;
    private int quiz_index;
    private String question = "";
    private String tag = "";

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        Intent intent = getIntent();
        final String room_code = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        ListView lv = (ListView) findViewById(R.id.swipey);
        quiz = new ArrayList<>();

        for (int i = 0; i < QUIZ_SIZE; i ++){
            //get question from quiz table index i              atch
            question = Integer.toString(i); // dummy code
            quiz.add(question);
        }

        quiz_display = new ArrayList<>();

        quiz_display.add(quiz.get(0));

        quiz_result = new ArrayList<>();


        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, quiz_display);

        lv.setAdapter(arrayAdapter);

        lv.setOnTouchListener(new OnSwipeTouchListener(this){
            @Override
            public void onSwipeLeft(){
                quiz.remove(0);
                arrayAdapter.notifyDataSetChanged();
                quiz_result.add(FALSE);
                quiz_index ++;
                if (quiz.size() == 0){
                    for (int i = 0; i < quiz_result.size(); i ++) {
                        //TODO server code that increments/decrements quiz result based on swipe results
                        if (quiz_result.get(i)) {
                            //TODO increment result
                        } else {
                            //TODO decrement result
                        }
                    }
                    //TODO increment quiz_complete counter on room table
                    while(TRUE){
                        //TODO keep checking for quiz done to be 1 on room table
                    }
                    Intent intent = new Intent(context, Results.class);
                    //intent.putIntegerArrayListExtra("results" , quiz_result);
                    intent.putExtra("room",room_code);
                    startActivity(intent);
                    finish();
                }
                else {
                    quiz_display.remove(0);
                    quiz_display.add(quiz.get(0));
                }
            }

            public void onSwipeRight(){
                quiz.remove(0);
                arrayAdapter.notifyDataSetChanged();
                quiz_result.add(TRUE);
                quiz_index ++;
                if (quiz.size() == 0){
                    for (int i = 0; i < quiz_result.size(); i ++) {
                        //TODO server code that increments/decrements quiz result based on swipe results
                        if (quiz_result.get(i)) {
                            //TODO increment result
                        } else {
                            //TODO decrement result
                        }
                    }
                    //TODO increment quiz_complete counter on room table
                    while(TRUE){
                        //TODO keep checking for quiz done to be 1 on room table
                    }
                    Intent intent = new Intent(context, Results.class);
                    //intent.putIntegerArrayListExtra("results" , quiz_result);
                    intent.putExtra("room",room_code);
                    startActivity(intent);
                    finish();
                }
                else {
                    quiz_display.remove(0);
                    quiz_display.add(quiz.get(0));
                }
            }
        });
    }
}
