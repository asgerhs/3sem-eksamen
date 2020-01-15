package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author asgerhs
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Item.getAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.deleteAllRows", query = "DELETE FROM Item")
})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Storage itemId;
    @OneToOne(mappedBy = "item", cascade = CascadeType.PERSIST)
    private Ingredient ingredient;

    public Item() {
    }

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
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

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

}
