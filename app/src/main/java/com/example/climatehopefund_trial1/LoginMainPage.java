package com.example.climatehopefund_trial1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginMainPage extends AppCompatActivity {
    TextInputLayout textinputlayoutUserLogin,textinputlayoutPassLogin;
    TextInputEditText textinput_username,textinput_password;
    ProgressBar progressBarLogin;
    FirebaseAuth AuthLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main_page);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Inter-Black.ttf");
        TextView heading_loginPage = findViewById(R.id.heading_loginPage);
        heading_loginPage.setTypeface(tf);

        Typeface tf_1 = Typeface.createFromAsset(getAssets(),"fonts/Inter-Bold.ttf");

        TextView login_forgot_password = findViewById(R.id.login_forgot_password);
        login_forgot_password.setTypeface(tf_1);

        Button new_member_btn = findViewById(R.id.new_member_btn);
        new_member_btn.setTypeface(tf);

        textinputlayoutUserLogin = findViewById(R.id.textinputlayoutUserLogin);
        textinputlayoutPassLogin = findViewById(R.id.textinputlayoutPassLogin);

        textinput_username = findViewById(R.id.textinput_username);
        textinput_username.setTypeface(tf_1);

        textinput_password = findViewById(R.id.textinput_password);
        textinput_password.setTypeface(tf_1);

        progressBarLogin = findViewById(R.id.progressBarLogin);

        AuthLogin = FirebaseAuth.getInstance();

//  Ensuring that a logged in user wont be led to the login page again
//  FirebaseUser is a class that represents a user, used to get information about the signed in user
        FirebaseUser User_current = FirebaseAuth.getInstance().getCurrentUser();
        if(User_current != null){
            Intent mainActivityIntent = new Intent(getApplicationContext(), Activity3.class);
            startActivity(mainActivityIntent);
            finish();
        }
        new_member_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login_NewMember.class);
                startActivity(intent);
            }
        });
    }

    public void login_forgot_passwordClicked(View v){
       Intent x = new Intent(LoginMainPage.this, LoginForgotPassword1.class);
       startActivity(x);
    }

    public void login_btnClicked(View v){
        String loginUser_name =  textinput_username.getText().toString().trim();
        String loginPass_word = textinput_password.getText().toString().trim();


        if(textinput_password.length() < 11){
            textinput_password.setError("Please Enter upto 11 characters");
            textinput_password.requestFocus();
        }

        progressBarLogin.setVisibility(View.VISIBLE);

        AuthLogin.signInWithEmailAndPassword(loginUser_name,loginPass_word).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    progressBarLogin.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(),"Login In Successful",Toast.LENGTH_LONG).show();
                }
                else{
                    progressBarLogin.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(),"Login In Failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}