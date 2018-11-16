package sescheraun.worldoffuturedarkness.rest;


import org.apache.logging.log4j.*;
import sescheraun.worldoffuturedarkness.generator.Role;
import sescheraun.worldoffuturedarkness.persistance.GenericDAO;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;
import com.fasterxml.jackson.databind.*;

@Path("/role")
public class UserRoles {

    @Transient
    private final Logger logger = LogManager.getLogger(this.getClass());

    private GenericDAO roleDAO = new GenericDAO(Role.class);

    private List<Role> roles = (List<Role>)roleDAO.getAll();

    private String jsonInString = "";

    //Create

    //Read



    @GET
    @Produces("application/json")
    public Response getMessage() throws Exception {

        logger.info(roles);

        String reply = jsonInString(roles);

        return Response.status(200).entity(reply).build();

    }



    //Update

    //Delete


    //Utilities
    private String jsonInString(List<Role> roles ) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        jsonInString = mapper.writeValueAsString(roles);


        return jsonInString;

    }
}
