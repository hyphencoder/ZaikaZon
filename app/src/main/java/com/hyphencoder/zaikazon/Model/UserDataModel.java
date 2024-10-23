package com.hyphencoder.zaikazon.Model;

public class UserDataModel {

    String name, email, number, password, cpassword;

    public UserDataModel() {
    }

    public UserDataModel(String name, String email, String number, String password, String cpassword) {
        this.cpassword = cpassword;
        this.password = password;
        this.number = number;
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }
}
