package com.example.projektodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile extends AppCompatActivity implements View.OnClickListener{
    private GoogleSignInOptions gso;
    private GoogleSignInClient gsc;
    private TextView Name, Email, Phone;
    private ImageButton Back;

    private CircleImageView ppUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Name = (TextView) findViewById(R.id.tv_nameprofile);
        Email = (TextView) findViewById(R.id.tv_emailprofile);
        Back = (ImageButton) findViewById(R.id.imgbtn_backprofile);

        Name.setOnClickListener(this);
        Email.setOnClickListener(this);
        Back.setOnClickListener(this);

        ppUser = findViewById(R.id.ppuser);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        String userId = "0";
        if(acct!=null){
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            String ppUrl = acct.getPhotoUrl().toString();
            Name.setText(personName);
            Email.setText(personEmail);
            Picasso.get().load(ppUrl).into(ppUser);

        }


    }

    @Override
    public void onClick(View view) {
        Intent i;

        if (view.getId() == R.id.imgbtn_backprofile){
            i = new Intent(this, Beranda.class);
            startActivity(i);
        }


    }
}