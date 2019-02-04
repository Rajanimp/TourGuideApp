package com.example.tourguideapp.model;

public class Place {

    private String mPlaceName;
    private String mPlaceDetails;
    private String mPlacePhone;
    private String mPlaceDescription;
    private float mPlaceRating;
    private int mImageResourceId;
    private boolean hasImage;
    private boolean hasRating;

    public Place(String placeName, String placeDetails, String placePhone, String placeDescription) {
        this.mPlaceName = placeName;
        this.mPlaceDetails = placeDetails;
        this.mPlacePhone = placePhone;
        this.mPlaceDescription = placeDescription;
        hasImage = false;
        hasRating = false;
    }

    public Place(String placeName, float placeRating, String placeDetails, String placePhone, String placeDescription) {
        this.mPlaceName = placeName;
        this.mPlaceRating = placeRating;
        this.mPlaceDetails = placeDetails;
        this.mPlacePhone = placePhone;
        this.mPlaceDescription = placeDescription;
        hasImage = false;
        hasRating = true;
    }

    public Place(String mPlaceName, String mPlaceDetails, String placePhone, String placeDescrtiption, int mImageResourceId) {
        this.mPlaceName = mPlaceName;
        this.mPlaceDetails = mPlaceDetails;
        this.mPlacePhone = placePhone;
        this.mPlaceDescription = placeDescrtiption;
        this.mImageResourceId = mImageResourceId;
        hasImage = true;
        hasRating = false;
    }

    public String getPlaceName() {
        return mPlaceName;
    }

    public float getPlaceRating(){
        return mPlaceRating;
    }

    public String getPlaceDetails() {
        return mPlaceDetails;
    }

    public String getPlacePhone() {
        return mPlacePhone;
    }

    public String getPlaceDescription(){
        return mPlaceDescription;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage(){
        return hasImage;
    }

    public boolean hasRating(){
        return hasRating;
    }
}
