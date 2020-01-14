package facades;

import entities.dto.ItemDTO;
import entities.Item;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.ws.rs.Path;

/**
 *
 * @author asgerhs
 */
@Path("item")
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
        Query query = getEntityManager().createQuery("SELECT item FROM Item item", Item.class);
        List<Item> item = query.getResultList();
        List<ItemDTO> dto = new ArrayList();
        for(Item itm : item){
            itm.setItemId(null);
            itm.setIngredient(null);
            dto.add(new ItemDTO(itm));
        }
        return dto;
        //return getEntityManager().createQuery("SELECT new entities.dto.ItemDTO(items) FROM Item items", ItemDTO.class).getResultList();
       
    }

    
    
    public ItemDTO getItembyId(long id){
        Item item = getEntityManager().find(Item.class, id);
        item.setItemId(null);
        item.setIngredient(null);
        return new ItemDTO(item);
    }
    
   

}
