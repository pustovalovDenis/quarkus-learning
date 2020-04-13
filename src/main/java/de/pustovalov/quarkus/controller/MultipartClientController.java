package de.pustovalov.quarkus.controller;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.pustovalov.quarkus.entity.MultipartBody;
import de.pustovalov.quarkus.service.MultipartServiceRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/client")
public class MultipartClientController {

    @Inject
    @RestClient
    MultipartServiceRestClient service;

    @POST
    @Path("/multipart")
    @Produces(MediaType.TEXT_PLAIN)
    public String sendFile() {
        MultipartBody body = new MultipartBody();
        body.fileName = "greeting.txt";
        body.file = new ByteArrayInputStream("HELLO WORLD".getBytes(StandardCharsets.UTF_8));
        return service.sendMultipartData(body);
    }

}
