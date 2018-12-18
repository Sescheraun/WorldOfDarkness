package sescheraun.worldoffuturedarkness.controler;
import org.apache.logging.log4j.*;
import sescheraun.worldoffuturedarkness.generator.Critter;
import sescheraun.worldoffuturedarkness.generator.SubCritter;
import sescheraun.worldoffuturedarkness.persistance.GenericDAO;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet(
        urlPatterns = {"/subCritterCRUD"}
)


public class SubCritterCRUD extends HttpServlet {
    private static GenericDAO critterDAO = new GenericDAO(Critter.class);
    private static GenericDAO subCritterDAO = new GenericDAO(SubCritter.class);
    private static String RETURN_TO = "/admin/subCritters.jsp";

    private final Logger logger = LogManager.getLogger(this.getClass());

    /************************************************************************
    **                             doGet Method                            **
    *************************************************************************/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "You have reached the doGet method";
        logger.info(response);

        try {
            response = getSubCrittersAsJSON();
            logger.info("response received");
        } catch (Exception ex) {
            logger.error( ex );
                response="An error ocured";
        }

        logger.info(response);

        resp.setContentType("Application/JSON");
        resp.getWriter().write(response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = buildSubCritter(req);

        SubCritter subCritter = (SubCritter)subCritterDAO.getByID(id);

        String response = "Subtype " + subCritter.getCritterSubName()
                + " under type " + subCritter.getCritter().getCritterName()
                + " has been created and assigned ID " + id + ".";
        logger.info(response);

        resp.setContentType("text/plain");
        resp.getWriter().write(response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "You have reached the doPut method";
        logger.info(response);
        resp.setContentType("text/plain");
        resp.getWriter().write(response);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subCritter = req.getParameter("subCritterID");

        logger.debug(subCritter);

        String response = "You have reached the doDelete method, you have chosen to delete id# " + subCritter;


        resp.setContentType("text/plain");
        resp.getWriter().write(response);
    }

    /**
     * Takes the request and pulls the data out to build the new subcritter.
     *
     * @param req the current HttpServletRequest
     * @return the id of the newly created subCritter
     */

    private int buildSubCritter (HttpServletRequest req) {
        int critterID = Integer.parseInt(req.getParameter("critter"));
        String subCritterName  = (req.getParameter("subCritterName"));
        String category        = (req.getParameter("category"));
        String firstAdvantage  = (req.getParameter("firstAdvantage"));
        String secondAdvantage = (req.getParameter("secondAdvantage"));
        String flaw            = (req.getParameter("flaw"));

        Critter critter = (Critter)critterDAO.getByID(critterID);
        logger.info(critter);

        SubCritter subCritter = new SubCritter(critter, category, subCritterName, firstAdvantage, secondAdvantage, flaw );
        logger.info(subCritter);

        return subCritterDAO.create(subCritter);


    }

    /**
     * This gets a list of Subcritters and sends them to be converted
     * into json.
     *
     * @return the JSON object that was returned by the called method.
     * @throws Exception The exception is passed to the calling method to handle.
     */
    private String getSubCrittersAsJSON() throws Exception {

        List<Object> subCritters = (List<Object>)subCritterDAO.getAll();

        logger.debug("The read list is " + subCritters);

        String jsonSubCritters = toJson(subCritters);

        logger.debug("The returned JSON string is " + jsonSubCritters);

        return jsonSubCritters;
    }

    /**
     * Takes a list of objects and converts them to JSON.
     * This method may need to be placed in a utilities class.
     *
     * @param arrayList This is a list of generic objects to be converted to JSON
     * @return the converted list.
     * @throws Exception The exception is passed to the calling method to handle.
     */

    private String toJson(List<Object> arrayList) throws Exception{

        ObjectMapper mapper = new ObjectMapper();

        String jsonInString = "";

        logger.debug(arrayList);

        jsonInString = mapper.writeValueAsString(arrayList);

        logger.debug(jsonInString);

        return jsonInString;
    }
}