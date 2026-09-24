package org.dewqryp.tacocloud.repositories;

import org.dewqryp.tacocloud.data.Ingredient;

import java.util.Optional;

public interface IngridientRepository {

    Iterable<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient save(Ingredient ingredient);

}
