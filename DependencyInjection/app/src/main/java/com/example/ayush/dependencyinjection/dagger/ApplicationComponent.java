package com.example.ayush.dependencyinjection.dagger;

import com.example.ayush.dependencyinjection.FragmentA;
import com.example.ayush.dependencyinjection.FragmentB;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component( modules = {
        ApplicationModule.class
} )
public interface ApplicationComponent {
    void inject(FragmentA fragmentA);
    void inject(FragmentB fragmentB);
}
