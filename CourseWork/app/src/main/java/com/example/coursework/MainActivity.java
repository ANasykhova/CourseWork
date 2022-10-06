package com.example.coursework;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

    }
    AddFragment addFragment = new AddFragment();
    NotificationsFragment notificationsFragment = new NotificationsFragment();
    HomeFragment homeFragment = new HomeFragment();
    MapFragment mapFragment = new MapFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navigation_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                return true;

            case R.id.navigation_notifications:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, notificationsFragment).commit();
                return true;

            case R.id.navigation_map:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, mapFragment).commit();
                return true;

            case R.id.navigation_add:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, addFragment).commit();
                return true;
        }
        return false;
    }

}