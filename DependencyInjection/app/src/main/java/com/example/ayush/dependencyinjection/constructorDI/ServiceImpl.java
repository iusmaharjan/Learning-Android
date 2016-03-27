package com.example.ayush.dependencyinjection.constructorDI;

public class ServiceImpl implements ServiceInterface{

    private String name;

    public ServiceImpl() {
        name = "Dependency/Service";
    }

    @Override
    public String getName() {
        return name;
    }
}
