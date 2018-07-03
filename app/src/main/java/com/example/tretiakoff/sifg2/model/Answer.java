package com.example.tretiakoff.sifg2.model;

/**
 * Created by tretiakoff on 03/07/2018.
 */

public class Answer {

    private int id;
    private String text;
    private int next_question_id;

    public Answer(int id, String text, int next_question_id) {
        this.id = id;
        this.text = text;
        this.next_question_id = next_question_id;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getNext_question_id() {
        return next_question_id;
    }

}
