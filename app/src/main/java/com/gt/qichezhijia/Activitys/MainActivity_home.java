package com.gt.qichezhijia.Activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gt.qichezhijia.Fragments.Fragment_car;
import com.gt.qichezhijia.Fragments.Fragment_discover;
import com.gt.qichezhijia.Fragments.Fragment_forum;
import com.gt.qichezhijia.Fragments.Fragment_recommend;
import com.gt.qichezhijia.Fragments.Fragment_user;
import com.gt.qichezhijia.R;

public class MainActivity_home extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{
//https://github.com/wxjqgt/App_qichezhijia.git
    private RadioGroup radioGroup_home;

    private FragmentManager manager;
    private Fragment lastfragment = null;
    private long firstTime;
    private boolean isFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        radioGroup_home = (RadioGroup) findViewById(R.id.radiogroup_home);
        radioGroup_home.check(R.id.radiobutton_recommend);
        manager = getSupportFragmentManager();
        initRadiogroup();

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        manager.beginTransaction().hide(lastfragment).commit();
        switch (checkedId) {
            case R.id.radiobutton_recommend:
                Fragment_recommend fr = (Fragment_recommend) manager.findFragmentByTag("recommend");
                manager.beginTransaction().show(fr).commit();
                lastfragment = fr;
                break;
            case R.id.radiobutton_forum:
                Fragment_forum ff = (Fragment_forum) manager.findFragmentByTag("forum");
                if (ff != null){
                    manager.beginTransaction().show(ff).commit();
                }else {
                    ff = Fragment_forum.getIntance();
                    manager.beginTransaction().add(R.id.fragment_home, ff, "forum").commit();
                }
                lastfragment = ff;
                break;
            case R.id.radiobutton_car:
                Fragment_car fc = (Fragment_car) manager.findFragmentByTag("car");
                if (fc != null){
                    manager.beginTransaction().show(fc).commit();
                }else {
                    fc = Fragment_car.getIntance();
                    manager.beginTransaction().add(R.id.fragment_home, fc, "car").commit();
                }
                lastfragment = fc;
                break;
            case R.id.radiobutton_discover:
                Fragment_discover fd = (Fragment_discover) manager.findFragmentByTag("discover");
                if (fd != null){
                    manager.beginTransaction().show(fd).commit();
                }else {
                    fd = Fragment_discover.getIntance();
                    manager.beginTransaction().add(R.id.fragment_home, fd, "discover").commit();
                }
                lastfragment = fd;
                break;
            case R.id.radiobutton_user:
                Fragment_user fu = (Fragment_user) manager.findFragmentByTag("user");
                if (fu != null){
                    manager.beginTransaction().show(fu).commit();
                }else {
                    fu = Fragment_user.getIntance();
                    manager.beginTransaction().add(R.id.fragment_home, fu, "user").commit();
                }
                lastfragment = fu;
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if(isFirst){
            firstTime = System.currentTimeMillis();
            isFirst = false;
            Toast.makeText(this, "再按一次返回键退出当前应用", Toast.LENGTH_SHORT).show();
        }else{
            long secondTime = System.currentTimeMillis();
            if(secondTime - firstTime <= 2000){
                finish();
            }else{
                Toast.makeText(this, "再按一次返回键退出当前应用", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
            }
        }
    }


    private void initRadiogroup() {
        FragmentTransaction ft = manager.beginTransaction();
        Fragment_recommend fr = Fragment_recommend.getIntance();
        lastfragment = fr;
        ft.add(R.id.fragment_home, fr, "recommend");
        ft.commit();
        radioGroup_home.setOnCheckedChangeListener(this);
    }


}
