package entities.dto;

import entities.Ingredient;
import entities.Recipe;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asgerhs
 */
public class RecipeDTO {

    private Long id;
    private List<IngredientDTO> ingredients;
    private int prepTime;
    private String directions;

    public RecipeDTO() {
    }

    public RecipeDTO(Recipe recipe) {
            this.id = recipe.getId();

        this.ingredients = new ArrayList();
        for(Ingredient ingredient : recipe.getIngredients()){
            this.ingredients.add(new IngredientDTO(ingredient));
        }
        this.prepTime = recipe.getPrepTime();
        this.directions = recipe.getDirections();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public List<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }
    
    

}
