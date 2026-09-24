package org.dewqryp.tacocloud.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.ArrayList;
import java.util.List;

@Data
@UserDefinedType("taco")
public class TacoUDT {
    private final String name;
    private final List<IngredientUDT> ingredients;
}
