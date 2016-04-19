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
import com.gt.qichezhijia.bean_recomend.kuaibao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/25.
 */
public class KuaiBaoAdapter extends BaseAdapter {
    private List<kuaibao> data = new ArrayList<>();
    private Context context;

    public void setDatas(List<kuaibao> datas){
        this.data.clear();
        this.data.addAll(datas);
        this.notifyDataSetChanged();
    }

    public KuaiBaoAdapter(Context context) {
        this.context = context;
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
            view = LayoutInflater.from(context).inflate(R.layout.kuaibao, parent, false);

            ImageView bgimage = (ImageView) view.findViewById(R.id.image1);

            TextView reviewcount = (TextView) view.findViewById(R.id.reviewcount);
            TextView typename = (TextView) view.findViewById(R.id.typename);
            TextView title_1 = (TextView) view.findViewById(R.id.title);
            TextView createtime = (TextView) view.findViewById(R.id.createtime);

            ViewHolder holder = new ViewHolder(bgimage, title_1, reviewcount, typename, createtime);

            view.setTag(holder);
        }

        kuaibao kuaibaos = data.get(position);
        ViewHolder holder = (ViewHolder) view.getTag();

        holder.title_1.setText(kuaibaos.getTitle());
        holder.reviewcount.setText(kuaibaos.getReviewcount());
        holder.typename.setText(kuaibaos.getTypename());
        holder.createtime.setText(kuaibaos.getCreatetime());

        ImageLoader.ImageListener listener = ImageLoader.getImageListener(
                holder.bgimage, R.drawable.abc_ic_menu_cut_mtrl_alpha,
                R.drawable.abc_ic_clear_mtrl_alpha);
        MyApp.loader.get(kuaibaos.getBgimage(), listener);
        return view;
    }

    public class ViewHolder {
        public ImageView bgimage;
        public TextView title_1, reviewcount, typename, createtime;

        public ViewHolder(ImageView bgimage, TextView title_1, TextView reviewcount, TextView typename, TextView createtime) {
            this.bgimage = bgimage;
            this.title_1 = title_1;
            this.reviewcount = reviewcount;
            this.typename = typename;
            this.createtime = createtime;
        }
    }

}
