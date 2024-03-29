package com.example.upclubapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.example.upclubapp.R;
import com.example.upclubapp.view.fragment.ChatsFragment;
import com.example.upclubapp.view.fragment.MarketFragment;

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
        ahBottomNavigation.setOnTabSelectedListener(this);
        ahBottomNavigation.setAccentColor(getResources().getColor(R.color.colorPrimary));
        ahBottomNavigation.setCurrentItem(0);
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        switch (position) {
            case 0: {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment, new MarketFragment())
                        .addToBackStack("market")
                        .commit();
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
