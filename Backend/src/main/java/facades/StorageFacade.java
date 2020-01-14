package facades;

import entities.dto.ItemDTO;
import entities.dto.StorageDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author asgerhs
 */
public class StorageFacade {
    
    private static StorageFacade instance;
    private static EntityManagerFactory emf;

    public StorageFacade() {
    }

    public static StorageFacade getItemFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new StorageFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<StorageDTO> getAllItems() {
        return getEntityManager().createQuery("SELECT new entities.dto.StorageDTO(storage) from Storage storage", StorageDTO.class).getResultList();
    }
    
}
