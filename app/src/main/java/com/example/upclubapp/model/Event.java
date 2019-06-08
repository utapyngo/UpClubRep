package com.example.upclubapp.model;

public class Event {
    private String id;
    private String title;
    private String description;
    private String address;
    private String skill;

    public Event() {
    }

    public Event(String id, String title, String description, String address, String skill) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.address = address;
        this.skill = skill;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
