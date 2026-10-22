package org.dewqryp.tacocloud;

import org.dewqryp.tacocloud.controllers.IngredientController;
import org.dewqryp.tacocloud.data.Ingredient;
import org.dewqryp.tacocloud.repositories.IngredientRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class IngredientControllerTest {
    private final IngredientRepository ingredientRepository = mock(IngredientRepository.class);
    private final IngredientController ingredientController = new IngredientController(ingredientRepository);
    @Test
    void getAllIngredients() {
        List<Ingredient> ingredients = new ArrayList<>(List.of(new Ingredient("Test", "Test Type", Ingredient.Type.WRAP),
                new Ingredient("Test2", "Test Type2", Ingredient.Type.WRAP)));
        when(ingredientRepository.findAll()).thenReturn(ingredients);
        assertThat(ingredientController.getIngredients()).containsExactlyInAnyOrder(
                new Ingredient("Test", "Test Type", Ingredient.Type.WRAP),
                new Ingredient("Test2", "Test Type2", Ingredient.Type.WRAP)
        );
    }
    @Test
    void getAllIngredientsWithoutIngredients() {
        List<Ingredient> ingredients = new ArrayList<>(List.of());
        when(ingredientRepository.findAll()).thenReturn(ingredients);
        assertThat(ingredientController.getIngredients()).isEmpty();
    }
    @Test
    void deleteIngredient() {
        String id = "FLTO";

        ingredientController.deleteIngredient(id);

        verify(ingredientRepository, times(1)).deleteById(id);

    }
}
