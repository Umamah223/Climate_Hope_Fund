package com.example.climatehopefund_trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProceedAfterPaymentDetails extends AppCompatActivity {
    TextView reviewDonationText, amountDonated,amountdonatedheading,category_donatedheading,organizationDonatedHeading,category_donated,organization_donated;
    EditText amountDonatedbyUser;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceed_after_payment_details);

        Typeface bold = Typeface.createFromAsset(getAssets(),"fonts/Inter-Bold.ttf");
        reviewDonationText = findViewById(R.id.reviewDonationText);
        reviewDonationText.setTypeface(bold);

        amountdonatedheading = findViewById(R.id.amountdonatedheading);
        amountdonatedheading.setTypeface(bold);

        category_donatedheading = findViewById(R.id.category_donatedheading);
        category_donatedheading.setTypeface(bold);

        amountDonatedbyUser = findViewById(R.id.amountDonatedbyUser);
        amountDonatedbyUser.setTypeface(bold);

        organizationDonatedHeading = findViewById(R.id.organizationDonatedHeading);

        category_donated = findViewById(R.id.category_donated);

        organization_donated = findViewById(R.id.organization_donated);
        organization_donated.setTypeface(bold);

        Button donateButton_Review = findViewById(R.id.donateButton_Review);
        auth = FirebaseAuth.getInstance();

//  gets the category details from the donation organizations page and displays in review donation page
        Intent intent = getIntent();
        if(intent != null){

                String categoryofDonation = intent.getStringExtra("category_title");
                String organization_Donation = intent.getStringExtra("organization_donated");

            Log.d("DEBUG", "Received category title: " + categoryofDonation);
            Log.d("DEBUG", "Received organization name: " + organization_Donation);


               organization_donated.setText(organization_Donation);
                category_donated.setText("Plant A Tree");
        }

        donateButton_Review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amountDonated = amountDonatedbyUser.getText().toString();
                String categoryDonated = category_donated.getText().toString();
                String organizationDonatedTo = organization_donated.getText().toString();

                 if(auth.getCurrentUser() != null){
                     String userid = auth.getCurrentUser().getUid();
                     //create the Donation Table under Users Table
                     Donation Donations = new Donation(userid, categoryDonated, organizationDonatedTo, amountDonated);
                     DatabaseReference DonationsRef = FirebaseDatabase.getInstance().getReference().child("Users").child("Donations");
                     String donationId = DonationsRef.push().getKey();
                     DonationsRef.child(donationId).setValue(Donations);

                 }
                Intent mainIntent = new Intent(getApplicationContext(), Activity3.class);
                startActivity(mainIntent);
                finish();
            }
        });
    }
}