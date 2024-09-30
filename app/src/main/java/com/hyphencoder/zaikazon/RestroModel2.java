package com.hyphencoder.zaikazon;

public class RestroModel2 {
    String img;
    String restroname;
    String restrolocation;

    public RestroModel2(String img, String restroname, String restrolocation) {
        this.img = img;
        this.restroname = restroname;
        this.restrolocation = restrolocation;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRestroname() {
        return restroname;
    }

    public void setRestroname(String restroname) {
        this.restroname = restroname;
    }

    public String getRestrolocation() {
        return restrolocation;
    }

    public void setRestrolocation(String restrolocation) {
        this.restrolocation = restrolocation;
    }
}
