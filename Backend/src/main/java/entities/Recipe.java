package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author asgerhs
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Recipe.getAll", query = "SELECT r FROM Recipe r"),
    @NamedQuery(name = "Recipe.deleteAllRows", query = "DELETE FROM Recipe")
})
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredients;
    private int prepTime;
    private String directions;
    private List<WeeklyMenuPlanner> weeklyMenuPlan;

    public Recipe() {
        this.ingredients = new ArrayList();
        this.weeklyMenuPlan = new ArrayList();
    }

    public Recipe(int prepTime, String directions) {
        this.prepTime = prepTime;
        this.directions = directions;
        this.ingredients = new ArrayList();
        this.weeklyMenuPlan = new ArrayList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
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

    public List<WeeklyMenuPlanner> getWeeklyMenuPlan() {
        return weeklyMenuPlan;
    }

    public void setWeeklyMenuPlan(List<WeeklyMenuPlanner> weeklyMenuPlan) {
        this.weeklyMenuPlan = weeklyMenuPlan;
    }

   

}
