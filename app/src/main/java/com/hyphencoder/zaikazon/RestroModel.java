package com.hyphencoder.zaikazon;

public class RestroModel {

   String img;
   String restoname;
   String address;


    public RestroModel(String img, String restoname, String address) {
        this.img = img;
        this.restoname = restoname;
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRestoname() {
        return restoname;
    }

    public void setRestoname(String restoname) {
        this.restoname = restoname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
