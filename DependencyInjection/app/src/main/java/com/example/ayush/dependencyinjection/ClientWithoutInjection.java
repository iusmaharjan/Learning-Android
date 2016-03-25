package com.example.ayush.dependencyinjection;

public class ClientWithoutInjection {

    private Service service;

    ClientWithoutInjection() {
        this.service = new Service();
    }

    public String greet() {
        return "Hello " + service.getName();
    }
}
