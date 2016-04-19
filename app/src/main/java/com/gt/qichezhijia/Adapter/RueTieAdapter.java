package com.gt.qichezhijia.Adapter;

import android.content.Context;
import android.widget.TextView;

import com.gt.qichezhijia.R;
import com.gt.qichezhijia.bean.RueTie_info;


/**
 * Created by Administrator on 2015/11/24 0024.
 */
public class RueTieAdapter  extends AbsBaseAdapter<RueTie_info> {
    public RueTieAdapter(Context context, int resid) {
        super(context, resid);
    }

    @Override
    public void bindDatas(ViewHolder viewHolder, RueTie_info data) {
        TextView title = (TextView) viewHolder.getView(R.id.forum_rt_title);
        TextView bbs = (TextView) viewHolder.getView(R.id.forum_rt_bbs);
        TextView time = (TextView) viewHolder.getView(R.id.forum_rt_time);
        TextView reply = (TextView) viewHolder.getView(R.id.forum_rt_reply);
        title.setText(data.getTitle());
        bbs.setText(data.getBbsname());
        time.setText(data.getPostdate());
        reply.setText(data.getReplycounts()+"回帖");
    }
}
