package com.example.andre.qfinder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class Swipe extends AppCompatActivity {

    public static final int QUIZ_SIZE = 7;
    public static final int CULTURAL_Q_SIZE = 3;
    public static final int RANDOM_Q_SIZE = 4;
    private ArrayList<Question> mandatory_qs = new ArrayList<>();
    private ArrayList<Question> cultural_qs = new ArrayList<>();
    private ArrayList<Question> random_qs = new ArrayList<>();
    private ArrayList<String> quiz_tags = new ArrayList<>();
    private ArrayList<Question> quiz;
    private String quiz_display;
    private ArrayList<Integer> quiz_result;
    private ArrayAdapter<String> arrayAdapter;
    private int quiz_index = 0;
    private Question question;
    private String tag = "";
    private int rand_int = 0;
    Random r = new Random();

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        //Intent intent = getIntent();
        //final String room_code = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        create_questions(mandatory_qs, cultural_qs, random_qs);


        final TextView text = (TextView) findViewById(R.id.swipey);
        quiz = new ArrayList<>();

        for (int i = 0; i < QUIZ_SIZE; i ++){
            if (i < 3){
                question = mandatory_qs.get(i);
            }
            else if (i > 2 && i < 5) {
                rand_int = r.nextInt(CULTURAL_Q_SIZE);
                question = cultural_qs.get(rand_int);
                while (question == quiz.get(i-1)){
                    rand_int = (rand_int + 1 ) % CULTURAL_Q_SIZE;
                    question = cultural_qs.get(rand_int);
                }
            }
            else {
                rand_int = r.nextInt(RANDOM_Q_SIZE);
                question = random_qs.get(rand_int);
                while (question == quiz.get(i-1)){
                    rand_int = (rand_int + 1) % RANDOM_Q_SIZE;
                    question = random_qs.get(rand_int);
                }
            }
            quiz.add(question);
        }
        //quiz_display = new ArrayList<>();

        quiz_display = quiz.get(quiz_index).getQuestion();
        text.setText(quiz_display);

        quiz_result = new ArrayList<>();


        //arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, quiz_display);

        //lv.setAdapter(arrayAdapter);

        text.setOnTouchListener(new OnSwipeTouchListener(this){
            @Override
            public void onSwipeLeft(){
                quiz_tags.add(quiz.get(0).getQuestionTag());
                //quiz.remove(0);
                //arrayAdapter.notifyDataSetChanged();
                quiz_result.add(0);
                quiz_index ++;
                if (quiz_index == QUIZ_SIZE){
                    Intent intent = new Intent(context, Results.class);
                    intent.putIntegerArrayListExtra("results" , quiz_result);
                    intent.putStringArrayListExtra("tags", quiz_tags);
                    //intent.putExtra("room",room_code);
                    startActivity(intent);
                    finish();
                }
                else {
                    //quiz_display.remove(0);
                    quiz_display = quiz.get(quiz_index).getQuestion();
                    text.setText(quiz_display);
                }
            }

            public void onSwipeRight(){
                quiz_tags.add(quiz.get(0).getQuestionTag());
                //quiz.remove(0);
                //arrayAdapter.notifyDataSetChanged();
                quiz_result.add(1);
                quiz_index ++;
                if (quiz_index == QUIZ_SIZE){
                    Intent intent = new Intent(context, Results.class);
                    intent.putIntegerArrayListExtra("results" , quiz_result);
                    intent.putStringArrayListExtra("tags", quiz_tags);
                    startActivity(intent);
                    finish();
                }
                else {
                    //quiz_display.remove(0);
                    quiz_display = quiz.get(quiz_index).getQuestion();
                    text.setText(quiz_display);
                }
            }
        });
    }

    public void create_questions(ArrayList<Question> mandatory, ArrayList<Question> cultural, ArrayList<Question> random){
        mandatory.add(new Question("Are you comfortable with spending $15 or more","cheap")); //TODO: actual price question
        mandatory.add(new Question("Is fast food okay?","fast"));
        mandatory.add(new Question("Are you looking for dinner?","dinner"));

        cultural.add(new Question("Would you like western food?","western"));
        cultural.add(new Question("Are you okay with middle eastern food?","middle"));
        cultural.add(new Question("Would you like asian food?","asian"));

        random.add(new Question("Are you okay with vegetarian food?","vegetarian"));
        random.add(new Question("Would you like dessert?","dessert"));
        random.add(new Question("Are you okay with spicy food?","spicy"));
        random.add(new Question("Would you like to go to a sit-down restaurant?","sit"));
    }

}
