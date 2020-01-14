package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne; 

/**
 *
 * @author asgerhs
 */
@Entity
public class Storage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int amount;
    @OneToOne(mappedBy = "itemId", cascade = CascadeType.PERSIST)
    private Item itemId;
 

    public Storage() {
    }

    public Storage(int amount, Item itemId) {
        this.amount = amount;
        this.itemId = itemId;
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
