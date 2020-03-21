package com.android.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvEmail, tvPassword;
    Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEmail = findViewById(R.id.main_name);
        tvPassword = findViewById(R.id.main_password);
        btnKembali = findViewById(R.id.btn_back);

        Bundle bundle = getIntent().getExtras();
        tvEmail.setText(bundle.getString("EMAIL"));
        tvPassword.setText(bundle.getString("PASSWORD"));

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
