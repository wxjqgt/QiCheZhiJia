package com.gt.qichezhijia.Adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.gt.qichezhijia.R;
import com.gt.qichezhijia.bean.JingXuan_info;
import com.gt.qichezhijia.utils.VolleyUtil;

/**
 * Created by Administrator on 2015/11/24 0024.
 */
public class JingXuanAdapter extends AbsBaseAdapter<JingXuan_info> {
    public JingXuanAdapter(Context context, int resid) {
        super(context, resid);
    }

    @Override
    public void bindDatas(ViewHolder viewHolder, JingXuan_info data) {
        TextView title = (TextView) viewHolder.getView(R.id.forum_all_title);
        TextView bbs = (TextView) viewHolder.getView(R.id.forum_all_bbsname);
        TextView reply = (TextView) viewHolder.getView(R.id.forum_all_reply);
        ImageView imageView = (ImageView) viewHolder.getView(R.id.forum_all_image);
        VolleyUtil.requestImage(data.getSmallpic(), imageView, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        title.setText(data.getTitle());
        bbs.setText(data.getBbsname());
        reply.setText(data.getReplycounts()+"回帖");
    }
}
