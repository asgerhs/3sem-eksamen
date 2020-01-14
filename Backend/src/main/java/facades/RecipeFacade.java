package facades;

import entities.dto.RecipeDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author asgerhs
 */
public class RecipeFacade {
    
    private static RecipeFacade instance;
    private static EntityManagerFactory emf;

    public RecipeFacade() {
    }

    public static RecipeFacade getRecipeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RecipeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<RecipeDTO> getAllRecipes() {
        return getEntityManager().createQuery("SELECT new entities.dto.RecipeDTO(recipe) from Recipe recipe", RecipeDTO.class).getResultList();
    }
}
