package de.pustovalov.quarkus.bean;

import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import de.pustovalov.quarkus.event.GreetingObserves;
import de.pustovalov.quarkus.service.HelloService;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class AppLifecycleBean {

    @ConfigProperty(name = "welcome.message")
    String welcomeMessage;

    private static final Logger LOGGER = Logger.getLogger("ListenerBean");

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("The application is starting..." + welcomeMessage);
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application is stopping...");
    }

    void onCallHelloService(@Observes HelloService ev) {
        LOGGER.info("HelloService was called..");
    }

    void onCallHelloServiceQualifiers(@Observes @GreetingObserves String name) {
        LOGGER.info("HelloService was called.. with name: " + name);
    }

}
