package facades;

import entities.Ingredient;
import entities.Recipe;
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
//         EntityManager em = getEntityManager();
//         try{
//             return em.createQuery("SELECT new entities.dto.IngredientDTO(ingredient) from Ingredient ingredient", IngredientDTO.class).getResultList();
//         }finally{
//             em.close();
//         }
        Query query = getEntityManager().createQuery("SELECT ingredient from Ingredient ingredient", Ingredient.class);
        List<Ingredient> ingredients = query.getResultList();
        List<IngredientDTO> dto = new ArrayList();
        for(Ingredient ingredient : ingredients){
            System.out.println(ingredient.getItem());
            System.out.println(ingredient.getRecipe());
            dto.add(new IngredientDTO(ingredient));
            ingredient.setRecipe(null);
            ingredient.setItem(null);
            
        }
        return dto;
    }
    
}
