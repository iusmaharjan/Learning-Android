package com.example.ayush.dependencyinjection.noDI;

public class ClientWithoutInjection {

    private Service service;

    public ClientWithoutInjection() {
        this.service = new Service();
    }

    public String greet() {
        return "Hello " + service.getName();
    }
}
