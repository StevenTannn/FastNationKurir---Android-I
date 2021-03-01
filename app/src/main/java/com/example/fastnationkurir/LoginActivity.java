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

public class LoginActivity extends AppCompatActivity {
    ArrayList<User> ArrUser;
    ArrayList<User> SessionUser = new ArrayList<>();
    private TextView tvSignupnow;
    private Button btnLogin;
    private EditText etEmail,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent = getIntent();
        ArrUser = intent.getParcelableArrayListExtra("myData");
        TextView tvSignupnow = findViewById(R.id.tv_signupnow);
        tvSignupnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SignupActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        EditText etEmail = findViewById(R.id.et_email);
        EditText etPassword = findViewById(R.id.et_password);
        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ArrUser == null){
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("You have to register first")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                    Intent intent = new Intent(v.getContext(), SignupActivity.class);
                                    v.getContext().startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                else{
                    validate(etEmail.getText().toString(), etPassword.getText().toString());
                }
            }
        });
    }
    private void validate(String valEmail, String valPassword) {
        for (int idx = 0; idx < ArrUser.size();idx++){
            String UserEmail = ArrUser.get(idx).getEmail();
            String UserPassword = ArrUser.get(idx).getPassword();
            String UserName = ArrUser.get(idx).getName();
            if (valEmail.equals(UserEmail) && valPassword.equals(UserPassword)) {
                saveData(UserEmail,UserName,UserPassword);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putParcelableArrayListExtra("sessionData",SessionUser);
                startActivity(intent);
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("You password and username are not match")
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
    private void saveData(String email,String name, String password){
        SessionUser.add(new User(email,name,password));
    }
}