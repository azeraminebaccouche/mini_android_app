package com.example.projet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.projet.R;


import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        ImageView image1 = findViewById(R.id.image1);
        ImageView image2 = findViewById(R.id.image2);
        ImageView image3 = findViewById(R.id.image3);
        ImageView image4 = findViewById(R.id.image4);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailPage("Grey Sofa", "$320.00", "A comfortable grey sofa for 3 people made with linen.", R.drawable.imgg);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailPage("Black Sofa", "$640.00", "A stylish modern sofa with black color for your living room.", R.drawable.ss0);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailPage("Leather Sofa", "$850.00", "An ergonomic sofa made of total leather with a natural yellow color.", R.drawable.ss03);
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailPage("Suiden Sofa", "$1400.00", "A large sofa made with Suiden leather.", R.drawable.ss1);
            }
        });

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomnavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.nav_home) {
                    return true;
                } else if (item.getItemId() == R.id.nav_search) {
                    Toast.makeText(HomePage.this, "Search clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (item.getItemId() == R.id.nav_whitelist) {
                    Toast.makeText(HomePage.this, "Whitelist clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (item.getItemId() == R.id.nav_account) {
                    Intent accountIntent = new Intent(HomePage.this, AccountPage.class);
                    startActivity(accountIntent);
                    return true;
                }
return false;
            }
        });
    }

    private void openDetailPage(String title, String price, String description, int imageResource) {
        Intent intent = new Intent(HomePage.this, Buy.class);
        intent.putExtra("product_title", title);
        intent.putExtra("product_price", price);
        intent.putExtra("product_description", description);
        intent.putExtra("product_image", imageResource);
        startActivity(intent);
    }
}
