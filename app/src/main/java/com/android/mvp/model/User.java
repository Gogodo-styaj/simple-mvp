package com.android.mvp.model;

import android.text.TextUtils;
import android.util.Patterns;

public class User implements IUser {

    String email, password;

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Integer isValidData() {
        if(TextUtils.isEmpty(getEmail())){
            return 0;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()) {
            return 1;
        } else if (getPassword().length() <= 6) {
            return 2;
        } else if (getEmail().equalsIgnoreCase("gogodo@gmail.com") && password.equalsIgnoreCase("jkt58hard")) {
            return 3;
        }else {
            return -1;
        }
    }
}
