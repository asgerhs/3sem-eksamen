package entities.dto;

import entities.Ingredient;
import entities.Recipe;
import entities.WeeklyMenuPlanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asgerhs
 */
public class RecipeDTO {

    private Long id;
    private List<WeeklyMenuPlannerDTO> plannerId;
    private List<IngredientDTO> ingredients;
    private int prepTime;
    private String directions;

    public RecipeDTO() {
    }

    public RecipeDTO(Recipe recipe) {
        if (recipe.getId() != null) {
            this.id = id;
        }
        this.plannerId = new ArrayList();
        for(WeeklyMenuPlanner planner : recipe.getPlannerId()){
            this.plannerId.add(new WeeklyMenuPlannerDTO(planner));
        }
        this.ingredients = new ArrayList();
        for(Ingredient ingredient : recipe.getIngredients()){
            this.ingredients.add(new IngredientDTO(ingredient));
        }
        this.prepTime = prepTime;
        this.directions = directions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<WeeklyMenuPlannerDTO> getPlannerId() {
        return plannerId;
    }

    public void setPlannerId(List<WeeklyMenuPlannerDTO> plannerId) {
        this.plannerId = plannerId;
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
