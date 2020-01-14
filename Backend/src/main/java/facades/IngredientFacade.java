package facades;

import entities.Ingredient;
import entities.dto.IngredientDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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
        Query query = getEntityManager().createQuery("SELECT ingredient from Ingredient ingredient", Ingredient.class);
        List<Ingredient> ingredients = query.getResultList();
        List<IngredientDTO> dto = new ArrayList();
        for(Ingredient ingredient : ingredients){
            dto.add(new IngredientDTO(ingredient));
            ingredient.setItem(null);
            ingredient.setRecipe(null);
        }
        return dto;
    }
    
}
