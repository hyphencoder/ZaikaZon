package com.hyphencoder.zaikazon.Model;

public class TopRecyclerModel {
    String id,  name,  imageUrl,time;

    public TopRecyclerModel() {
    }

    public TopRecyclerModel(String id, String name, String imageUrl, String time) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
