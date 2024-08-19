package com.example.climatehopefund_trial1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserProfile extends AppCompatActivity {
    TextView edit_profile,desc;
    EditText email,phone,password_user_profile,confirm_password_up;
    Button logout_button;

    TextView category_donated_to_userprofile,amount_donated_userprofile,category_volunteered_userprofile,organization_volunteered_userprofile,username_editprofile;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/Inter-Black.ttf");
        TextView save_profile = findViewById(R.id.save_profile);
        save_profile.setTypeface(tf);

        edit_profile = findViewById(R.id.edit_profile);
        edit_profile.setTypeface(tf);


        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/Inter-SemiBold.ttf");
        desc = findViewById(R.id.desc);
        desc.setTypeface(typeface);
       // underlining text
        desc.setPaintFlags(desc.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        Typeface typeface1 = Typeface.createFromAsset(getAssets(),"fonts/Inter-Medium.ttf");
        email = findViewById(R.id.email);
        email.setTypeface(typeface1);

        phone = findViewById(R.id.phone);
        phone.setTypeface(typeface1);

        username_editprofile = findViewById(R.id.username_editprofile);
        password_user_profile = findViewById(R.id.password_user_profile);
        password_user_profile.setTypeface(typeface1);

        confirm_password_up = findViewById(R.id.confirm_password_up);
        confirm_password_up.setTypeface(typeface1);

        category_donated_to_userprofile = findViewById(R.id.category_donated_to_userprofile);
        amount_donated_userprofile = findViewById(R.id.amount_donated_userprofile);
        category_volunteered_userprofile = findViewById(R.id.category_volunteered_userprofile);
        organization_volunteered_userprofile = findViewById(R.id.organization_volunteered_userprofile);

        logout_button = findViewById(R.id.buttonLogOut);


        auth = FirebaseAuth.getInstance();

//getting the data from the firebase and updating in the userprofile section
        DatabaseReference curr_user_ref = FirebaseDatabase.getInstance().getReference("Users").child(auth.getCurrentUser().getUid());
        DatabaseReference donation_curr_user =FirebaseDatabase.getInstance().getReference("Users").child("Donations");
        DatabaseReference volunteer_curr_user = FirebaseDatabase.getInstance().getReference("Users").child("Volunteer");

        curr_user_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                if(user != null){
                    String username_user = user.Username;
                    String email_user = user.Email;
                    String password_user = user.Password;
                    String confirm_pass_user = user.ConfirmPassword;
                    String phone_user = user.Number;

                    email.setText(email_user);
                    password_user_profile.setText(password_user);
                    confirm_password_up.setText(confirm_pass_user);
                    phone.setText(phone_user);
                    username_editprofile.setText(username_user);

                //Getting donation info
                    donation_curr_user.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot donationsnapshot) {
                            for(DataSnapshot donations: donationsnapshot.getChildren()){
                                String userid = donations.child("userId").getValue(String.class);
                                if(userid != null && userid.equals(auth.getCurrentUser().getUid())){
                                    String categoryDonated = donations.child("donationCategory").getValue(String.class);
                                    String amountDonated = donations.child("amountDonated").getValue(String.class);

                                    category_donated_to_userprofile.setText(categoryDonated);
                                    amount_donated_userprofile.setText(amountDonated +" AED");
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    volunteer_curr_user.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot vsnapshot) {
                            for(DataSnapshot volunteers : vsnapshot.getChildren()){
                                String user_id = volunteers.child("userId").getValue(String.class);
                                if(user_id != null && user_id.equals(auth.getCurrentUser().getUid())){
                                    String volunteerOrg =  volunteers.child("volunteering_Org_Name").getValue(String.class);
                                    String categoryName = volunteers.child("volunteering_Org_CategoryName").getValue(String.class);

                                    organization_volunteered_userprofile.setText(volunteerOrg);
                                    category_volunteered_userprofile.setText(categoryName);
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                //allowing users to edit their password and email
                    edit_profile.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            email.setEnabled(true);
                            phone.setEnabled(true);
                            password_user_profile.setEnabled(true);
                            confirm_password_up.setEnabled(true);

                            save_profile.setVisibility(View.VISIBLE);
                        }
                    });

                    save_profile.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String newEmail = email.getText().toString();
                            String newNo = phone.getText().toString();
                            String newPass = password_user_profile.getText().toString();
                            String newCpass = confirm_password_up.getText().toString();

                            if(newPass.length() >= 11 && oneSpecChar(newPass) ){
                                Toast.makeText(getApplicationContext(),"Edited Successfully",Toast.LENGTH_LONG).show();

                                DatabaseReference databaseReference_currentUser = FirebaseDatabase.getInstance().getReference("Users").child(auth.getCurrentUser().getUid());

                                databaseReference_currentUser.child("Email").setValue(newEmail);
                                databaseReference_currentUser.child("Password").setValue(newPass);
                                databaseReference_currentUser.child("Number").setValue(newNo);
                                databaseReference_currentUser.child("ConfirmPassword").setValue(newCpass);

                            }

                            else {
                                Toast.makeText(UserProfile.this,"Enter 11 characters and 1 special character",Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                    
//                    DataSnapshot donationInfoSnap = snapshot.child("Donations");
//                    if (donationInfoSnap.exists()) {
//                        for (DataSnapshot donationsnap : donationInfoSnap.getChildren()) {
//                            String userId = donationsnap.child("userId").getValue(String.class);
//
//                            if (userId != null && userId.equals(auth.getCurrentUser().getUid())) {
//                                String category_donatedTo = donationsnap.child("donationCategory").getValue(String.class);
//                                String amountDonatedByUser = donationsnap.child("amountDonated").getValue(String.class);
//                                // Do something with the donation information, e.g., update UI
//                                amount_donated_userprofile.setText(amountDonatedByUser);
//                                category_donated_to_userprofile.setText(category_donatedTo);
//                            }
//                        }
//                    }

//                    DataSnapshot volunteerInfoSnap = snapshot.child("Volunteer");
//                    if (volunteerInfoSnap.exists()) {
//                        for (DataSnapshot volunteersnap : volunteerInfoSnap.getChildren()){
////                            String userId = volunteersnap.child("userId");
//                        }
//                        Volunteer volunteer = snapshot.getValue(Volunteer.class);
//
//                        if (volunteer != null) {
//                            String volunteering_org = volunteer.getVolunteering_Org_Name();
//                            String volunteer_category = volunteer.getVolunteering_Org_CategoryName();
//
//                            organization_volunteered_userprofile.setText(volunteering_org);
//                            category_volunteered_userprofile.setText(volunteer_category);
//                        }
//                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Logged Out Successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean oneSpecChar(String string) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}