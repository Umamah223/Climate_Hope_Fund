package com.example.climatehopefund_trial1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class LoginForgotPassword1 extends AppCompatActivity {

    private EditText forgotPassUserEmail;
    private FirebaseAuth AuthLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_forgot_password1);

        Typeface bold = Typeface.createFromAsset(getAssets(),"fonts/Inter-Black.ttf");
        TextView forgot_password_send_btn = findViewById(R.id.forgot_password_send_btn);
        forgot_password_send_btn.setTypeface(bold);

       TextView forgot_password_heading = findViewById(R.id.forgot_password_heading);
        forgot_password_heading.setTypeface(bold);

        forgotPassUserEmail = findViewById(R.id.forgot_pass_user_email);
        AuthLogin = FirebaseAuth.getInstance();
    }

    public void send_email_reset_pass(View view){
        String email = forgotPassUserEmail.getText().toString();
        AuthLogin.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginForgotPassword1.this, "Please Check Your Email", Toast.LENGTH_LONG).show();
                    finish(); // Close the activity after successful password reset email sent
                } else {
                    Toast.makeText(LoginForgotPassword1.this, "Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}