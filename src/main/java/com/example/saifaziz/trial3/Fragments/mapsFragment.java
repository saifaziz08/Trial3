package com.example.saifaziz.trial3.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.Nullable;

import com.example.saifaziz.trial3.R;


/**
 * Created by saif aziz on 9/14/2017.
 */

public class mapsFragment extends Fragment implements mapsFrag {
    View mySettings;
    @Nullable
    @Override
    public View OnCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        mySettings = inflater.inflate(R.layout.activity_maps, container, false);
        return mySettings;
    }


}
