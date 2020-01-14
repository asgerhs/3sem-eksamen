package entities.dto;

import entities.Item;
import entities.Storage;
import java.util.List;
import javax.persistence.OneToMany;

/**
 *
 * @author asgerhs
 */
public class StorageDTO {

    private Long id;
    private int amount;
    private Item itemId;

    public StorageDTO() {
    }

    public StorageDTO(Storage storage) {
        if (storage.getId() != null) {
            this.id = id;
        }
        this.amount = storage.getAmount();
        this.itemId = storage.getItemId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    

}
