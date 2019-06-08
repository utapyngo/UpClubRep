package com.example.upclubapp.model;

import android.os.Bundle;

public class Message {
    private String id;
    private String message;
    private int receiver;
    private int sender;

    public Message() {
    }

    public Message(String id, String message, int receiver, int sender) {
        this.id = id;
        this.message = message;
        this.receiver = receiver;
        this.sender = sender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }
}
