package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.dto.WeeklyMenuPlannerDTO;
import facades.WeeklyMenuPlannerFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 *
 * @author asgerhs
 */
@Path("week-planner")
public class WeeklyMenuPlannerResource {
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/eksamen",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final WeeklyMenuPlannerFacade FACADE = WeeklyMenuPlannerFacade.getWeeklyMenuPlannerFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<WeeklyMenuPlannerDTO> getAll(){
        return FACADE.getAllWeeklyMenuPlanners();
    }
    
    @Path("test")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public WeeklyMenuPlannerDTO test(){
        return FACADE.getActiveWeek();
    }
    
}
