package com.gt.qichezhijia.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gt.qichezhijia.R;
import com.gt.qichezhijia.utils.MyImageloader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/25.
 */
public class GridViewIcons_Adapter extends BaseAdapter {

    private List<IconsInfo> list = new ArrayList<>();
    private Context context;

    public GridViewIcons_Adapter(Context context) {
        this.context = context;
    }

    public void setData(List<IconsInfo> data) {
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
                    R.layout.icons_layout,parent,false);
            viewHolder.imageView_icons = (ImageView) convertView.findViewById(R.id.imageView_icons);
            viewHolder.textView_icons = (TextView) convertView.findViewById(R.id.textView_icons);
            convertView.setTag(viewHolder);
        }

        IconsInfo info = list.get(position);
        viewHolder = (ViewHolder) convertView.getTag();
        MyImageloader.initImageLoader(context).displayImage(info.getIconurl(),viewHolder.imageView_icons);
        //app.imageLoader.displayImage(info.getIcon(),viewHolder.imageView_icon);
        viewHolder.textView_icons.setText(info.getTitle());

        return convertView;
    }

    class ViewHolder{
        ImageView imageView_icons;
        TextView textView_icons;
    }
}
