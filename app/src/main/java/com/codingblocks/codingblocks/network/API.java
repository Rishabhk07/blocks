package com.codingblocks.codingblocks.network;

import android.content.Context;

import com.codingblocks.codingblocks.network.cacheInterceptors.OfflineResponseCacheInterceptors;
import com.codingblocks.codingblocks.network.cacheInterceptors.ResponseCacheInterceptor;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rishabhkhanna on 30/06/17.
 */

public class API {
    private static API apiInstance;
    public Retrofit retrofit;
    Context context;
    private API (Context context) {
        this.context = context;
        Cache cache = new Cache(
                new File("/cache"),
                1000*1000*100
        );

        OkHttpClient okhttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new ResponseCacheInterceptor())
                .addInterceptor(new OfflineResponseCacheInterceptors(context))
                .cache(new Cache(new File(context.getApplicationContext().getCacheDir(),
                        "apiResponses"),5*1024*1024))
                .build();

        retrofit
                 = new Retrofit.Builder().baseUrl("https://api.gitbook.com/")
                .client(okhttpClient)
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();
    }

    public static API getInstance(Context context){

        if(apiInstance == null){
            apiInstance = new API(context);
        }
        return apiInstance;
    }



}
