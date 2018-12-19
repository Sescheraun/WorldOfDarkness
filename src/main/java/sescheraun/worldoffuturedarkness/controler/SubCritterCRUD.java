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
        String method = req.getParameter("method");

        if (method.equals("delete")) {
            delete(req, resp);
        } else if (method.equals("update")){
            logger.debug("Update");
            update(req, resp);
        } else {

            int id = buildSubCritter(req);

            SubCritter subCritter = (SubCritter) subCritterDAO.getByID(id);

            String response = "Subtype " + subCritter.getCritterSubName()
                    + " under type " + subCritter.getCritter().getCritterName()
                    + " has been created and assigned ID " + id + ".";
            logger.info(response);

            resp.setContentType("text/plain");
            resp.getWriter().write(response);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Inside Update");

        Enumeration params = req.getParameterNames();

        while (params.hasMoreElements()) {
            String paramater = (String) params.nextElement();
            logger.info(paramater);
        }

        String subCritterID = req.getParameter("subCritterID");
        int id = Integer.parseInt(subCritterID);

        logger.debug(id);
        SubCritter subCritter = (SubCritter)subCritterDAO.getByID(id);

        String newName = req.getParameter("subCritterName");
        logger.debug(newName);
        String newCategory = req.getParameter("category");
        logger.debug(newCategory);
        String newFirstAdvantage = req.getParameter("firstAdvantage");
        logger.debug(newFirstAdvantage);
        String newSecondAdvantage = req.getParameter("secondAdvantage");
        logger.debug(newSecondAdvantage);
        String newFlaw = req.getParameter("flaw");
        logger.debug(newFlaw);

        subCritter.setCritter((Critter)critterDAO.getByID(Integer.parseInt(req.getParameter("critter"))));
        subCritter.setSubCritterLabel(newName);
        subCritter.setCritterSubName(newCategory);
        subCritter.setFirstAdvantage(newFirstAdvantage);
        subCritter.setSecondAdvantage(newSecondAdvantage);
        subCritter.setFlaw(newFlaw);

        logger.debug(subCritter);
        subCritterDAO.update(subCritter);

        String response = "You have reached the doPut method";
        logger.info(response);
        resp.setContentType("text/plain");
        resp.getWriter().write(response);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subCritterID = req.getParameter("subCritterID");
        int id = Integer.parseInt(subCritterID);

        String response = "You have reached the doDelete method, you have chosen to delete id# " + subCritterID;

        SubCritter subCritter = (SubCritter)subCritterDAO.getByID(id);
        subCritter.setIsDeleted(true);

        subCritterDAO.update(subCritter);

        response = "The sub type " + subCritter.getCritterSubName() + " was deleted.";

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

        SubCritter subCritter = new SubCritter(critter, subCritterName, category, firstAdvantage, secondAdvantage, flaw );
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