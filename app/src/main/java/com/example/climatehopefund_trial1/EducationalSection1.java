package com.example.climatehopefund_trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class EducationalSection1 extends AppCompatActivity {
    TextView tv_titleEducation1,climate_ch_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_section1);


        Typeface bold = Typeface.createFromAsset(getAssets(),"fonts/Inter-Black.ttf");
        Typeface nbold = Typeface.createFromAsset(getAssets(),"fonts/Inter-Medium.ttf");

        tv_titleEducation1 = findViewById(R.id.tv_titleEducation1);
        tv_titleEducation1.setTypeface(nbold);


        climate_ch_title = findViewById(R.id.climate_ch_title);
        climate_ch_title.setTypeface(bold);

    }
}