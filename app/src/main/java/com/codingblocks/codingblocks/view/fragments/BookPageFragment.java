package com.codingblocks.codingblocks.view.fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingblocks.codingblocks.R;

import im.delight.android.webview.AdvancedWebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookPageFragment extends Fragment {



    AdvancedWebView webView;
    public static final String TAG = "BookPageFragment";
    public BookPageFragment() {
        // Required empty public constructor
    }

    public static BookPageFragment getInstance(String data,Boolean themeId){
        BookPageFragment  bookPageFragment = new BookPageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("data",data);
        bundle.putBoolean("themeId",themeId);
        bookPageFragment.setArguments(bundle);
        return bookPageFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_book_page, container, false);
         webView = (AdvancedWebView) root.findViewById(R.id.webview);
        String thisData = getArguments().getString("data");
        Log.d(TAG, "onCreateView: " + thisData);
        setData(thisData);


        return root;
    }

    public void replacePage(String data){
        setData(data);
    }


    public void setData(String data){
        String theme = "";
        int backgroundColor = R.color.bookLightBackground;
        if(!getArguments().getBoolean("themeId",false)){
            theme = "ct2";
            Log.d(TAG, "setData: " + theme);
            backgroundColor = R.color.bookDarkBakcground;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            webView.setBackgroundColor(getResources().getColor(backgroundColor,null));
        }else{
            webView.setBackgroundColor(getResources().getColor(backgroundColor));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<HTML><HEAD><LINK href=\"style.min.css\" type=\"text/css\" rel=\"stylesheet\"/></HEAD><body>");
        sb.append("<div class=\"gb without-animation with-summary font-size-2 font-family-1 ");
        sb.append(theme);
        sb.append("\">\n");
        sb.append("<div class=\"search-noresults\">\n <xq class=\"nm ms\">");
        sb.append(data);
        sb.append("</xq>\n"+
                "</div>\n" +
                "</div></body></HTML>");

        webView.setCookiesEnabled(false);
        webView.setMixedContentAllowed(false);
        webView.setGeolocationEnabled(false);
        webView.getSettings().setJavaScriptEnabled(false);
        webView.getSettings().setDatabaseEnabled(false);
        webView.getSettings().setDomStorageEnabled(false);
        webView.getSettings().setAppCacheEnabled(false);
        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setDisplayZoomControls(false);
        webView.animate();
        webView.loadDataWithBaseURL("file:///android_asset/",sb.toString(),"text/html","utf-8",null);

    }


}
