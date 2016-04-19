package com.gt.qichezhijia.MyView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.HorizontalScrollView;

/**
 * Created by Ken on 2015/11/20.
 */
public class MyScrollView extends HorizontalScrollView{
    private static final String TAG = "print";

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        Log.d(TAG, "onScrollChanged() returned: " + l + "   " + t + "   " + oldl + "   " + oldt);
    }
}
