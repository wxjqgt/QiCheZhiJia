package com.gt.qichezhijia.app;

import android.app.Application;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.gt.qichezhijia.BuildConfig;
import com.gt.qichezhijia.utils.VolleyUtil;

import org.xutils.x;

/**
 * Created by Administrator on 2015/11/13.
 */
public class MyApp extends Application {

    public static RequestQueue queue;

    public static ImageLoader loader;

    @Override
    public void onCreate() {
        super.onCreate();
        VolleyUtil.initVolley(this);
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        queue = Volley.newRequestQueue(this);

        initImageLoader();
    }

    private void initImageLoader(){
        loader = new ImageLoader(MyApp.queue, new MyImageCache());
    }
    //ImageLoader的缓存类
    public class MyImageCache implements ImageLoader.ImageCache {
        private LruCache<String, Bitmap> imgCache;  //理解成一个Map集合
        public MyImageCache(){
            imgCache = new LruCache<String, Bitmap>(10 * 1024 * 1024){
                @Override
                protected int sizeOf(String key, Bitmap value) {

                    return value.getByteCount();  //返回Bitmap总共字节即可。  一定要和设置的容量单位保证一一直
                }
            };
        }
        //从缓存中读取数据
        @Override
        public Bitmap getBitmap(String url) {
            return imgCache.get(url);
        }
        //向缓存中存入数据  写入缓存
        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            imgCache.put(url, bitmap);

        }
    }


}
