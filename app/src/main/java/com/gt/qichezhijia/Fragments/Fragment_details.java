package com.gt.qichezhijia.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RadioButton;

import com.gt.qichezhijia.Activitys.MainActivity_home;
import com.gt.qichezhijia.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_details extends Fragment implements View.OnClickListener {


    public Fragment_details() {

    }

    public static Fragment_details getIntance(int type,String openurl) {
        Fragment_details fd = new Fragment_details();
        Bundle bundle = new Bundle();
        bundle.putInt("type",type);
        bundle.putString("openurl",openurl);
        fd.setArguments(bundle);
        return fd;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        Bundle bundle = getArguments();
        switch (bundle.getInt("type")){
            case 1:
                view = inflater.inflate(R.layout.fragment_details, container, false);
                RadioButton radioButton = (RadioButton) view.findViewById(R.id.radioButton);
                WebView webView = (WebView) view.findViewById(R.id.webview_details);
                webView.setWebChromeClient(new WebChromeClient());
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(bundle.getString("openurl"));
                radioButton.setOnClickListener(this);
                return view;
            default:
                break;
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), MainActivity_home.class);
        getActivity().startActivity(intent);
        getActivity().finish();
    }
}
