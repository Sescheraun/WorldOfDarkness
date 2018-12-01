package sescheraun.worldoffuturedarkness.controler;

import org.apache.logging.log4j.*;
import sescheraun.worldoffuturedarkness.generator.Critter;
import sescheraun.worldoffuturedarkness.persistance.GenericDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/prepSubCritterForm"}
)


public class populateSubCrittersFromServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("Greets from populateSubCritterServlet");

        GenericDAO critterDAO = new GenericDAO(Critter.class);
        logger.info("DAOs are made");

        List<Critter> critters = (List<Critter>)critterDAO.getAll();
        logger.info("Got the critters");


        req.setAttribute("critters", critters);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/subCritters.jsp");
        dispatcher.forward(req, resp);

    }
}
