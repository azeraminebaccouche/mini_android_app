package com.example.projet;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import androidx.appcompat.app.AppCompatActivity;

public class Buy extends AppCompatActivity {

    ImageView productImage;
    TextView productTitle, productDescription, productPrice, quantityText;
    MaterialButton addToCartButton, buttonPlus, buttonMinus;

    int quantity = 1; // Default quantity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        // Initialize Views
        productImage = findViewById(R.id.productImage);
        productTitle = findViewById(R.id.productTitle);
        productDescription = findViewById(R.id.productDescription);
        productPrice = findViewById(R.id.productPrice);
        quantityText = findViewById(R.id.quantityText);
        addToCartButton = findViewById(R.id.addToCartButton);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);

        // Retrieve the data passed from the HomePage activity
        String title = getIntent().getStringExtra("product_title");
        String price = getIntent().getStringExtra("product_price");
        String description = getIntent().getStringExtra("product_description");
        int imageResource = getIntent().getIntExtra("product_image", R.drawable.imgg); // Add a default image if missing

        // Set the values into the views
        if (title != null) {
            productTitle.setText(title);
        } else {
            productTitle.setText("Product Title");
        }

        if (description != null) {
            productDescription.setText(description);
        } else {
            productDescription.setText("No description available.");
        }

        if (price != null) {
            productPrice.setText(price);
        } else {
            productPrice.setText("$0.00");
        }

        productImage.setImageResource(imageResource);

        // Initialize Quantity
        quantityText.setText(String.valueOf(quantity));

        // Add to Cart Button Click Listener
        addToCartButton.setOnClickListener(v -> {
            Toast.makeText(Buy.this, "Added " + quantity + " item(s) to Cart!", Toast.LENGTH_SHORT).show();
        });

        // Plus Button Listener
        buttonPlus.setOnClickListener(v -> {
            quantity++;
            quantityText.setText(String.valueOf(quantity));
        });

        // Minus Button Listener
        buttonMinus.setOnClickListener(v -> {
            if (quantity > 1) { // Prevent quantity from going below 1
                quantity--;
                quantityText.setText(String.valueOf(quantity));
            }
        });
    }
}
