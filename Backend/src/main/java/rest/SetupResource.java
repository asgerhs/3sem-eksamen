package rest;

import entities.Ingredient;
import entities.Item;
import entities.Recipe;
import entities.Storage;
import entities.WeeklyMenuPlanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 *
 * @author asgerhs
 */
@Path("setup")
public class SetupResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/eksamen",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String setup() {
         EntityManager em = EMF.createEntityManager();
        Item item1 = new Item("Spagetti", 1000);
        Item item2 = new Item("Bacon", 16000);
        Item item3 = new Item("Pesto", 9000);
        Item item4 = new Item("Basil", 100000);
        
        // --> Dette er sådan Storage skal opdateres <-- 
//        Item itemTest = em.find(Item.class, 5L);
//        Storage storageTest = em.find(Storage.class, itemTest.getItemId().getId());
//        storageTest.setAmount(50);
//        itemTest.setItemId(storageTest);

        Storage storage1 = new Storage(10, item1);
        Storage storage2 = new Storage(20, item2);
        Storage storage3 = new Storage(30, item3);
        Storage storage4 = new Storage(40, item4);

        item1.setItemId(storage1);
        item2.setItemId(storage2);
        item3.setItemId(storage3);
        item4.setItemId(storage4);
        List<Item> items = new ArrayList();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        Ingredient ing1 = new Ingredient(5, item1);
        Ingredient ing2 = new Ingredient(10, item2);
        Ingredient ing3 = new Ingredient(15, item3);
        Ingredient ing4 = new Ingredient(20, item4);

        List<Ingredient> ingredients = new ArrayList();
        ingredients.add(ing1);
        ingredients.add(ing2);
        ingredients.add(ing3);
        ingredients.add(ing4);

        Recipe recipe1 = new Recipe(1000, "Bare lav det.", ingredients);
        Recipe recipe2 = new Recipe(2000, "Bare lav det.", ingredients);
        Recipe recipe3 = new Recipe(3000, "Bare lav det.", ingredients);
        Recipe recipe4 = new Recipe(4000, "Bare lav det.", ingredients);
        Recipe recipe5 = new Recipe(5000, "Bare lav det.", ingredients);
        Recipe recipe6 = new Recipe(6000, "Bare lav det.", ingredients);
        Recipe recipe7 = new Recipe(7000, "Bare lav det.", ingredients);

        List<Recipe> recipes = new ArrayList();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe4);
        recipes.add(recipe5);
        recipes.add(recipe6);
        recipes.add(recipe7);

        WeeklyMenuPlanner wmp1 = new WeeklyMenuPlanner(new Date(), new Date(), recipes);
        WeeklyMenuPlanner wmp2 = new WeeklyMenuPlanner(new Date(), new Date(), recipes);
       
        em.getTransaction().begin();
        em.persist(item1);
        em.persist(item2);
        em.persist(item3);
        em.persist(item4);
        em.persist(storage1);
        em.persist(storage2);
        em.persist(storage3);
        em.persist(storage4);
        em.persist(ing1);
        em.persist(ing2);
        em.persist(ing3);
        em.persist(ing4);
        em.persist(recipe1);
        em.persist(recipe2);
        em.persist(recipe3);
        em.persist(recipe4);
        em.persist(recipe5);
        em.persist(recipe6);
        em.persist(recipe7);
        em.persist(wmp1);
        em.persist(wmp2);
        em.getTransaction().commit();
        
        return "{\"status\":\"completed\"}";
    }

}
