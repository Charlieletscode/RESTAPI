package com.example.userlogin;

import static com.example.userlogin.MainActivity.mAuth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class profile extends AppCompatActivity {

    GoogleApiClient mGoogleApiClient;
    Button scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        scan = (Button) findViewById(R.id.scan);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(profile.this);
                intentIntegrator.setPrompt("Use volume up key for Flash on/ volume down key for flash off");
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setCaptureActivity(Barscanner.class);
                intentIntegrator.initiateScan();
            }
        });

        FirebaseUser currentUser = mAuth.getCurrentUser();

        TextView idtxt =(TextView)findViewById(R.id.id_txt);
        TextView nametxt =(TextView)findViewById(R.id.name_txt);
        TextView email =(TextView)findViewById(R.id.email_txt);

        idtxt.setText("xz2134dsffa");
        nametxt.setText("Charlie Chung");
        email.setText("charliechung88@gmail.com");

        Button next = (Button)findViewById(R.id.sign_out_btn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(profile.this, "next", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent((Context)profile.this, Barscanner.class);
                profile.this.startActivity(intent);
                profile.this.finish();
            }
        });

        Button sout = (Button)findViewById(R.id.sign_out_btn);

        sout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();

                Toast.makeText(profile.this, "here", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent((Context)profile.this, login.class);
                profile.this.startActivity(intent);
                profile.this.finish();
            }
        });
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,
                resultCode, data);
        // test if the content is not null :

        if (intentResult.getContents() != null){
            AlertDialog.Builder builder = new AlertDialog.Builder(profile.this);
            builder.setTitle("Results");
            builder.setMessage(intentResult.getContents());
            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        } else {
            Toast.makeText(this, "scan anything ! ", Toast.LENGTH_SHORT).show();
        }

    }
}