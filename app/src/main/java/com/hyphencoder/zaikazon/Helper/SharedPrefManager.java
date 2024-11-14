package com.hyphencoder.zaikazon.Helper;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import com.hyphencoder.zaikazon.Model.UserDataModel;

public class SharedPrefManager {

    private  static final String SHARED_PREF_NAME="zaikazon";
    private  static final String KEY_ID="id";
    private  static final String KEY_NAME="name";
    private  static final String KEY_EMAIL="email";
    private  static final String KEY_NUMBER="number";
    private  static final String KEY_PASSWORD="password";
    private  static final String KEY_ADDRESS="address";

    Context context;

    private static SharedPrefManager instance;

    public SharedPrefManager(Context context) {
        this.context = context;
    }
    public static synchronized SharedPrefManager getInstance(Context context){
        if(instance==null){
             instance=new SharedPrefManager(context);
        }
        return instance;
    }




    public void setUser(UserDataModel user){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(KEY_ID,user.getId());
        editor.putString(KEY_NAME, user.getName());
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.putString(KEY_NUMBER, user.getNumber());
        editor.putString(KEY_PASSWORD, user.getPassword());
        editor.putString(KEY_ADDRESS, user.getAddress());
        editor.apply();
        editor.commit();

    }

    public UserDataModel getUser(){

        SharedPreferences sharedPreferences= context.getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        UserDataModel userDataModel=new UserDataModel(
                sharedPreferences.getString(KEY_ID,""),
                sharedPreferences.getString(KEY_NAME,""),
                sharedPreferences.getString(KEY_EMAIL,""),
                sharedPreferences.getString(KEY_NUMBER,""),
                sharedPreferences.getString(KEY_PASSWORD,""),
                sharedPreferences.getString(KEY_ADDRESS,"")

        );
        return userDataModel;

    }

    public boolean checkUserLogin(){
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String email= sharedPreferences.getString(KEY_EMAIL,"");

        if(email.equalsIgnoreCase("")){
            return false;
        }else {
            return true;
        }
    }

    public void logout(){
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.clear();
        editor.apply();
        editor.commit();
    }
}
