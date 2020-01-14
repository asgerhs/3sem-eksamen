package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author asgerhs
 */
@Entity
public class WeeklyMenuPlanner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Recipe> recipes; 
    @Temporal(value=TemporalType.DATE)
    private Date weekNo;
    @Temporal(value=TemporalType.DATE)
    private Date year;

    public WeeklyMenuPlanner() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(Date weekNo) {
        this.weekNo = weekNo;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

}
