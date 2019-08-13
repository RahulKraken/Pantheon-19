package com.kraken.pantheon19;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MyApplication extends Application {

    private static RequestQueue volleyRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        volleyRequestQueue = Volley.newRequestQueue(this);
    }

    public static RequestQueue getVolleyRequestQueue() {
        return volleyRequestQueue;
    }
}
