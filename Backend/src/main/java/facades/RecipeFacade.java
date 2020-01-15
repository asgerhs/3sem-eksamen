package facades;

import entities.Ingredient;
import entities.Recipe;
import entities.dto.IngredientDTO;
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

//    public List<RecipeDTO> getRecipes() {
//        EntityManager em = getEntityManager();
//        try {
//            em.getTransaction().begin();
//            List<Recipe> recipes = em.createQuery("SELECT recipe FROM Recipe recipe", Recipe.class).getResultList();
//            List<RecipeDTO> recipesDTO = new ArrayList();
//            for (Recipe recipe : recipes) {
//                List<Ingredient> ingredients = em.createQuery("SELECT ingredient FROM Ingredient ingredient WHERE ingredient.recipe.id = :id").setParameter("id", recipe.getId()).getResultList();
//                List<IngredientDTO> ingredientDTO = new ArrayList();
//                for (Ingredient ingredient : ingredients) {
//                    Item item = em.createQuery("SELECT item FROM Item item WHERE item.id = (SELECT ingredient.item.id FROM Ingredient ingredient WHERE ingredient.id = :id)", item.class).
//                }
//                }
//
//            }
//        }
    
    

    public List<RecipeDTO> getAllRecipes() {
        Query query = getEntityManager().createQuery("SELECT recipe FROM Recipe recipe", Recipe.class);
        List<Recipe> recipes = query.getResultList();
        List<RecipeDTO> dto = new ArrayList();
        for (Recipe recipe : recipes) {
            System.out.println(recipe.getIngredients());
            dto.add(new RecipeDTO(recipe));
        }
        return dto;

    }
}
