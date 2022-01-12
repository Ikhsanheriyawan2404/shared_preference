package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    SharedPreferences getData;
    TextView name;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        getData = getSharedPreferences("user", MODE_PRIVATE);
        name = findViewById(R.id.name);
        logout = findViewById(R.id.logout);

        if(getData.contains("USERNAME")) {
            name.setText(getData.getString("NAME", null));
        } else {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData.edit().clear().commit();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
    }
}