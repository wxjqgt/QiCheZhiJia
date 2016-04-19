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
public class GridViewAadapter_discover extends BaseAdapter {

    private List<DiscovergridviewList> list = new ArrayList<>();
    private Context context;

    public GridViewAadapter_discover(Context context) {
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
                    R.layout.gridview_item_discover,parent,false);
            viewHolder.imageView_car = (ImageView) convertView.findViewById(R.id.imageView_car);
            viewHolder.textView_car = (TextView) convertView.findViewById(R.id.textView_car);
            viewHolder.textView_youhuicar = (TextView) convertView.findViewById(R.id.textView_youhuicar);
            viewHolder.textView_qianggoucar = (TextView) convertView.findViewById(R.id.textView_qianggoucar);
            convertView.setTag(viewHolder);
        }

        DiscovergridviewList info = list.get(position);
        viewHolder = (ViewHolder) convertView.getTag();
        MyImageloader.initImageLoader(context).displayImage(info.getLogo(),viewHolder.imageView_car);
        //app.imageLoader.displayImage(info.getIcon(),viewHolder.imageView_icon);
        viewHolder.textView_car.setText(info.getTitle());
        viewHolder.textView_qianggoucar.setText(info.getState());
        viewHolder.textView_youhuicar.setText(info.getShorttitle());

        return convertView;
    }

    class ViewHolder{
        ImageView imageView_car;
        TextView textView_car;
        TextView textView_youhuicar;
        TextView textView_qianggoucar;
    }
}

