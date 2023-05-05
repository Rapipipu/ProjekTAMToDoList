package com.example.projektodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AddCategory extends AppCompatActivity implements View.OnClickListener{

    private ImageButton Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        Back = (ImageButton) findViewById(R.id.imgbtn_backcategory);

        Back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        if (view.getId() == R.id.imgbtn_backcategory){
            i = new Intent(this, Beranda.class);
            startActivity(i);
        }

    }
}