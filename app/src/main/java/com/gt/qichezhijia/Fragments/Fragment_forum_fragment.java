package com.gt.qichezhijia.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gt.qichezhijia.Activitys.Forum_WebView;
import com.gt.qichezhijia.Adapter.JingXuanAdapter;
import com.gt.qichezhijia.Adapter.RueTieAdapter;
import com.gt.qichezhijia.MyView.Forum_header;
import com.gt.qichezhijia.R;
import com.gt.qichezhijia.bean.JingXuan_info;
import com.gt.qichezhijia.bean.RueTie_info;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2015/11/23 0023.
 */
public class Fragment_forum_fragment extends Fragment implements View.OnClickListener {
    private View view;
    private LayoutInflater inflater;
    private JingXuanAdapter jingXuanAdapter;
    private RueTieAdapter rueTieAdapter;
    private ListView listView;
    private ViewGroup container;
    private List<JingXuan_info> jingXuan_infos;
    private boolean isLate = false;
    private LinearLayout layout;
    private int page = 1;
    private List<JingXuan_info> list = new ArrayList<>();
    private List<RueTie_info> list2 = new ArrayList<>();
    private List<RueTie_info> rueTie_infos;


    private TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, lastTv;

    private String url = "http://app.api.autohome.com.cn/autov5.0.5/club/jingxuantopic-pm2-c0-p2-s30.json";

