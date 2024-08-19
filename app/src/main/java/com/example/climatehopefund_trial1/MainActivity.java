package com.example.climatehopefund_trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
import android.widget.*;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    Timer activityTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//Applying font style to the textview
        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/Inter-Black.ttf");
        TextView mainActivityText = findViewById(R.id.mainActivityText);
        mainActivityText.setTypeface(tf);

//Setting the timer for the main Activity Page
        activityTimer = new Timer();
        activityTimer.schedule(new TimerTask() {
            @Override
          public void run(){
                Intent intent = new Intent(getApplicationContext(),Activity2.class);
                startActivity(intent);
                finish();
            }
        },10000);
    }
}