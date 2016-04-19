package com.gt.qichezhijia.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.bigkoo.convenientbanner.CBViewHolderCreator;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.gt.qichezhijia.Adapter.KuaiBaoAdapter;
import com.gt.qichezhijia.Adapter.XinWenAdapter;
import com.gt.qichezhijia.MyConfig.MyConfig;
import com.gt.qichezhijia.R;
import com.gt.qichezhijia.app.MyApp;
import com.gt.qichezhijia.bean_recomend.Adv;
import com.gt.qichezhijia.bean_recomend.Newslidst;
import com.gt.qichezhijia.bean_recomend.Xinwen;
import com.gt.qichezhijia.bean_recomend.kuaibao;
import com.gt.qichezhijia.networkimageholderview.NetworkImageHolderView;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2015/11/24.
 */
public class ShowFragment_recomend extends Fragment {
    private View view, view_adv;
    private ListView listView;
    private MyNewAdapter adapter;
    private List<Adv> advs;

    private KuaiBaoAdapter kuaiBaoAdapter;
    private ConvenientBanner convenientBanner;//顶部广告栏控件
    private ArrayList<Integer> localImages = new ArrayList<Integer>();
    private List<String> networkImages;
    private ArrayAdapter transformerArrayAdapter;
    private ArrayList<String> transformerList = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        if (bundle != null && bundle.size() != 0) {
            int i = bundle.getInt("page");
            switch (i) {
                case 0:
                    view = inflater.inflate(R.layout.showfragment, container, false);
                    view_adv = inflater.inflate(R.layout.zuixin_adv, null);
                    initView();
                    getDataForNet();
                    addHeaderView();
                    break;
                case 1:
                    view = inflater.inflate(R.layout.showfragment, container, false);
                    listView = (ListView) view.findViewById(R.id.listview_show);
                    getDataForNet_Kuaibao();
                    break;
                case 2:
                    view = inflater.inflate(R.layout.showfragment, container, false);
                    listView = (ListView) view.findViewById(R.id.listview_show);
                    getDataForNet_Xinwen();
                    break;
                case 3:
                    view = inflater.inflate(R.layout.showfragment, container, false);
                    listView = (ListView) view.findViewById(R.id.listview_show);
                    getDataForNet_Daogou();
                    break;
                case 4:
                    break;
            }
        }
        return view;
    }

    private void getDataForNet_Daogou() {
        StringRequest request = new StringRequest(Request.Method.GET, MyConfig.URL_DAOGOU,
                new XinwenListener(), null);
        MyApp.queue.add(request);
    }

    private void getDataForNet_Xinwen() {
        StringRequest request = new StringRequest(Request.Method.GET, MyConfig.URL_XINWEN,
                new XinwenListener(), null);
        MyApp.queue.add(request);
    }

    private class XinwenListener implements Response.Listener<String>{

        @Override
        public void onResponse(String s) {
            try {
                JSONObject object = new JSONObject(s);
                JSONObject object1 = object.getJSONObject("result");
                JSONArray array = object1.getJSONArray("newslist");
                List<Xinwen> xinwens = JSON.parseArray(array + "", Xinwen.class);
                XinWenAdapter xinWenAdapter= new XinWenAdapter(getActivity());
                xinWenAdapter.setDatas(xinwens);
                listView.setAdapter(xinWenAdapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void getDataForNet_Kuaibao() {
        StringRequest request = new StringRequest(Request.Method.GET, MyConfig.URL_KUAIBAO,
                new KuaibaoListener(), null);
        MyApp.queue.add(request);
    }

    //初始化网络图片缓存库
    private void initImageLoader(){
        //网络图片例子,结合常用的图片缓存库UIL,你可以根据自己需求自己换其他网络图片库
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().
                showImageForEmptyUri(R.mipmap.ic_launcher)
                .cacheInMemory(true).cacheOnDisk(true).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity())
                .defaultDisplayImageOptions(defaultOptions)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();
        com.nostra13.universalimageloader.core.ImageLoader.getInstance().init(config);
    }

    /*
    加入测试Views
    * */
    private void loadTestDatas() {
        //本地图片集合
        for (int position = 0; position < 10; position++){
            localImages.add(getResId("ic_test_" + position, R.drawable.class));
        }
        //各种翻页效果
        transformerArrayAdapter.notifyDataSetChanged();
        //设置自动翻页效果
        convenientBanner.startTurning(5000);
    }

    /**
     * 通过文件名获取资源id 例子：getResId("icon", R.drawable.class);
     *
     * @param variableName
     * @param c
     * @return
     */
    public static int getResId(String variableName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }



    private class KuaibaoListener implements Response.Listener<String> {
        @Override
        public void onResponse(String s) {
            try {
                JSONObject object = new JSONObject(s);
                JSONObject object1 = object.getJSONObject("result");
                JSONArray array = object1.getJSONArray("list");
                List<kuaibao> kuaibaos = JSON.parseArray(array+"", kuaibao.class);

                kuaiBaoAdapter = new KuaiBaoAdapter(getActivity());
                kuaiBaoAdapter.setDatas(kuaibaos);

                listView.setAdapter(kuaiBaoAdapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    private void addHeaderView() {
        listView.addHeaderView(view_adv);
    }

    private void getDataForNet() {

        StringRequest request = new StringRequest(Request.Method.GET, MyConfig.URL_LIST,
                new NewListener(), null);
        MyApp.queue.add(request);

        StringRequest request1 = new StringRequest(Request.Method.GET, MyConfig.URL_ADV,
                new AdvListener(), null);
        MyApp.queue.add(request1);
    }

    private class AdvListener implements Response.Listener<String> {
        @Override
        public void onResponse(String s) {
            try {
                JSONObject object = new JSONObject(s);
                JSONObject object1 = object.getJSONObject("result");
                JSONArray array = object1.getJSONArray("adlist");
                advs = JSON.parseArray(array + "", Adv.class);
                for (int i = 0; i < advs.size(); i++){
                   // Log.d("print", advs.get(i).getImgpath());
                    networkImages.add(advs.get(i).getImgpath());
                }

                //显示广告栏
                initImageLoader();
                loadTestDatas();
                //将图片网址的集合networkImages传进来
                convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
                    @Override
                    public NetworkImageHolderView createHolder() {
                        return new NetworkImageHolderView();
                    }
                }, networkImages)
                        .setPageIndicator(new int[]{R.mipmap.icon_hollow_circle,
                                R.mipmap.icon_standard_circle});

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public class NewListener implements Response.Listener<String> {

        @Override
        public void onResponse(String response) {
            try {
                JSONObject object = new JSONObject(response);
                JSONObject object1 = object.getJSONObject("result");
                JSONArray array = object1.getJSONArray("newslist");
                List<Newslidst> datas = JSON.parseArray(array + "", Newslidst.class);
                adapter = new MyNewAdapter();
                adapter.setData(datas);
                listView.setAdapter(adapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

    private void initView() {

        listView = (ListView) view.findViewById(R.id.listview_show);
        adapter = new MyNewAdapter();
        networkImages = new ArrayList<>();

        convenientBanner = (ConvenientBanner) view_adv.findViewById(R.id.convenientBanner);
        transformerArrayAdapter = new ArrayAdapter(getActivity().getApplication()
                ,R.layout.adapter_transformer,transformerList);
    }

    public class MyNewAdapter extends BaseAdapter {
        private List<Newslidst> data = new ArrayList<>();

        public void setData(List<Newslidst> datas) {
            this.data.clear();
            this.data.addAll(datas);
            this.notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;

            if (view == null) {
                view = getActivity().getLayoutInflater().inflate(
                        R.layout.zuiixin_item, parent, false);

                ImageView smallpic = (ImageView) view.findViewById(R.id.zuixin_item_image);
                TextView title = (TextView) view.findViewById(R.id.zuixin_item_title);
                TextView time = (TextView) view.findViewById(R.id.zuixin_item_time);
                ViewHolder holder = new ViewHolder(smallpic, title, time);
                view.setTag(holder);
            }

            Newslidst newslidst = data.get(position);
            ViewHolder holder = (ViewHolder) view.getTag();
            holder.title.setText(newslidst.getTitle());
            holder.time.setText(newslidst.getTime());

            ImageLoader.ImageListener listener = ImageLoader.getImageListener(
                    holder.smallpic, R.drawable.abc_ic_menu_cut_mtrl_alpha,
                    R.drawable.abc_ic_clear_mtrl_alpha);
            MyApp.loader.get(newslidst.getSmallpic(), listener);
            return view;
        }

        public class ViewHolder {
            public ImageView smallpic;
            public TextView title, time;
            //123
            public ViewHolder(ImageView smallpic, TextView title, TextView time) {
                this.smallpic = smallpic;
                this.title = title;
                this.time = time;
            }
        }
    }

}
