package com.example.tretiakoff.sifg2.api.model;

import com.example.tretiakoff.sifg2.api.model.chat.Pathology;

import java.util.ArrayList;

/**
 * Created by tretiakoff on 05/07/2018.
 */

public class PathologyResult {

    public PathologyResult(ArrayList<Pathology> pathologies) {
        this.pathologies = pathologies;
    }

    public ArrayList<Pathology> getPathologies() {
        return pathologies;
    }

    private ArrayList<Pathology> pathologies;
}
