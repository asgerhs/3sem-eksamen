package facades;

import entities.dto.ItemDTO;
import entities.Item;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author asgerhs
 */
public class ItemFacade {

    private static ItemFacade instance;
    private static EntityManagerFactory emf;

    public ItemFacade() {
    }

    public static ItemFacade getItemFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ItemFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<ItemDTO> getAllItems() {
        return getEntityManager().createQuery("SELECT new entities.dto.ItemDTO(item) from Item item", ItemDTO.class).getResultList();
    }
    
    public ItemDTO getItembyId(long id){
        Item item = getEntityManager().find(Item.class, id);
        return new ItemDTO(item);
    }
    
   

}
