package com.example.Prueba_compatible;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created with IntelliJ IDEA.
 * User: Cesar
 * Date: 24/11/13
 * Time: 21:23
 * To change this template use File | Settings | File Templates.
 */
public class CountryInfoFragment extends Fragment {
    WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_country_info,container,false);
        webView=(WebView)view.findViewById(R.id.webView);
        return  view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        String country=((CountryDetailActivity)getActivity()).getCountry();

        webView.loadUrl("http://es.m.wikipedia.org/wiki/"+country);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url) {
                view.loadUrl(url);
                return true;
            };
        });
    }
}
