package com.example.ayush.dependencyinjection.noDI;

public class Service {

    private String name;

    public Service() {
        name = "Dependency/Service";
    }

    public String getName() {
        return name;
    }
}
