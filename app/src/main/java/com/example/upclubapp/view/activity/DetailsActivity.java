package com.example.upclubapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.upclubapp.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.tvDescription)
    TextView tvDescription;

    @BindView(R.id.tvAddress)
    TextView tvAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setTitle("Подробнее");

        tvTitle.setText(getIntent().getExtras().getString("title"));
        tvDescription.setText(getIntent().getExtras().getString("description"));
        tvAddress.setText(getIntent().getExtras().getString("address"));
    }
}
