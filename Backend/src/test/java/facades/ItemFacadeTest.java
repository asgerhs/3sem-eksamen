package facades;

import entities.Ingredient;
import entities.Item;
import entities.Recipe;
import entities.dto.ItemDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utils.EMF_Creator;

/**
 *
 * @author asgerhs
 */
public class ItemFacadeTest {

    private static EntityManagerFactory emf;
    private static ItemFacade facade;

    public ItemFacadeTest() {
    }

    @BeforeAll
    public static void setUpClassV2() {
        emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.DROP_AND_CREATE);
        facade = ItemFacade.getItemFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        Item pasta = new Item("pasta", 100);
        Item bacon = new Item("bacon", 1000);
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Item").executeUpdate();
            em.persist(pasta);
            em.getTransaction().commit();
            em.getTransaction().begin();
            em.persist(bacon);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    /**
     * Test of getItembyId method, of class ItemFacade.
     */
    @Test
    public void testGetItembyId() {
        String result = facade.getItembyId(1L).getName();
        assertEquals("pasta", result);
    }

    /**
     * Test of getAllItems method, of class ItemFacade.
     */
    @Test
    public void testgetAllItems() {
        int result = facade.getAllItems().size();
        assertEquals(2, result);
    }

}
