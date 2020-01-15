package entities.dto;

import entities.WeeklyMenuPlanner;
import entities.Recipe;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author asgerhs
 */
public class WeeklyMenuPlannerDTO {

    private long id;
    private List<RecipeDTO> recipes;
    private int weekNo;
    private int year;

    public WeeklyMenuPlannerDTO() {
        this.recipes = new ArrayList();
    }
    
    public WeeklyMenuPlannerDTO(WeeklyMenuPlanner planner) {
        if (planner.getId() != null) {
            this.id = id;
        }
        this.recipes = new ArrayList();
        for(Recipe recipe : planner.getRecipes()){
            this.recipes.add(new RecipeDTO(recipe));
        }
        this.weekNo = planner.getWeekNo();
        this.year = planner.getYear();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<RecipeDTO> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeDTO> recipes) {
        this.recipes = recipes;
    }

    public int getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(int weekNo) {
        this.weekNo = weekNo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    
    
    

}
