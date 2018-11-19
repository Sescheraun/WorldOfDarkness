package sescheraun.worldoffuturedarkness.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.*;
import sescheraun.worldoffuturedarkness.generator.Role;
import sescheraun.worldoffuturedarkness.persistance.GenericDAO;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;



@Path("/role")
public class UserRoles {

    @Transient
    private final Logger logger = LogManager.getLogger(this.getClass());

    private GenericDAO roleDAO = new GenericDAO(Role.class);


    //Create

    //Read



    @GET
    @Produces("application/json")
    public Response getMessage() throws Exception {

        List<Object> roles = (List<Object>)roleDAO.getAll();

        String jsonInString;

        logger.info(roles);

        jsonInString = toJson(roles);

        return Response.status(200).entity(jsonInString).build();

    }

    //Update

    //Delete

    //Utilities
    private String toJson(List<Object> roles ) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        String jsonInString = mapper.writeValueAsString(roles);

        logger.info(jsonInString);

        return jsonInString;

    }
}
