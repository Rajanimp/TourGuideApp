package com.example.tourguideapp.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tourguideapp.R;
import com.example.tourguideapp.adapters.CustomListViewAdapter;
import com.example.tourguideapp.model.Place;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        //Get all data required for populating the data object
        String restaurantNameList[] = getResources().getStringArray(R.array.restaurant_name);
        String restaurantAddressList[] = getResources().getStringArray(R.array.restaurant_address);
        String restaurantPhoneList[] = getResources().getStringArray(R.array.restaurant_phone);
        String restaurantDescriptionList[] = getResources().getStringArray(R.array.restaurant_description);
        float restaurantRatingList[] = {3.5f, 4, 4.5f, 5, 4, 4.5f, 3.5f, 3.5f, 4.5f, 4};

        ArrayList<Place> restaurantsList = new ArrayList<Place>();

        //Populate arraylist with details of the places
        for(int i = 0; i < restaurantNameList.length; i++){
            restaurantsList.add(new Place(restaurantNameList[i], restaurantRatingList[i], restaurantAddressList[i], restaurantPhoneList[i], restaurantDescriptionList[i]));
        }

        CustomListViewAdapter eventAdapter = new CustomListViewAdapter(getActivity(), restaurantsList);

        ListView restaurantsListView = rootView.findViewById(R.id.list);

        restaurantsListView.setAdapter(eventAdapter);
        return rootView;
    }

}
