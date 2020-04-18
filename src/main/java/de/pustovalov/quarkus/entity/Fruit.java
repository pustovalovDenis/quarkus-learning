package de.pustovalov.quarkus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fruit {

    private String name;

    private String description;

}
