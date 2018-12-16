package sescheraun.worldoffuturedarkness.controler;
import org.apache.logging.log4j.*;
import sescheraun.worldoffuturedarkness.generator.Critter;
import sescheraun.worldoffuturedarkness.generator.SubCritter;
import sescheraun.worldoffuturedarkness.persistance.GenericDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/subCritterCRUD"}
)


public class SubCritterCRUD extends HttpServlet {
    private static GenericDAO critterDAO = new GenericDAO(Critter.class);
    private static GenericDAO subCritterDAO = new GenericDAO(SubCritter.class);
    private static String RETURN_TO = "/admin/subCritters.jsp";

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "You have reached the doGet method";
        logger.info(response);
        resp.setContentType("text/plain");
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
        String response = "You have reached the doDelete method";
        logger.info(response);
        resp.setContentType("text/plain");
        resp.getWriter().write(response);
    }


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
}