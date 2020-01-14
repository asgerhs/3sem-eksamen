package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import net.minidev.json.annotate.JsonIgnore;

/**
 *
 * @author asgerhs
 */
@Entity
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToMany(mappedBy = "recipes")
    private List<WeeklyMenuPlanner> plannerId;
    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredients;
    private int prepTime;
    private String directions;

    public Recipe() {
    }

    public Recipe(int prepTime, String directions, List<Ingredient> ingredients) {
        this.prepTime = prepTime;
        this.directions = directions;
        this.ingredients = ingredients; 
    }


    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<WeeklyMenuPlanner> getPlannerId() {
        return plannerId;
    }

    public void setPlannerId(List<WeeklyMenuPlanner> plannerId) {
        this.plannerId = plannerId;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    
    

}
