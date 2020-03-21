package com.android.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.mvp.presenter.ILoginPresenter;
import com.android.mvp.presenter.LoginPresenter;
import com.android.mvp.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    EditText etEmail, etPassword;
    Button btnLogin;

    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        loginPresenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                loginPresenter.onLogin(email, password);
            }
        });
    }
    @Override
    public void onLoginSucces(String message) {
        String emails = etEmail.getText().toString();
        String passwords = etPassword.getText().toString();
        Toast.makeText(getApplicationContext(), message + emails, Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putString("EMAIL", emails);
        bundle.putString("PASSWORD", passwords);
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        i.putExtras(bundle);
        startActivity(i);
        finish();
    }

    @Override
    public void onLoginError(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}