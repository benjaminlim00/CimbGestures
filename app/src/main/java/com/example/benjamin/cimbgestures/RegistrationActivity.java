package com.example.benjamin.cimbgestures;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RegistrationActivity extends AppCompatActivity {
//    private static final String NUMBER_OF_TIMES_RUN_KEY = "NUMBER_OF_TIMES_RUN_KEY";
//
//    int defaultValue = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);
        Button regButton = findViewById(R.id.regButton);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegistrationActivity.this, RegisterGesture.class);
                startActivity(i);

            }
        });
    }
    /*
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pref = this.getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE);


        int howManyTimesBeenRun = pref.getInt(NUMBER_OF_TIMES_RUN_KEY,defaultValue);   //number of times run always starts at default 0

        if (howManyTimesBeenRun != 0 ) {
            Intent i = new Intent(RegistrationActivity.this, WelcomePage.class);
            startActivity(i);
        } */

//        Intent i = new Intent(RegistrationActivity.this, WelcomePage.class);
//        startActivity(i);

//    }
}
