package com.example.andre.qfinder;

import java.util.ArrayList;

/**
 * Created by py344 on 2017-11-13.
 */

public class Question {
    private String question;
    private String tag;


    public Question() {
        question = "";
        tag = "";
    }

    public Question(String in_question, String in_tag){
        question = in_question;
        tag = in_tag;
    }

    public String getQuestion() {
        return question;
    }

    public String getQuestionTag() {
        return tag;
    }
}
