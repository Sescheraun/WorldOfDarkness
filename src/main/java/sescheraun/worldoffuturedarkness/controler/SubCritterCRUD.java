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
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "You have reached the doPost method";
        logger.info(response);


        logger.info(req.getParameter("critter"));
        logger.info(req.getParameter("subCritterName"));
        logger.info(req.getParameter("category"));
        logger.info(req.getParameter("firstAdvantage"));
        logger.info(req.getParameter("secondAdvantage"));
        logger.info(req.getParameter("flaw"));

        resp.setContentType("text/plain");
        resp.getWriter().write("Post Recieved.");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "You have reached the doPut method";
        logger.info(response);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "You have reached the doDelete method";
        logger.info(response);
    }

}