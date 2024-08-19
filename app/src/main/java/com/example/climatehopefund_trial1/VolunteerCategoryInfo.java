package com.example.climatehopefund_trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VolunteerCategoryInfo extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_category_info);

        TextView volunteer_category_title = findViewById(R.id.volunteer_category_title);
        TextView volunteer_category_description = findViewById(R.id.volunteer_category_description);

        TextView volunteer_category_location = findViewById(R.id.volunteer_category_location);
        Button volunteer_now = findViewById(R.id.volunteer_now_btn);

   //Firebase intialization
        auth = FirebaseAuth.getInstance();

        Intent categoryIntent = getIntent();
        if (categoryIntent != null){
            String categoryTitle = categoryIntent.getStringExtra("VOLUNTEER_CATEGORY_TITLE");
            String categoryLocation = categoryIntent.getStringExtra("VOLUNTEER_CATEGORY_LOCATION");

            volunteer_category_title.setText(categoryTitle);
            volunteer_category_location.setText(categoryLocation);
        }

        volunteer_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String volunteering_Org_Name = categoryIntent.getStringExtra("ORG_NAME");
                String category_Title = categoryIntent.getStringExtra("VOLUNTEER_CATEGORY_TITLE");

                if(auth.getCurrentUser() != null){
                   String UserId = auth.getCurrentUser().getUid();

                    //creating Volunteering Organizations Table in the database
                    DatabaseReference OrgsRef = FirebaseDatabase.getInstance().getReference().child("Volunteering Organizations");
                    String VorgIds = OrgsRef.push().getKey();
                    Volunteering_Organizations_DB volunteering_Organizations_DB = new Volunteering_Organizations_DB(VorgIds,volunteering_Org_Name);
                    OrgsRef.child(VorgIds).setValue(volunteering_Organizations_DB);

                    //creating Volunteering Organizations Categories Table in the database
                    DatabaseReference CatRef = FirebaseDatabase.getInstance().getReference().child("Volunteering Organizations Categories");
                    String catIds = CatRef.push().getKey();
                    VolunteerCategory volunteerCategory = new VolunteerCategory(catIds,category_Title,VorgIds);
                    CatRef.child(catIds).setValue(volunteerCategory);

                    //creating Volunteering Table under the User Table in the database
                    Volunteer volunteer = new Volunteer(UserId,volunteering_Org_Name,VorgIds,catIds,category_Title);
                    DatabaseReference VolunteerRef = FirebaseDatabase.getInstance().getReference().child("Users").child("Volunteer");
                    String volunteerid = VolunteerRef.push().getKey();
                    VolunteerRef.child(volunteerid).setValue(volunteer);

                    Toast.makeText(getApplicationContext(),"Successfully registered for volunteering",Toast.LENGTH_LONG).show();
                    Intent goHomePage = new Intent(getApplicationContext(), Activity3.class);
                    startActivity(goHomePage);

                }
            }
        });
    }
}