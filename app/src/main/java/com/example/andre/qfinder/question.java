package com.example.andre.qfinder;

/**
 * Created by py344 on 2017-11-13.
 */

public class question {
    private final String question;
    private final String tag;


    public question(String in_question, String in_tag) {
        this.question = in_question;
        this.tag = in_tag;
    }

    public String get_question(){
        return this.question;
    }

    public String get_tag(){
        return this.tag;
    }
}
