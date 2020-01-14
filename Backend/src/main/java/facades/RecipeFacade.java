package facades;

import entities.Recipe;
import entities.dto.RecipeDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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
        Query query = getEntityManager().createQuery("SELECT new entities.dto.RecipeDTO(recipe) from Recipe recipe", RecipeDTO.class);
        List<Recipe> recipes = query.getResultList();
        List<RecipeDTO> dto = new ArrayList();
        for(Recipe recipe : recipes){
            dto.add(new RecipeDTO(recipe));
            recipe.setIngredients(null);
            recipe.setPlannerId(null);
        }
        return dto;
    
    }
}
