package com.example.climatehopefund_trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class volunteer_organizations_sample extends AppCompatActivity {
    TextView NAME_VOLUNTEER_sample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_organizations_sample);

        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/Inter-Black.ttf");
        TextView NAME_VOLUNTEER_sample = findViewById(R.id.NAME_VOLUNTEER_sample);
        NAME_VOLUNTEER_sample.setTypeface(tf);

        Typeface tf_2 = Typeface.createFromAsset(getAssets(),"fonts/Inter-SemiBold.ttf");
        TextView volunteer_categories = findViewById(R.id.volunteer_categories);
        volunteer_categories.setTypeface(tf_2);

        Typeface tf_3 = Typeface.createFromAsset(getAssets(),"fonts/Inter-Medium.ttf");
        TextView volunteer_organi_sample_desc = findViewById(R.id.volunteer_organi_sample_desc);
        volunteer_organi_sample_desc.setTypeface(tf_3);

//Starting intent
        Intent i = getIntent();
        if (i != null) {
            int orgImg = i.getIntExtra("VOLUNTEER_IMG", 0);
            String title = i.getStringExtra("NAME_VOLUNTEER_sample");
            String descr = i.getStringExtra("VOLUNTEER_DESC");
//            String organizationName = i.getStringExtra("ORG_NAME");

            int img_category1 = i.getIntExtra("VOLUNTEER_CATG_1",0);
            int img_category2 = i.getIntExtra("VOLUNTEER_CATG_2",0);

            Log.d("ImageDebug", "Category1: " + img_category1 + ", Category2: " + img_category2);

            if (title != null) {
                NAME_VOLUNTEER_sample.setText(title);
            }
            if (orgImg != 0) {
                // Set the image resource in  ImageView
                ImageView volunteer_org_sample = findViewById(R.id.volunteer_org_sample);
                volunteer_org_sample.setImageResource(orgImg);
            }
            if (descr != null) {
                TextView volunteerDescr = findViewById(R.id.volunteer_organi_sample_desc);
                volunteerDescr.setText(descr);
            }
            ImageView volunteer_org_categories1 = findViewById(R.id.volunteer_org_categories1);
            ImageView volunteer_org_categories2 = findViewById(R.id.volunteer_org_categories2);

            if (title.equals("BEEAH Group")) {
                volunteer_org_categories1.setImageResource(R.drawable.community_composting_beeah_volunteer);
                volunteer_org_categories2.setImageResource(R.drawable.waste_mangement_beeah);

                volunteer_org_categories1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Start VolunteerCategoryInfo activity and pass relevant data
                        Intent categoryIntent = new Intent(v.getContext(), VolunteerCategoryInfo.class);
                        categoryIntent.putExtra("VOLUNTEER_CATEGORY_TITLE", "COMPOSTING WITH BEEAH GROUP");
                        categoryIntent.putExtra("VOLUNTEER_CATEGORY_LOCATION", "Location : BEEAH Composting Sector - Sharjah");
                        categoryIntent.putExtra("ORG_NAME",title);
                        startActivity(categoryIntent);
                    }
                });

                volunteer_org_categories2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent categoryIntent = new Intent(v.getContext(), VolunteerCategoryInfo.class);
                        categoryIntent.putExtra("VOLUNTEER_CATEGORY_TITLE", "Waste Management with BEEAH Group");
                        categoryIntent.putExtra("VOLUNTEER_CATEGORY_LOCATION", "Location : BEEAH MANAGEMENT - Dubai");
                      // sending the organization name to the category info to store in firebase
                        categoryIntent.putExtra("ORG_NAME",title);
                        startActivity(categoryIntent);
                    }
                });
            }
            else if (title.equals("Emirates Marine Group")) {
                volunteer_org_categories1.setImageResource(R.drawable.endangered_species_emeg_volunteer);
                volunteer_org_categories2.setImageResource(R.drawable.clean_beach_emeg_volunteer);

                volunteer_org_categories1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Start VolunteerCategoryInfo activity and pass relevant data
                        Intent categoryIntent = new Intent(v.getContext(), VolunteerCategoryInfo.class);
                        categoryIntent.putExtra("VOLUNTEER_CATEGORY_TITLE", "PROTECTING ENDANGERED SPECIES WITH Emirates Marine Group");
                        categoryIntent.putExtra("VOLUNTEER_CATEGORY_LOCATION", "Location : Emirates Marine Group  - Dubai");
                        categoryIntent.putExtra("ORG_NAME",title);
                        startActivity(categoryIntent);
                    }
                });

                volunteer_org_categories2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent categoryIntent = new Intent(v.getContext(), VolunteerCategoryInfo.class);
                        categoryIntent.putExtra("VOLUNTEER_CATEGORY_TITLE", "Ocean Cleanup with Emirates Marine Group");
                        categoryIntent.putExtra("VOLUNTEER_CATEGORY_LOCATION", "Location : Emirates Marine Group- Dubai");
                        categoryIntent.putExtra("ORG_NAME",title);
                        startActivity(categoryIntent);
                    }
                });
            }
        }
    }

//    private int getImageForCategory(String title,String category) {
//        Log.d("ImageDebug", "Organization: " +title+ ", Category: " + category);
//        if (title.equals("BEEAH Group") ){
//            if ("img_category1".equals(category)) {
//                return R.drawable.community_composting_beeah_volunteer;
//            }
//            else if("img_category2".equals(category)){
//                return R.drawable.waste_mangement_beeah;
//            }
//
//        }
//        else if (title.equals("Emirates Marine Group")){
//            if ("img_category1".equals(category)) {
//                return R.drawable.endangered_species_emeg_volunteer;
//            }
//        }
//        return R.drawable.mwad_assessment2_app_logo;
//    }
}