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
        urlPatterns = {"/manageSubCritters"}
)

public class ManageSubCrittersServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("title", "Manage Sub Types");


        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/subCritters.jsp");
        dispatcher.forward(req, resp);
    }
}