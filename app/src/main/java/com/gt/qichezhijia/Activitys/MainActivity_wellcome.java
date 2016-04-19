package com.gt.qichezhijia.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.gt.qichezhijia.MyConfig.MyConfig;
import com.gt.qichezhijia.R;
import com.gt.qichezhijia.app.MyApp;
import com.gt.qichezhijia.utils.MyImageloader;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity_wellcome extends Activity implements View.OnClickListener{

    private ImageView im_wellcome;
    private Timer timer;
    private String openurl;
    private Button button_wellcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_wellcome);
        im_wellcome = (ImageView) findViewById(R.id.imageView_wellcome);
        button_wellcome = (Button) findViewById(R.id.button_wellcome);
        button_wellcome.setOnClickListener(this);
        StringRequest request = new StringRequest(MyConfig.URL_WELLCOME, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    JSONObject result = object.getJSONObject("result");
                    String imgurl = result.getString("imgurl");
                    openurl = result.getString("openurl");
                    MyImageloader.initImageLoader(getApplication()).displayImage(imgurl,im_wellcome);
                    im_wellcome.setOnClickListener(MainActivity_wellcome.this);
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(MainActivity_wellcome.this,MainActivity_home.class);
                            startActivity(intent);
                            finish();
                        }
                    }, 3000);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },null);
        MyApp.queue.add(request);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView_wellcome:
                Intent intent = new Intent(MainActivity_wellcome.this,Activity_details.class);
                intent.putExtra("type",1);
                intent.putExtra("openurl",openurl);
                startActivity(intent);
                timer.cancel();
                finish();
                break;
            case R.id.button_wellcome:
                Intent intent1 = new Intent(MainActivity_wellcome.this,MainActivity_home.class);
                startActivity(intent1);
                finish();
                break;
            default:
                break;
        }
    }
}
