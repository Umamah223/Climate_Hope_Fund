package com.example.climatehopefund_trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.graphics.Typeface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Volunteer_Organizations extends AppCompatActivity {
    TextView go_back_mainPage;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_organizations);

        recyclerView = findViewById(R.id.recyclerview2);

        VolunteerOrgCards v[] = { new VolunteerOrgCards(R.drawable.beeah_volunteer,"BEEAH Group","Volunteer with BEEAH","-->"),
                new VolunteerOrgCards(R.drawable.marine_group_volunteer,"Emirates Marine Group","Volunteer with Marine Group","-->"),
        };

        cardAdapter adapter = new cardAdapter(v);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/Inter-Black.ttf");
        TextView title_volunteer_org = findViewById(R.id.title_volunteer_org);
        title_volunteer_org.setTypeface(tf);

        go_back_mainPage = findViewById(R.id.go_back_mainPage);
        go_back_mainPage.setTypeface(tf);

        go_back_mainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(getApplicationContext(), Activity3.class);
                startActivity(newIntent);
            }
        });
    }
}