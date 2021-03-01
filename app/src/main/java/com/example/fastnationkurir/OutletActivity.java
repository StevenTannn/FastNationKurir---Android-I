package com.example.fastnationkurir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class OutletActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private OutletAdapter outletAdapter;
    private ArrayList<Outlet> ArrOutlet;
    private ArrayList<User> SessionUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outlet);
        Intent intent = getIntent();
        SessionUser = intent.getParcelableArrayListExtra("sessionData");
        getData();

        recyclerView = findViewById(R.id.list_outlet);

        outletAdapter = new OutletAdapter(ArrOutlet);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(OutletActivity.this);

        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(outletAdapter);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        Intent intent = new Intent(OutletActivity.this,MainActivity.class);
                        intent.putParcelableArrayListExtra("sessionData",SessionUser);
                        startActivity(intent);
                        break;
                    case R.id.action_cekresi:
                        Intent intent1 = new Intent(OutletActivity.this,CekresiActivity.class);
                        intent1.putParcelableArrayListExtra("sessionData",SessionUser);
                        startActivity(intent1);
                        break;
                }
                return true;
            }
        });
    }
    public void getData(){
        ArrOutlet = new ArrayList<>();
        ArrOutlet.add(new Outlet("Klambir V","Kelas","Medan"));
        ArrOutlet.add(new Outlet("Tanjung Gusta","Kelas","Jakarta"));
        ArrOutlet.add(new Outlet("Medan Kota","Kelas","Surabaya"));
        ArrOutlet.add(new Outlet("Medan Selatan","Kelas","Medan"));
        ArrOutlet.add(new Outlet("Medan Utara","Kelas","Medan"));
        ArrOutlet.add(new Outlet("Medan Medan","Kelas","Medan"));
        ArrOutlet.add(new Outlet("Klambir V","Kelas","Medan"));
        ArrOutlet.add(new Outlet("Tanjung Gusta","Kelas","Jakarta"));
        ArrOutlet.add(new Outlet("Medan Kota","Kelas","Surabaya"));
        ArrOutlet.add(new Outlet("Medan Selatan","Kelas","Medan"));
        ArrOutlet.add(new Outlet("Medan Utara","Kelas","Medan"));
        ArrOutlet.add(new Outlet("Medan Medan","Kelas","Medan"));
        ArrOutlet.add(new Outlet("Klambir V","Kelas","Medan"));
        ArrOutlet.add(new Outlet("Tanjung Gusta","Kelas","Jakarta"));
        ArrOutlet.add(new Outlet("Medan Kota","Kelas","Surabaya"));
        ArrOutlet.add(new Outlet("Medan Selatan","Kelas","Medan"));
        ArrOutlet.add(new Outlet("Medan Utara","Kelas","Medan"));
        ArrOutlet.add(new Outlet("Medan Medan","Kelas","Medan"));
        ArrOutlet.add(new Outlet("Klambir V","Kelas","Medan"));
        ArrOutlet.add(new Outlet("Tanjung Gusta","Kelas","Jakarta"));
        ArrOutlet.add(new Outlet("Medan Kota","Kelas","Surabaya"));
        ArrOutlet.add(new Outlet("Medan Selatan","Kelas","Medan"));
        ArrOutlet.add(new Outlet("Medan Utara","Kelas","Medan"));
        ArrOutlet.add(new Outlet("Medan Medan","Kelas","Medan"));

    }
}