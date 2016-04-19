package com.gt.qichezhijia.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.gt.qichezhijia.R;
import com.gt.qichezhijia.app.MyApp;
import com.gt.qichezhijia.bean_recomend.Xinwen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/25.
 */
public class XinWenAdapter extends BaseAdapter {
    private List<Xinwen> data = new ArrayList<>();
    private Context context;

    public XinWenAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<Xinwen> datas){
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
            view = LayoutInflater.from(context).inflate(R.layout.xinwen, parent, false);

            ImageView smallpic = (ImageView) view.findViewById(R.id.xinwen_item_image);

            TextView title_xinwen = (TextView) view.findViewById(R.id.xinwen_item_title);
            TextView time = (TextView) view.findViewById(R.id.xinwen_item_time);
            TextView replycount = (TextView) view.findViewById(R.id.replycount);

            ViewHolder holder = new ViewHolder(smallpic, title_xinwen, time, replycount);

            view.setTag(holder);
        }

        Xinwen xinwen = data.get(position);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.title_xinwen.setText(xinwen.getTitle());
        holder.time.setText(xinwen.getTime());
        holder.replycount.setText(xinwen.getReplycount());

        ImageLoader.ImageListener listener = ImageLoader.getImageListener(
                holder.smallpic, R.drawable.abc_ic_menu_cut_mtrl_alpha,
                R.drawable.abc_ic_clear_mtrl_alpha);
        MyApp.loader.get(xinwen.getSmallpic(), listener);
        return view;
    }

    public class ViewHolder {
        public ImageView smallpic;
        public TextView title_xinwen, time, replycount;

        public ViewHolder(ImageView smallpic, TextView title_xinwen, TextView time, TextView replycount) {
            this.smallpic = smallpic;
            this.title_xinwen = title_xinwen;
            this.time = time;
            this.replycount = replycount;
        }
    }

}
