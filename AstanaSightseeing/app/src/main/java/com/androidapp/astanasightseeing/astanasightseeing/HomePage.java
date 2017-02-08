package com.androidapp.astanasightseeing.astanasightseeing;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class HomePage extends AppCompatActivity {

    PlacesListAdapter adapter;
    MaterialSearchView materialSearchView;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState)
     {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
         //init the widgets
         materialSearchView = (MaterialSearchView) findViewById(R.id.searchView);
         final ListView lvPlacesList = (ListView)findViewById(R.id.lvPlacesList);
         Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         btnBack = (Button) findViewById(R.id.btnBack);

        //Set/Change Action Bar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));


        // Utility.populateTheList(Utility.mPlaceList,HomePage.this);
         adapter = new PlacesListAdapter(getApplicationContext(), Utility.mPlaceList);
         lvPlacesList.setAdapter(adapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        materialSearchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener(){

            @Override
            public void onSearchViewShown() {

                btnBack.setVisibility(View.GONE);
            }

            @Override
            public void onSearchViewClosed() {
                btnBack.setVisibility(View.VISIBLE);
                //Utility.mPlaceList.clear();
                //Utility.populateTheList(Utility.mPlaceList,HomePage.this);
                //adapter = new PlacesListAdapter(getApplicationContext(), Utility.mPlaceList);
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
                    final List<Place> listFound = new ArrayList<>();
                    for(Place p: Utility.mPlaceList){

                        if(Pattern.compile(Pattern.quote(newText), Pattern.CASE_INSENSITIVE).matcher(p.placeName).find()){
                            listFound.add(p);

                        }
                    }
                    adapter = new PlacesListAdapter(getApplicationContext(), listFound);
                    lvPlacesList.setAdapter(adapter);

                    lvPlacesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //System.out.println("position: " + mPlaceList.get(position).getPlaceId());
                            int chosenPlaceId = listFound.get(position).getPlaceId();
                            Intent intent = new Intent(HomePage.this, PlaceInfoPage.class);
                            intent.putExtra("chosenPlaceId", chosenPlaceId);
                            startActivity(intent);
                        }
                    });

                }else{

                    adapter = new PlacesListAdapter(getApplicationContext(), Utility.mPlaceList);
                    lvPlacesList.setAdapter(adapter);

                    lvPlacesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //System.out.println("position: " + mPlaceList.get(position).getPlaceId());
                            int chosenPlaceId = Utility.mPlaceList.get(position).getPlaceId();
                            Intent intent = new Intent(HomePage.this, PlaceInfoPage.class);
                            intent.putExtra("chosenPlaceId", chosenPlaceId);
                            startActivity(intent);
                        }
                    });
                }
                return true;
            }
        });



         lvPlacesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 //System.out.println("position: " + mPlaceList.get(position).getPlaceId());
                 int chosenPlaceId = Utility.mPlaceList.get(position).getPlaceId();
                 Intent intent = new Intent(HomePage.this, PlaceInfoPage.class);
                 intent.putExtra("chosenPlaceId", chosenPlaceId);
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


    @Override
    public void onBackPressed() {
     super.onBackPressed();
        Utility.mPlaceList.clear();
    }


}