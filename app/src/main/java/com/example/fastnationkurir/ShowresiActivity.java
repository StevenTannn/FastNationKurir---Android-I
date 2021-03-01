package com.example.fastnationkurir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ShowresiActivity extends AppCompatActivity {
    ArrayList<Resi> SessionResi;
    ArrayList<User> SessionUser;
    ArrayList<Resi> DataSessionResiUser = new ArrayList<>();
    private TextView tvNoResi, tvSender, tvReceiver, tvKotaAsal, tvKotaPenerima, tvStatus;
    Button btnHome, btnSaveresi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showresi);
        Intent intent = getIntent();
        SessionResi = intent.getParcelableArrayListExtra("DataResi");
        SessionUser = intent.getParcelableArrayListExtra("sessionData");
        String showNoResi = "";
        String showNamaPengirim = "";
        String showNamaPenerima = "";
        String showKotaAsal = "";
        String showKotaPenerima = "";
        String showStatus = "";
        if (SessionResi != null) {
            for (int idx = 0; idx < SessionResi.size(); idx++) {
                showNoResi = SessionResi.get(idx).getNoresi();
                showNamaPengirim = SessionResi.get(idx).getNamapengirim();
                showNamaPenerima = SessionResi.get(idx).getNamapenerima();
                showKotaAsal = SessionResi.get(idx).getKotaasal();
                showKotaPenerima = SessionResi.get(idx).getKotatujuan();
                showStatus = SessionResi.get(idx).getStatus();
            }
        }
        tvNoResi = findViewById(R.id.tv_resinoresi);
        tvNoResi.setText(showNoResi);
        tvSender = findViewById(R.id.tv_resinamapengirim);
        tvSender.setText(showNamaPengirim);
        tvReceiver = findViewById(R.id.tv_resinamapenerima);
        tvReceiver.setText(showNamaPenerima);
        tvKotaAsal = findViewById(R.id.tv_resikotaasal);
        tvKotaAsal.setText(showKotaAsal);
        tvKotaPenerima = findViewById(R.id.tv_resikotatujuan);
        tvKotaPenerima.setText(showKotaPenerima);
        tvStatus = findViewById(R.id.tv_resistatus);
        tvStatus.setText(showStatus);
        btnSaveresi = findViewById(R.id.btn_saveresi);
        String saveNoResi = showNoResi;
        String saveSender = showNamaPengirim;
        String saveReceiver = showNamaPenerima;
        String saveFrom = showKotaAsal;
        String saveTo = showKotaPenerima;
        String saveStatus = showStatus;
        btnSaveresi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ShowresiActivity.this);
                builder.setMessage("Data have been saved")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                saveData(saveNoResi, saveSender, saveReceiver, saveFrom, saveTo, saveStatus);
                                Intent intent = new Intent(v.getContext(), MainActivity.class);
                                intent.putParcelableArrayListExtra("sessionData", SessionUser);
                                intent.putParcelableArrayListExtra("DataSessionResi", DataSessionResiUser);
                                v.getContext().startActivity(intent);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_cekresi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Intent intent = new Intent(ShowresiActivity.this, MainActivity.class);
                        intent.putParcelableArrayListExtra("sessionData", SessionUser);
                        startActivity(intent);
                        break;
                    case R.id.action_myresi:
                        Intent intent2 = new Intent(ShowresiActivity.this, MainActivity.class);
                        intent2.putParcelableArrayListExtra("sessionData", SessionUser);
                        intent2.putParcelableArrayListExtra("DataSessionResi", DataSessionResiUser);
                        startActivity(intent2);
                        break;
                    case R.id.action_cekresi:
                        Intent intent1 = new Intent(ShowresiActivity.this, CekresiActivity.class);
                        intent1.putParcelableArrayListExtra("sessionData", SessionUser);
                        startActivity(intent1);
                        break;
                    case R.id.action_rates:
                        Intent intent3 = new Intent(ShowresiActivity.this, MainActivity.class);
                        intent3.putParcelableArrayListExtra("sessionData", SessionUser);
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });
    }
    private void saveData(String noresi, String namapengirim, String namapenerima, String kotaasal, String kotapenerima, String status) {
        DataSessionResiUser.add(new Resi(noresi, namapengirim, namapenerima, kotaasal, kotapenerima, status));
    }

}