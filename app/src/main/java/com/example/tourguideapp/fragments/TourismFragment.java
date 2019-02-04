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
public class TourismFragment extends Fragment {

    public TourismFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        //Get all data required for populating the data object
        String touristPlaceNameList[] = getResources().getStringArray(R.array.touristPlace_name);
        String touristPlaceAddressList[] = getResources().getStringArray(R.array.touristPlace_address);
        String touristPlacePhoneList[] = getResources().getStringArray(R.array.touristPlace_phone);
        String touristPlaceDescriptionList[] = getResources().getStringArray(R.array.touristPlace_description);
        int touristPlaceImagesList[] = {R.drawable.sree_chithra_art_gallery, R.drawable.thiruvananthapuram_zoo, R.drawable.veli_tourist_village,
                R.drawable.shankhumugham_beach, R.drawable.kovalam, R.drawable.magic_planet, R.drawable.science_and_technology_museum};

        ArrayList<Place> touristPlacesList = new ArrayList<Place>();

        //Populate arraylist with details of the places
        for(int i = 0; i < touristPlaceNameList.length; i++){
            touristPlacesList.add(new Place(touristPlaceNameList[i], touristPlaceAddressList[i], touristPlacePhoneList[i], touristPlaceDescriptionList[i], touristPlaceImagesList[i]));
        }

        CustomListViewAdapter eventAdapter = new CustomListViewAdapter(getActivity(), touristPlacesList);

        ListView touristPlacesListView = rootView.findViewById(R.id.list);

        touristPlacesListView.setAdapter(eventAdapter);
        return rootView;
    }

}
