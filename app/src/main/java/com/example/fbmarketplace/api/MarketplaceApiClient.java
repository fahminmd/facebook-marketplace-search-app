package com.example.fbmarketplace.api;

import com.example.fbmarketplace.model.SearchResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MarketplaceApiClient {

    private static final String BASE_URL = "https://api.facebook-marketplace-scraper.com/";
    private static MarketplaceApiClient instance;
    private Retrofit retrofit;
    private MarketplaceApiService apiService;

    private MarketplaceApiClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(MarketplaceApiService.class);
    }

    public static MarketplaceApiClient getInstance() {
        if (instance == null) {
            instance = new MarketplaceApiClient();
        }
        return instance;
    }

    public void searchMarketplace(String query, Callback<SearchResponse> callback) {
        apiService.searchMarketplace(query).enqueue(callback);
    }

    public void getListings(String category, int limit, Callback<SearchResponse> callback) {
        apiService.getListings(category, limit).enqueue(callback);
    }
}
