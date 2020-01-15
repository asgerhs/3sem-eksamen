package facades;

import entities.Storage;
import entities.dto.StorageDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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
        Query query = getEntityManager().createQuery("SELECT storage from Storage storage", Storage.class);
        List<Storage> storage = query.getResultList();
        List<StorageDTO> dto = new ArrayList();
        for(Storage strg : storage){
            strg.setItemId(null);
            dto.add(new StorageDTO(strg));
        }
        return dto;
    }
    
        public StorageDTO addStorage(StorageDTO storageDTO) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(storageDTO);
            em.getTransaction().commit();
            return storageDTO;
        } finally {
            em.close();
        }
    }
    
    
    
}
