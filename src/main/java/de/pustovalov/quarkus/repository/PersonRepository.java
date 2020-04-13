package de.pustovalov.quarkus.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import de.pustovalov.quarkus.entity.Person;
import de.pustovalov.quarkus.filter.PersonFilter;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    @Inject
    private EntityManager entityManager;

    public Person findByName(String name) {
        return find("name", name).firstResult();
    }

    public List<Person> search(PersonFilter filter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> root = criteriaQuery.from(Person.class);
        List<Predicate> operationList = createPredicateOperationList(filter, criteriaBuilder, root);
        return entityManager.createQuery(
            criteriaQuery.where(criteriaBuilder.and(operationList.toArray(new Predicate[0])))
                         .orderBy(criteriaBuilder.asc(root.get(Person.Fields.id)))
        ).getResultList();
    }

    private List<Predicate> createPredicateOperationList(PersonFilter filter, CriteriaBuilder criteriaBuilder, Root<?> root) {
        List<Predicate> operationList = new ArrayList<>();

        Optional.ofNullable(filter.getId())
                .ifPresent(val -> operationList.add(criteriaBuilder.equal(root.get(Person.Fields.id), val)));

        Optional.ofNullable(filter.getSurname())
                .ifPresent(val -> operationList.add(criteriaBuilder.equal(root.get(Person.Fields.surname), val)));

        Optional.ofNullable(filter.getName())
                .ifPresent(val -> operationList.add(criteriaBuilder.equal(root.get(Person.Fields.name), val)));

        return operationList;
    }

}
