package com.androidapp.astanasightseeing.astanasightseeing;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.RemoteInput;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Double.parseDouble;

public class PlaceInfoPage extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, OnMapReadyCallback, GoogleMap.OnCameraMoveStartedListener,
        GoogleMap.OnCameraMoveListener,
        GoogleMap.OnCameraMoveCanceledListener,
        GoogleMap.OnCameraIdleListener{

    ScrollView svContainer;
    Button btnBack;
    private SliderLayout mDemoSlider;
    TextView tvPhotoCount;
    TextView tvPlaceName;
    TextView tvPlaceHistory;
    TextView tvPlaceAddr;
    TextView tvPlacePNum;
    TextView tvPlaceWebAddr;
    TextView tvPlaceWHrs;
    TextView tvPlaceBusNumber;

    ImageView ivWebAddr;

    MapView mapView;
    private GoogleMap googleMap;

    String pName;
    HashMap<String, Integer> pPhotos;
    String pHistory;
    String pLat;
    String pLon;
    String pAddr;
    String pPhoneNum;
    String pWebAddr;
    String pWHrs;
    String pBusNumber;

    public static final int LOCATION_PERMISSION_REQUEST_CODE = 100;
    public static List<Place> placeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_info_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        //Set/Change Action Bar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        svContainer = (ScrollView) findViewById(R.id.scMainContainer);
        btnBack = (Button) findViewById(R.id.btnBack);

        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        tvPlaceName = (TextView) findViewById(R.id.tvPlaceName);
        tvPlaceHistory = (TextView) findViewById(R.id.tvHistory);
        tvPlaceAddr = (TextView) findViewById(R.id.tvMapAddress);
        tvPlacePNum = (TextView) findViewById(R.id.tvPhoneAddress);
        tvPlaceWebAddr = (TextView) findViewById(R.id.tvWebAddress);
        tvPlaceWHrs = (TextView) findViewById(R.id.tvWHrs);
        tvPhotoCount = (TextView) findViewById(R.id.tvPhotoCount);
        tvPlaceBusNumber = (TextView) findViewById(R.id.tvBusTime);

        ivWebAddr = (ImageView) findViewById(R.id.ivWebAddr);

        //Get data from the database
        DbAccess databaseAccess = DbAccess.getInstance(this);
        databaseAccess.open();
        placeList = databaseAccess.getData();
        databaseAccess.close();

        int chosenPlaceId = getIntent().getExtras().getInt("chosenPlaceId");
        Place p = null;
        for(int i = 0; i < placeList.size(); i ++ ){
            if(placeList.get(i).getPlaceId() == chosenPlaceId){
               p = placeList.get(i);
            }
        }

        pName = p.getPlaceName();
        pPhotos = p.getpPhotos();
        pHistory = p.getpHistory();
        pLat = p.getpLat();
        pLon = p.getpLon();
        pAddr = p.getpAddress();
        pPhoneNum = p.getpPhoneNum();
        pWebAddr = p.getpWebAddress();
        pWHrs = p.getpWHrs();
        pBusNumber = p.getpBusNumber();

        tvPlaceName.setText(pName);
        tvPhotoCount.setText(pPhotos.keySet().size() + " "+ getResources().getString(R.string.Photo));
        tvPlaceHistory.setText(pHistory);
        tvPlaceAddr.setText(pAddr);
        tvPlacePNum.setText(pPhoneNum);
        tvPlaceWebAddr.setText(pWebAddr);
        tvPlaceWHrs.setText(pWHrs);
        tvPlaceBusNumber.setText(pBusNumber);

        System.out.println(pWebAddr+" here is the web address");

        if(pWebAddr == null) {
            tvPlaceWebAddr.setVisibility(View.GONE);
            ivWebAddr.setVisibility(View.GONE);
        }
        //System.out.println("Size of the here"+pPhotos.keySet().size());

        int i = 1;
        for (String name : pPhotos.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(getResources().getString(R.string.PhotoLabel) + " " + i++)
                    .image(pPhotos.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        // Gets to GoogleMap from the MapView and does initialization stuff
        mapView.setClickable(true);

        mapView.getMapAsync(PlaceInfoPage.this);

        mapView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onMapReady(GoogleMap map) {
        //DO WHATEVER YOU WANT WITH GOOGLEMAP
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            ActivityCompat.requestPermissions(PlaceInfoPage.this, new String[] { android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION },
                    LOCATION_PERMISSION_REQUEST_CODE);
            return;
        }

        //map.setMyLocationEnabled(true);
        map.getUiSettings().setMyLocationButtonEnabled(false);
        map.setTrafficEnabled(true);
        map.setIndoorEnabled(true);
        map.setBuildingsEnabled(true);
        map.getUiSettings().setZoomControlsEnabled(true);

        map.setOnCameraIdleListener(this);
        map.setOnCameraMoveStartedListener(this);
        map.setOnCameraMoveListener(this);
        map.setOnCameraMoveCanceledListener(this);


        // For dropping a marker at a point on the Map
        LatLng marker = new LatLng(Double.parseDouble(pLat),  Double.parseDouble(pLon));
        map.addMarker(new MarkerOptions().position(marker).title(pName).snippet(pLat+" , " + pLon));
        // For zooming automatically to the location of the marker
        CameraPosition cameraPosition = new CameraPosition.Builder().target(marker).zoom(15).build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }



    @Override
    protected void onResume()
    {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public final void onDestroy()
    {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public final void onLowMemory()
    {
        mapView.onLowMemory();
        super.onLowMemory();
    }

    @Override
    public final void onPause(){
        mapView.onPause();
        super.onPause();
    }

    @Override
    public void onCameraMove() {
        svContainer.requestDisallowInterceptTouchEvent(true);
    }

    @Override
    public void onCameraMoveCanceled() {
        svContainer.requestDisallowInterceptTouchEvent(false);
    }

    @Override
    public void onCameraIdle() {
        svContainer.requestDisallowInterceptTouchEvent(false);
    }

    @Override
    public void onCameraMoveStarted(int i) {
    }
}
