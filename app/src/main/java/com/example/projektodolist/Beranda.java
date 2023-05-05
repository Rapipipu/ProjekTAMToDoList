package com.example.projektodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Beranda extends AppCompatActivity implements View.OnClickListener{
    private TextView Nama;
    private ImageButton Profile, AddCategory, AddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        Nama = (TextView) findViewById(R.id.tv_name);
        Profile = (ImageButton) findViewById(R.id.imgbtn_profile);
        AddCategory = (ImageButton) findViewById(R.id.imgbtn_addcategory);
        AddTask = (ImageButton) findViewById(R.id.imgbtn_addtask);

        Nama.setOnClickListener(this);
        Profile.setOnClickListener(this);
        AddCategory.setOnClickListener(this);
        AddTask.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        if (view.getId() == R.id.imgbtn_profile){
            i = new Intent(this, Profile.class);
            startActivity(i);
        }

        if (view.getId() == R.id.imgbtn_addcategory) {
            i = new Intent(this, AddCategory.class);
            startActivity(i);
        }

        if (view.getId() == R.id.imgbtn_addtask) {
            i = new Intent(this, AddTask.class);
            startActivity(i);
        }

    }
}