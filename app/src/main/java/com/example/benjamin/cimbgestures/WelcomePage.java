package com.example.benjamin.cimbgestures;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class WelcomePage extends AppCompatActivity {
    //implements View.OnTouchListener
    private int howManyTimesBeenRun = 0;
    private static final String NUMBER_OF_TIMES_RUN_KEY = "NUMBER_OF_TIMES_RUN_KEY";
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);
        sharedPreferences = getPreferences(Context.MODE_PRIVATE); //create shared preferences



        //read
        int defaultValue = 0;
        howManyTimesBeenRun = sharedPreferences.getInt(NUMBER_OF_TIMES_RUN_KEY,defaultValue);   //number of times run always starts at default 0
        //first time message
        if(howManyTimesBeenRun == 0){   //aka first time so registration only
            //Toast.makeText(this,"Welcome to first-time registration", Toast.LENGTH_LONG).show();
            //for debugging
            editSharedPref();





            //wait for 2 sec and auto move to next screen
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    final Intent mainIntent = new Intent(WelcomePage.this, RegistrationActivity.class);
                    WelcomePage.this.startActivity(mainIntent);
                    WelcomePage.this.finish();
                }
            }, 2000);


        } else {//if it is not the first time starting the app - meaning that we are doing a verification

            editSharedPref();

            //wait for 2 sec and auto move to next screen
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //now we open the verification page

                    final Intent i = new Intent(WelcomePage.this, VerifyGesture.class);
                    WelcomePage.this.startActivity(i);
                    WelcomePage.this.finish();
                }
            }, 2000);

        }

        //touch to go next screen
//        RelativeLayout layout= findViewById(R.id.relativeLayout);
//        layout.setOnTouchListener(this);




    }

    private void editSharedPref() {
        howManyTimesBeenRun++;  //increment count by 1
        //for debugging - next line
        //Toast.makeText(WelcomePage.this, "number of times app ran: " + howManyTimesBeenRun, Toast.LENGTH_SHORT).show();
        SharedPreferences.Editor editor = sharedPreferences.edit(); //open a editor
        editor.putInt(NUMBER_OF_TIMES_RUN_KEY,howManyTimesBeenRun); //save the number of times ran
        editor.commit();    //commit the changes
    }




//    @Override
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//        Intent i = new Intent(WelcomePage.this,  RegistrationActivity.class);
//        startActivity(i);
//        // here we move to the registration page.
//        return true;
//    }
}
