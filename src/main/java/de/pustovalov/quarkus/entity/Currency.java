package de.pustovalov.quarkus.entity;

import lombok.Data;

@Data
public class Currency {

    private String code;

    private String name;

    private String symbol;

}