package com.example.tretiakoff.sifg2.api.model.doctor;

import java.util.ArrayList;

/**
 * Created by tretiakoff on 05/07/2018.
 */

public class DoctorResult {

    public DoctorResult(ArrayList<Doctor> specialized_doctors) {
        this.specialized_doctors = specialized_doctors;
    }

    public ArrayList<Doctor> getSpecialized_doctors() {
        return specialized_doctors;
    }

    public ArrayList<Doctor> specialized_doctors;
}
