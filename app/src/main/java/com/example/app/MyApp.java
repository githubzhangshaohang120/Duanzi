package com.example.app;

import android.app.Application;

import com.example.week1duanzi.bean.DaoMaster;
import com.example.week1duanzi.bean.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApp extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "baway.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
