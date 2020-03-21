package com.android.mvp.presenter;

import com.android.mvp.model.User;
import com.android.mvp.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {
    ILoginView loginView;

    public LoginPresenter(ILoginView loginView){
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int loginCode = user.isValidData();

        if(loginCode == 0){
            loginView.onLoginError("You must enter your email");
        } else if(loginCode == 1) {
            loginView.onLoginError("You must enter valid email");
        } else if(loginCode == 2) {
            loginView.onLoginError("Password lenght must be greater than 6");
        } else if(loginCode == 3) {
            loginView.onLoginSucces("Login Sukses");
        } else {
            loginView.onLoginError("Make sure your password is correct");
        }
    }

}
