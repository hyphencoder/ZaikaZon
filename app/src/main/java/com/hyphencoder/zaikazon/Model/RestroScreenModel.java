package com.hyphencoder.zaikazon.Model;

public class RestroScreenModel {
    String img;
    String name;
    String time;
    String url;
    String txtreview;

    public RestroScreenModel(String img, String name, String time, String url, String txtreview) {
        this.img = img;
        this.name = name;
        this.time = time;
        this.url = url;
        this.txtreview = txtreview;
    }

    public RestroScreenModel() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTxtreview() {
        return txtreview;
    }

    public void setTxtreview(String txtreview) {
        this.txtreview = txtreview;
    }
}
