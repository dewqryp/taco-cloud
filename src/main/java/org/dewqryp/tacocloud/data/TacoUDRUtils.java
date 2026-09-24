package org.dewqryp.tacocloud.data;

import java.util.List;

public class TacoUDRUtils {

    public static TacoUDT toTacoUDT(Taco taco){
        return new TacoUDT(taco.getName(), taco.getIngredients());
    }

    public static List<IngredientUDT> toIngredientsUDTs(List<Ingredient> ingredients){
        return ingredients.stream().map(ingredient -> toIngredientsUDT(ingredient)).toList();
    }
    public static IngredientUDT toIngredientsUDT(Ingredient ingredient){
        return new IngredientUDT(ingredient.getName(), ingredient.getType());
    }
}
