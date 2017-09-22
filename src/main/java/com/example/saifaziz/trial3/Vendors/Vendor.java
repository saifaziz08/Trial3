package com.example.saifaziz.trial3.Vendors;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by saif aziz on 8/23/2017.
 */

public class Vendor {
    Integer id;
    String lName;
    String fName;
    double lon;
    double lat;
    boolean isVisible;

    public Vendor(String fName, String lName, double lat, double lon, Integer id, boolean isVisible)
    {
        this.id = id;
        this.lName = lName;
        this.fName = fName;
        this.lon = lon;
        this.lat = lat;
        this.isVisible = isVisible;
    }

    public boolean isVisible() {return isVisible; }
    public Integer getId() { return id; }
    public String getlName()
    {
        return lName;
    }
    public String getfName() { return fName; }
    public double getLon() { return lon; }
    public double getLat() { return lat; }
}
