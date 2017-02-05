package com.androidapp.astanasightseeing.astanasightseeing;

import java.util.HashMap;

/**
 * Created by B_k_spaev on 02.02.2017.
 */

public class Place {

    int placeId;
    String placeName;
    int placePic;
    HashMap <String,Integer> pPhotos;
    String pHistory;
    String pLat;
    String pLon;
    String pAddress;
    String pPhoneNum;
    String pWebAddress;

    public String getpWHrs() {
        return pWHrs;
    }

    public void setpWHrs(String pWHrs) {
        this.pWHrs = pWHrs;
    }

    String pWHrs;

    public Place(int placeId, String placeName, int placePic){
        this.placeId = placeId;
        this.placeName = placeName;
        this.placePic = placePic;
    }

    public Place(int placeId, String placeName, int placePic
            ,HashMap <String,Integer> pPhotos, String pHistory,String pLat, String pLon,String pAddress, String pPhoneNum, String pWebAddress,String pWHrs){
        this.placeId = placeId;
        this.placeName = placeName;
        this.placePic = placePic;
        this.pPhotos = pPhotos;
        this.pHistory = pHistory;
        this.pLat = pLat;
        this.pLon = pLon;
        this.pAddress = pAddress;
        this.pPhoneNum = pPhoneNum;
        this.pWebAddress = pWebAddress;
        this.pWHrs = pWHrs;
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

    public int getPlacePic() {
        return placePic;
    }

    public void setPlacePic(int placePic) {
        this.placePic = placePic;
    }
}
