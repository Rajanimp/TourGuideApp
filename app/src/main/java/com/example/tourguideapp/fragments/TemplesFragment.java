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
public class TemplesFragment extends Fragment {

    public TemplesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        //Get all data required for populating the data object
        String templeNameList[] = getResources().getStringArray(R.array.temple_name);
        String templeAddressList[] = getResources().getStringArray(R.array.temple_address);
        String templePhoneList[] = getResources().getStringArray(R.array.temple_phone);
        String templeDescriptionList[] = getResources().getStringArray(R.array.temple_description);
        int templeImagesList[] = {R.drawable.padmanabhaswamy, R.drawable.attukal, R.drawable.karikkakom,
                                    R.drawable.pazhavangadi, R.drawable.sreekanteswaram, R.drawable.thiruvallam};

        ArrayList<Place> templesList = new ArrayList<Place>();

        //Populate arraylist with details of the places
        for(int i = 0; i < templeNameList.length; i++){
            templesList.add(new Place(templeNameList[i], templeAddressList[i], templePhoneList[i], templeDescriptionList[i], templeImagesList[i]));
        }

        CustomListViewAdapter eventAdapter = new CustomListViewAdapter(getActivity(), templesList);

        ListView templesListView = rootView.findViewById(R.id.list);

        templesListView.setAdapter(eventAdapter);
        return rootView;
    }

}
