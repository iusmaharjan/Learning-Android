package com.example.ayush.dependencyinjection;

public class ServiceInjectorImpl implements ServiceInjectorInterface{
    @Override
    public ClientImpl getClient() {
        return new ClientImpl(new ServiceImpl());
    }
}
