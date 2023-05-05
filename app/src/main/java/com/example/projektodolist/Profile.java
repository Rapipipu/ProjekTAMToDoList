package com.example.projektodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Profile extends AppCompatActivity implements View.OnClickListener{
    private TextView Name, Email, Phone;
    private ImageButton Back;
    private Button CompletedTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Name = (TextView) findViewById(R.id.tv_nameprofile);
        Email = (TextView) findViewById(R.id.tv_emailprofile);
        Phone = (TextView) findViewById(R.id.tv_phoneprofile);
        Back = (ImageButton) findViewById(R.id.imgbtn_backprofile);
        CompletedTask = (Button) findViewById(R.id.btn_completedtask);

        Name.setOnClickListener(this);
        Email.setOnClickListener(this);
        Phone.setOnClickListener(this);
        Back.setOnClickListener(this);
        CompletedTask.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent i;

        if (view.getId() == R.id.imgbtn_backprofile){
            i = new Intent(this, Beranda.class);
            startActivity(i);
        }

        if (view.getId() == R.id.btn_completedtask){
            i = new Intent(this, CompletedTask.class);
            startActivity(i);
        }


    }
}