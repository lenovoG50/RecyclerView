package com.example.demo.recyclerview;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.store.PersistentCookieStore;

/**
 * Created by 59246 on 2018/3/9.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkGo.init(this);
        try {
            OkGo.getInstance().setCookieStore(new PersistentCookieStore())
                    .setCacheTime(OkGo.DEFAULT_MILLISECONDS)
                    .setCacheMode(CacheMode.IF_NONE_CACHE_REQUEST)
                    .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS)
                    .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS)
                    .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS)
                    .debug("okGo")//打印log
                    .setCertificates();//信任所有证书
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
