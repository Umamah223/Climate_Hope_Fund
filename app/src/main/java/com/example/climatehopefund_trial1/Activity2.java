package com.example.climatehopefund_trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
//import com.denzcoskun.imageslider.ImageSlider;
//import com.denzcoskun.imageslider.constants.ScaleTypes;
//import com.denzcoskun.imageslider.models.SlideModel;
//import java.util.ArrayList;
//import android.graphics.Typeface;

public class Activity2 extends AppCompatActivity {
    Timer activity2_timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

//        ImageSlider image_slider = findViewById(R.id.image_slider);
//
//        ArrayList<SlideModel> slideModels = new ArrayList<>();
//
//          slideModels.add(new SlideModel(R.drawable.children_activity2, ScaleTypes.FIT));
//          slideModels.add(new SlideModel(R.drawable.rainforest_management_activity2, ScaleTypes.FIT));
//          slideModels.add(new SlideModel(R.drawable.marine_conservation_activity2, ScaleTypes.FIT));
//          slideModels.add(new SlideModel(R.drawable.volcano_activity2, ScaleTypes.FIT));
//
//
//        image_slider.setImageList(slideModels,ScaleTypes.FIT);

        //Applying font style to the textview
        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/Inter-Black.ttf");
        TextView mainActivity2Text = findViewById(R.id.textview2);
        mainActivity2Text.setTypeface(tf);

        activity2_timer = new Timer();
        activity2_timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent newIntent = new Intent(getApplicationContext(),Activity3.class);
                startActivity(newIntent);
                finish();
            }
        },5000);
    }
}
