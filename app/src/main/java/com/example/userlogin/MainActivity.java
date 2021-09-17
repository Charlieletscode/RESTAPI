package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    static FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();
        final Runnable r = new Runnable() {
            public final void run() {
                Intent dashboardIntent;
                if (user != null) {
                    dashboardIntent = new Intent((Context)MainActivity.this, profile.class);
                    MainActivity.this.startActivity(dashboardIntent);
                    MainActivity.this.finish();
                } else {
                    dashboardIntent = new Intent((Context)MainActivity.this, login.class);
                    MainActivity.this.startActivity(dashboardIntent);
                    MainActivity.this.finish();
                }
    }
        };final Handler handler = new Handler();
        handler.postDelayed(r, 1000);
    }
}