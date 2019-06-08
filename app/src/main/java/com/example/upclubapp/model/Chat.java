package com.example.upclubapp.model;

public class Chat {
    private String id;
    private String lastMessage;
    private int receiver;
    private int sender;
    private String urlImage;

    public Chat() {
    }

    public Chat(String id, String lastMessage, int receiver, int sender, String urlImage) {
        this.id = id;
        this.lastMessage = lastMessage;
        this.receiver = receiver;
        this.sender = sender;
        this.urlImage = urlImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
