package com.example.ayush.dependencyinjection;

import android.app.Application;

import com.example.ayush.dependencyinjection.dagger.ApplicationComponent;

public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
