package com.example.upclubapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.upclubapp.R;
import com.example.upclubapp.UpClubApp;
import com.example.upclubapp.api.dto.UserDto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        UpClubApp.getInstance().getApiService().getUserById(1).enqueue(new Callback<UserDto>() {
            @Override
            public void onResponse(Call<UserDto> call, Response<UserDto> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(ModeActivity.this, response.body().getEmail(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserDto> call, Throwable t) {
                Log.e("Api", t.toString());
                Toast.makeText(ModeActivity.this, "Error!", Toast.LENGTH_LONG).show();
            }
        });

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
