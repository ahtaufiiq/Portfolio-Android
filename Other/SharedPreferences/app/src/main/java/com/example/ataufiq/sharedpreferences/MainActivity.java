package com.example.ataufiq.sharedpreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.ataufiq.sharedpreferences.SharedPreferences.SharedPref;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPref.saveString("Budi","Budi");
        Log.d("Namanya", SharedPref.getString("Budi"));
        SharedPref.deleteString("Budi");

    }

    public void intent(View view) {
        Intent i = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(i);
    }
}
