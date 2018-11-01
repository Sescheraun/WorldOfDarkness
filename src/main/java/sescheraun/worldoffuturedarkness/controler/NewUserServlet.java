package sescheraun.worldoffuturedarkness.controler;

import sescheraun.worldoffuturedarkness.generator.*;
import sescheraun.worldoffuturedarkness.persistance.GenericDAO;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
        urlPatterns = {"/addUser"}
)
public class NewUserServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDAO userDao = new GenericDAO(User.class);
        GenericDAO roleDao = new GenericDAO(Role.class);


        // Make sure the user isn't being a smart ass and trying to use a bad user name.
        String userNameError = null;
        List<User> users = (List<User>)userDao.getEntityByEqual("userName", req.getParameter("userName"));

        //TODO:  put some of this error checking in javascript as well.
        if (req.getParameter("userName").length() <= 1) {
            userNameError = "User Name is a required field";
        } else if (users.size() >= 1) {
            userNameError = "The user name '" + req.getParameter("userName") + "' is already in use.";
        } else if (!req.getParameter("password").equals(req.getParameter("password2")) || req.getParameter("password").length() < 5) {
            userNameError = "The passwords must match and be at least 5 characters long.";
        }

        if (userNameError == null) {

            //todo figure out how to implement a better algorithm

            MessageDigestCredentialHandler credentialHandler = new MessageDigestCredentialHandler();
            try {
                credentialHandler.setAlgorithm("sha-512");
            } catch (NoSuchAlgorithmException e) {
                logger.error("Bad hash", e);
            }

            credentialHandler.setEncoding("UTF-8");
            String hashedPassword = credentialHandler.mutate(req.getParameter("password"));

            Role player = new Role();
            User user = new User();

            user.setLastName(req.getParameter("lastName"));
            user.setFirstName(req.getParameter("firstName"));
            user.setUserName(req.getParameter("userName"));
            user.setAuthenticator(hashedPassword);
            user.setEmailAddress(req.getParameter("EMAIL"));

            player.setRoleName("player");
            player.setUser(user);
            user.addRole(player);

            System.out.println(user);
            System.out.println(player);

            userDao.create(user);
            resp.sendRedirect("/WorldOfFutureDarkness");
        } else {
            logger.info(userNameError);
            resp.sendRedirect("/WorldOfFutureDarkness/createNewUser.jsp");
        }
    }
}