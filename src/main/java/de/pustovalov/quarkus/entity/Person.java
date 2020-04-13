package de.pustovalov.quarkus.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Entity
@Data
@FieldNameConstants
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    private LocalDate birth;

}
