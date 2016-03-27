package com.example.ayush.dependencyinjection.noDI;

public class ClientWithConstructorInjection {

    private Service service;

    public ClientWithConstructorInjection(Service service) {
        this.service = service;
    }

    public String greet() {
        return "Hello " + service.getName();
    }
}
