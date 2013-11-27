package com.example.Prueba_compatible;

import android.support.v4.app.Fragment;
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
        View view = inflater.inflate(R.layout.fragment_country_info, container, false);
        webView = (WebView)view.findViewById(R.id.webView);
        int altura=getResources().getDisplayMetrics().heightPixels;
        webView.loadData("<div style=\"  color:#cccccc; text-align:center;\">Selecciona un pa&iacute;s de la lista </div>","text/html", "UTF-8");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof CountryDetailActivity) {
            String country = ((CountryDetailActivity)getActivity()).getCountry();
            loadWebViewContent(country);
        }
    }

    public void loadWebViewContent(String country) {
        webView.loadUrl("http://es.m.wikipedia.org/wiki/" + country);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }
}
