package com.example.demo.response;

public class MyFirstResponse {
    private int id;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "MyFirstResponse{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
