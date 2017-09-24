package com.example.saifaziz.trial3.Vendors;

import android.os.AsyncTask;

import com.example.saifaziz.trial3.Database.DatabaseAdapter;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

/**
 * Created by saif aziz on 8/23/2017.
 */

public class VendorProvider {
    GoogleMap mMap;
    ResultSet rs ;
    volatile HashMap<Integer, Marker>  markers;


    public VendorProvider(GoogleMap mMap){
        this.mMap = mMap;
        markers = new HashMap<Integer, Marker>();
    }

    public void populateVendors() throws SQLException, ExecutionException, InterruptedException
    {
        DatabaseAdapter dba = new DatabaseAdapter();
        dba.setQuery("SELECT * FROM Users;");
        rs = dba.execute().get();
        if (rs != null) {
            mMap.clear();
            while (rs.next()) {
                MarkerOptions markerOption = new MarkerOptions().position(new LatLng(rs.getDouble("lat"), rs.getDouble("long"))).title(rs.getString("fName") + rs.getString("lName"));
                Marker marker =  mMap.addMarker(markerOption);
                marker.setVisible(rs.getBoolean("isVisible"));
                markers.put(rs.getInt("idtest"),marker);
            }
        }
    }
}
