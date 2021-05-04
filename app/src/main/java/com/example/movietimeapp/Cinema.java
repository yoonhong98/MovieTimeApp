package com.example.movietimeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Cinema extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema);
        setTitle("Cinema");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cinema");

        BottomNavigationView btm_nav = findViewById(R.id.btm_nav_bar);
        btm_nav.setSelectedItemId(R.id.navigation_cinema);
        btm_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        startActivity(new Intent(getApplicationContext(), Homepage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_cinema:
                        return true;
                    case R.id.navigation_profile:
                        startActivity(new Intent(getApplicationContext(), Account.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_contact_us:
                        startActivity(new Intent(getApplicationContext(), Contact_us.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        String cinema_name[] ={"TGV KUANTAN", "TGV KL", "TGV AMAN SETIA"};
        Integer photo[] = {
                R.drawable.tom_and_jerry,
                R.drawable.godzilla_vs_kong,
                R.drawable.border
        };
        String cinema_hall[]={"HALL 1", "HALL 2", "HALL 3"};

        CinemaAdapter cinemaAdapter = new CinemaAdapter(Cinema.this, photo, cinema_name, cinema_hall);
        ListView cinema_list = findViewById(R.id.cinemaList);
        cinema_list.setAdapter(cinemaAdapter);


    }
}