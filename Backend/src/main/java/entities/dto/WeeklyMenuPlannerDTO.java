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
    @Temporal(value = TemporalType.DATE)
    private Date weekNo;
    @Temporal(value = TemporalType.DATE)
    private Date year;

    public WeeklyMenuPlannerDTO() {
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

    public Date getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(Date weekNo) {
        this.weekNo = weekNo;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    
    

}
