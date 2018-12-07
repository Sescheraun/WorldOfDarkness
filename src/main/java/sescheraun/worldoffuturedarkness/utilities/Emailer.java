package sescheraun.worldoffuturedarkness.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class Emailer {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public void sendMail(String to, String subject, String messageBody, String from, String userName, String password) {

        String host = "smtp.gmail.com";

        logger.debug("In the sendMail method");
        Properties properties = new Properties();
        properties.put ("mail.smtp.auth", "true");
        properties.put ("mail.smtp.starttls.enable", "true");
        properties.put ("mail.smtp.host", host);
        properties.put ("mail.smtp.port", "587");
        properties.put ("mail.smtp.user", userName);
        properties.put ("mail.smtp.password", password);


        logger.debug("The properties are set up");

        logger.debug("User name is :" + userName);
        logger.debug("Password is :" + password);


        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);

//        , new Authenticator() {
//
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(userName, password);
//            }
//        });

        logger.debug("The session is set up");

        try {

            logger.debug("in the try");
            logger.debug("new message(session)");
            message.setFrom(new InternetAddress(from));
            logger.debug("InternetAddress(from)");
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            logger.debug("Message.RecipientType.TO");
            message.setSubject(subject);
            logger.debug("setSubject(subject)");
            message.setText(messageBody);
            logger.debug("setText(messageBody)");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, password);
            Transport.send(message);

            logger.debug("Sent");

        } catch (MessagingException messagingException) {
            throw new RuntimeException(messagingException);
        }

    }
}
//
//
//package sescheraun.worldoffuturedarkness.utilities;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import javax.mail.*;
//import javax.mail.internet.*;
//import java.util.Properties;
//
//public class Emailer {
//
//    private final Logger logger = LogManager.getLogger(this.getClass());
//
//    public void sendMail(String to, String subject, String messageBody, String from, String userName, String password) {
//
//    String host = "smtp.mail.yahoo.com";
//
//    logger.debug("In the sendMail method");
//        Properties properties = new Properties();
//        properties.put ("mail.smtp.auth", "true");
//        properties.put ("mail.smtp.starttls.enable", "true");
//        properties.put ("mail.smtp.host", host);
//        properties.put ("mail.smtp.port", "587");
//        properties.put ("mail.smtp.user", userName);
//        properties.put ("mail.smtp.password", password);
//
//
//        logger.debug("The properties are set up");
//
//        logger.debug("User name is :" + userName);
//        logger.debug("Password is :" + password);
//
//
//        Session session = Session.getDefaultInstance(properties);
//        MimeMessage message = new MimeMessage(session);
//
////        , new Authenticator() {
////
////            protected PasswordAuthentication getPasswordAuthentication() {
////                return new PasswordAuthentication(userName, password);
////            }
////        });
//
//        logger.debug("The session is set up");
//
//        try {
//
//            logger.debug("in the try");
//            logger.debug("new message(session)");
//            message.setFrom(new InternetAddress(from));
//            logger.debug("InternetAddress(from)");
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//            logger.debug("Message.RecipientType.TO");
//            message.setSubject(subject);
//            logger.debug("setSubject(subject)");
//            message.setText(messageBody);
//            logger.debug("setText(messageBody)");
//            Transport transport = session.getTransport("smtp");
//            transport.connect("smtp.gmail.com", "cworldofdarkness@yahoo.com", "chipped-in chi_ldren changel_ings for the cyberdream");
//            transport.send(message);
//
//            logger.debug("Sent");
//
//        } catch (MessagingException messagingException) {
//            throw new RuntimeException(messagingException);
//        }
//
//    }
//}
