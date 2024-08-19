package com.example.climatehopefund_trial1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;


public class Drawer_Base_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;

    @Override
    public void setContentView(View view){
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base,null);
        FrameLayout container = drawerLayout.findViewById(R.id.activityContainer);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        NavigationView navigationView1 = drawerLayout.findViewById(R.id.nav_view);
        navigationView1.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.menu_open,R.string.menu_open);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);

        int itemId = item.getItemId();
        if (itemId == R.id.home) {
            startActivity(new Intent(getApplicationContext(), Activity3.class));
            overridePendingTransition(0, 0);
        } else if (itemId == R.id.donation_catalogue) {
            startActivity(new Intent(getApplicationContext(), DonationCategories.class));
            overridePendingTransition(0, 0);
        }

        else if (itemId == R.id.volunteer_catalogue){
            startActivity(new Intent(getApplicationContext(), Volunteer_Organizations.class));
            overridePendingTransition(0,0);
        }

        else if(itemId == R.id.about_us){
            startActivity(new Intent(getApplicationContext(), AboutUs.class));
            overridePendingTransition(0,0);
        }

        else if(itemId == R.id.educational){
            startActivity(new Intent(getApplicationContext(), EducationalSection.class));
            overridePendingTransition(0,0);
        }
        else if(itemId == R.id.contact_us){
            startActivity(new Intent(getApplicationContext(), ContactUs.class));
            overridePendingTransition(0,0);
        }

        else if(itemId == R.id.profile){
            startActivity(new Intent(getApplicationContext(), UserProfile.class));
            overridePendingTransition(0,0);
        }

        else if(itemId == R.id.preferred_items){
            startActivity(new Intent(getApplicationContext(),PreferredDonationActivity.class));
            overridePendingTransition(0,0);
        }
        return false;
    }

// Write the title of the app activity to the app bar
    protected void giveActivityTitle(String titleName){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(titleName);
        }

    }
}