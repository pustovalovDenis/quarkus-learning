package de.pustovalov.quarkus.service;

import java.util.Set;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import de.pustovalov.quarkus.entity.Country;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/v2")
@RegisterRestClient
public interface CountriesServiceRestClient {

    @GET
    @Path("/name/{name}")
    @Produces("application/json")
    Set<Country> getByName(@PathParam String name);

    @GET
    @Path("/all")
    @Produces("application/json")
    Set<Country> getAllCountriesInfo();

}
