package com.gt.qichezhijia.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gt.qichezhijia.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_user extends Fragment {

    public Fragment_user() {

    }

    public static Fragment_user getIntance(){
        Fragment_user fu = new Fragment_user();
        return fu;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }


}
