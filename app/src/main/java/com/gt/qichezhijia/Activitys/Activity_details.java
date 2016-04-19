package com.gt.qichezhijia.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.gt.qichezhijia.Fragments.Fragment_details;
import com.gt.qichezhijia.R;

public class Activity_details extends FragmentActivity {

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        manager = getSupportFragmentManager();
        Intent intent = getIntent();
        FragmentTransaction ft = manager.beginTransaction();
        Fragment_details fd = Fragment_details.getIntance(intent.getIntExtra("type",1),intent.getStringExtra("openurl"));
        ft.add(R.id.fragment_details, fd);
        ft.commit();

    }
}
