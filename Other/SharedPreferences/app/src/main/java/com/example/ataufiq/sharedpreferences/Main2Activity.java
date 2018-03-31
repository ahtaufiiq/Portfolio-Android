package com.example.ataufiq.sharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.ataufiq.sharedpreferences.SharedPreferences.SharedPref;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if (SharedPref.getString("Budi")!=null) {
            Log.d("Namanya", SharedPref.getString("Budi"));
            SharedPref.saveString("Budi", "andi");
            Log.d("Namanya", SharedPref.getString("Budi"));
        }else {
            Log.d("Namanya", "Udah dihapuis");
        }
    }
}
