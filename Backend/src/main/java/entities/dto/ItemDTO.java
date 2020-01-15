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

    public ItemDTO() {
    }

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.price = item.getPrice();
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

  

}
