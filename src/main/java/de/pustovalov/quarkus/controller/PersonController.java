package de.pustovalov.quarkus.controller;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.core.MediaType;

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

    @PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public List<Person> findAll(@RequestBody @NotEmpty PersonFilter filter) {
        return personService.search(filter);
    }

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON)
    public Person findByName(@PathParam("name") String name) {
        return personService.findByName(name);
    }

}
