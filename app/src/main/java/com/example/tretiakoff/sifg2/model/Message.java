package com.example.tretiakoff.sifg2.model;

/**
 * Created by tretiakoff on 03/07/2018.
 */

public class Message {

    String message;
    Boolean received;

    public Message(String message, Boolean received) {
        this.message = message;
        this.received = received;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setReceived(Boolean received) {
        this.received = received;
    }

    public Boolean getReceived() {
        return received;
    }
}
