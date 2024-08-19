package com.example.climatehopefund_trial1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EducationalSection extends AppCompatActivity {
    TextView educationalArticlesHeading,goBack_activity_3, heading_edu,chchange_1,chchange_2;
    CardView cardView_educational1,cardView_educational2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_section);

        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/Inter-Black.ttf");
        educationalArticlesHeading = findViewById(R.id.educationalArticlesHeading);
        educationalArticlesHeading.setTypeface(tf);

        chchange_2 = findViewById(R.id.chchange_2);
        chchange_1 = findViewById(R.id.chchange_1);
        chchange_1.setTypeface(tf);
        chchange_2.setTypeface(tf);

        goBack_activity_3 = findViewById(R.id.goBack_activity_3);
        goBack_activity_3.setTypeface(tf);

        heading_edu = findViewById(R.id.heading_edu);
        heading_edu.setTypeface(tf);

        cardView_educational1 = findViewById(R.id.cardView_educational1);
        cardView_educational2 = findViewById(R.id.cardView_educational2);

    }
    public void cardview1clicked(View v){
        Intent education_cardview1 = new Intent(getApplicationContext(),EducationalSection1.class);
        startActivity(education_cardview1);
    }
    public void cardview2clicked(View v){
        Intent education_cardview2 = new Intent(getApplicationContext(), EducationalSection2.class);
        startActivity(education_cardview2);
    }
}