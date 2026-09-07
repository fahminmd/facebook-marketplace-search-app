package com.example.fbmarketplace;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fbmarketplace.adapter.ListingAdapter;
import com.example.fbmarketplace.api.MarketplaceApiClient;
import com.example.fbmarketplace.model.Listing;
import com.example.fbmarketplace.model.SearchResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText searchEditText;
    private ImageButton searchButton;
    private RecyclerView listingsRecyclerView;
    private ProgressBar progressBar;
    private ListingAdapter adapter;
    private List<Listing> listings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupRecyclerView();
        setupSearchListener();
    }

    private void initializeViews() {
        searchEditText = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);
        listingsRecyclerView = findViewById(R.id.listingsRecyclerView);
        progressBar = findViewById(R.id.progressBar);
    }

    private void setupRecyclerView() {
        listings = new ArrayList<>();
        adapter = new ListingAdapter(this, listings);
        listingsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        listingsRecyclerView.setAdapter(adapter);
    }

    private void setupSearchListener() {
        searchButton.setOnClickListener(v -> performSearch());
    }

    private void performSearch() {
        String searchQuery = searchEditText.getText().toString().trim();

        if (searchQuery.isEmpty()) {
            Toast.makeText(this, "Please enter a search term", Toast.LENGTH_SHORT).show();
            return;
        }

        searchListings(searchQuery);
    }

    private void searchListings(String query) {
        progressBar.setVisibility(View.VISIBLE);
        listingsRecyclerView.setVisibility(View.GONE);

        MarketplaceApiClient.getInstance().searchMarketplace(query, new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                progressBar.setVisibility(View.GONE);
                listingsRecyclerView.setVisibility(View.VISIBLE);

                if (response.isSuccessful() && response.body() != null) {
                    listings.clear();
                    listings.addAll(response.body().getListings());
                    adapter.notifyDataSetChanged();

                    if (listings.isEmpty()) {
                        Toast.makeText(MainActivity.this, "No listings found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                listingsRecyclerView.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Failed to fetch listings: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
