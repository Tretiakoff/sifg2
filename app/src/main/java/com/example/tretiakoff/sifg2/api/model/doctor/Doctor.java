package com.example.tretiakoff.sifg2.api.model.doctor;

/**
 * Created by tretiakoff on 05/07/2018.
 */

public class Doctor {

    public Doctor(int id, String firstname, String lastname, String phone, String email, Address address, Specialty specialty, int distance, boolean open, String scheduleInformation) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.specialty = specialty;
        this.distance = distance;
        this.open = open;
        this.scheduleInformation = scheduleInformation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setScheduleInformation(String scheduleInformation) {
        this.scheduleInformation = scheduleInformation;
    }

    private int id;

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isOpen() {
        return open;
    }

    public String getScheduleInformation() {
        return scheduleInformation;
    }

    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private Address address;
    private Specialty specialty;
    private int distance;
    private boolean open;
    private String scheduleInformation;
}
