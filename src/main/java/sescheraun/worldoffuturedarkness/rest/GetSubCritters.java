package sescheraun.worldoffuturedarkness.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sescheraun.worldoffuturedarkness.generator.Critter;
import sescheraun.worldoffuturedarkness.generator.Role;
import sescheraun.worldoffuturedarkness.generator.SubCritter;
import sescheraun.worldoffuturedarkness.persistance.GenericDAO;

import javax.persistence.Transient;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/getSubCritters")
public class GetSubCritters {

    @Transient
    private final Logger logger = LogManager.getLogger(this.getClass());

    private GenericDAO subCritterDAO = new GenericDAO(SubCritter.class);
    private GenericDAO critterDAO = new GenericDAO(Critter.class);

    //Create

    @GET
    @Produces("application/json")
    public Response getMessage() throws Exception {

        List<Object> subCritters = (List<Object>)subCritterDAO.getAll();

        String jsonInString = "placeholder";

        logger.info(subCritters);

        return Response.status(200).entity(jsonInString).build();

    }


}
