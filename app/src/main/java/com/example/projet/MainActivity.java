package com.example.projet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure activity_main.xml exists in res/layout

        // Apply window insets for edge-to-edge design
        View mainView = findViewById(R.id.main); // Ensure `main` is the root layout ID in activity_main.xml
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        // Inside onCreate method of MainActivity
        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
        });
    }
}
