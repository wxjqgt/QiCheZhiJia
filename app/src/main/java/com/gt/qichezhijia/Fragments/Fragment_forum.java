package com.gt.qichezhijia.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gt.qichezhijia.Adapter.MyPagerAdapter;
import com.gt.qichezhijia.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_forum extends Fragment {
    private View view;
    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private TextView[] titles;
    private List<Fragment>list;


    public Fragment_forum() {
        // Required empty public constructor
    }
    public static Fragment_forum getIntance(){
        Fragment_forum fc = new Fragment_forum();
        return fc;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_forum, container, false);
        initView();
        initTitles();
        initViewPager();
        return view;
    }
    private void initTitles() {
        titles = new TextView[linearLayout.getChildCount()];

        for (int i = 0; i < titles.length; i++) {

            titles[i] = (TextView) linearLayout.getChildAt(i);
            titles[i].setTextColor(Color.BLACK);
            titles[i].setEnabled(true);
            titles[i].setTag(i);
            titles[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem((int) v.getTag());
                }
            });
        }
        titles[0].setTextColor(Color.BLUE);
        titles[0].setEnabled(false);

    }

    private void initViewPager() {
        viewPager.setOffscreenPageLimit(3);

        list = new ArrayList<Fragment>();
        for (int i = 0; i < 3; i++) {
            Fragment_forum_fragment fragment = new Fragment_forum_fragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position", i);
            fragment.setArguments(bundle);
            list.add(fragment);
        }
        viewPager.setAdapter(new MyPagerAdapter(getFragmentManager(),list));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                for (int i = 0; i < titles.length; i++) {
                    titles[i].setTextColor(Color.BLACK);
                    titles[i].setEnabled(true);
                }
                titles[position].setTextColor(Color.BLUE);
                titles[position].setEnabled(false);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        viewPager= (ViewPager) view.findViewById(R.id.forum_viewpager);
        linearLayout = (LinearLayout) view.findViewById(R.id.forum_layout);

    }


}