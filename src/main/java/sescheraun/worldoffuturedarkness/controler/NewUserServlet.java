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

/**
 * The type New user servlet.
 */
@WebServlet(
        urlPatterns = {"/addUser"}
)
public class NewUserServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * doGet Handles the post request for the users.
     *
     * @param req the htp request that triggered the function
     * @param resp the http response that likely be sent back
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDAO userDao = new GenericDAO(User.class);

        String userNameError = inspectDetails(req, userDao);

        if (userNameError.equals("")) {

            User user = buildUser(req);

            int id = writeUser(user, userDao);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/WorldOfFutureDarkness");
            dispatcher.forward(req, resp);

        } else {
            logger.info(userNameError);

            Error error = new Error();
            error.report(req, resp, userNameError, "Your account could not be created");
        }
    }

    /**
     * Adds the created user object to the database
     * @param user the new user
     * @param userDao a generic Dao to handle the database access
     * @return the id of the new user.
     */

    private int writeUser(User user, GenericDAO userDao) {

        Role player = new Role(user, "player");

        user.addRole(player);

        return userDao.create(user);
    }


    /**
     * Validate the data the user entered
     *
     * @param req the current httpRequest
     * @param userDao a generic Dao to handle the database access
     * @return a string that contains the error code.
     */
    private String inspectDetails(HttpServletRequest req, GenericDAO userDao) {
        String userNameError = "";
        List<User> users = (List<User>)userDao.getEntityByEqual("userName", req.getParameter("userName"));

        //TODO:  put some of this error checking in javascript as well.
        if (req.getParameter("firstName").length() <= 1) {
            userNameError += "First Name is a required field<br />";

        }

        if (req.getParameter("lastName").length() <= 1) {
            userNameError += "Last Name is a required field<br />";

        }

        if (req.getParameter("userName").length() <= 1) {
            userNameError += "User Name is a required field<br />";

        }
        if (users.size() >= 1) {
            userNameError += "The user name '" + req.getParameter("userName") + "' is already in use.<br />";

        }
        if (req.getParameter("EMAIL").length() <= 1) {
            userNameError += "Email Address is a required field<br />";

        }
        if (!req.getParameter("password").equals(req.getParameter("password2")) || req.getParameter("password").length() < 10) {
            userNameError += "The passwords must match and be at least 10 characters long.<br />";
        }

        return userNameError;

    }


    /**
     * Take the user details out of the request and use
     * them to build the user object
     *
     * @param req the current httpRequest
     * @return the user object
     */
    private User buildUser(HttpServletRequest req) {

        String hashedPassword = mutilatePassword(req);

        User user = new User();

        user.setLastName(req.getParameter("lastName"));
        user.setFirstName(req.getParameter("firstName"));
        user.setUserName(req.getParameter("userName"));
        user.setAuthenticator(hashedPassword);
        user.setEmailAddress(req.getParameter("EMAIL"));

        return user;
    }


    /**
     * Turn the password the user entered into a hashed up mess
     *
     * @param req the current httpRequest
     * @return the hashed password
     */
    private String mutilatePassword (HttpServletRequest req) {
        //todo figure out how to implement a better algorithm

        MessageDigestCredentialHandler credentialHandler = new MessageDigestCredentialHandler();
        try {
            credentialHandler.setAlgorithm("sha-512");
        } catch (NoSuchAlgorithmException e) {
            logger.error("Bad hash", e);
        }

        credentialHandler.setEncoding("UTF-8");
        String hashedPassword = credentialHandler.mutate(req.getParameter("password"));

        return hashedPassword;
    }
}