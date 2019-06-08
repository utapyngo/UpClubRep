package com.example.upclubapp.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.upclubapp.R;
import com.example.upclubapp.model.Event;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddNewEventActivity extends AppCompatActivity {

    @BindView(R.id.etTitle)
    EditText etTitle;

    @BindView(R.id.etDescription)
    EditText etDescription;

    @BindView(R.id.etAddress)
    EditText etAddress;

    @BindView(R.id.spinnerSkills)
    Spinner spinnerSkills;

    @BindView(R.id.btnAdd)
    Button btnAdd;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_event);

        ButterKnife.bind(this);

        progressBar.setVisibility(View.INVISIBLE);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.btnAdd)
    void onClick() {
        if (!etTitle.getText().toString().equals("") && !etDescription.getText().toString().equals("")
        && !etAddress.getText().toString().equals("")) {
            progressBar.setVisibility(View.VISIBLE);
            btnAdd.setVisibility(View.INVISIBLE);

            DocumentReference dr = FirebaseFirestore.getInstance().collection("events")
                    .document();

            Event event = new Event();
            event.setId(dr.getId());
            event.setTitle(etTitle.getText().toString());
            event.setDescription(etDescription.getText().toString());
            event.setAddress(etAddress.getText().toString());
            event.setSkill("skill");

            dr.set(event).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(AddNewEventActivity.this, "Успешно добавлено!",
                            Toast.LENGTH_LONG).show();
                    onBackPressed();
                }
            }).addOnFailureListener(e -> {
                progressBar.setVisibility(View.INVISIBLE);
                btnAdd.setVisibility(View.VISIBLE);
            });
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
