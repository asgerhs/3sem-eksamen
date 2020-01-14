package entities.dto;

import java.util.List;
import entities.Item;
import entities.Storage;
import entities.Ingredient;
import java.util.ArrayList;

/**
 *
 * @author asgerhs
 */
public class ItemDTO {

    private Long id;
    private String name;
    private int price;
    private Storage itemId;

    public ItemDTO() {
    }

    public ItemDTO(Item item) {
        if (item.getId() != null) {
            this.id = item.getId();
        }
        this.name = item.getName();
        this.price = item.getPrice();
        this.itemId = item.getItemId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Storage getItemId() {
        return itemId;
    }

    public void setItemId(Storage itemId) {
        this.itemId = itemId;
    }

}
