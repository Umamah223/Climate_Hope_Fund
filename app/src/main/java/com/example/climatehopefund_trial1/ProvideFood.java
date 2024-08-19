package com.example.climatehopefund_trial1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class ProvideFood extends AppCompatActivity {
    RecyclerView recyclerviewFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provide_food);

        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/Inter-Black.ttf");

        TextView provide_food_tv= findViewById(R.id.provide_food_tv);
        provide_food_tv.setTypeface(tf);

        TextView go_back_tv4 = findViewById(R.id.go_back_tv4);
        go_back_tv4.setTypeface(tf);

        recyclerviewFood = findViewById(R.id.recyclerviewFood);
        DonationCards d[] = {new DonationCards(R.drawable.provide_food_uae_foodbank,"UAE FOOD BANK","Donate To Provide Food","-->"),
                new DonationCards(R.drawable.provide_food_foodforfree,"Food For Free Group","Donate Now","-->"),
        };

        DonationCardAdapter3 adapter3 = new DonationCardAdapter3(d);
        recyclerviewFood.setLayoutManager(new LinearLayoutManager(this));

        recyclerviewFood.setAdapter(adapter3);
    }
}