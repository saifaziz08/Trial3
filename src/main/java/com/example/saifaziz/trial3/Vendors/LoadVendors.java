package com.example.saifaziz.trial3.Vendors;

import android.os.Handler;

import com.example.saifaziz.trial3.CurrentLocation;
import com.example.saifaziz.trial3.MapsActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MarkerOptions;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

/**
 * Created by saif aziz on 9/7/2017.
 */

public class LoadVendors {
    VendorProvider vendorProvider;
    GoogleMap mMap;
    CurrentLocation currentLocation;

    public LoadVendors(GoogleMap mMap, CurrentLocation currentLocation)
    {
        this.mMap = mMap;
        this.vendorProvider  = new VendorProvider(mMap);
        this.currentLocation = currentLocation;
        executeRunnable();
    }

    public void executeRunnable() {

        Handler mHandler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run()
            {
                refresh();
            }

            private void refresh()
            {
                boolean mStopHandler = false;
                try {
                    vendorProvider.populateVendors();
                    currentLocation.addCurrentLocation(false);
                    if (!mStopHandler)
                        mHandler.postDelayed(this, 10000);


                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        mHandler.post(runnable);
    }
}
