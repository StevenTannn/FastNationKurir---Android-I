package com.example.fastnationkurir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class CekresiActivity extends AppCompatActivity {

    ArrayList<Resi> listResi;
    ArrayList<Resi> SessionResi = new ArrayList<>();
    ArrayList<User> SessionUser;

    private Button btnCekResi;
    private EditText etNoResi;
    public boolean adaresi = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cekresi);
        Intent intent = getIntent();
        SessionUser = intent.getParcelableArrayListExtra("sessionData");
        getData();
        btnCekResi = findViewById(R.id.btn_cekresi);
        etNoResi = findViewById(R.id.et_noresi);
        btnCekResi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
                validate(etNoResi.getText().toString());
            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation1);
        bottomNavigationView.setSelectedItemId(R.id.action_cekresi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        Intent intent = new Intent(CekresiActivity.this,MainActivity.class);
                        intent.putParcelableArrayListExtra("sessionData",SessionUser);
                        startActivity(intent);
                        break;
                    case R.id.action_myresi:
                        Intent intent2 = new Intent(CekresiActivity.this,MainActivity.class);
                        intent2.putParcelableArrayListExtra("sessionData",SessionUser);
                        startActivity(intent2);
                        break;
                    case R.id.action_cekresi:
                        Intent intent1 = new Intent(CekresiActivity.this,CekresiActivity.class);
                        intent1.putParcelableArrayListExtra("sessionData",SessionUser);
                        startActivity(intent1);
                        break;
                    case R.id.action_rates:
                        Intent intent3 = new Intent(CekresiActivity.this,MainActivity.class);
                        intent3.putParcelableArrayListExtra("sessionData",SessionUser);
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });
    }
    public void getData(){
        listResi = new ArrayList<>();
        listResi.add(new Resi("1","Gino","Mario","Medan","Jakarta","OnDelivery"));
        listResi.add(new Resi("2","Mario","Mario","Medan","Jakarta","OnDelivery"));
        listResi.add(new Resi("3","Andika","Mario","Medan","Jakarta","OnDelivery"));
    }
    private void saveData(String noresi, String namapengirim, String namapenerima, String kotaasal, String kotapenerima, String status){
        SessionResi.add(new Resi(noresi,namapengirim,namapenerima,kotaasal,kotapenerima,status));
    }
    private void validate(String valResi) {
        for (int idx = 0; idx < listResi.size();idx++){
            String UserResi = listResi.get(idx).getNoresi();
            String UserKotaAsal = listResi.get(idx).getKotaasal();
            String UserKotaPenerima = listResi.get(idx).getKotatujuan();
            String UserPengirim = listResi.get(idx).getNamapengirim();
            String UserPenerima = listResi.get(idx).getNamapenerima();
            String UserStatus = listResi.get(idx).getStatus();
            if (valResi.equals(UserResi)) {
                adaresi = true;
                saveData(UserResi,UserPengirim,UserPenerima,UserKotaAsal,UserKotaPenerima,UserStatus);
                Intent intent = new Intent(CekresiActivity.this, ShowresiActivity.class);
                intent.putParcelableArrayListExtra("DataResi",SessionResi);
                intent.putParcelableArrayListExtra("sessionData",SessionUser);
                startActivity(intent);
            }
        }
        if (adaresi == false) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Resi yang anda masukan tidak ada")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }

    }
}