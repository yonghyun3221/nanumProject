package com.example.nanum;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    private FragmentManager fm;
    private FragmentTransaction ft;

    SocialTabFragment socialTabFragment = new SocialTabFragment();
    ChatTabFragment chatTabFragment = new ChatTabFragment();
    ProfileTabFragment profileTabFragment = new ProfileTabFragment();
    HomeTabFragment homeTabFragment = new HomeTabFragment();

    private void replaceFragment(Fragment fragment){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.frame_layout, fragment).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setBackground(null);
        //bottomNavigationView.getMenu().getItem(2).setEnabled(false); //floatingbutton 빈공간 설정
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        replaceFragment(homeTabFragment);
                        break;
                    case R.id.social:
                        replaceFragment(socialTabFragment);
                        break;
                    case R.id.chat:
                        replaceFragment(chatTabFragment);
                        break;
                    case R.id.profile:
                        replaceFragment(profileTabFragment);
                        break;
                }

                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.home);
    }

}


