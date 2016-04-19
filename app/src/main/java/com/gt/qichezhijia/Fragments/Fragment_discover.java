package com.gt.qichezhijia.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.bigkoo.convenientbanner.CBPageAdapter;
import com.bigkoo.convenientbanner.CBViewHolderCreator;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.gt.qichezhijia.Adapter.GridViewAadapter_discover;
import com.gt.qichezhijia.Adapter.GridViewAadapter_discover_01;
import com.gt.qichezhijia.Adapter.GridViewIcons_Adapter;
import com.gt.qichezhijia.Adapter.IconsInfo;
import com.gt.qichezhijia.MyConfig.MyConfig;
import com.gt.qichezhijia.R;
import com.gt.qichezhijia.app.MyApp;
import com.gt.qichezhijia.bean.Discover_List;
import com.gt.qichezhijia.bean.Discover_gridview;
import com.gt.qichezhijia.bean.DiscovergridviewList;
import com.gt.qichezhijia.bean.ViewPagerInfo;
import com.gt.qichezhijia.utils.MyImageloader;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_discover extends Fragment {

    @ViewInject(R.id.convenientBanner)
    private ConvenientBanner convenientBanner;

    @ViewInject(R.id.gridView_dikoujuan)
    private GridView gridView_dikoujuan;

    @ViewInject(R.id.image_icon_dikoujia)
    private ImageView image_icon_dikoujia;

    @ViewInject(R.id.text_11)
    private TextView text_11;

    @ViewInject(R.id.radioButton_dikoujia)
    private RadioButton radioButton_dikoujia;

    @ViewInject(R.id.gridView_yikoujia)
    private GridView gridView_yikoujia;

    @ViewInject(R.id.image_icon_yikoujia)
    private ImageView image_icon_yikoujia;

    @ViewInject(R.id.text_12)
    private TextView text_12;

    @ViewInject(R.id.radioButton_yikoujia)
    private RadioButton radioButton_yikoujia;

    @ViewInject(R.id.convenientBanner_icons)
    private ConvenientBanner convenientBanner_icons;

    private List<String> networkImages = new ArrayList<>();

    public Fragment_discover() {

    }

    public static Fragment_discover getIntance() {
        Fragment_discover fd = new Fragment_discover();
        return fd;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        x.view().inject(this, view);
        initBannerdata();
        initGridView();
        initIcons();
        return view;
    }

    private void initIcons() {
        StringRequest request_icons = new StringRequest(MyConfig.URL_ICON,
                new IconsListener(), null);
        MyApp.queue.add(request_icons);
    }

    private void initGridView() {
        StringRequest request_gridview = new StringRequest(MyConfig.URL_YIKOUJIA,
                new GoucheListener(), null);
        MyApp.queue.add(request_gridview);
    }

    private void initBannerdata() {
        StringRequest request = new StringRequest(MyConfig.URL_AD, new ADListener(), null);
        MyApp.queue.add(request);
        //开始自动翻页
        convenientBanner.startTurning(5000);//此值不能小于1200（即ViewPagerScroller的mScr
        // ollDuration的值），否则最后一页翻页效果会出问题。如果硬要兼容1200以下，
        // 那么请修改ViewPagerScroller的mScrollDuration的值，不过修改后，3d效果就没那么明显了。
        convenientBanner.setFocusable(true);
        convenientBanner.setFocusableInTouchMode(true);
        convenientBanner.requestFocus();
    }

    private void initconventBanner() {
        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, networkImages)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.mipmap.banner_page_normal,
                        R.mipmap.banner_page_selected})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                //设置翻页的效果，不需要翻页效果可用不设
                .setPageTransformer(ConvenientBanner.Transformer.DefaultTransformer);
