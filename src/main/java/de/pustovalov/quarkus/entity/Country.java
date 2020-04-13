package de.pustovalov.quarkus.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    private String name;

    private String alpha2Code;

    private String capital;

    private List<Currency> currencies;

}
