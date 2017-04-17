package com.androidapp.astanasightseeing.astanasightseeing;

import java.util.HashMap;

public class Place {

    int placeId;
    String placeName;
    String picName;
    HashMap <String,Integer> pPhotos;
    String pHistory;
    String pLat;
    String pLon;
    String pAddress;
    String pPhoneNum;
    String pWebAddress;
    String pWHrs;
    String category;

    String pBusNumber;

    public Place(int placeId, String placeName, String picName, String pHistory,String pLat, String pLon,String pAddress, String pPhoneNum, String pWebAddress,String pWHrs,String category,String pBusNumber){
        this.placeId = placeId;
        this.placeName = placeName;
        this.picName = picName;
        //hashmap
        pPhotos = new HashMap<String,Integer>();
        populateTheHashMap(placeId,pPhotos);

        this.pHistory = pHistory;
        this.pLat = pLat;
        this.pLon = pLon;
        this.pAddress = pAddress;
        this.pPhoneNum = pPhoneNum;
        this.pWebAddress = pWebAddress;
        this.pWHrs = pWHrs;
        this.category = category;
        this.pBusNumber = pBusNumber;
    }

    public String getpBusNumber() {
        return pBusNumber;
    }

    public void setpBusNumber(String pBusNumber) {
        this.pBusNumber = pBusNumber;
    }

    public HashMap<String, Integer> getpPhotos() {
        return pPhotos;
    }

    public void setpPhotos(HashMap<String, Integer> pPhotos) {
        this.pPhotos = pPhotos;
    }

    public String getpHistory() {
        return pHistory;
    }

    public void setpHistory(String pHistory) {
        this.pHistory = pHistory;
    }

    public String getpLat() {
        return pLat;
    }

    public void setpLat(String pLat) {
        this.pLat = pLat;
    }

    public String getpLon() {
        return pLon;
    }

    public void setpLon(String pLon) {
        this.pLon = pLon;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public String getpPhoneNum() {
        return pPhoneNum;
    }

    public void setpPhoneNum(String pPhoneNum) {
        this.pPhoneNum = pPhoneNum;
    }

    public String getpWebAddress() {
        return pWebAddress;
    }

    public void setpWebAddress(String pWebAddress) {
        this.pWebAddress = pWebAddress;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getpWHrs() {
        return pWHrs;
    }

    public void setpWHrs(String pWHrs) {
        this.pWHrs = pWHrs;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    static void populateTheHashMap(int place_ID, HashMap<String,Integer> pPhotos){
        switch (place_ID){

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
                pPhotos.put("Photo 1", R.drawable.main_asia_park);
                pPhotos.put("Photo 2", R.drawable.aziya_park);
                break;
            case 5:
                pPhotos.put("Photo 1", R.drawable.opera_front);
                //pPhotos.put("Photo 2", R.drawable.opera_inside);
                pPhotos.put("Photo 2", R.drawable.opera_zal);
                pPhotos.put("Photo 3", R.drawable.opera_side);
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
                pPhotos.put("Photo 2", R.drawable.main_duman_astana);
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
                pPhotos.put("Photo 1", R.drawable.alau_night);
                pPhotos.put("Photo 2", R.drawable.alau_bassein);
                pPhotos.put("Photo 3", R.drawable.alau_outside);
                //pPhotos.put("Photo 4", R.drawable.alau_night);
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
