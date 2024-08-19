package com.example.climatehopefund_trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/Inter-Black.ttf");
        TextView about_us_heading = findViewById(R.id.about_us_heading);
        about_us_heading.setTypeface(type);

    }
}