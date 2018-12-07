package com.example.benjamin.cimbgestures;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VerifyGesture extends AppCompatActivity {

    GestureLibrary lib;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        txtResult = findViewById(R.id.txtResult);

        lib = GestureLibraries.fromRawResource(this, R.raw.gesture);
        if (!lib.load()) {
            finish();
        }
        final GestureOverlayView gesture = findViewById(R.id.gesture);
        gesture.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
                ArrayList<Prediction> predictionArrayList = lib.recognize(gesture);
                for (Prediction prediction: predictionArrayList) {
                    if (prediction.score > 1.0) {
                        //txtResult.setText(prediction.name);
                        //txtResult.setText("Success");
                        Toast.makeText(VerifyGesture.this, "Successfully verified!", Toast.LENGTH_LONG).show();


                        //quit and return to telegram
                        //now we countdown 3 sec and app destroy

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                moveTaskToBack(true);
                                finish();   //this should close everything
                                //android.os.Process.killProcess(android.os.Process.myPid());
                                //System.exit(1);
                            }
                        }, 2000);





                    } else {
                        //txtResult.setText("Failed");
                        Toast.makeText(VerifyGesture.this, "Failed, please try again!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
