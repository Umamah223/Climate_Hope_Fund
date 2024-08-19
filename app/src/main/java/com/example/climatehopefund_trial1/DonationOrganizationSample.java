package com.example.climatehopefund_trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DonationOrganizationSample extends AppCompatActivity {
    private static int TIME_OUT = 5000;
    private int progressStart = 0;
    private ProgressBar progressBarDonation;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_organization_sample);


        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Inter-Black.ttf");
        TextView heading_donation_categories_title = findViewById(R.id.heading_donation_categories_title);
        heading_donation_categories_title.setTypeface(tf);


        Typeface tf_desc = Typeface.createFromAsset(getAssets(), "fonts/Inter-SemiBold.ttf");
        TextView description_donation = findViewById(R.id.description_donation);
        description_donation.setTypeface(tf_desc);


        Button donatenow = findViewById(R.id.donatenow);
        donatenow.setTypeface(tf);

        auth = FirebaseAuth.getInstance();

        progressBarDonation = findViewById(R.id.progressBarDonation);


        Intent intents = getIntent();

        if (intents != null) {

            String DonationTitle = intents.getStringExtra("heading_donation_categories_title");
            int DonationImage = intents.getIntExtra("imageViewDonation", 0);
            String DonationDescr = intents.getStringExtra("description_donation");
            int DonationAmount = intents.getIntExtra("donation_amount_gathered", 0);

            if (DonationTitle != null) {
                heading_donation_categories_title.setText(DonationTitle);
            }

            if (DonationImage != 0) {
                ImageView imageViewDonation = findViewById(R.id.imageViewDonation);
                imageViewDonation.setImageResource(DonationImage);
            }
            if (DonationDescr != null) {
                TextView Descr = findViewById(R.id.description_donation);
                description_donation.setText(DonationDescr);

            }

            if (DonationAmount != 0) {
                TextView donation_amount_gathered = findViewById(R.id.donation_amount_gathered);
                donation_amount_gathered.setTypeface(tf);
                donation_amount_gathered.setText("Amount Gathered: " + DonationAmount + " AED");
            }

            donatenow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    progressStart = progressStart+10;
                    progressBarDonation.setProgress(progressStart);
                    progressBarDonation.setMax(100);


                    //checks if user is already signed up or not using firebase
                    if (auth.getCurrentUser() != null) {

                        //activity starting after few seconds
                        new Handler().postDelayed(new Runnable(){
                            public void run(){

                                //moves to review donation page
                                Intent reviewDonation = new Intent(getApplicationContext(), ProceedAfterPaymentDetails.class);
                                reviewDonation.putExtra("organization_donated", DonationTitle);
                                startActivity(reviewDonation);
                                finish();
                            }
                        },TIME_OUT);

                    } else {
                        Intent goToLogin = new Intent(getApplicationContext(), LoginMainPage.class);
                        startActivity(goToLogin);
                    }
                }
            });
        }
    }
}