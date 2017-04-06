package com.androidapp.astanasightseeing.astanasightseeing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class PlacesListAdapter extends BaseAdapter {

    static class ViewHolder {
        private ImageView placePic;
        private TextView placeName;
        int position;
    }

    private Context mContext;
    private List<Place> mPlaceList;

    public PlacesListAdapter(Context mContext, List<Place> mPlaceList){
        this.mContext = mContext;
        this.mPlaceList = mPlaceList;
    }

    @Override
    public int getCount() {
        return mPlaceList.size();
    }

    @Override
    public Object getItem(int i) {
        return mPlaceList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
       ViewHolder holder;

        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_places_list,viewGroup,false);
            holder.placePic = (ImageView) view.findViewById(R.id.ivPlacePic);
            holder.placeName = (TextView) view.findViewById(R.id.tvPlaceName);
            holder.position = i;
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        final Place place = mPlaceList.get(i);
        int place_id = mContext.getResources().getIdentifier(place.getPicName(), "drawable",
                mContext.getPackageName());

        holder.placePic.setImageResource(place_id);
        holder.placeName.setText(" "+place.getPlaceName());

        return view;
    }
}


