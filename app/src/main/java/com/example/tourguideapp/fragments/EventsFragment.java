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
public class EventsFragment extends Fragment {

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        //Get all data required for populating the data object
        String eventNameList[] = getResources().getStringArray(R.array.event_name);
        String eventDateAndTimeList[] = getResources().getStringArray(R.array.event_date_time);
        String eventVenueList[] = getResources().getStringArray(R.array.event_venue);
        String eventAddressList[] = getResources().getStringArray(R.array.event_address);

        ArrayList<Place> eventsList = new ArrayList<Place>();

        //Populate arraylist with details of the places
        for(int i = 0; i < eventNameList.length; i++){
            eventsList.add(new Place(eventNameList[i], eventDateAndTimeList[i], eventVenueList[i], eventAddressList[i]));
        }

        CustomListViewAdapter eventAdapter = new CustomListViewAdapter(getActivity(), eventsList);

        ListView eventsListView = rootView.findViewById(R.id.list);

        eventsListView.setAdapter(eventAdapter);

        return rootView;
    }
}
