package com.example.andre.qfinder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Swipe extends AppCompatActivity {

    private ArrayList<String> quiz;
    private ArrayList<String> quiz_display;
    private ArrayList<Integer> quiz_result;
    private ArrayAdapter<String> arrayAdapter;
    private int quiz_index;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        ListView lv = (ListView) findViewById(R.id.swipey);
        quiz = new ArrayList<>();
        quiz.add("Q1: Is spending over $15 okay?");
        quiz.add("Q2: Do there need to be vegetarian options?");
        quiz.add("Q3:");
        quiz.add("Q4:");
        quiz.add("Q5:");
        quiz.add("Q6:");
        quiz.add("Q7:");

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
                quiz_result.add(0);
                quiz_index ++;
                if (quiz.size() == 0){
                    Intent intent = new Intent(context, Results.class);
                    intent.putIntegerArrayListExtra("results" , quiz_result);
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
                quiz_result.add(1);
                quiz_index ++;
                if (quiz.size() == 0){
                    Intent intent = new Intent(context, Results.class);
                    intent.putIntegerArrayListExtra("results" , quiz_result);
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
