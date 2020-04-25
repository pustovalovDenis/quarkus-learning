package de.pustovalov.quarkus.reactive.routes;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RoutingExchange;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;

@ApplicationScoped
public class MyDeclarativeRoutes {

    @Route(path = "/route", methods = HttpMethod.GET)
    void hello(RoutingContext rc) {
        rc.response().end("hello");
    }

    @Route(path = "/route/greetings", methods = HttpMethod.GET)
    void greetings(RoutingExchange ex) {
        ex.ok("hello " + ex.getParam("name").orElse("world"));
    }
}
