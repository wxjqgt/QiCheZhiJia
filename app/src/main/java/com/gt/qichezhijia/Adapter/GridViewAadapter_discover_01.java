package com.gt.qichezhijia.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gt.qichezhijia.R;
import com.gt.qichezhijia.bean.DiscovergridviewList;
import com.gt.qichezhijia.utils.MyImageloader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/25.
 */
public class GridViewAadapter_discover_01 extends BaseAdapter {

    private List<DiscovergridviewList> list = new ArrayList<>();
    private Context context;

    public GridViewAadapter_discover_01(Context context) {
        this.context = context;
    }

    public void setData(List<DiscovergridviewList> data) {
        this.list = data;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.gridview_item_discover_01,parent,false);
            viewHolder.imageView_car_01 = (ImageView) convertView.findViewById(R.id.imageView_car_01);
            viewHolder.textView_title = (TextView) convertView.findViewById(R.id.textView_title);
            viewHolder.textView_fcprice = (TextView) convertView.findViewById(R.id.textView_fcprice);
            viewHolder.textView_yikoujia = (TextView) convertView.findViewById(R.id.textView_yikoujia);
            viewHolder.textView_price = (TextView) convertView.findViewById(R.id.textView_price);
            convertView.setTag(viewHolder);
        }

        DiscovergridviewList info = list.get(position);
        viewHolder = (ViewHolder) convertView.getTag();
        MyImageloader.initImageLoader(context).displayImage(info.getLogo(),viewHolder.imageView_car_01);
        //app.imageLoader.displayImage(info.getIcon(),viewHolder.imageView_icon);
        viewHolder.textView_title.setText(info.getTitle());
        viewHolder.textView_fcprice.setText(info.getFctprice());
        viewHolder.textView_price.setText(info.getPrice());
        viewHolder.textView_yikoujia.setText(info.getAdinfo());

        return convertView;
    }

    class ViewHolder{
        ImageView imageView_car_01;
        TextView textView_title;
        TextView textView_yikoujia;
        TextView textView_price;
        TextView textView_fcprice;
    }
}

