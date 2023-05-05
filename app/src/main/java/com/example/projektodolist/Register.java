package com.example.projektodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Register extends AppCompatActivity implements View.OnClickListener{

    private ImageButton Back;
    private Button Register;
    private EditText Username, Email, Phone, Pass, ConfPass ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Back = (ImageButton) findViewById(R.id.imgbtn_backcreate);
        Register = (Button) findViewById(R.id.btn_register);
        Username = (EditText) findViewById(R.id.edt_username);
        Email = (EditText) findViewById(R.id.edt_email);
        Phone = (EditText) findViewById(R.id.edt_phone);
        Pass = (EditText) findViewById(R.id.edt_pass);
        ConfPass = (EditText) findViewById(R.id.edt_confpass);

        Back.setOnClickListener(this);
        Register.setOnClickListener(this);
        Username.setOnClickListener(this);
        Email.setOnClickListener(this);
        Phone.setOnClickListener(this);
        Pass.setOnClickListener(this);
        ConfPass.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        if (view.getId() == R.id.imgbtn_backcreate){
            i = new Intent(this, Login.class);
            startActivity(i);
        }
        if (view.getId() == R.id.btn_register){
            i = new Intent(this, Beranda.class);
            startActivity(i);
        }
    }
}