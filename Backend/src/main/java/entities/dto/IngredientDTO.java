package entities.dto;

import entities.Ingredient;
import entities.Recipe;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asgerhs
 */
public class IngredientDTO {

    private Long id;
    private int amount;
    private ItemDTO item;

    public IngredientDTO() {
    }

    public IngredientDTO(Ingredient ingredient) {
        this.id = ingredient.getId();
        this.amount = ingredient.getAmount();
        this.item = new ItemDTO(ingredient.getItem());

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

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }


}
