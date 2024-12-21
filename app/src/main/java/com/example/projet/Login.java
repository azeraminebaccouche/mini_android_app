package com.example.projet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText usernameInput, passwordInput;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);  // Make sure this corresponds to the correct XML file

        // Find views by their IDs
        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);

        // Set up login button click listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the username and password from the inputs
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                // Validate that username and password are not empty
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Login.this, "Username or password cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if both username and password match the credentials
                if (username.equals("azer") && password.equals("azer")) {
                    // If valid, redirect to HomeActivity
                    Intent intent = new Intent(Login.this, HomePage.class);
                    startActivity(intent);
                    finish();  // Optional: Finish LoginActivity so the user can't go back
                } else {
                    // If invalid, show an error message
                    Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
