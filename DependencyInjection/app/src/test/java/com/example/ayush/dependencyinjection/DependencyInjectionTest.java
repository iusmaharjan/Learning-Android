package com.example.ayush.dependencyinjection;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class DependencyInjectionTest {

    @Test
    public void testClientWithoutDependencyInjection() throws Exception {
        ClientWithoutInjection clientWithoutInjection = new ClientWithoutInjection();
        System.out.println(clientWithoutInjection.greet());
        assertEquals("Hello " + new Service().getName(), clientWithoutInjection.greet());
    }

    @Test
    public void testClientWithConstructorInjection() throws Exception {
        Service service = new Service();
        ClientWithConstructorInjection clientWithConstructorInjection = new ClientWithConstructorInjection(service);
        System.out.println(clientWithConstructorInjection.greet());
        assertEquals("Hello " + service.getName(), clientWithConstructorInjection.greet());
    }

    @Test
    public void testDependencyInjection() throws Exception {
        ServiceInjectorImpl serviceInjector = new ServiceInjectorImpl();
        ClientImpl client = serviceInjector.getClient();
        System.out.println(client.greet());
    }
}