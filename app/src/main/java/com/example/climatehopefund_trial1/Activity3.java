package com.example.climatehopefund_trial1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.climatehopefund_trial1.databinding.Activity3Binding;

public class Activity3 extends Drawer_Base_Activity {

    Activity3Binding activity3Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity3Binding = Activity3Binding.inflate(getLayoutInflater());
        giveActivityTitle("Home");
        setContentView(activity3Binding.getRoot());

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Inter-Black.ttf");
        TextView heading_textView3 = activity3Binding.headingTextView3;
        heading_textView3.setTypeface(tf);

        // Applying font style to the heading for donation categories
        TextView heading_donation_categories = activity3Binding.headingDonationCategories;
        heading_donation_categories.setTypeface(tf);

        // Applying font styles to the view all tv
        TextView view_all_donations = activity3Binding.viewAllDonations;
        view_all_donations.setTypeface(tf);

        TextView heading_volunteer_categories = activity3Binding.headingVolunteerCategories;
        heading_volunteer_categories.setTypeface(tf);

        TextView view_all_volunteer = activity3Binding.viewAllVolunteer;
        view_all_volunteer.setTypeface(tf);

        view_all_donations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intents = new Intent(getApplicationContext(), DonationCategories.class);
                startActivity(intents);
            }
        });

        view_all_volunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Volunteer_Organizations.class);
                startActivity(intent);
            }
        });
    }
}
