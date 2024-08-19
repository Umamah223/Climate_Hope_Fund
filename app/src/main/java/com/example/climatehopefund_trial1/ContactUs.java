package com.example.climatehopefund_trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class ContactUs extends AppCompatActivity {
    TextView title_contact_us,appName,location,email,phone1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        Typeface bold = Typeface.createFromAsset(getAssets(),"fonts/Inter-Black.ttf");

        phone1 = findViewById(R.id.phone1);
        phone1.setTypeface(bold);

        email = findViewById(R.id.email);
        email.setTypeface(bold);

        location = findViewById(R.id.location);
        location.setTypeface(bold);

        appName = findViewById(R.id.appName);
        appName.setTypeface(bold);

        title_contact_us = findViewById(R.id.title_contact_us);
        title_contact_us.setTypeface(bold);

    }
}