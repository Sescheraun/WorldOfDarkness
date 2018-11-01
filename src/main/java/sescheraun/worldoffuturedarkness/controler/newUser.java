package sescheraun.worldoffuturedarkness.controler;

import sescheraun.worldoffuturedarkness.generator.*;
import sescheraun.worldoffuturedarkness.persistance.GenericDAO;

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
        urlPatterns = {"/addUser"}
)
public class newUser extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDAO userDao = new GenericDAO(User.class);
        GenericDAO roleDao = new GenericDAO(Role.class);

        //todo check to make sure the user name is not in use
        List<User> users = (List<User>)userDao.getEntityBy("userName", req.getParameter("userName"));

        if (users.size() == 0) {

            String stringToHash = "testing";
            MessageDigestCredentialHandler credentialHandler = new MessageDigestCredentialHandler();


            //todo figure out how to implement a better algorithm
            try {
                credentialHandler.setAlgorithm("sha-512");
            } catch (NoSuchAlgorithmException e) {
                logger.error("Bad hash", e);
            }

            credentialHandler.setEncoding("UTF-8");
            String hashedPassword = credentialHandler.mutate(stringToHash);


//            User user = new User();
//            user.setLastName();
//            user.setFirstName();
//            user.setUserName();
//            user.addRole();
//            user.setAuthenticator(hashedPassword);
//            user.setEmailAddress();

            //userDao.create(user);
            resp.sendRedirect("index.jsp");
        } else {
            logger.info("User name " + req.getParameter("userName") + "was already taken.");
            resp.sendRedirect("/WorldOfFutureDarkness/createNewUser.jsp");
        }
    }
}