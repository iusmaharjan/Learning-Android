package com.example.ayush.dependencyinjection;

public class ClientWithConstructorInjection {

    private Service service;

    ClientWithConstructorInjection(Service service) {
        this.service = service;
    }

    public String greet() {
        return "Hello " + service.getName();
    }
}
