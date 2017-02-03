package com.androidapp.astanasightseeing.astanasightseeing;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class HomePage extends AppCompatActivity {

    PlacesListAdapter adapter;
    MaterialSearchView materialSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
     {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        materialSearchView = (MaterialSearchView) findViewById(R.id.searchView);
        final ListView lvPlacesList = (ListView)findViewById(R.id.lvPlacesList);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //Set/Change Action Bar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("AstanaGuide");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        final List<Place> mPlaceList = Utility.populateTheList();
        adapter = new PlacesListAdapter(getApplicationContext(), mPlaceList);
         lvPlacesList.setAdapter(adapter);


        materialSearchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener(){

            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {
                final List<Place> mPlaceList = Utility.populateTheList();

                adapter = new PlacesListAdapter(getApplicationContext(), mPlaceList);

                lvPlacesList.setAdapter(adapter);
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

                        if(Pattern.compile(Pattern.quote(newText), Pattern.CASE_INSENSITIVE).matcher(p.placeName).find()){
                            listFound.add(p);

                        }
                    }
                    adapter = new PlacesListAdapter(getApplicationContext(), listFound);
                    lvPlacesList.setAdapter(adapter);

                }else{

                    adapter = new PlacesListAdapter(getApplicationContext(), mPlaceList);
                    lvPlacesList.setAdapter(adapter);
                }
                return true;
            }
        });

         lvPlacesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 System.out.println("position: " + mPlaceList.get(position).getPlaceId());
                 String chosenPlaceName = mPlaceList.get(position).getPlaceName();
                 Intent intent = new Intent(HomePage.this, PlaceInfoPage.class);
                 intent.putExtra("chosenPlaceName",chosenPlaceName);
                 startActivity(intent);
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