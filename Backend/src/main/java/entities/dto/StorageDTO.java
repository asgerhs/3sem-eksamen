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
    private ItemDTO itemId;

    public StorageDTO() {
    }

    public StorageDTO(ItemDTO item, int amount, Long id) {
        this.id = id;
        this.amount = amount;
        this.itemId = itemId;
    }

     public StorageDTO(Storage storage) {
        this.id = storage.getId();
        this.itemId = new ItemDTO(storage.getItemId());
        this.amount = storage.getAmount();
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

    public ItemDTO getItemId() {
        return itemId;
    }

    public void setItemId(ItemDTO itemId) {
        this.itemId = itemId;
    }

    

}
