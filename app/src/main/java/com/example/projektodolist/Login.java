package com.example.projektodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private Button SignIn, CreateAccount;
    private EditText Username, Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SignIn = (Button) findViewById(R.id.btn_signin);
        CreateAccount = (Button) findViewById(R.id.btn_createaccount);
        Username = (EditText) findViewById(R.id.edt_username);
        Pass = (EditText) findViewById(R.id.edt_pass);

        SignIn.setOnClickListener(this);
        CreateAccount.setOnClickListener(this);
        Username.setOnClickListener(this);
        Pass.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
    Intent i;
        if (view.getId() == R.id.btn_createaccount){
            i = new Intent(this, Register.class);
            startActivity(i);
        }

        if (view.getId() == R.id.btn_signin){
            i = new Intent(this, Beranda.class);
            startActivity(i);
        }
    }
}
