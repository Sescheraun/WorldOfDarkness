package sescheraun.worldoffuturedarkness.controler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sescheraun.worldoffuturedarkness.utilities.Emailer;
import sescheraun.worldoffuturedarkness.utilities.Icons;
import sescheraun.worldoffuturedarkness.utilities.PropertiesLoader;

/**
 * The type Email servlet.
 */
@WebServlet(
        urlPatterns = {"/sendMail"}
)
public class EmailServlet extends HttpServlet implements PropertiesLoader{

    private final Logger logger = LogManager.getLogger(this.getClass());
    private final Icons icons = new Icons();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {

        Properties emailProperties = loadProperties("/emailProperties.properties");



        logger.debug("In email servlet");

        String emailError = "";

        emailError = validateData(req);

        if (emailError == "") {

            sendToHandler(req, emailProperties);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/emailSuccess.jsp");
            dispatcher.forward(req, resp);

        } else {
            logger.info(emailError);

            Error error = new Error();
            error.report(req, resp, emailError, "Your email was not sent!");

        }


    }

    /**
     * Takes the various parts for the email and sends to the the email handler.
     *
     * @param req the current HttpServletRequest
     * @param emailProperties File containing the constants for sending an email
     */

    private void sendToHandler (HttpServletRequest req, Properties emailProperties) {

        Emailer emailHandler = new Emailer();
        logger.info("Made an instance of the emailHandler");

        String EMAIL_ACCESS = emailProperties.getProperty("emailAccess");
        String EMAIL_USER = emailProperties.getProperty("emailUser");
        String admin = emailProperties.getProperty("adminEmail");

        String senderName = req.getParameter("senderName");
        String senderEmail = req.getParameter("email");
        String subject = req.getParameter("subject");
        String messageBody = req.getParameter("messageBody");

        messageBody = prepMessageBody(messageBody, senderName, senderEmail);



        emailHandler.sendMail(admin, subject, messageBody, EMAIL_USER, EMAIL_USER, EMAIL_ACCESS);
        logger.debug("Called the send Mail method");
    }

    /**
     * This method takes the information from the user input and assemble the
     * information into the body of the email, this way the username and return
     * email address shows up in the body.
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

    /**
     * Takes the information form the request and validates it.
     * Returns an error statement if its not valid.
     *
     *
     * @param req the current HttpServletRequest
     * @return Any issues with the email information
     */
    private String validateData (HttpServletRequest req) {
        String emailError = "";

        if (req.getParameter("senderName").length() <= 1) {
            emailError += icons.sadface() + " - Your Name is a required field.<br />";
        }

        if (req.getParameter("email").length() <= 1) {
            emailError += icons.sadface() + " - Your Email is a required field.<br />";
        }

        if (req.getParameter("subject").length() <= 1) {
            emailError += icons.sadface() + " - Topic is a required field.<br />";
        }

        if (req.getParameter("messageBody").length() <= 1) {
            emailError += icons.sadface() + " - The message body is a required field.";
        }

        return emailError;
    }
}