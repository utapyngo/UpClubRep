package com.example.upclubapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements AHBottomNavigation.OnTabSelectedListener {

    @BindView(R.id.ahBottomNavigation)
    AHBottomNavigation ahBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initBottomNavigation();
    }

    private void initBottomNavigation() {
        AHBottomNavigationAdapter adapter =
                new AHBottomNavigationAdapter(this, R.menu.menu_bottom_navigaton);
        adapter.setupWithBottomNavigation(ahBottomNavigation);
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        switch (position) {
            case 0: {
                // TODO: Market
                break;
            }
            case 1: {
                // TODO: Chats
                break;
            }
            case 2: {
                // TODO: Profile
                break;
            }
        }
        return true;
    }
}
