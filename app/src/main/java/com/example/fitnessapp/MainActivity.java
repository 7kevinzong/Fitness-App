package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    FrameLayout frameLayout;

    private HomeFragment homeFragment;
    private ExercisesFragment exercisesFragment;
    private CalendarFragment calendarFragment;
    private SettingsFragment settingsFragment;
    private ProgressFragment progressFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNavigationView);
        frameLayout = findViewById(R.id.frameLayout);

        homeFragment = new HomeFragment();
        exercisesFragment = new ExercisesFragment();
        calendarFragment = new CalendarFragment();
        settingsFragment = new SettingsFragment();
        progressFragment = new ProgressFragment();

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){

                    case R.id.navigation_calendar:
                        InitializeFragment(calendarFragment);
                        return true;

                    case R.id.navigation_exercises:
                        InitializeFragment(exercisesFragment);
                        return true;

                    case R.id.navigation_home:
                        InitializeFragment(homeFragment);
                        return true;

                    case R.id.navigation_progress:
                        InitializeFragment(progressFragment);
                        return true;

                    case R.id.navigation_settings:
                        InitializeFragment(settingsFragment);
                        return true;

                }

                return false;
            }
        });
    }

    private void InitializeFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
