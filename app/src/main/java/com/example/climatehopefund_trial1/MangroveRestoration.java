package com.example.climatehopefund_trial1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MangroveRestoration extends AppCompatActivity {
    RecyclerView recyclerviewMangrove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangrove_restoration);

        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/Inter-Black.ttf");
        TextView mangrove_restoration_tv = findViewById(R.id.mangrove_restoration_tv);
        mangrove_restoration_tv.setTypeface(tf);

        recyclerviewMangrove = findViewById(R.id.recyclerviewMangrove);
        DonationCards d[] = {new DonationCards(R.drawable.mangrove_conservation_mangrove_action_p,"Mangorve Action Project","Donate To Conserve Mangroves","-->"),
                new DonationCards(R.drawable.mangrove_restoration_blue_mangrove,"Blue Mangrove Fund","Donate Now","-->"),
        };

        DonationCardAdapter4 adapter4 = new DonationCardAdapter4(d);
        recyclerviewMangrove.setLayoutManager(new LinearLayoutManager(this));

        recyclerviewMangrove.setAdapter(adapter4);

    }
}