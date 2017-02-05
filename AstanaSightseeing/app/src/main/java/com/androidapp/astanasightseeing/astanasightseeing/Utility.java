package com.androidapp.astanasightseeing.astanasightseeing;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bekmuratspayev on 2/2/17.
 */

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

        for(int i = 0; i < 12; i++){
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

            System.out.println("check this one:" + pHistory);

            mPlaceList.add(new Place(pID, pName, pImg, pPhotosMap,pHistory,pLat,pLon,pAddress,pPhoneNum,pWebAddress,pWHrs));
            //mPlaceList.add(new Place(pID, pName, pImg));

        }

        //String URL = Resources.getSystem().getString(R.string.bayterek_history);
    }


    static void populateTheHashMap(int i, HashMap<String,Integer> pPhotos){
        switch (i){

            case 0:
                pPhotos.put("Hannibal", R.drawable.baiterek_pic);
                pPhotos.put("Big Bang Theory", R.drawable.hazret_sultan_pic);
                pPhotos.put("House of Cards", R.drawable.khan_shatyr_pic);
                pPhotos.put("Game of Thrones", R.drawable.nur_astana_pic);
                break;
            case 1:
                pPhotos.put("Hannibal", R.drawable.baiterek_pic);
                pPhotos.put("Big Bang Theory", R.drawable.hazret_sultan_pic);
                pPhotos.put("House of Cards", R.drawable.khan_shatyr_pic);
                pPhotos.put("Game of Thrones", R.drawable.nur_astana_pic);
                break;
            case 2:
                pPhotos.put("Hannibal", R.drawable.baiterek_pic);
                pPhotos.put("Big Bang Theory", R.drawable.hazret_sultan_pic);
                pPhotos.put("House of Cards", R.drawable.khan_shatyr_pic);
                pPhotos.put("Game of Thrones", R.drawable.nur_astana_pic);
                break;
            case 3:
                pPhotos.put("Hannibal", R.drawable.baiterek_pic);
                pPhotos.put("Big Bang Theory", R.drawable.hazret_sultan_pic);
                pPhotos.put("House of Cards", R.drawable.khan_shatyr_pic);
                pPhotos.put("Game of Thrones", R.drawable.nur_astana_pic);
                break;
            case 4:
                pPhotos.put("Hannibal", R.drawable.baiterek_pic);
                pPhotos.put("Big Bang Theory", R.drawable.hazret_sultan_pic);
                pPhotos.put("House of Cards", R.drawable.khan_shatyr_pic);
                pPhotos.put("Game of Thrones", R.drawable.nur_astana_pic);
                break;
            case 5:
                pPhotos.put("Hannibal", R.drawable.baiterek_pic);
                pPhotos.put("Big Bang Theory", R.drawable.hazret_sultan_pic);
                pPhotos.put("House of Cards", R.drawable.khan_shatyr_pic);
                pPhotos.put("Game of Thrones", R.drawable.nur_astana_pic);
                break;
            case 6:
                pPhotos.put("Hannibal", R.drawable.baiterek_pic);
                pPhotos.put("Big Bang Theory", R.drawable.hazret_sultan_pic);
                pPhotos.put("House of Cards", R.drawable.khan_shatyr_pic);
                pPhotos.put("Game of Thrones", R.drawable.nur_astana_pic);
                break;
            case 7:
                pPhotos.put("Hannibal", R.drawable.baiterek_pic);
                pPhotos.put("Big Bang Theory", R.drawable.hazret_sultan_pic);
                pPhotos.put("House of Cards", R.drawable.khan_shatyr_pic);
                pPhotos.put("Game of Thrones", R.drawable.nur_astana_pic);
                break;
            case 8:
                pPhotos.put("Hannibal", R.drawable.baiterek_pic);
                pPhotos.put("Big Bang Theory", R.drawable.hazret_sultan_pic);
                pPhotos.put("House of Cards", R.drawable.khan_shatyr_pic);
                pPhotos.put("Game of Thrones", R.drawable.nur_astana_pic);
                break;
            case 9:
                pPhotos.put("Hannibal", R.drawable.baiterek_pic);
                pPhotos.put("Big Bang Theory", R.drawable.hazret_sultan_pic);
                pPhotos.put("House of Cards", R.drawable.khan_shatyr_pic);
                pPhotos.put("Game of Thrones", R.drawable.nur_astana_pic);
                break;
            case 10:
                pPhotos.put("Hannibal", R.drawable.baiterek_pic);
                pPhotos.put("Big Bang Theory", R.drawable.hazret_sultan_pic);
                pPhotos.put("House of Cards", R.drawable.khan_shatyr_pic);
                pPhotos.put("Game of Thrones", R.drawable.nur_astana_pic);
                break;
            case 11:
                pPhotos.put("Hannibal", R.drawable.baiterek_pic);
                pPhotos.put("Big Bang Theory", R.drawable.hazret_sultan_pic);
                pPhotos.put("House of Cards", R.drawable.khan_shatyr_pic);
                pPhotos.put("Game of Thrones", R.drawable.nur_astana_pic);
                break;
            case 12:
                pPhotos.put("Hannibal", R.drawable.baiterek_pic);
                pPhotos.put("Big Bang Theory", R.drawable.hazret_sultan_pic);
                pPhotos.put("House of Cards", R.drawable.khan_shatyr_pic);
                pPhotos.put("Game of Thrones", R.drawable.nur_astana_pic);
                break;
            case 13:
                pPhotos.put("Hannibal", R.drawable.baiterek_pic);
                pPhotos.put("Big Bang Theory", R.drawable.hazret_sultan_pic);
                pPhotos.put("House of Cards", R.drawable.khan_shatyr_pic);
                pPhotos.put("Game of Thrones", R.drawable.nur_astana_pic);
                break;
            default:
                break;
        }
    }


}
