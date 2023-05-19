package com.example.projektodolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Beranda extends AppCompatActivity implements View.OnClickListener{
    private TextView Nama;
    private ImageButton Profile;
    private Button AddTask;
    private RecyclerView recyclerView;
    private ArrayList<Task> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerViewTasksList);
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(TaskData.getListData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CardViewTaskAdapter cardViewTaskAdapter= new CardViewTaskAdapter(this);
        cardViewTaskAdapter.setTaskList(list);
        recyclerView.setAdapter(cardViewTaskAdapter);

        Nama = (TextView) findViewById(R.id.tv_name);
        Profile = (ImageButton) findViewById(R.id.imgbtn_profile);
        AddTask = (Button) findViewById(R.id.btn_addtask);

        Nama.setOnClickListener(this);
        Profile.setOnClickListener(this);
        AddTask.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        if (view.getId() == R.id.imgbtn_profile){
            i = new Intent(this, Profile.class);
            startActivity(i);
        }

        if (view.getId() == R.id.btn_addtask) {
            i = new Intent(this, AddTask.class);
            startActivity(i);
        }

    }
}