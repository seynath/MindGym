package com.example.mindgym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.mindgym.databinding.ActivityHomeBinding;


public class Home extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomnavigation.setOnItemSelectedListener(item ->{

            if (item.getItemId() == R.id.home1) {
                replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.audio2) {
                replaceFragment(new AudioFragment());
            } else if (item.getItemId() == R.id.video3) {
                replaceFragment(new VideoFragment());
            } else if (item.getItemId() == R.id.activity4) {
                replaceFragment(new ActivityFragment());
            } else if (item.getItemId() == R.id.settings5) {
                replaceFragment(new SettingsFragment());
            } else {
                // Handle invalid item ID
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}