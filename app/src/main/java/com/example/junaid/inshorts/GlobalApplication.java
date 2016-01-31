package com.example.junaid.inshorts;

import android.app.Application;

import com.example.junaid.inshorts.helpers.ImageHelper;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by junaid on 29/01/16.
 */
public class GlobalApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
//        ImageHelper.getInstance().init(getApplicationContext());
    }
}
