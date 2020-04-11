package de.pustovalov.quarkus.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.pustovalov.quarkus.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/hello")
@RequiredArgsConstructor
public class HelloController {

    private final HelloService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(@PathParam String name) {
        return service.greeting(name);
    }

}