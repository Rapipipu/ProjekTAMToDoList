package com.example.projektodolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Beranda extends AppCompatActivity implements View.OnClickListener{

    private GoogleSignInOptions gso;
    private GoogleSignInClient gsc;
    private TextView Nama;
    private CircleImageView Profile;
    private Button AddTask;
    private RecyclerView recyclerView;
    private ArrayList<TaskObject> list;

    private TaskViewAdapter tvadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        recyclerView = findViewById(R.id.recyclerViewTasksList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        tvadapter = new TaskViewAdapter(list);
        recyclerView.setAdapter(tvadapter);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference taskRef = db.collection("task");
        taskRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<TaskObject> taskObjectFetchedList = new ArrayList<>();

                for(QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                    String deadline = documentSnapshot.getString("deadline");
                    String desc = documentSnapshot.getString("deskripsi");
                    String nama = documentSnapshot.getString("nama");

                    TaskObject taskObject = new TaskObject(nama, desc, deadline);
                    taskObjectFetchedList.add(taskObject);

                }

                tvadapter.setListTask(taskObjectFetchedList);
                tvadapter.notifyDataSetChanged();
                Toast.makeText(Beranda.this, "Berhasil Menarik Dataa", Toast.LENGTH_SHORT).show();
            }
        });

        Nama = (TextView) findViewById(R.id.tv_name);
        Profile = (CircleImageView) findViewById(R.id.imgbtn_profile);
        AddTask = (Button) findViewById(R.id.btn_addtask);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestId().build();
        gsc = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        String userId = "0";
        if(acct!=null){
            String personName = acct.getDisplayName();
            String ppUrl = acct.getPhotoUrl().toString();
            Nama.setText("Hello, " + personName);
            Picasso.get().load(ppUrl).into(Profile);

        }

        Nama.setOnClickListener(this);
        Profile.setOnClickListener(this);
        AddTask.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        if(view.getId() == R.id.imgbtn_profile){
            i = new Intent(this, Profile.class);
            startActivity(i);
        }

        if (view.getId() == R.id.btn_addtask) {
            i = new Intent(this, AddTask.class);
            startActivity(i);
        }

    }
}