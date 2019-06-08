package com.example.upclubapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModeActivity extends AppCompatActivity {

    Button _buttonPatient;
    Button _buttonVolunteer;
    Button _buttonOrganization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        _buttonPatient = findViewById(R.id.buttonPatient);
        _buttonVolunteer = findViewById(R.id.buttonVolunteer);
        _buttonOrganization = findViewById(R.id.buttonOrganization);

        _buttonPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginActivity();
            }
        });

        _buttonVolunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginActivity();
            }
        });

        _buttonOrganization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginActivity();
            }
        });
    }

    private void openLoginActivity() {
        Intent intent = new Intent(ModeActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
