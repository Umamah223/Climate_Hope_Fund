package com.example.climatehopefund_trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class Items_Cards_Donation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_cards_donations);

        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/Inter-Black.ttf");
        TextView name_donation_org = findViewById(R.id.name_donation_org);
        name_donation_org.setTypeface(tf);

        TextView donation_info = findViewById(R.id.donation_info);
        donation_info.setTypeface(tf);

        TextView know_more_donation_org = findViewById(R.id.know_more_donation_org);
        know_more_donation_org.setTypeface(tf);
       
    }
}