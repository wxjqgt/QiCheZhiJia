package com.gt.qichezhijia.MyView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.gt.qichezhijia.R;


/**
 * Created by Administrator on 2015/11/26 0026.
 */
public class Forum_header {

    private static View view;

    private static Context context;

    public Forum_header(Context context) {
        this.context = context;
    }

    public static View getView() {

        view = LayoutInflater.from(context).inflate(R.layout.forum_header, null);

        view.measure(0, 0);//测量组件的宽高
        int headViewHeight = view.getMeasuredHeight();//获得测量后的宽高
        view.setPadding(0, -headViewHeight, 0, 0);
        return view;
    }
}
