package sescheraun.worldoffuturedarkness.controler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Error {

    public Error() {};

    public void report(HttpServletRequest req, HttpServletResponse resp, String error, String warning) throws ServletException, IOException {
        req.setAttribute("error", error);
        req.setAttribute("warning", warning);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
        dispatcher.forward(req, resp);
    }


}
