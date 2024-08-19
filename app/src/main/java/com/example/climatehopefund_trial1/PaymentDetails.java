package com.example.climatehopefund_trial1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class PaymentDetails extends AppCompatActivity {
    EditText nameOnCard, cardNumber,cvv;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        Typeface heading = Typeface.createFromAsset(getAssets(),"fonts/Inter-Black.ttf");
        TextView paymentDetailsHeading = findViewById(R.id.paymentDetailsHeading);
        paymentDetailsHeading.setTypeface(heading);

        TextView proceedNowBtn = findViewById(R.id.proceedNowBtn);
        proceedNowBtn.setTypeface(heading);

        Typeface textviews = Typeface.createFromAsset(getAssets(),"fonts/Inter-Bold.ttf");
        TextView nameOnCardHeading = findViewById(R.id.nameOnCardHeading);
        nameOnCardHeading.setTypeface(textviews);

        TextView cardNumberOnCardHeading = findViewById(R.id.cardNumberOnCardHeading);
        cardNumberOnCardHeading.setTypeface(textviews);

        TextView validThroughHeading = findViewById(R.id.validThroughHeading);
        validThroughHeading.setTypeface(textviews);

        TextView cvvHeading = findViewById(R.id.cvvHeading);
        cvvHeading.setTypeface(textviews);

        nameOnCard = findViewById(R.id.nameOnCard);
        cardNumber = findViewById(R.id.cardNumber);
        cvv = findViewById(R.id.cvv);

        mAuth = FirebaseAuth.getInstance();

    }

    public void proceednow_payment_details_Clicked(View v){
        String CardName = nameOnCard.getText().toString().trim();
        String CardNumber = cardNumber.getText().toString().trim();
        String lastCardNumber = cvv.getText().toString().trim();

        if (CardName.matches(".*[^a-zA-Z0-9].*")) {
            nameOnCard.setError("Should not contain special characters");
        }

        if(CardNumber.length() > 9){
            cardNumber.setError("Enter valid 9 characters");
        }

        if(lastCardNumber.length() > 4){
            cvv.setError("Enter valid CVV");
        }

        String name_on_cardtext = nameOnCard.getText().toString();
        String card_Numbertext = cardNumber.getText().toString();
        String cvvtxt = cvv.getText().toString();


//  Passing the data from the loginNew memeber page to the payment details page to store in the "Users" table in firebase
        Intent intent = getIntent();
        String usernameText = intent.getStringExtra("username");
        String emailText = intent.getStringExtra("email");
        String nameText = intent.getStringExtra("name");
        String phoneText = intent.getStringExtra("phone");
        String passwrdTxt = intent.getStringExtra("password");
        String confirmPasswordtxt = intent.getStringExtra("confirmPassword");


        mAuth.createUserWithEmailAndPassword(emailText, passwrdTxt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //storing user details in the Realtime Database
                    String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    User user_details = new User(usernameText, emailText, nameText, phoneText, passwrdTxt, confirmPasswordtxt, name_on_cardtext, card_Numbertext, cvvtxt);
                    FirebaseDatabase.getInstance().getReference("Users").child(userId).setValue(user_details)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(getApplicationContext(), Activity3.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Not Registered", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(getApplicationContext(), "Authentication Failed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
      }
}