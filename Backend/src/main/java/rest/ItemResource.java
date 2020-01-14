package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.dto.ItemDTO;
import facades.ItemFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 *
 * @author asgerhs
 */
@Path("item")
public class ItemResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/eksamen",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final ItemFacade FACADE = ItemFacade.getItemFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ItemDTO> getAll() {
        return FACADE.getAllItems();
    }
    
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ItemDTO getById(@PathParam("id") long id){
        return FACADE.getItembyId(id);
    }
    

}
