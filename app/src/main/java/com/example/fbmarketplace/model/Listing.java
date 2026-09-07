package com.example.fbmarketplace.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Listing implements Parcelable {

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("price")
    private double price;

    @SerializedName("description")
    private String description;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("seller_name")
    private String sellerName;

    @SerializedName("location")
    private String location;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("listing_url")
    private String listingUrl;

    public Listing() {}

    protected Listing(Parcel in) {
        id = in.readString();
        title = in.readString();
        price = in.readDouble();
        description = in.readString();
        imageUrl = in.readString();
        sellerName = in.readString();
        location = in.readString();
        createdAt = in.readString();
        listingUrl = in.readString();
    }

    public static final Creator<Listing> CREATOR = new Creator<Listing>() {
        @Override
        public Listing createFromParcel(Parcel in) {
            return new Listing(in);
        }

        @Override
        public Listing[] newArray(int size) {
            return new Listing[size];
        }
    };

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getListingUrl() {
        return listingUrl;
    }

    public void setListingUrl(String listingUrl) {
        this.listingUrl = listingUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeDouble(price);
        dest.writeString(description);
        dest.writeString(imageUrl);
        dest.writeString(sellerName);
        dest.writeString(location);
        dest.writeString(createdAt);
        dest.writeString(listingUrl);
    }
}
