package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText username_input, password_input;

    String[] user = {
            "admin", "admin", "Ikhsan Heriyawan"
    };
    String username, password;
    SharedPreferences.Editor setData;
    SharedPreferences getData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setData = getSharedPreferences("user", MODE_PRIVATE).edit();
        login = findViewById(R.id.login);
        username_input = findViewById(R.id.username_input);
        password_input = findViewById(R.id.password_input);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = username_input.getText().toString();
                password = password_input.getText().toString();

                if (username.equals(user[0]) && password.equals(user[1])) {
                    setData.putString("USERNAME", username);
                    setData.putString("NAME", user[2]);
                    setData.apply();
                    Toast.makeText(getApplicationContext(),
                            "Login Success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), Dashboard.class));
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}