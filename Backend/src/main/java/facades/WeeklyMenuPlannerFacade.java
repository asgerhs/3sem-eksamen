package facades;

import entities.Recipe;
import entities.WeeklyMenuPlanner;
import entities.dto.RecipeDTO;
import entities.dto.WeeklyMenuPlannerDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author asgerhs
 */
public class WeeklyMenuPlannerFacade {

    private static WeeklyMenuPlannerFacade instance;
    private static EntityManagerFactory emf;

    public WeeklyMenuPlannerFacade() {
    }

    public static WeeklyMenuPlannerFacade getWeeklyMenuPlannerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new WeeklyMenuPlannerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<WeeklyMenuPlannerDTO> getAllWeeklyMenuPlanners() {
        Query query = getEntityManager().createQuery("SELECT weeklyMenuPlanner from WeeklyMenuPlanner weeklyMenuPlanner", WeeklyMenuPlanner.class);
        List<WeeklyMenuPlanner> wmp = query.getResultList();
        List<WeeklyMenuPlannerDTO> dto = new ArrayList();
        List<Recipe> recipes = new ArrayList();
        for (WeeklyMenuPlanner planner : wmp) {

            for (Recipe recipe : planner.getRecipes()) {
                recipes.add(recipe);
            }
            planner.setRecipes(recipes);
            dto.add(new WeeklyMenuPlannerDTO(planner));
            planner.setRecipes(null);
        }

        return dto;
        
    }
    
    public WeeklyMenuPlannerDTO getActiveWeek(){
        WeeklyMenuPlanner wmp = getEntityManager().find(WeeklyMenuPlanner.class, 1L);
        wmp.setRecipes(null);
        return new WeeklyMenuPlannerDTO(wmp);
    }

}
