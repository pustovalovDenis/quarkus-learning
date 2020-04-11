package de.pustovalov.quarkus.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.BeanManager;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class HelloService {

    private final BeanManager beanManager;

    public String greeting(String name) {
        return "hello " + name;
    }

}
