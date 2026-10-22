package org.dewqryp.tacocloud;

import org.dewqryp.tacocloud.controllers.IngredientController;
import org.dewqryp.tacocloud.data.Ingredient;
import org.dewqryp.tacocloud.repositories.IngredientRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IngredientControllerTest {
    private final IngredientRepository ingredientRepository = mock(IngredientRepository.class);
    private final IngredientController ingredientController = new IngredientController(ingredientRepository);
    @Test
    void getAllIngredients() {
        List<Ingredient> ingredients = new ArrayList<>(List.of(new Ingredient("Test", "Test Type", Ingredient.Type.WRAP),
                new Ingredient("Test2", "Test Type2", Ingredient.Type.WRAP)));
        when(ingredientController.getIngredients()).thenReturn(ingredients);
        assertThat(ingredientController.getIngredients()).containsExactlyInAnyOrder(
                new Ingredient("Test", "Test Type", Ingredient.Type.WRAP),
                new Ingredient("Test2", "Test Type2", Ingredient.Type.WRAP)
        );
    }
}
