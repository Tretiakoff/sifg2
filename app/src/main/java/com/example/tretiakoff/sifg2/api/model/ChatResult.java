package com.example.tretiakoff.sifg2.api.model;

import java.util.ArrayList;

/**
 * Created by tretiakoff on 03/07/2018.
 */

public class ChatResult {

    private int id;
    private String text;
    ArrayList<Answer> answers;

    public ChatResult(int id, String text, ArrayList<Answer> answers) {
        this.id = id;
        this.text = text;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }
}
