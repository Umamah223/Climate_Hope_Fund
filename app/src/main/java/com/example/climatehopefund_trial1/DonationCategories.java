package com.example.climatehopefund_trial1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import com.example.climatehopefund_trial1.databinding.Activity3Binding;

public class DonationCategories extends AppCompatActivity {

    ImageView cat1;
    ImageView cat2;
    ImageView cat3;
    ImageView cat4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_categories);

        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/Inter-Black.ttf");
        TextView heading_categories = findViewById(R.id.heading_categories);
        heading_categories.setTypeface(tf);

        Typeface tf_1 = Typeface.createFromAsset(getAssets(),"fonts/Inter-SemiBold.ttf");
        TextView plant_a_tree_tv_activity4 = findViewById(R.id.plant_a_tree_tv_activity4);
        plant_a_tree_tv_activity4.setTypeface(tf_1);

        TextView marine_conservation_tv_activity4= findViewById(R.id.marine_conservation_tv_activity4);
        marine_conservation_tv_activity4.setTypeface(tf_1);


        cat1 = findViewById(R.id.cat1);
        cat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cat1intent = new Intent(getApplicationContext(), PlantATree.class);
                startActivity(cat1intent);
            }
        });

        cat2 = findViewById(R.id.cat2);
        cat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MarineConservation.class);
                startActivity(intent1);
            }
        });

        cat3 = findViewById(R.id.cat3);
        cat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), ProvideFood.class);
                startActivity(intent2);
            }
        });

        cat4 = findViewById(R.id.cat4);
        cat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), MangroveRestoration.class);
                startActivity(intent3);
            }
        });
    }
}




//        cat1_img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1 = new Intent(getApplicationContext(),PlantATree.class);
//                startActivity(intent1);
//            }
//        });
//
//        cat2_img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2 = new Intent(getApplicationContext(),MarineConservation.class);
//                startActivity(intent2);
//            }
//        });
//
//        cat3_img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent3 = new Intent(getApplicationContext(),ProvideFood.class);
//                startActivity(intent3);
//            }
//        });
//
//        cat4_img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent4 = new Intent(getApplicationContext(),MangroveRestoration.class);
//                startActivity(intent4);
//            }
//        });
