package com.dc.indonesia.juxinli.global;

import com.dc.indonesia.sdk.global.GlobalApplication;

/**
 * Created by ThinkPad on 2018/3/2.
 */

public class MyApplication extends GlobalApplication {
    public static MyApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
