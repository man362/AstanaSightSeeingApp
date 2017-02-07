package com.androidapp.astanasightseeing.astanasightseeing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.List;

public class PlacesListAdapter extends BaseAdapter {

    static class ViewHolder {
        private ImageView placePic;
        private TextView placeName;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
       ViewHolder holder;

        if(view == null){

            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.item_places_list,viewGroup,false);
            holder = new ViewHolder();
            holder.placePic = (ImageView) view.findViewById(R.id.ivPlacePic);
            holder.placeName = (TextView) view.findViewById(R.id.tvPlaceName);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        Place place = mPlaceList.get(i);

        //holder.placePic.setImageResource(place.getPlacePic());
        holder.placePic.setImageDrawable(mContext.getDrawable(place.getPlacePic()));

        holder.placeName.setText(" "+place.getPlaceName());

        return view;
    }


    class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
        private final WeakReference<ImageView> imageViewReference;
        private int data = 0;

        public BitmapWorkerTask(ImageView imageView) {
            // Use a WeakReference to ensure the ImageView can be garbage collected
            imageViewReference = new WeakReference<ImageView>(imageView);
        }

        // Decode image in background.
        @Override
        protected Bitmap doInBackground(Integer... params) {
            data = params[0];

            return BitmapFactory.decodeResource(mContext.getResources(),
                    data);
        }

        // Once complete, see if ImageView is still around and set bitmap.
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (imageViewReference != null && bitmap != null) {
                final ImageView imageView = imageViewReference.get();
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        }
    }
}


