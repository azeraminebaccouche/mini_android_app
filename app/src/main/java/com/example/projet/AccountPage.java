package com.example.projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AccountPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content view to the layout XML for AccountPage
        setContentView(R.layout.activity_account_page);

        // Find the TextView by ID to set the static account name "Azer"
        TextView textView = findViewById(R.id.profile_name);  // Updated ID
        if (textView != null) {
            // Set the static account name "Azer"
            textView.setText("Welcome, Azer!");
        }

        // Find the logout button by ID
        Button btnLogout = findViewById(R.id.btn_logout);

        // Set an OnClickListener for the logout button
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to navigate to the login page (assuming LoginActivity is your login screen)
                Intent intent = new Intent(AccountPage.this, Login.class);

                // Start the login activity
                startActivity(intent);

                // Optionally, finish the current activity so it doesn't remain in the back stack
                finish();
            }
        });
    }
}
