package com.gt.qichezhijia.bean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.gt.qichezhijia.R;

/**
 * Created by Administrator on 2015/11/24 0024.
 */
public class GetView {
    private Context context;
    public  static View getView(Context context,int position){
        View view= LayoutInflater.from(context).inflate(R.layout.forum_all,null);
//        listView = (ListView) view.findViewById(R.id.lv_forum_all);
//        radioGroup = (RadioGroup) view.findViewById(R.id.forum_all_radiogrout);
        return view;
    }

}
