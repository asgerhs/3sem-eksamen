package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.dto.RecipeDTO;
import facades.RecipeFacade;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
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
@Path("recipe")
public class RecipeResource {
    
         private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/eksamen",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final RecipeFacade FACADE = RecipeFacade.getRecipeFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    
    @Path("all")
    @GET
    @JsonbTransient
    @Produces(MediaType.APPLICATION_JSON)
    public List<RecipeDTO> getAll(){
        return FACADE.getAllRecipes();
    }
    
}
