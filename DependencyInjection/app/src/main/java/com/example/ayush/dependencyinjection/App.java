package com.example.ayush.dependencyinjection;

import android.app.Application;

import com.example.ayush.dependencyinjection.dagger.ApplicationComponent;
import com.example.ayush.dependencyinjection.dagger.ApplicationModule;
import com.example.ayush.dependencyinjection.dagger.DaggerApplicationComponent;

public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
