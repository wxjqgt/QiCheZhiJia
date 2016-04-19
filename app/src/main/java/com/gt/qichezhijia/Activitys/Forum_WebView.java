package com.gt.qichezhijia.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gt.qichezhijia.R;


/**
 * Created by Administrator on 2015/11/25 0025.
 */
public class Forum_WebView extends Activity implements View.OnClickListener{
    private WebView webView;
    private TextView web_return;
    private ImageView web_collect,web_share;
    private String detialUrl;
    private int isFirst=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forum_webview);
        initView();
    }

    private void initView() {
        webView= (WebView) findViewById(R.id.forum_webview);
        web_return = (TextView) findViewById(R.id.webview_return);
        web_share= (ImageView) findViewById(R.id.web_share);
        web_collect = (ImageView) findViewById(R.id.web_collected);
       detialUrl = getIntent().getStringExtra("detialUrl");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(detialUrl);
        web_return.setOnClickListener(this);
        web_share.setOnClickListener(this);
        web_collect.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.webview_return:
                onBackPressed();
                break;
            case R.id.web_share:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, detialUrl);
                startActivity(Intent.createChooser(intent,"选择分享到"));
                break;
            case R.id.web_collected:
                isFirst+=1;
                if (isFirst%2==1){
                    Toast.makeText(Forum_WebView.this,"取消收藏",Toast.LENGTH_SHORT).show();
                    web_collect.setImageResource(R.mipmap.bar_btn_car_collected);
                }else {
                    Toast.makeText(Forum_WebView.this, "收藏成功", Toast.LENGTH_SHORT).show();
                    web_collect.setImageResource(R.mipmap.bar_btn_car_collected_check);
                }
                break;
        }
    }
}
