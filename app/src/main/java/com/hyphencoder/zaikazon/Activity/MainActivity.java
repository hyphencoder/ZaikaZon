package com.hyphencoder.zaikazon.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hyphencoder.zaikazon.Fragment.FavoriteFragment;
import com.hyphencoder.zaikazon.Fragment.HomeFragment;
import com.hyphencoder.zaikazon.Fragment.ProfileFragment;
import com.hyphencoder.zaikazon.R;
import com.hyphencoder.zaikazon.Fragment.SearchFragment;

public class MainActivity extends AppCompatActivity {


   public static BottomNavigationView bottom_navigate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        bottom_navigate=findViewById(R.id.bottom_navigate);

        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container_view, new HomeFragment()).commit();

        bottom_navigate.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id= item.getItemId();
                if(id==R.id.home){
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container_view, new HomeFragment()).commit();
                }else if (id==R.id.search){
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container_view, new SearchFragment()).commit();
                } else if (id==R.id.favorite) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container_view, new FavoriteFragment()).commit();
                } else if (id==R.id.profile) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container_view, new ProfileFragment()).commit();
                }
                return  true;
            }
        });


    }
}