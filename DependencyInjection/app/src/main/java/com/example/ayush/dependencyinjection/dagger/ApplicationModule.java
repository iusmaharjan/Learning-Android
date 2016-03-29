package com.example.ayush.dependencyinjection.dagger;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.ayush.dependencyinjection.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private App app;

    public ApplicationModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

}
