package de.pustovalov.quarkus.controller;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.pustovalov.quarkus.entity.Person;
import de.pustovalov.quarkus.filter.PersonFilter;
import de.pustovalov.quarkus.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping(produces = MediaType.APPLICATION_JSON)
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON)
    public Person findByName(@PathParam("name") String name) {
        return personService.findByName(name);
    }

    /**
     * if you use Response and Quarkus can’t determine the beans that are serialized,
     * you need to annotate them with @RegisterForReflection.
     *
     * @param filter {@link PersonFilter}
     *
     * @return {@link Response} with list of {@link Person}
     */
    @PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public Response findAll(@RequestBody @NotEmpty PersonFilter filter) {
        return Response.ok(personService.search(filter)).build();
    }

}
