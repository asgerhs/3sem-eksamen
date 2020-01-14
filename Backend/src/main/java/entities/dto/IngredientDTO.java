package entities.dto;

import entities.Item;
import entities.Ingredient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asgerhs
 */
public class IngredientDTO {

     private Long id;
    private int amount;
    private RecipeDTO recipe;
    private ItemDTO item;

    public IngredientDTO() {
    }

    public IngredientDTO(Ingredient ingredient) {
        if (ingredient.getId() != null) {
            this.id = id;
        }
        this.amount = ingredient.getAmount();
        this.item = new ItemDTO(ingredient.getItem());
        this.recipe = new RecipeDTO(ingredient.getRecipe());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public RecipeDTO getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeDTO recipe) {
        this.recipe = recipe;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

   
  
    
    

}
