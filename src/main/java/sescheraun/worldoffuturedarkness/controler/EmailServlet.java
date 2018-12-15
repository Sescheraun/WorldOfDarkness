package sescheraun.worldoffuturedarkness.controler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sescheraun.worldoffuturedarkness.utilities.Emailer;

/**
 * The type Email servlet.
 */
@WebServlet(
        urlPatterns = {"/sendMail"}
)
public class EmailServlet extends HttpServlet {

    private static final String EMAIL_ACCESS = "_pinE8inie2_W";
    private static final String EMAIL_USER = "cpworldofdarkness@gmail.com";
    private String admin = "sescheraun@gmail.com";

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.debug("In email servlet");

        // Make sure the user isn't being a smart ass and trying to use a bad user name.
        String emailError = "";
        String email = "";
        String subject = "";
        String senderName = "";
        String messageBody = "";


        if (req.getParameter("senderName").length() <= 1) {
            emailError += "Your Name is a required field.<br />";
        } else {
            senderName = req.getParameter("senderName");
        }
        logger.info("Got the sender's name: " + senderName);



        if (req.getParameter("email").length() <= 1) {
            emailError += "Your Email is a required field.<br />";
        } else {
            senderName = req.getParameter("email");
        }
        logger.info("Got the sender's email: " + senderName);



        if (req.getParameter("subject").length() <= 1) {
            emailError += "Topic is a required field.<br />";
        } else {
            subject = req.getParameter("subject");
        }
        logger.info("Got the Topic: " + subject);



        if (req.getParameter("messageBody").length() <= 1) {
            emailError += "The message body is a required field.";
        } else {
            messageBody = req.getParameter("messageBody");
        }
        logger.info("Got the body: " + messageBody);



        messageBody = prepMessageBody(messageBody, senderName, email);


        if (emailError == "") {

            Emailer emailHandler = new Emailer();

            logger.debug("Made an instance of the emailHandler");

            emailHandler.sendMail(admin, subject, messageBody, EMAIL_USER, EMAIL_USER, EMAIL_ACCESS);
            logger.debug("Called the send Mail method");

            RequestDispatcher dispatcher = req.getRequestDispatcher("/emailSuccess.jsp");
            dispatcher.forward(req, resp);

        } else {
            logger.info(emailError);
            req.setAttribute("emailError", emailError);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/emailError.jsp");
            dispatcher.forward(req, resp);

        }


    }

    /**
     *
     * @param body the message that the user wants to send
     * @param sender the name of the person sending the message
     * @param email the email of the person sending the message
     * @return An assembled copy of the message with the sender's details.
     */

    private String prepMessageBody(String body, String sender, String email) {

        body    = "From:  " + sender + "\n"
                + "Email: " + email + "\n\n"
                + body;

        return body;

    }
}