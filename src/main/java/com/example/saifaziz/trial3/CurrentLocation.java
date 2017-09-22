package com.example.saifaziz.trial3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.concurrent.Executor;

/**
 * Created by saif aziz on 9/13/2017.
 */

public class CurrentLocation {
    MenuActivity menuActivity;
    FusedLocationProviderClient mFusedLocationClient;
    GoogleMap mMap;

    public CurrentLocation(MenuActivity menuActivity, FusedLocationProviderClient mFusedLocationClient, GoogleMap mMap){
        this.menuActivity = menuActivity;
        this.mFusedLocationClient = mFusedLocationClient;
        this.mMap = mMap;
    }
    public void addCurrentLocation(Boolean moveMap)
    {
        if (ActivityCompat.checkSelfPermission(menuActivity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(menuActivity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(menuActivity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);
            return;
        }

        mFusedLocationClient.getLastLocation().addOnSuccessListener(menuActivity, location ->
        {
            // Got last known location. In some rare situations this can be null.
            if (location != null)
            {
                LatLng currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(currentLocation).title("My Marker Location"));
                if(moveMap)
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLocation));
            }
        });
    }
}
