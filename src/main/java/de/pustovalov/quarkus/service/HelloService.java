package de.pustovalov.quarkus.service;

import javax.enterprise.context.ApplicationScoped;

import de.pustovalov.quarkus.event.GreetingEventSource;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class HelloService {

    private final GreetingEventSource greetingEvent;

    public String greeting(String name) {
        greetingEvent.fireGreetingEvent(name);
        return "hello " + name;
    }

}
