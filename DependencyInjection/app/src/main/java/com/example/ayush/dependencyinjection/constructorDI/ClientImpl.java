package com.example.ayush.dependencyinjection.constructorDI;

public class ClientImpl implements ClientInterface {
    private ServiceInterface service;

    public ClientImpl(ServiceInterface service) {
        this.service = service;
    }

    @Override
    public String greet() {
        return "Hello " + service.getName();
    }
}
