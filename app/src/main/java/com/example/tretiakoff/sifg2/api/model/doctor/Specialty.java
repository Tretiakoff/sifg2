package com.example.tretiakoff.sifg2.api.model.doctor;

/**
 * Created by tretiakoff on 05/07/2018.
 */

public class Specialty {

    public Specialty(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    private int id;
    private String label;
}
