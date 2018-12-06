package sescheraun.worldoffuturedarkness.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sescheraun.worldoffuturedarkness.generator.Critter;
import sescheraun.worldoffuturedarkness.generator.SubCritter;
import sescheraun.worldoffuturedarkness.persistance.GenericDAO;

import javax.persistence.Transient;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/setSubCritters")
public class SetSubCritters {

    @Transient
    private final Logger logger = LogManager.getLogger(this.getClass());

    private GenericDAO subCritterDAO = new GenericDAO(SubCritter.class);
    private GenericDAO critterDAO = new GenericDAO(Critter.class);

    //Create

    @POST
    @Produces("application/json")
    public Response getMessage() throws Exception {

        //get the information out of the post request
        // see https://spring.io/guides/gs/rest-service/
        // Or https://stackoverflow.com/questions/4112686/how-to-use-servlets-and-ajax

        List<Object> subCritters = (List<Object>)subCritterDAO.getAll();

        String jsonInString = "placeholder";

        logger.info(subCritters);

        return Response.status(200).entity(jsonInString).build();

    }
}
