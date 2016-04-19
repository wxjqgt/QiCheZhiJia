package com.gt.qichezhijia.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gt.qichezhijia.Adapter.PagerAdapter_Recommend;
import com.gt.qichezhijia.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_recommend extends Fragment {
    private View view;

    private ViewPager viewPager;
    private ShowFragment_recomend showFragment_recomend;
    private TextView[] titles;
    private ImageView[] topline;
    private List<Fragment> list;

    private PagerAdapter_Recommend adapter;
    private LinearLayout daohanglan, layout_line;
    private int len = 5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_recommend, container, false);

        initView();
        viewPager.setOffscreenPageLimit(8);
        initViewPager();
        initTitles();
        initTopline();

        return view;
    }

    private void initTopline() {
        topline = new ImageView[len + 1];
        for (int i = 0; i < len + 1; i++){
            topline[i] = (ImageView) layout_line.getChildAt(i);
            topline[i].setVisibility(View.INVISIBLE);
        }
        topline[0].setVisibility(View.VISIBLE);
    }

    private void initTitles() {
        titles = new TextView[len];
        for (int i = 0; i < len; i++){
            titles[i] = (TextView) daohanglan.getChildAt(i);
            titles[i].setTextColor(Color.parseColor("#080c1a"));
            titles[i].setTag(i);
            titles[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem((Integer) v.getTag());
                }
            });
        }
        titles[0].setTextColor(Color.parseColor("#3a57a3"));
    }

    private void initViewPager() {
        list = new ArrayList<>();
        for (int i = 0; i < len; i++){
            showFragment_recomend = new ShowFragment_recomend();
            Bundle bundle = new Bundle();
            bundle.putInt("page", i);
            showFragment_recomend.setArguments(bundle);
            list.add(showFragment_recomend);
        }

        adapter = new PagerAdapter_Recommend(getActivity().getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < len; i++){
                    titles[i].setTextColor(Color.parseColor("#080c1a"));
                    topline[i].setVisibility(View.INVISIBLE);
                }
                titles[position].setTextColor(Color.parseColor("#3a57a3"));
                topline[position].setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        viewPager = (ViewPager) view.findViewById(R.id.pager_recommend);
        daohanglan = (LinearLayout) view.findViewById(R.id.daohanlan);
        layout_line = (LinearLayout) view.findViewById(R.id.layout_line);
    }


    public Fragment_recommend() {

    }

    public static Fragment_recommend getIntance(){
        Fragment_recommend fr = new Fragment_recommend();
        return fr;
    }

}




