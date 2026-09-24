package org.dewqryp.tacocloud.data;


import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table("ingredients")
@AllArgsConstructor
public class Ingredient {
    @PrimaryKey
    private String id;

    private String name;

    private Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }


}
