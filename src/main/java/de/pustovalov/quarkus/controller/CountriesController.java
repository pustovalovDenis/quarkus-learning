package de.pustovalov.quarkus.controller;

import java.util.Set;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.pustovalov.quarkus.entity.Country;
import de.pustovalov.quarkus.service.CountriesServiceRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/country")
public class CountriesController {

    @Inject
    @RestClient
    CountriesServiceRestClient countriesService;

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Country> name(@PathParam String name) {
        return countriesService.getByName(name);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Country> getAllCountriesInfo() {
        return countriesService.getAllCountriesInfo();
    }

}
