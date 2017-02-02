package com.androidapp.astanasightseeing.astanasightseeing;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class HomePage extends AppCompatActivity {

    PlacesListAdapter adapter;
    MaterialSearchView materialSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Material Search");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        materialSearchView = (MaterialSearchView) findViewById(R.id.searchView);

        final ListView lv = (ListView)findViewById(R.id.lvPlacesList);
        final List<Place> mPlaceList = new ArrayList<>();
        mPlaceList.add(new Place("0", "Bayterek ", R.drawable.baiterek_pic));
        mPlaceList.add(new Place("1", "Hazret Sultn", R.drawable.hazret_sultan_pic));
        mPlaceList.add(new Place("2", "Khan Shatyr", R.drawable.khan_shatyr_pic));
        mPlaceList.add(new Place("3", "Nur Astana", R.drawable.nur_astana_pic));
        mPlaceList.add(new Place("4", "Nurly Zhol", R.drawable.nurly_zhol_pic));

        adapter = new PlacesListAdapter(getApplicationContext(), mPlaceList);

        lv.setAdapter(adapter);




        materialSearchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener(){

            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {
                final ListView lv = (ListView)findViewById(R.id.lvPlacesList);
                final List<Place> mPlaceList = new ArrayList<>();
                mPlaceList.add(new Place("0", "Bayterek ", R.drawable.baiterek_pic));
                mPlaceList.add(new Place("1", "Hazret Sultn", R.drawable.hazret_sultan_pic));
                mPlaceList.add(new Place("2", "Khan Shatyr", R.drawable.khan_shatyr_pic));
                mPlaceList.add(new Place("3", "Nur Astana", R.drawable.nur_astana_pic));
                mPlaceList.add(new Place("4", "Nurly Zhol", R.drawable.nurly_zhol_pic));

                adapter = new PlacesListAdapter(getApplicationContext(), mPlaceList);

                lv.setAdapter(adapter);
            }
        });

        materialSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener(){


            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                if(newText != null && !newText.isEmpty()){
                    List<Place> listFound = new ArrayList<>();
                    for(Place p: mPlaceList){

                        System.out.println("Item ... " + p.placeName + " newText: " + newText);
                        if(Pattern.compile(Pattern.quote(newText), Pattern.CASE_INSENSITIVE).matcher(p.placeName).find()){
                            System.out.println("Contains ... ");
                            listFound.add(p);
                        }
                    }
                    adapter = new PlacesListAdapter(getApplicationContext(), listFound);

                    lv.setAdapter(adapter);
                }else{

                    adapter = new PlacesListAdapter(getApplicationContext(), mPlaceList);

                    lv.setAdapter(adapter);
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.actionSearch);
        materialSearchView.setMenuItem(item);
        return super.onCreateOptionsMenu(menu);
    }
}