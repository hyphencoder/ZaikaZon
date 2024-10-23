package com.hyphencoder.zaikazon.Model;

public class RestroModel2 {
    String id, name, desc, location, imageUrl, time,categoryId;


    public RestroModel2() {
    }

    public RestroModel2(String id, String name, String desc, String location, String imageUrl, String time, String categoryId) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.location = location;
        this.imageUrl = imageUrl;
        this.time = time;
        this.categoryId = categoryId;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
