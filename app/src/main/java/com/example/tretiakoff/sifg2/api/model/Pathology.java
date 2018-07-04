package com.example.tretiakoff.sifg2.api.model;

/**
 * Created by tretiakoff on 04/07/2018.
 */

public class Pathology {

    public Pathology(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    private int id;
    private String label;
}
