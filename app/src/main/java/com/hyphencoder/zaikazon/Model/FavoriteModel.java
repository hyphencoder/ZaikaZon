package com.hyphencoder.zaikazon.Model;

public class FavoriteModel {

    String img, favoritebtn, restroname, restrodis, restrolocation;

    public FavoriteModel() {
    }

    public FavoriteModel(String img, String favoritebtn, String restroname, String restrodis, String restrolocation) {
        this.img = img;
        this.favoritebtn = favoritebtn;
        this.restroname = restroname;
        this.restrodis = restrodis;
        this.restrolocation = restrolocation;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getFavoritebtn() {
        return favoritebtn;
    }

    public void setFavoritebtn(String favoritebtn) {
        this.favoritebtn = favoritebtn;
    }

    public String getRestroname() {
        return restroname;
    }

    public void setRestroname(String restroname) {
        this.restroname = restroname;
    }

    public String getRestrodis() {
        return restrodis;
    }

    public void setRestrodis(String restrodis) {
        this.restrodis = restrodis;
    }

    public String getRestrolocation() {
        return restrolocation;
    }

    public void setRestrolocation(String restrolocation) {
        this.restrolocation = restrolocation;
    }
}