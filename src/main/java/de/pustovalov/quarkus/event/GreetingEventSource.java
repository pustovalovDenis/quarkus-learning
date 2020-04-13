package de.pustovalov.quarkus.event;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@ApplicationScoped
public class GreetingEventSource {

    @Inject
    @GreetingObserves
    Event<String> simpleMessageEvent;

    public void fireGreetingEvent(String name) {
        simpleMessageEvent.fire(name);
    }

}
