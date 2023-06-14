package com.example.projektodolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddTask extends AppCompatActivity implements View.OnClickListener{

    private ImageButton Back;
    private Button Add;
    private EditText Name, Desc, DeadLine;

    private List<TaskObject> list;

    private FirebaseFirestore db;



    TaskData tasks = new TaskData();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        Add = (Button) findViewById(R.id.btn_add);
        Back = (ImageButton) findViewById(R.id.imgbtn_backtask);
        Name = (EditText) findViewById(R.id.edt_name);
        Desc = (EditText) findViewById(R.id.edt_description);
        DeadLine = (EditText) findViewById(R.id.edt_deadline);

        Add.setOnClickListener(this);
        Back.setOnClickListener(this);
        DeadLine.setOnClickListener(this);
        Name.setOnClickListener(this);
        Desc.setOnClickListener(this);
    }

    public void saveTask(){
        String nama = Name.getText().toString().trim();
        String desc = Desc.getText().toString().trim();
        String deadline = DeadLine.getText().toString().trim();
        db = FirebaseFirestore.getInstance();


        Map<String, Object> masukTask = new HashMap<>();
        masukTask.put("nama", nama);
        masukTask.put("deskripsi", desc);
        masukTask.put("deadline", deadline);
        db.collection("task").add(masukTask).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(AddTask.this, "Berhasil Masuk", Toast.LENGTH_SHORT).show();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddTask.this, "Gagal Masuk", Toast.LENGTH_SHORT).show();

                    }
                });




    }

    @Override
    public void onClick(View view) {
        Intent i;
        if (view.getId() == R.id.btn_add) {
            saveTask();
//            String nama = Name.getText().toString().trim();
//            String desc = Desc.getText().toString().trim();
//            String deadline = DeadLine.getText().toString().trim();
//
//            Task task = new Task();
//
//            String[][] add = new String[][]{
//                    {deadline,nama, desc}
//            };
//
//            TaskData.setData(add);
////            list.add(task);
            i = new Intent(this, Beranda.class);
            startActivity(i);
        }

        if (view.getId() == R.id.imgbtn_backtask){
            i = new Intent(this, Beranda.class);
            startActivity(i);
        }
    }


}