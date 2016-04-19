package com.gt.qichezhijia.networkimageholderview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.CBPageAdapter;
import com.gt.qichezhijia.R;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Administrator on 2015/11/25.
 */
public class NetworkImageHolderView implements CBPageAdapter.Holder<String> {
    private ImageView imageView;
    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        imageView.setImageResource(R.mipmap.ic_launcher);
        ImageLoader.getInstance().displayImage(data,imageView);
    }
}
