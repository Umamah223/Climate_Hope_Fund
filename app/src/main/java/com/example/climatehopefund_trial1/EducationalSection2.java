package com.example.climatehopefund_trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class EducationalSection2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_section2);

        Typeface bold = Typeface.createFromAsset(getAssets(),"fonts/Inter-Black.ttf");
        Typeface nbold = Typeface.createFromAsset(getAssets(),"fonts/Inter-Bold.ttf");

        TextView climate_ch_title2 = findViewById(R.id.climate_ch_title2);
        climate_ch_title2.setTypeface(bold);
        TextView tv_titleEducation2 = findViewById(R.id.tv_titleEducation2);
        tv_titleEducation2.setTypeface(nbold);


    }
}