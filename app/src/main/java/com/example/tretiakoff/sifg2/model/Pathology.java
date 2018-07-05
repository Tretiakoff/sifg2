package com.example.tretiakoff.sifg2.model;

public class Pathology {
    private int id;
    private String label;

    public Pathology(int id, String label) {
        this.id    = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
}
