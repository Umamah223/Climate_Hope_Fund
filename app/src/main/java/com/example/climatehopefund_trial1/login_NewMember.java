package com.example.climatehopefund_trial1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
//import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;


import org.jetbrains.annotations.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class login_NewMember extends AppCompatActivity {

    TextInputEditText new_member_username, donor_email, donor_name, phone_number, new_member_password, new_member_confirm_password;
    ImageView googleSignInImg;
    Button new_member_clear_btn;
//    GoogleSignInClient googleClient;
//    GoogleSignInOptions userClient;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_new_member);

        Typeface heading = Typeface.createFromAsset(getAssets(), "fonts/Inter-Black.ttf");
        TextView new_member_login_heading = findViewById(R.id.new_member_login_heading);
        new_member_login_heading.setTypeface(heading);

        Typeface btn = Typeface.createFromAsset(getAssets(), "fonts/Inter-Bold.ttf");
        TextView new_member_clear_btn = findViewById(R.id.new_member_clear_btn);
        new_member_clear_btn.setTypeface(btn);

        TextView new_member_register_btn = findViewById(R.id.new_member_register_btn);
        new_member_register_btn.setTypeface(btn);

        TextInputLayout textinputLayoutPassword = findViewById(R.id.textinputLayoutPassword);
        TextInputLayout confirm_PassInput_Layout = findViewById(R.id.confirm_PassInput_Layout);

        new_member_clear_btn= findViewById(R.id.new_member_clear_btn);


        new_member_username = findViewById(R.id.new_member_username);
        donor_email = findViewById(R.id.donor_email);
        donor_name = findViewById(R.id.donor_name);
        phone_number = findViewById(R.id.phone_number);
        new_member_password = findViewById(R.id.new_member_password);
        new_member_confirm_password = findViewById(R.id.new_member_confirm_password);


        mAuth = FirebaseAuth.getInstance();

//        ImageView googleSignInImg = findViewById(R.id.googleSignInImg);
//        userClient = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
//
//        googleClient = GoogleSignIn.getClient(this,userClient);

        new_member_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String passwrd_new_signUp = s.toString();
                if (passwrd_new_signUp.length() >= 11) {
                    Pattern patternMatch = Pattern.compile("[^a-zA-Z0-9]");
                    Matcher matcher = patternMatch.matcher(passwrd_new_signUp);
                    boolean specCharPresent = matcher.find();
                    if (specCharPresent) {
                        textinputLayoutPassword.setHelperText("Strong Password");
                    } else {
                        textinputLayoutPassword.setHelperText("");
                        textinputLayoutPassword.setError("Enter atleast 1 special character");
                    }
                } else {
                    textinputLayoutPassword.setHelperText("Enter Minimum 11 characters");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

//  Clearing all fields on "Clear" button click
        new_member_clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new_member_username.getText().clear();
                donor_email.getText().clear();
                phone_number.getText().clear();
                new_member_password.getText().clear();
                new_member_confirm_password.getText().clear();
            }
        });
    }

//        googleSignInImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SignIn();
//            }
//        });

//

//    private void SignIn(){
//        Intent intent = googleClient.getSignInIntent();
//
//    }
//
//    @Override
//    protected void onActivityResult(int codeRequest,int codeResult, @Nullable Intent data){
//        super.onActivityResult(codeRequest,codeResult,data );
//
//        if(codeResult == 1710){
//            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//            try {
//                GoogleSignInAccount account = task.getResult(ApiException.class);
//
//                AuthCredential userCrendential = GoogleAuthProvider.getCredential(account.getIdToken(),null);
//                FirebaseAuth.getInstance().signInWithCredential(userCrendential).
//                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if(task.isSuccessful()){
//                                }
//                                else{
//                                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT);
//                                }
//                            }
//                        });
//            }
//            catch (ApiException x) {
//                throw new RuntimeException(x);
//            }
//        }
//    }

    public void registerBtnClicked(View v){
        String usernameText = new_member_username.getText().toString().trim();
        String emailText = donor_email.getText().toString().trim();
        String nameText = donor_name.getText().toString().trim();
        String phoneText = phone_number.getText().toString().trim();
        String passwrdTxt = new_member_password.getText().toString().trim();
        String confirmPasswordtxt = new_member_confirm_password.getText().toString().trim();

        if(usernameText.isEmpty()){
            new_member_username.setError("Please Enter Username");
            new_member_username.requestFocus();
        }

        if(confirmPasswordtxt.isEmpty()){
            new_member_confirm_password.setError("Re-enter Password");
            new_member_confirm_password.requestFocus();
        }

        Intent intent = new Intent(getApplicationContext(),PaymentDetails.class);
        intent.putExtra("username", usernameText);
        intent.putExtra("email", emailText);
        intent.putExtra("name", nameText);
        intent.putExtra("phone", phoneText);
        intent.putExtra("password", passwrdTxt);
        intent.putExtra("confirmPassword", confirmPasswordtxt);
        startActivity(intent);

    }
}