package com.iusmaharjan.realm;

import android.app.Application;

import timber.log.Timber;

public class RealmApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());
    }
}
