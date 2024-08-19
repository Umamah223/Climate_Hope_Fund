package com.example.climatehopefund_trial1;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MarineConservation extends AppCompatActivity {
    RecyclerView recyclerviewMarine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marine_conservation);

        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/Inter-Black.ttf");
        TextView marine_conservation_tv = findViewById(R.id.marine_conservation_tv);
        marine_conservation_tv.setTypeface(tf);

        TextView go_back_tv2 = findViewById(R.id.go_back_tv2);
        go_back_tv2.setTypeface(tf);

        recyclerviewMarine = findViewById(R.id.recyclerview2);
        DonationCards d[] = {new DonationCards(R.drawable.marine_conservation_azraq,"AZRAQ ME","Donate To Conserve Oceans","-->"),
                new DonationCards(R.drawable.volunteer_cat2_activity3,"Emirates Marine Group","Donate Now","-->"),
        };

        DonationCardAdapter2 adapter2 = new DonationCardAdapter2(d);
        recyclerviewMarine.setLayoutManager(new LinearLayoutManager(this));

        recyclerviewMarine.setAdapter(adapter2);


    }
}