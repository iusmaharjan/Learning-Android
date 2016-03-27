package com.example.ayush.dependencyinjection.constructorDI;

public class ServiceInjectorImpl implements ServiceInjectorInterface{
    @Override
    public ClientInterface getClient() {
        return new ClientImpl(new ServiceImpl());
    }
}
