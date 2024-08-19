package com.example.climatehopefund_trial1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import android.widget.TextView;
import java.util.ArrayList;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;


public class PlantATree extends AppCompatActivity {

    RecyclerView recyclerView2;
    DonationCards[] d;
    FirebaseAuth auth;
    private SearchView searchView;
    private CollectionReference store_Image;
    private DonationCards[] originalData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_atree);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Inter-Black.ttf");

        TextView plant_a_tree_tv = findViewById(R.id.plant_a_tree_tv);
        plant_a_tree_tv.setTypeface(tf);

        TextView go_back_tv1 = findViewById(R.id.go_back_tv1);
        go_back_tv1.setTypeface(tf);

        searchView = (SearchView)findViewById(R.id.plantATree_sv);
        searchView.clearFocus();

        auth = FirebaseAuth.getInstance();

        originalData = new DonationCards[]{
                new DonationCards(R.drawable.plant_a_tree_eeg, "Emirates Environmental Group", "Donate To Plant A tree", "-->"),
                new DonationCards(R.drawable.plant_a_tree_tree_nation, "Tree Nation", "Donate Now", "-->"),
        };

        recyclerView2 = findViewById(R.id.recyclerview2);
        d = new DonationCards[]{new DonationCards(R.drawable.plant_a_tree_eeg, "Emirates Environmental Group", "Donate To Plant A tree", "-->"),
                new DonationCards(R.drawable.plant_a_tree_tree_nation, "Tree Nation", "Donate Now", "-->"),
        };

        CollectionReference store_Image = FirebaseFirestore.getInstance().collection("Images");
        DonationCardAdapter1 adapter1 = new DonationCardAdapter1(d, null, store_Image);

        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setAdapter(adapter1);

        go_back_tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNew = new Intent(getApplicationContext(), DonationCategories.class);
                startActivity(intentNew);
            }
        });
    }

    private void getFilterList(String newText) {
        // Filter the data based on the search query
        DonationCards[] filteredData = filterData(originalData, newText);

        // Update the RecyclerView adapter with the filtered data
        DonationCardAdapter1 adapter = new DonationCardAdapter1(filteredData, null, store_Image);
        recyclerView2.setAdapter(adapter);
    }

    private DonationCards[] filterData(DonationCards[] originalData, String newText) {
        ArrayList<DonationCards> filteredList = new ArrayList<>();

        // Iterate through the original data and include items that match the search query
        for (DonationCards card : originalData) {
            if (card.getDonation_org_name().toLowerCase().contains(newText.toLowerCase())) {
                filteredList.add(card);
            }
        }

        return filteredList.toArray(new DonationCards[0]);
    }
}


//    @Override
//    public void onItemClick(int position) {
//        DonationCards donationClicked = d[position];
//        storeImage(donationClicked,position);
//    }
//    private void storeImage(DonationCards donationCards,int position){
//
//        String imageId = String.valueOf(donationCards.getDonation_img());
//        imageStore.document(imageId).set(donationCards);
//    }

