package com.example.tourguideapp.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.tourguideapp.R;
import com.example.tourguideapp.model.Place;

import java.util.ArrayList;

public class CustomListViewAdapter extends ArrayAdapter<Place> {

    public CustomListViewAdapter(Context context, ArrayList<Place> places) {
        super(context, 0, places);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Place currentLocation = getItem(position);
        View listItemView = convertView;

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;
        if(listItemView == null) {
            viewHolder = new ViewHolder();
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
            viewHolder.placeName = listItemView.findViewById(R.id.tv_name);
            viewHolder.placeRating = listItemView.findViewById(R.id.rating_bar);
            viewHolder.placeAddress = listItemView.findViewById(R.id.tv_address);
            viewHolder.placePhone = listItemView.findViewById(R.id.tv_phone);
            viewHolder.placeDescription = listItemView.findViewById(R.id.tv_description);
            viewHolder.placeImage = listItemView.findViewById(R.id.img_place);
            listItemView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) listItemView.getTag();
        }

        // Populate the data into the template view using the data object
        if(currentLocation != null){
            viewHolder.placeName.setText(currentLocation.getPlaceName());
            viewHolder.placeAddress.setText(currentLocation.getPlaceDetails());
            viewHolder.placePhone.setText(currentLocation.getPlacePhone());
            viewHolder.placeDescription.setText(currentLocation.getPlaceDescription());
            if(currentLocation.hasImage()){
                viewHolder.placeImage.setVisibility(View.VISIBLE);
                viewHolder.placeImage.setImageResource(currentLocation.getImageResourceId());
            }else {
                viewHolder.placeImage.setVisibility(View.GONE);
                viewHolder.placeName.setTextColor(Color.DKGRAY);
            }
            if(currentLocation.hasRating()){
                viewHolder.placeRating.setVisibility(View.VISIBLE);
                viewHolder.placeRating.setRating(currentLocation.getPlaceRating());
            }else {
                viewHolder.placeRating.setVisibility(View.GONE);
            }
        }
        return listItemView;
    }

    private static class ViewHolder {
        TextView placeName;
        RatingBar placeRating;
        TextView placeAddress;
        TextView placePhone;
        TextView placeDescription;
        ImageView placeImage;
    }
}
