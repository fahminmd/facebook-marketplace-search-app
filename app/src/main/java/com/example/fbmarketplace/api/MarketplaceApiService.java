package com.example.fbmarketplace.api;

import com.example.fbmarketplace.model.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarketplaceApiService {

    @GET("api/search")
    Call<SearchResponse> searchMarketplace(
            @Query("q") String query
    );

    @GET("api/listings")
    Call<SearchResponse> getListings(
            @Query("category") String category,
            @Query("limit") int limit
    );
}
