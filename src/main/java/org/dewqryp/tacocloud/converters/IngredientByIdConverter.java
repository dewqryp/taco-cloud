package org.dewqryp.tacocloud.converters;

import org.dewqryp.tacocloud.data.Ingredient;

import org.dewqryp.tacocloud.repositories.IngridientRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngridientRepository ingridientRepository;


    public IngredientByIdConverter(IngridientRepository ingridientRepository) {
        this.ingridientRepository = ingridientRepository;
    }

    public Ingredient convert(String id){
        return ingridientRepository.findById(id).orElse(null);
    }

}
