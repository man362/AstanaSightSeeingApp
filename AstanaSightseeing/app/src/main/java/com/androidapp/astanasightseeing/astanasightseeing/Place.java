package com.androidapp.astanasightseeing.astanasightseeing;

/**
 * Created by B_k_spaev on 02.02.2017.
 */

public class Place {

    String placeId;
    String placeName;
    int placePic;

    public Place(String placeId, String placeName, int placePic
    ){
        this.placeId = placeId;
        this.placeName = placeName;
        this.placePic = placePic;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
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
