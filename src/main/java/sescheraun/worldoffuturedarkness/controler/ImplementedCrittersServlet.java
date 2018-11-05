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
        urlPatterns = {"/getCritters"}
)

public class ImplementedCrittersServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("Greets from ImplementedCrittersServlet");

        GenericDAO critterDAO = new GenericDAO(Critter.class);

        List<Critter> critters = (List<Critter>)critterDAO.getAll();

        req.setAttribute("critters", critters);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/player/characterCreation.jsp");
        dispatcher.forward(req, resp);

//        resp.sendRedirect("/WorldOfFutureDarkness/player/characterCreation.jsp");

    }
}
