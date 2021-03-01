package com.example.fastnationkurir;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<User> ArrUser = new ArrayList<>();
    private TextView tvLoginnow;
    private Button btnSignup;
    private EditText etEmail,etName,etPassword,etrePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        TextView tvLoginnow = findViewById(R.id.tv_loginnow);
        tvLoginnow.setOnClickListener(this);
        Button btnSignup = findViewById(R.id.btn_register);
        btnSignup.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_register) {
            EditText etEmail = findViewById(R.id.et_email);
            EditText etName = findViewById(R.id.et_name);
            EditText etPassword = findViewById(R.id.et_password);
            String Email = etEmail.getText().toString();
            String Name = etName.getText().toString();
            String Password = etPassword.getText().toString();
            saveData(Email,Name,Password);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You have to relogin after register")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(v.getContext(),LoginActivity.class);
                            intent.putParcelableArrayListExtra("myData",ArrUser);
                            v.getContext().startActivity(intent);
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        if(v.getId() == R.id.tv_loginnow) {
            Intent intent = new Intent(v.getContext(),LoginActivity.class);
            v.getContext().startActivity(intent);
        }
    }
    private void saveData(String email,String name, String password){
        ArrUser.add(new User(email,name,password));
    }
}