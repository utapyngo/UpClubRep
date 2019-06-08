package com.example.upclubapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.example.upclubapp.R;
import com.example.upclubapp.view.fragment.ChatsFragment;

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
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment, new ChatsFragment())
                        .addToBackStack("chats")
                        .commit();
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
