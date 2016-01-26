package controller;

import model.DAO.UserDAO;
import services.UserServices;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * Created by AndriiUSER on 13.11.2015.
 */
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private UserServices userServices;
    private static final String MESSAGE = "welcome";
    private static final String ERROR = "error";
    private static final String URI = "/WEB-INF/login.jsp";
    private static final String ERROR_MESSAGE = "Unknown login or password, please try again.";
    private static final String WELCOME_MESSAGE = "Hello, ";

    @Override
    public void init() throws ServletException {
        userServices = new UserServices();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(URI).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result;
        try {
            result = userServices.login(new HttpServletRequestWrapper(req));
            req.setAttribute(MESSAGE, WELCOME_MESSAGE);
            req.setAttribute("name", result);
            req.getRequestDispatcher("/").forward(req, resp);
        } catch (SQLException e) {
            req.setAttribute(ERROR, ERROR_MESSAGE);
            req.getRequestDispatcher(URI).forward(req, resp);
        }
    }
}
