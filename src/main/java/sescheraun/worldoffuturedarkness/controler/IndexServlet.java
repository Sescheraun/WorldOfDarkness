package sescheraun.worldoffuturedarkness.controler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sescheraun.worldoffuturedarkness.generator.Critter;
import sescheraun.worldoffuturedarkness.persistance.GenericDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/home"}
)
public class IndexServlet extends HttpServlet {


    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("Greets from the new welcome page...  I hope");

        req.setAttribute("pageTitle", "The Net");


        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);

    }
}
