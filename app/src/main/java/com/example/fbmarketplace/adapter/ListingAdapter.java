package com.example.fbmarketplace.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fbmarketplace.ListingDetailActivity;
import com.example.fbmarketplace.R;
import com.example.fbmarketplace.model.Listing;

import java.util.List;

public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ListingViewHolder> {

    private Context context;
    private List<Listing> listings;

    public ListingAdapter(Context context, List<Listing> listings) {
        this.context = context;
        this.listings = listings;
    }

    @NonNull
    @Override
    public ListingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_listing, parent, false);
        return new ListingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListingViewHolder holder, int position) {
        Listing listing = listings.get(position);
        holder.bind(listing);
    }

    @Override
    public int getItemCount() {
        return listings.size();
    }

    public class ListingViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView titleView;
        private TextView priceView;
        private TextView sellerView;
        private TextView locationView;

        public ListingViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.listingImageView);
            titleView = itemView.findViewById(R.id.listingTitleView);
            priceView = itemView.findViewById(R.id.listingPriceView);
            sellerView = itemView.findViewById(R.id.listingSellerView);
            locationView = itemView.findViewById(R.id.listingLocationView);
        }

        public void bind(Listing listing) {
            Glide.with(context)
                    .load(listing.getImageUrl())
                    .into(imageView);

            titleView.setText(listing.getTitle());
            priceView.setText("$" + listing.getPrice());
            sellerView.setText(listing.getSellerName());
            locationView.setText(listing.getLocation());

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, ListingDetailActivity.class);
                intent.putExtra(ListingDetailActivity.LISTING_EXTRA, listing);
                context.startActivity(intent);
            });
        }
    }
}
