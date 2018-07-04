package com.example.tretiakoff.sifg2.api.model;

/**
 * Created by tretiakoff on 03/07/2018.
 */

public class Answer {

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setEmergency(Boolean emergency) {
        this.emergency = emergency;
    }

    public void setNext_question_id(Integer next_question_id) {
        this.next_question_id = next_question_id;
    }

    public void setPathology(Pathology pathology) {
        this.pathology = pathology;
    }

    public Answer(int id, String text, Boolean emergency, Integer next_question_id, Pathology pathology) {
        this.id = id;
        this.text = text;
        this.emergency = emergency;
        this.next_question_id = next_question_id;
        this.pathology = pathology;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Boolean getEmergency() {
        return emergency;
    }

    public Integer getNext_question_id() {
        return next_question_id;
    }

    public Pathology getPathology() {
        return pathology;
    }

    private int id;
    private String text;
    private Boolean emergency;
    private Integer next_question_id;
    private Pathology pathology;
}