    private String url2 = "http://app.api.autohome.com.cn/autov5.0.5/Club/shotfoumlist-pm1-p1-s50.json";
    private String detialUrl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;
        initPageView();
        return view;
    }


    private void initPageView() {
        Bundle bundle = getArguments();
        jingXuanAdapter = new JingXuanAdapter(getActivity(), R.layout.forum_all_item);

        if (bundle != null) {
            int position = bundle.getInt("position");
            switch (position) {

                case 0:
                    page = 1;

                    initJingxuan();

                    break;
                case 1:
                    page = 1;

                    initRueTie();

                    break;
                case 2:
                    this.view = inflater.inflate(R.layout.forum_changyong, container, false);
                    break;
            }
        }
    }

    private void initRueTie() {
        view = inflater.inflate(R.layout.forum_ruetie, container, false);
        listView = (ListView) this.view.findViewById(R.id.lv_forum_ruetie);
        layout = (LinearLayout) view.findViewById(R.id.forum_ruetie_layout);
        rueTieAdapter = new RueTieAdapter(getActivity(), R.layout.forum_ruetie_item);
        listView.setAdapter(rueTieAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String topicid = list2.get(position).getTopicid();

                detialUrl = "http://forum.app.autohome.com.cn/autov5.0.5/forum/club/topiccontent-a2-pm2-v5.0.5-t" + topicid + "-o0-p1-s20-c1-nt0-fs0-sp0-al0-cw480.json";
                Log.e("TAG", detialUrl);
                Intent intent = new Intent(getActivity(), Forum_WebView.class);
                intent.putExtra("detialUrl", detialUrl);
                startActivity(intent);
            }
        });
        initListView(2);
        loadData2();
    }


    private void initJingxuan() {
        view = inflater.inflate(R.layout.forum_all, container, false);
        listView = (ListView) view.findViewById(R.id.lv_forum_all);
        Forum_header forum_header = new Forum_header(getActivity());
        listView.addHeaderView(forum_header.getView());


        layout = (LinearLayout) view.findViewById(R.id.forum_all_layout);
        tv1 = (TextView) view.findViewById(R.id.tv1);
        tv2 = (TextView) view.findViewById(R.id.tv2);
        tv3 = (TextView) view.findViewById(R.id.tv3);
        tv4 = (TextView) view.findViewById(R.id.tv4);
        tv5 = (TextView) view.findViewById(R.id.tv5);
        tv6 = (TextView) view.findViewById(R.id.tv6);
        tv7 = (TextView) view.findViewById(R.id.tv7);
        tv8 = (TextView) view.findViewById(R.id.tv8);
        tv9 = (TextView) view.findViewById(R.id.tv9);
        tv10 = (TextView) view.findViewById(R.id.tv10);


        jingXuanAdapter = new JingXuanAdapter(getActivity(), R.layout.forum_all_item);
        listView.setAdapter(jingXuanAdapter);
        tv1.setTextColor(Color.BLUE);
        lastTv = tv1;
        loadData();
        initListView(1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String topicid = list.get(position).getTopicid();
                detialUrl = "http://forum.app.autohome.com.cn/autov5.0.5/forum/club/topiccontent-a2-pm2-v5.0.5-t" + topicid + "-o0-p1-s20-c1-nt0-fs0-sp0-al0-cw480.json";
                Log.e("TAG", detialUrl);
                Intent intent = new Intent(getActivity(), Forum_WebView.class);
                intent.putExtra("detialUrl", detialUrl);
                startActivity(intent);
            }
        });
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
        tv7.setOnClickListener(this);
        tv8.setOnClickListener(this);
        tv9.setOnClickListener(this);
        tv10.setOnClickListener(this);
    }

    private void initListView(final int number) {
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (isLate && scrollState == SCROLL_STATE_IDLE) {
                    layout.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (totalItemCount != 0) {
                    if (firstVisibleItem + visibleItemCount == totalItemCount) {
                        isLate = true;
                        page += 1;
                        if (number == 1) {
                            loadData();
                        } else {
                            loadData2();
                        }

                    } else {
                        isLate = false;
                        layout.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv1:
                url = "http://app.api.autohome.com.cn/autov5.0.5/club/jingxuantopic-pm2-c0-p";
                initColor(tv1);
                loadData();
                break;
            case R.id.tv2:
                url = "http://app.api.autohome.com.cn/autov5.0.5/club/jingxuantopic-pm2-c233-p";
                initColor(tv2);
                loadData();
                break;
            case R.id.tv3:
                url = "http://app.api.autohome.com.cn/autov5.0.5/club/jingxuantopic-pm2-c104-p";
                initColor(tv3);
                loadData();
                break;
            case R.id.tv4:
                url = "http://app.api.autohome.com.cn/autov5.0.5/club/jingxuantopic-pm2-c110-p";

                initColor(tv4);
                loadData();
                break;
            case R.id.tv5:
                url = "http://app.api.autohome.com.cn/autov5.0.5/club/jingxuantopic-pm2-c172-p";

                initColor(tv5);
                loadData();
                break;
            case R.id.tv6:
                url = "http://app.api.autohome.com.cn/autov5.0.5/club/jingxuantopic-pm2-c230-p";

                initColor(tv6);
                loadData();
                break;
            case R.id.tv7:
                url = "http://app.api.autohome.com.cn/autov5.0.5/club/jingxuantopic-pm2-c121-p";

                initColor(tv7);
                loadData();
                break;
            case R.id.tv8:
                url = "http://app.api.autohome.com.cn/autov5.0.5/club/jingxuantopic-pm2-c106-p";

                initColor(tv8);
                loadData();
                break;
            case R.id.tv9:
                url = "http://app.api.autohome.com.cn/autov5.0.5/club/jingxuantopic-pm2-c118-p";

                initColor(tv9);
                loadData();
                break;
            case R.id.tv10:
                url = "http://app.api.autohome.com.cn/autov5.0.5/club/jingxuantopic-pm2-c210-p";
                initColor(tv10);
                loadData();
                break;
        }

    }


    private void loadData() {
        url = url + page + "-s30.json";

        StringRequest stringRequest = new StringRequest(url, new Mylistener(), null);
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

    private void loadData2() {
        url2 = "http://app.api.autohome.com.cn/autov5.0.5/Club/shotfoumlist-pm1-p" + page + "-s50.json";
        StringRequest stringRequest = new StringRequest(url2, new Mylistener2(), null);
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

    private void initColor(TextView tv) {
        list.clear();
        page = 1;
        lastTv.setTextColor(Color.BLACK);
        tv.setTextColor(Color.BLUE);
        lastTv = tv;
    }


    public class Mylistener implements Response.Listener {

        @Override
        public void onResponse(Object response) {

            try {
                JSONObject object1 = new JSONObject(response.toString());
                JSONObject object2 = object1.getJSONObject("result");
                JSONArray array = object2.getJSONArray("list");
                jingXuan_infos = JSON.parseArray(array.toString(), JingXuan_info.class);

                list.addAll(jingXuan_infos);
                jingXuanAdapter.setDatas(list);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public class Mylistener2 implements Response.Listener {

        @Override
        public void onResponse(Object response) {

            try {
                JSONObject object1 = new JSONObject(response.toString());
                JSONObject object2 = object1.getJSONObject("result");
                JSONArray array = object2.getJSONArray("list");
                rueTie_infos = JSON.parseArray(array.toString(), RueTie_info.class);
                list2.addAll(rueTie_infos);
                rueTieAdapter.setDatas(list2);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}