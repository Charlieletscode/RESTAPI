package com.example.userlogin;

import static com.example.userlogin.MainActivity.mAuth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class signout extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signout);

        FirebaseUser currentUser = mAuth.getCurrentUser();

        TextView idtxt =(TextView)findViewById(R.id.id_txt);
        TextView nametxt =(TextView)findViewById(R.id.name_txt);
        TextView email =(TextView)findViewById(R.id.email_txt);

        idtxt.setText("xz2134dsffa");
        nametxt.setText("Charlie Chung");
        email.setText("charliechung88@gmail.com");
        Button sout = (Button)findViewById(R.id.sign_out_btn);

        sout.setOnClickListener(view -> {
            mAuth.signOut();

            Toast.makeText(signout.this, "here", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent((Context)signout.this, login.class);
            signout.this.startActivity(intent);
            signout.this.finish();
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,
                resultCode, data);
        // test if the content is not null :

        if (intentResult.getContents() != null){
            AlertDialog.Builder builder = new AlertDialog.Builder(signout.this);
            builder.setTitle("Results");
            builder.setMessage(intentResult.getContents());
            builder.setNegativeButton("OK", (dialogInterface, i) -> dialogInterface.dismiss());
            builder.show();
        } else {
            Toast.makeText(this, "scan anything ! ", Toast.LENGTH_SHORT).show();
        }

    }
}
