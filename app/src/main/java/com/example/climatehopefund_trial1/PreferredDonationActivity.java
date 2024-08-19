package com.example.climatehopefund_trial1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentId;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class PreferredDonationActivity extends AppCompatActivity {
    TextView titlePrefeeredDonation;
    RecyclerView recyclerviewPreferredDonations;
    DonationCards[] preferredDonationsPage;
    FirebaseAuth auth;
    PreferredDonationAdapter preferredDonationAdapter;
    List<PreferredDonationCards> preferredDonationList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferred_donation);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/Inter-Black.ttf");

        titlePrefeeredDonation = findViewById(R.id.titlePrefeeredDonation);
        titlePrefeeredDonation.setTypeface(typeface);

//        recyclerviewPreferredDonations = findViewById(R.id.recyclerviewPreferredDonations);
//        recyclerviewPreferredDonations.setLayoutManager(new LinearLayoutManager(this));

        CheckBox checkbox_favourite_Donations = findViewById(R.id.checkbox_favourite_Donations);
        checkbox_favourite_Donations.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            CardView cardViewdonation = findViewById(R.id.cardViewdonation);
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){
                    Toast.makeText(getApplicationContext(),"Removed From Preferred Donations",Toast.LENGTH_SHORT).show();
                    cardViewdonation.setVisibility(View.GONE);
                }
            }
        });

        auth = FirebaseAuth.getInstance();

//        preferredDonationList = new ArrayList<>();
//        preferredDonationAdapter = new PreferredDonationAdapter(preferredDonationList);
//        recyclerviewPreferredDonations.setAdapter(preferredDonationAdapter);
//
//        PreferredDonationCards sampleCard = new PreferredDonationCards(R.drawable.plant_a_tree_eeg, "Emirates Environmental Group", "Donate Now", "-->");
//        preferredDonationList.add(sampleCard);
//        preferredDonationAdapter.notifyDataSetChanged();



    }
    private void populateRecyclerView(){
//        FirebaseFirestore getData = FirebaseFirestore.getInstance();

//        getData.collection("Preferred Donations").document(auth.getCurrentUser().getUid()).get().addOnCompleteListener(task -> {
//            if(task.isSuccessful()){
//                 DocumentSnapshot ds = task.getResult();
//
//                 if(ds.exists()) {
//                     String organizationName = ds.getString("organizationDonatedTo");
//                     String imageURL = ds.getString("Url_Image");
//                     PreferredDonationCards preferredDonationCards = new PreferredDonationCards(imageURL, organizationName, "Donate Now", "-->");
//                     preferredDonationList.add(preferredDonationCards);
//                     preferredDonationAdapter.notifyDataSetChanged();
//                 }
//            }vity ,
//        });

//        PreferredDonationCards sampleCard = new PreferredDonationCards(R.drawable.plant_a_tree_eeg, "Emirates Environmental Group", "Donate Now", "-->");
//        preferredDonationList.add(sampleCard);
//        preferredDonationAdapter.notifyDataSetChanged();
    }
}