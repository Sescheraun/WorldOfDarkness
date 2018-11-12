package sescheraun.worldoffuturedarkness.rest;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import sescheraun.worldoffuturedarkness.generator.Role;
import sescheraun.worldoffuturedarkness.persistance.GenericDAO;
import javax.persistence.Transient;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/role")
public class UserRoles {

    @Transient
    private final Logger logger = LogManager.getLogger(this.getClass());

    private GenericDAO roleDAO = new GenericDAO(Role.class);
    private List<Role> roles = (List<Role>)roleDAO.getAll();

    //Create

    //Read



    @GET
    @Produces("text/plain")
    public Response getMessage() {

        logger.info(roles);

        String reply = roles.toString();


        return Response.status(200).entity(reply).build();

    }

    //Update

    //Delete

}
