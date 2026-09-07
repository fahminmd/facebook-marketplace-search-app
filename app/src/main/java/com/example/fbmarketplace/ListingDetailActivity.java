package com.example.fbmarketplace;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.fbmarketplace.model.Listing;

public class ListingDetailActivity extends AppCompatActivity {

    public static final String LISTING_EXTRA = "listing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_detail);

        Listing listing = getIntent().getParcelableExtra(LISTING_EXTRA);

        if (listing != null) {
            displayListingDetails(listing);
        }
    }

    private void displayListingDetails(Listing listing) {
        ImageView imageView = findViewById(R.id.detailImageView);
        TextView titleView = findViewById(R.id.detailTitleView);
        TextView priceView = findViewById(R.id.detailPriceView);
        TextView descriptionView = findViewById(R.id.detailDescriptionView);
        TextView sellerView = findViewById(R.id.detailSellerView);
        TextView locationView = findViewById(R.id.detailLocationView);

        Glide.with(this)
                .load(listing.getImageUrl())
                .into(imageView);

        titleView.setText(listing.getTitle());
        priceView.setText("$" + listing.getPrice());
        descriptionView.setText(listing.getDescription());
        sellerView.setText("Seller: " + listing.getSellerName());
        locationView.setText("Location: " + listing.getLocation());
    }
}
