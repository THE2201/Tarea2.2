package com.example.listarequestsg4.Modelos;

public class Posts {
    public int usedId;
    public int id;
    public String title;
    public String body;

    public Posts(int usedId, int id, String title, String body) {
        this.usedId = usedId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Posts() {
    }

    public int getUsedId() {
        return usedId;
    }

    public void setUsedId(int usedId) {
        this.usedId = usedId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
