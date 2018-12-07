package sescheraun.worldoffuturedarkness.controler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sescheraun.worldoffuturedarkness.utilities.Emailer;

@WebServlet(
        urlPatterns = {"/sendMail"}
)
public class EmailServlet extends HttpServlet {

    private static final String EMAIL_ACCESS = "ch8pped9nchi_ldrenchangel_0ngsofthecyberdream";
    private static final String EMAIL_USER = "cpworldofdarkness@gmail.com";

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.debug("In email servlet");

        // Make sure the user isn't being a smart ass and trying to use a bad user name.
        String emailError = null;
        String subject = "";
        String senderName = "";
        String messageBody = "";


        if (req.getParameter("senderName").length() <= 1) {
            emailError += "Your Name is a required field. /n";
        } else {
            senderName = req.getParameter("senderName");
        }

        logger.debug("Got the sender's name: " + senderName);

        if (req.getParameter("subject").length() <= 1) {
            emailError += "Topic is a required field. /n";
        } else {
            subject = req.getParameter("subject");
        }

        logger.debug("Got the Topic: " + subject);

        if (req.getParameter("messageBody").length() <= 1) {
            emailError += "Topic is a required field. /n";
        } else {
            messageBody = req.getParameter("messageBody");
        }

        logger.debug("Got the body: " + messageBody);


        if (emailError == null) {

            Emailer emailHandler = new Emailer();

            logger.debug("Made an instance of the emailHandler");

            emailHandler.sendMail("Admin", subject, messageBody, senderName, EMAIL_USER, EMAIL_ACCESS);
            logger.debug("Called the send Mail method");


        } else {
            logger.info(emailError);
            resp.addHeader("error", emailError);
            resp.sendRedirect("/WorldOfFutureDarkness/error.jsp");
        }
    }
}

//package sescheraun.worldoffuturedarkness.controler;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import sescheraun.worldoffuturedarkness.utilities.Emailer;
//
//@WebServlet(
//        urlPatterns = {"/sendMail"}
//)
//public class EmailServlet extends HttpServlet {
//
//    private static final String EMAIL_ACCESS = "chipped-in chi_ldren changel_ings for the cyberdream";
//    private static final String EMAIL_USER = "cworldofdarkness";
//    private static final String EMAIL_FROM = "cworldofdarkness@yahoo.com";
//
//    private final Logger logger = LogManager.getLogger(this.getClass());
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        logger.debug("In email servlet");
//
//        // Make sure the user isn't being a smart ass and trying to use a bad user name.
//        String emailError = null;
//        String subject = "";
//        String senderName = "";
//        String messageBody = "";
//
//
//        if (req.getParameter("senderName").length() <= 1) {
//            emailError += "Your Name is a required field. /n";
//        } else {
//            senderName = req.getParameter("senderName");
//        }
//
//        logger.debug("Got the sender's name: " + senderName);
//
//        if (req.getParameter("subject").length() <= 1) {
//            emailError += "Topic is a required field. /n";
//        } else {
//            subject = req.getParameter("subject");
//        }
//
//        logger.debug("Got the Topic: " + subject);
//
//        if (req.getParameter("messageBody").length() <= 1) {
//            emailError += "Topic is a required field. /n";
//        } else {
//            messageBody = req.getParameter("messageBody");
//        }
//
//        logger.debug("Got the body: " + messageBody);
//
//
//        if (emailError == null) {
//
//            Emailer emailHandler = new Emailer();
//
//            logger.debug("Made an instance of the emailHandler");
//
//            emailHandler.sendMail("Admin", subject, messageBody, EMAIL_FROM, EMAIL_USER, EMAIL_ACCESS);
//            logger.debug("Called the send Mail method");
//
//
//        } else {
//            logger.info(emailError);
//            resp.addHeader("error", emailError);
//            resp.sendRedirect("/WorldOfFutureDarkness/error.jsp");
//        }
//    }
//}