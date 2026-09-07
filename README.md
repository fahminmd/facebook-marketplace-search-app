# Facebook Marketplace Search App

A simple Android application for searching Facebook Marketplace listings. Users can search for items, view listings in a RecyclerView, and click on items to view detailed information.

## Features

- **Search Marketplace**: Enter keywords to search for marketplace listings
- **Browse Listings**: View search results in a scrollable list with images, titles, prices, and seller information
- **View Details**: Click on any listing to view full details including description, seller name, and location
- **Image Loading**: Efficient image loading using Glide library
- **Network Communication**: Uses Retrofit for API communication

## Tech Stack

- **Language**: Java
- **UI Framework**: Android (RecyclerView, Layouts)
- **Networking**: Retrofit, OkHttp
- **Image Loading**: Glide
- **JSON Parsing**: Gson
- **Build Tool**: Gradle

## Project Structure

```
app/src/main/
├── java/com/example/fbmarketplace/
│   ├── MainActivity.java          # Main search activity
│   ├── ListingDetailActivity.java  # Detail view activity
│   ├── adapter/
│   │   └── ListingAdapter.java     # RecyclerView adapter
│   ├── api/
│   │   ├── MarketplaceApiClient.java    # Retrofit singleton
│   │   └── MarketplaceApiService.java   # API endpoints
│   └── model/
│       ├── Listing.java           # Listing data model
│       └── SearchResponse.java     # API response model
├── res/
│   ├── layout/
│   │   ├── activity_main.xml
│   │   ├── activity_listing_detail.xml
│   │   └── item_listing.xml
│   ├── drawable/
│   │   ├── search_edit_text_bg.xml
│   │   └── item_listing_bg.xml
│   └── values/
│       └── strings.xml
└── AndroidManifest.xml
```

## API Integration

The app uses a mock API endpoint that should return listings in the following format:

```json
{
  "success": true,
  "listings": [
    {
      "id": "123",
      "title": "Vintage Chair",
      "price": 45.99,
      "description": "A nice vintage chair in good condition",
      "image_url": "https://...",
      "seller_name": "John Doe",
      "location": "San Francisco, CA",
      "created_at": "2024-01-01T10:00:00Z",
      "listing_url": "https://..."
    }
  ],
  "total_count": 10
}
```

## Setup Instructions

1. Clone the repository
2. Open the project in Android Studio
3. Update the API base URL in `MarketplaceApiClient.java` if needed
4. Build and run the application

## Permissions

The app requires the following permissions (defined in AndroidManifest.xml):
- `INTERNET` - For making API calls
- `ACCESS_NETWORK_STATE` - For checking network connectivity
