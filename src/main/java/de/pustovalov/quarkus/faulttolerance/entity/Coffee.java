package de.pustovalov.quarkus.faulttolerance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {

    private Integer id;
    private String name;
    private String countryOfOrigin;
    private Integer price;

}
