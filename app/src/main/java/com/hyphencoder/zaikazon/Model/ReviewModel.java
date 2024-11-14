package com.hyphencoder.zaikazon.Model;

public class ReviewModel {

    String id, rating, msg, time, restroId;

    public ReviewModel() {
    }

    public ReviewModel(String id, String rating, String msg, String time, String restroId) {
        this.id = id;
        this.rating = rating;
        this.msg = msg;
        this.time = time;
        this.restroId = restroId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRestroId() {
        return restroId;
    }

    public void setRestroId(String restroId) {
        this.restroId = restroId;
    }
}
