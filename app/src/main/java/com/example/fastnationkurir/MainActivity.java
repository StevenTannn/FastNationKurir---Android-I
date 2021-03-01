package com.example.fastnationkurir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<User> SessionUser;
    ArrayList<Resi> DataSessionResiUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        SessionUser = intent.getParcelableArrayListExtra("sessionData");
        DataSessionResiUser = intent.getParcelableArrayListExtra("DataSessionResi");
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("sessionData", SessionUser);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(bundle);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, new HomeFragment());
        ft.commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        FragmentManager fm1 = getSupportFragmentManager();
                        FragmentTransaction ft1 = fm1.beginTransaction();
                        ft1.replace(R.id.container, new HomeFragment());
                        ft1.commit();
                        break;
                    case R.id.action_myresi:
                        Bundle b = new Bundle();
                        b.putParcelableArrayList("DataSessionResi", DataSessionResiUser);
                        MyresiFragment f = new MyresiFragment();
                        f.setArguments(b);
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.container, new MyresiFragment());
                        ft.commit();
                        break;
                    case R.id.action_cekresi:
                        Intent intent1 = new Intent(MainActivity.this, CekresiActivity.class);
                        intent1.putParcelableArrayListExtra("sessionData", SessionUser);
                        startActivity(intent1);
                        break;
                    case R.id.action_rates:
                        FragmentManager fm2 = getSupportFragmentManager();
                        FragmentTransaction ft2 = fm2.beginTransaction();
                        ft2.replace(R.id.container, new RatesFragment());
                        ft2.commit();
                        break;
                    case R.id.action_profile:
                        FragmentManager fm3 = getSupportFragmentManager();
                        FragmentTransaction ft3 = fm3.beginTransaction();
                        ft3.replace(R.id.container, new ProfileFragment());
                        ft3.commit();
                        break;
                }
                return true;
            }
        });
    }
}

