package com.example.ataufiq.popotoan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LandingActivity extends AppCompatActivity {

    TextInputLayout mEmail, mPassword;
    Button mDaftar, mMasuk;
    String email, password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        mAuth = FirebaseAuth.getInstance();

        mEmail = findViewById(R.id.et_email);
        mPassword = findViewById(R.id.et_password);
        mMasuk = findViewById(R.id.btn_masuk);
        mDaftar = findViewById(R.id.btn_daftar);

        mMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mEmail.getEditText().getText().toString();
                password = mPassword.getEditText().getText().toString();

                if (validateForm()) {
                    signIn(email, password);
                } else {
                    Toast.makeText(LandingActivity.this, "Please Fill the Form",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        mDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mEmail.getEditText().getText().toString();
                password = mPassword.getEditText().getText().toString();

                if (validateForm()) {
                    createAccount(email, password);
                } else {
                    Toast.makeText(LandingActivity.this, "Please Fill the Form",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void createAccount(final String email, final String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent i = new Intent(LandingActivity.this, MainActivity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(LandingActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void signIn(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent i = new Intent(LandingActivity.this, MainActivity.class);
                            startActivity(i);

                        } else {

                            Toast.makeText(LandingActivity.this, "Akun Belum Terdaftar",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
    private boolean validateForm() {
        boolean valid = false;

        if (email.isEmpty() || password.isEmpty()) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;

    }
}
