package rest;

import entities.Ingredient;
import entities.Item;
import entities.Recipe;
import entities.Storage;
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
        try {
            em.getTransaction().begin();
            Item pasta = new Item("pasta", 100);
            Item bacon = new Item("bacon", 1000);
     
            Ingredient pastaIng = new Ingredient(10, pasta);
            Ingredient baconIng = new Ingredient(34, bacon);


            Recipe pastaBacon = new Recipe(4000, "Pasta med Bacon");
            baconIng.setRecipe(pastaBacon);
            pastaIng.setRecipe(pastaBacon);
            em.persist(pastaBacon);
            // Persist ingredients
            em.persist(pastaIng);
            em.persist(baconIng);
            em.persist(pasta);
            em.persist(bacon);

            em.getTransaction().commit();
        } finally {
            em.close();
        }

//         EntityManager em = EMF.createEntityManager();
//        Item item1 = new Item("Spagetti", 1000);
//        Item item2 = new Item("Bacon", 16000);
//        Item item3 = new Item("Pesto", 9000);
//        Item item4 = new Item("Basil", 100000);
//        
//        // --> Dette er sådan Storage skal opdateres <-- 
////        Item itemTest = em.find(Item.class, 5L);
////        Storage storageTest = em.find(Storage.class, itemTest.getItemId().getId());
////        storageTest.setAmount(50);
////        itemTest.setItemId(storageTest);
//
//
//        item1.setItemId(storage1);
//        item2.setItemId(storage2);
//        item3.setItemId(storage3);
//        item4.setItemId(storage4);
//      
//
//        Ingredient ing1 = new Ingredient(5, item1);
//        Ingredient ing2 = new Ingredient(10, item2);
//        Ingredient ing3 = new Ingredient(15, item3);
//        Ingredient ing4 = new Ingredient(20, item4);
//
//        List<Ingredient> ingredients = new ArrayList();
//        ingredients.add(ing1);
//        ingredients.add(ing2);
//        ingredients.add(ing3);
//        ingredients.add(ing4);
//
//        Recipe recipe1 = new Recipe(1000, "Bare lav det.");
//        ing1.setRecipe(recipe1);
//        ing2.setRecipe(recipe1);
//        ing3.setRecipe(recipe1);
//        ing4.setRecipe(recipe1);
//        
//
//
//
//       
//        em.getTransaction().begin();
//        em.persist(item1);
//        em.persist(item2);
//        em.persist(item3);
//        em.persist(item4);
//        em.persist(storage1);
//        em.persist(storage2);
//        em.persist(storage3);
//        em.persist(storage4);
//        em.persist(recipe1);
//        em.persist(ing1);
//        em.persist(ing2);
//        em.persist(ing3);
//        em.persist(ing4);
//
//        em.getTransaction().commit();
        return "{\"status\":\"completed\"}";
    }

}
