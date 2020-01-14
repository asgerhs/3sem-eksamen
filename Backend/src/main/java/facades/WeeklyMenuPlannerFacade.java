package facades;

import entities.dto.WeeklyMenuPlannerDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
        return getEntityManager().createQuery("SELECT new entities.dto.WeeklyMenuPlannerDTO(weeklyMenuPlanner) from WeeklyMenuPlanner weeklyMenuPlanner", WeeklyMenuPlannerDTO.class).getResultList();
    }
    
}
