package com.hyphencoder.zaikazon.Model;

public class FavModel {

    String uniqueId, userId, restroId;


    public FavModel() {
    }

    public FavModel(String uniqueId, String userId, String restroId) {
        this.uniqueId = uniqueId;
        this.userId = userId;
        this.restroId = restroId;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRestroId() {
        return restroId;
    }

    public void setRestroId(String restroId) {
        this.restroId = restroId;
    }
}
