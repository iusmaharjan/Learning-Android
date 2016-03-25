package com.example.ayush.dependencyinjection;

public class ClientImpl {
    private ServiceInterface service;

    ClientImpl(ServiceInterface service) {
        this.service = service;
    }

    public String greet() {
        return "Hello " + service.getName();
    }
}
