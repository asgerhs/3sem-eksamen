package facades;

import entities.dto.IngredientDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author asgerhs
 */
public class IngredientFacade {
    
    private static IngredientFacade instance;
    private static EntityManagerFactory emf;

    public IngredientFacade() {
    }

    public static IngredientFacade getIngredientFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new IngredientFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<IngredientDTO> getAllIngredients() {
        return getEntityManager().createQuery("SELECT new entities.dto.IngredientDTO(ingredient) from Ingredient ingredient", IngredientDTO.class).getResultList();
    }
    
}
