package com.androidapp.astanasightseeing.astanasightseeing;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utility {
    public static String chosenLanguage = "";
    public static List<Place> mPlaceList = new ArrayList<>();

    static int [] pIdArr;
    static String [] pNameArr;
    static TypedArray pImgArr;
    static HashMap <String,Integer> pPhotosMap;
    static String [] pHistoryArr;
    static String [] pLatArr;
    static String [] pLonArr;
    static String [] pAddressArr;
    static String [] pPhoneNumArr;
    static String [] pWebAddressArr;
    static String [] pWHrsArr;


    public static void populateTheList(List<Place> mPlaceList,Context context){

        pIdArr = context.getResources().getIntArray(R.array.arrOfPIds);
        pNameArr = context.getResources().getStringArray(R.array.arrOfPNames);
        pImgArr = context.getResources().obtainTypedArray(R.array.arrOfPPics_main);
        //HashMap is skipped because it is on the loop below
        pHistoryArr = context.getResources().getStringArray(R.array.arrOfPHistories);
        pLatArr = context.getResources().getStringArray(R.array.arrOfPLats);
        pLonArr = context.getResources().getStringArray(R.array.arrOfPLons);
        pAddressArr = context.getResources().getStringArray(R.array.arrOfPAddr);
        pPhoneNumArr = context.getResources().getStringArray(R.array.arrOfPPhoneAddr);
        pWebAddressArr = context.getResources().getStringArray(R.array.arrOfPWebAddr);
        pWHrsArr = context.getResources().getStringArray(R.array.arrOfPHrs);

        for(int i = 0; i <=12; i++){
            int pID = pIdArr[i];
            String pName = pNameArr[i];
            int pImg = pImgArr.getResourceId(i,-1);
            pPhotosMap = new HashMap<String,Integer>();
            populateTheHashMap(i,pPhotosMap);
            String pHistory = pHistoryArr[i];
            String pLat = pLatArr[i];
            String pLon = pLonArr[i];
            String pAddress = pAddressArr[i];
            String pPhoneNum = pPhoneNumArr[i];
            String pWebAddress = pWebAddressArr[i];
            String pWHrs = pWHrsArr[i];

            mPlaceList.add(new Place(pID, pName, pImg, pPhotosMap,pHistory,pLat,pLon,pAddress,pPhoneNum,pWebAddress,pWHrs));
            //mPlaceList.add(new Place(pID, pName, pImg));

        }

        //String URL = Resources.getSystem().getString(R.string.bayterek_history);
    }


    static void populateTheHashMap(int i, HashMap<String,Integer> pPhotos){
        switch (i){

            case 0:
                pPhotos.put("Photo 1", R.drawable.hazret_sultan_from_sides);
                pPhotos.put("Photo 2", R.drawable.hazret_sultan_from_sides_left);
                pPhotos.put("Photo 3", R.drawable.hazret_sultan_front_side_night);
                pPhotos.put("Photo 4", R.drawable.hazret_sultan_inside);
               // pPhotos.put("Photo 5", R.drawable.hazret_sultan_inside_zal1);
               // pPhotos.put("Photo 6", R.drawable.hazret_sultan_night);
               // pPhotos.put("Photo 7", R.drawable.hazret_sultan_night_salut);
               // pPhotos.put("Photo 8", R.drawable.hazret_sultan_pic);
                break;
            case 1:
                pPhotos.put("Photo 1", R.drawable.nur_astana_drone);
                pPhotos.put("Photo 2", R.drawable.nur_astana_from_left_side);
                pPhotos.put("Photo 3", R.drawable.nur_astana_front_side);
                pPhotos.put("Photo 4", R.drawable.nur_astana_front_side_front);
               // pPhotos.put("Photo 5", R.drawable.nur_astana_inside);
               // pPhotos.put("Photo 6", R.drawable.nur_astana_kupala);
               // pPhotos.put("Photo 7", R.drawable.nur_astana_pic);
                break;
            case 2:
                pPhotos.put("Photo 1", R.drawable.hsh_from_kmg_side);
                pPhotos.put("Photo 2", R.drawable.hsh_front);
                pPhotos.put("Photo 3", R.drawable.hsh_inside);
                pPhotos.put("Photo 4", R.drawable.hsh_inside_view);
                //pPhotos.put("Photo 5", R.drawable.hsh_leto);
                //pPhotos.put("Photo 6", R.drawable.hsh_night_from_nu_side);
                //pPhotos.put("Photo 7", R.drawable.hsh_night_salut);
                //pPhotos.put("Photo 8", R.drawable.hsh_ocean);
               // pPhotos.put("Photo 9", R.drawable.hsh_vecher);
                break;
            case 3:
                pPhotos.put("Photo 1", R.drawable.mast_night);
                pPhotos.put("Photo 2", R.drawable.mast_mega_outside);
                pPhotos.put("Photo 3", R.drawable.mast_eskalatory);
                pPhotos.put("Photo 4", R.drawable.mast_from_street);
                //pPhotos.put("Photo 5", R.drawable.mast_inside);
                //pPhotos.put("Photo 6", R.drawable.mast_kinopark);
                //pPhotos.put("Photo 7", R.drawable.mast_night);
                break;
            case 4:
                pPhotos.put("Photo 1", R.drawable.asia_park);
                pPhotos.put("Photo 2", R.drawable.aziya_park);
                break;
            case 5:
                pPhotos.put("Photo 1", R.drawable.opera_front);
                pPhotos.put("Photo 2", R.drawable.opera_inside);
                pPhotos.put("Photo 3", R.drawable.opera_zal);
                pPhotos.put("Photo 4", R.drawable.opera_side);
                //pPhotos.put("Photo 5", R.drawable.opera_zal);
                //pPhotos.put("Photo 6", R.drawable.opera_zal_f);
                //pPhotos.put("Photo 7", R.drawable.astana_opera);
                break;
            case 6:
                pPhotos.put("Photo 1", R.drawable.bayterek_back_side);
                pPhotos.put("Photo 2", R.drawable.bayterek_front);
                pPhotos.put("Photo 3", R.drawable.bayterek_at_night);
                pPhotos.put("Photo 4", R.drawable.bayterek_inside_second_floor);
                //pPhotos.put("Photo 5", R.drawable.bayterek_from_drone);
                //pPhotos.put("Photo 6", R.drawable.bayterek_inside);
                //pPhotos.put("Photo 7", R.drawable.bayterek_from_kmg_side);
                //pPhotos.put("Photo 8", R.drawable.bayterek_inside_hand);
                break;
            case 7:
                pPhotos.put("Photo 1", R.drawable.duman_akva);
                pPhotos.put("Photo 2", R.drawable.duman_astana);
                pPhotos.put("Photo 3", R.drawable.duman_front);
                pPhotos.put("Photo 4", R.drawable.duman_inside);
                //pPhotos.put("Photo 5", R.drawable.duman_inside_view);
                //pPhotos.put("Photo 6", R.drawable.duman_jungle);
                break;
            case 8:
                pPhotos.put("Photo 1", R.drawable.piramida_drone);
                pPhotos.put("Photo 2", R.drawable.piramida_drone_view);
                pPhotos.put("Photo 3", R.drawable.piramida_night);
                pPhotos.put("Photo 4", R.drawable.piramida_stol_krugli);
                //pPhotos.put("Photo 5", R.drawable.piramida_zal);
                //pPhotos.put("Photo 6", R.drawable.piramida_zal_hall);
                break;
            case 9:
                pPhotos.put("Photo 1", R.drawable.muzei_eagle);
                pPhotos.put("Photo 2", R.drawable.muzei_exponents);
                pPhotos.put("Photo 3", R.drawable.muzei_horses);
                pPhotos.put("Photo 4", R.drawable.muzei_inside_horses);
                //pPhotos.put("Photo 5", R.drawable.muzei_lazers);
                //pPhotos.put("Photo 6", R.drawable.muzei_outside);
                //pPhotos.put("Photo 7", R.drawable.muzei_outside_horses);
                break;
            case 10:
                pPhotos.put("Photo 1", R.drawable.alau_astana);
                pPhotos.put("Photo 2", R.drawable.alau_bassein);
                pPhotos.put("Photo 3", R.drawable.alau_outside);
                pPhotos.put("Photo 4", R.drawable.alau_night);
                //pPhotos.put("Photo 5", R.drawable.alau_night);
                //pPhotos.put("Photo 6", R.drawable.alau_outside);
                break;
            case 11:
                pPhotos.put("Photo 1", R.drawable.keruen_cinema);
                pPhotos.put("Photo 2", R.drawable.keruen_inside);
                pPhotos.put("Photo 3", R.drawable.keruen_outside);
                pPhotos.put("Photo 4", R.drawable.keruen_zal);
                break;
            case 12:
                pPhotos.put("Photo 1", R.drawable.arena_field);
                pPhotos.put("Photo 2", R.drawable.arena_from_sides);
                pPhotos.put("Photo 3", R.drawable.arena_night);
                pPhotos.put("Photo 4", R.drawable.arena_outside);
                //pPhotos.put("Photo 5", R.drawable.arena_shaktar);
                //pPhotos.put("Photo 6", R.drawable.astana_arena);
                break;
            default:
                break;
        }
    }


}
