package sescheraun.worldoffuturedarkness.controler;

import sescheraun.worldoffuturedarkness.generator.*;
import sescheraun.worldoffuturedarkness.persistance.GenericDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.catalina.realm.MessageDigestCredentialHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@WebServlet(
        urlPatterns = {"/prepTraitForm"}
)

public class populateTraitFormServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("Greets from populateTraitsServlet");

        GenericDAO critterDAO = new GenericDAO(Critter.class);
        GenericDAO subCritterDAO = new GenericDAO(SubCritter.class);
        logger.info("DAOs are made");

        List<Critter> critters = (List<Critter>)critterDAO.getAll();
        logger.info("Got the critters");
        List<SubCritter> subCritters = (List<SubCritter>)subCritterDAO.getAll();
        logger.info("Got the subCritters");

        req.setAttribute("critters", critters);
        req.setAttribute("subCritters", subCritters);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/traits.jsp");
        dispatcher.forward(req, resp);

//        resp.sendRedirect("/WorldOfFutureDarkness/player/characterCreation.jsp");

    }
}
