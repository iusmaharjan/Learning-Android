package com.example.ayush.dependencyinjection.dagger;

import com.example.ayush.dependencyinjection.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component( modules = {
        ApplicationModule.class
} )
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
