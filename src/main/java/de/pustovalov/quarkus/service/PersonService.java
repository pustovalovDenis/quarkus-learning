package de.pustovalov.quarkus.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;

import de.pustovalov.quarkus.entity.Person;
import de.pustovalov.quarkus.filter.PersonFilter;
import de.pustovalov.quarkus.repository.PersonRepository;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person findByName(String name) {
        return personRepository.findByName(name);
    }

    public List<Person> search(PersonFilter filter) {
        return personRepository.search(filter);
    }

    public List<Person> findAll() {
        return personRepository.findAll().list();
    }

}
