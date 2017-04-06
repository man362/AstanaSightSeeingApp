package com.androidapp.astanasightseeing.astanasightseeing;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
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
    public static List<Place> wholeList = new ArrayList<>();
    List<Place> filtered_list = new ArrayList<>();
    List<Place> displaying_list;
    public ListView lvPlacesList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //Get data from the database
        DbAccess databaseAccess = DbAccess.getInstance(this);
        databaseAccess.open();
        wholeList = databaseAccess.getData();
        displaying_list = wholeList;
        databaseAccess.close();

        //init the widgets
        materialSearchView = (MaterialSearchView) findViewById(R.id.searchView);
        lvPlacesList = (ListView)findViewById(R.id.lvPlacesList);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnBack = (Button) findViewById(R.id.btnBack);

        //Set/Change Action Bar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        adapter = new PlacesListAdapter(getApplicationContext(), displaying_list);
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
                    for(Place p: displaying_list){

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

                    adapter = new PlacesListAdapter(getApplicationContext(), displaying_list);
                    lvPlacesList.setAdapter(adapter);

                    lvPlacesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //System.out.println("position: " + mPlaceList.get(position).getPlaceId());
                            int chosenPlaceId = displaying_list.get(position).getPlaceId();
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
                 int chosenPlaceId = displaying_list.get(position).getPlaceId();
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionCategory:
                View v = this.findViewById(R.id.actionCategory);
                PopupMenu popupMenu = new PopupMenu(this, v);
                //Inflating the Popup using xml file
                popupMenu.getMenuInflater().inflate(R.menu.popup_category_menu, popupMenu.getMenu());
                //registering popup with OnMenuItemClickListener
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        filtered_list.clear();

                        if(item.getTitle().toString().equals("All") || item.getTitle().toString().equals("Барлығы") || item.getTitle().toString().equals("Все")){
                            adapter = new PlacesListAdapter(getApplicationContext(), wholeList);
                            displaying_list = wholeList;
                            lvPlacesList.setAdapter(adapter);
                            return true;
                        }

                        String comparingString = item.getTitle().toString();

                        if(item.getTitle().toString().equals("Мәдениет орындары") || item.getTitle().toString().equals("Культура"))
                            comparingString = "Culture";
                        else if(item.getTitle().toString().equals("Ойын-сауық орындары") || item.getTitle().toString().equals("Развлечение"))
                            comparingString = "Entertainment";

                        for(int i =0; i< wholeList.size(); i++){
                            if(wholeList.get(i).getCategory().equalsIgnoreCase(comparingString)){
                                filtered_list.add(wholeList.get(i));
                            }
                        }

                        displaying_list = filtered_list;
                        adapter = new PlacesListAdapter(getApplicationContext(), filtered_list);
                        lvPlacesList.setAdapter(adapter);
                        return true;
                    }
                });


                popupMenu.show();
                break;
    }
        return super.onOptionsItemSelected(item);
    }
}