//        convenientBanner.setManualPageable(false);//设置不能手动影响

        //停止翻页
        //convenientBanner.stopTurning();
    }

    private class IconsListener implements Response.Listener<String> {
        @Override
        public void onResponse(String s) {
            try {
                JSONObject object = new JSONObject(s);
                JSONObject result = object.getJSONObject("result");
                String list = result.getString("list");
                final List<ViewPagerInfo> info = JSON.parseArray(list.toString(), ViewPagerInfo.class);
                List<String> groupid = new ArrayList<>();
                for (int i = 0; i < info.size(); i++) {
                    groupid.add(info.get(i).getGroupid());
                }
                convenientBanner_icons.setPages(new CBViewHolderCreator<NetworkIconsHolderView>() {
                    @Override
                    public NetworkIconsHolderView createHolder() {
                        return new NetworkIconsHolderView(info);
                    }
                }, groupid)
                        //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                        .setPageIndicator(new int[]{R.mipmap.function_normal,
                                R.mipmap.function_selected})
                        //设置指示器的方向
                        .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                        //设置翻页的效果，不需要翻页效果可用不设
                        .setPageTransformer(ConvenientBanner.Transformer.DefaultTransformer);
//        convenientBanner.setManualPageable(false);//设置不能手动影响

                //停止翻页
                //convenientBanner.stopTurning();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private class NetworkIconsHolderView implements CBPageAdapter.Holder<String> {

        private GridView gridView;
        private List<ViewPagerInfo> info;

        public NetworkIconsHolderView(List<ViewPagerInfo> info) {
            this.info = info;
        }

        @Override
        public View createView(Context context) {
            //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
            gridView = new GridView(context);
            gridView.setColumnWidth(5);
            gridView.setNumColumns(4);
            gridView.setHorizontalSpacing(10);
            gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
            gridView.setVerticalSpacing(10);
            return gridView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            for (int i = 0;i<info.size();i++){
                if (info.get(i).getGroupid().equals(data)){
                    String list = info.get(i).getList();
                    List<IconsInfo> iconsinfo = JSON.parseArray(list,IconsInfo.class);
                    GridViewIcons_Adapter adapter = new GridViewIcons_Adapter(getActivity());
                    adapter.setData(iconsinfo);
                    gridView.setAdapter(adapter);
                }
            }
        }
    }

    private class GoucheListener implements Response.Listener<String> {
        @Override
        public void onResponse(String s) {
            try {
                JSONObject object = new JSONObject(s);
                JSONObject object1 = object.getJSONObject("result");
                initGridview_apricebuycar(object1);
                initGridview_discountbuycar(object1);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void initGridview_apricebuycar(JSONObject object1) {
        JSONObject object_apricebuycar = null;
        try {
            object_apricebuycar = object1.getJSONObject("apricebuycar");
            Discover_gridview data_apricebuycar = JSON.parseObject(
                    object_apricebuycar.toString(), Discover_gridview.class);
            List<DiscovergridviewList> lists = JSON.parseArray(data_apricebuycar.getList(), DiscovergridviewList.class);
            GridViewAadapter_discover_01 adapter_discover_01 = new GridViewAadapter_discover_01(getActivity());
            adapter_discover_01.setData(lists);
            gridView_yikoujia.setAdapter(adapter_discover_01);
            ImageLoader imageLoader = MyImageloader.initImageLoader(getActivity());
            imageLoader.displayImage(data_apricebuycar.getIconurl(), image_icon_yikoujia);
            text_12.setText(data_apricebuycar.getTitle());
            radioButton_yikoujia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void initGridview_discountbuycar(JSONObject object1) {
        JSONObject object_discountbuycar = null;
        try {
            object_discountbuycar = object1.getJSONObject("discountbuycar");
            Discover_gridview data_discountbuycar = JSON.parseObject(
                    object_discountbuycar.toString(), Discover_gridview.class);
            List<DiscovergridviewList> lists = JSON.parseArray(data_discountbuycar.getList(), DiscovergridviewList.class);
            GridViewAadapter_discover adapter_discover = new GridViewAadapter_discover(getActivity());
            adapter_discover.setData(lists);
            gridView_dikoujuan.setAdapter(adapter_discover);
            ImageLoader imageLoader = MyImageloader.initImageLoader(getActivity());
            imageLoader.displayImage(data_discountbuycar.getIconurl(), image_icon_dikoujia);
            text_11.setText(data_discountbuycar.getTitle());
            radioButton_dikoujia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private class NetworkImageHolderView implements CBPageAdapter.Holder<String> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            imageView.setImageResource(R.mipmap.ic_launcher);
            ImageLoader imageLoader = MyImageloader.initImageLoader(getActivity());
            imageLoader.displayImage(data, imageView);

        }
    }

    private class ADListener implements Response.Listener<String> {
        @Override
        public void onResponse(String s) {
            try {
                JSONObject object = new JSONObject(s);
                JSONObject object1 = object.getJSONObject("result");
                String result1 = object1.getString("list");
                List<Discover_List> list = JSONArray.parseArray(result1, Discover_List.class);
                for (Discover_List a : list) {
                    networkImages.add(a.getImgurl());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            initconventBanner();
        }
    }

}
