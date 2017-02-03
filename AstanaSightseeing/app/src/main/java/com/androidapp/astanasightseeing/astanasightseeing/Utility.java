package com.androidapp.astanasightseeing.astanasightseeing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bekmuratspayev on 2/2/17.
 */

public class Utility {


    public static List<Place> populateTheList(){
        List<Place> mPlaceList = new ArrayList<>();

        mPlaceList.add(new Place("0", "Bayterek ", R.drawable.baiterek_pic));
        mPlaceList.add(new Place("1", "Hazret Sultan", R.drawable.hazret_sultan_pic));
        mPlaceList.add(new Place("2", "Khan Shatyr", R.drawable.khan_shatyr_pic));
        mPlaceList.add(new Place("3", "Nur Astana", R.drawable.nur_astana_pic));
        mPlaceList.add(new Place("4", "Nurly Zhol", R.drawable.nurly_zhol_pic));

        return mPlaceList;
    }


}
