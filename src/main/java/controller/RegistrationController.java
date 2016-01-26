package controller;

import model.javaBeans.UserBean;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.websocket.Session;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by AndriiUSER on 15.11.2015.
 */
@WebServlet(urlPatterns = "/registration")
public class RegistrationController extends HttpServlet {
    private UserServices userServices;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userServices = new UserServices();
        req.getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = null;
        try {
            result = userServices.register(new HttpServletRequestWrapper(req));

            switch (result) {
                case "error1":
                    req.setAttribute("message", "You haven't filled in the required fields.");
                    req.getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
                    break;
                case "error2":
                    req.setAttribute("message", "Password does not match the confirm password field.");
                    req.getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
                    break;
                case "error3":
                    req.setAttribute("message", "Wrong email.");
                    req.getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
                    break;
                case "error4":
                    req.setAttribute("message", "Your login is too short.");
                    req.getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
                    break;
                case "error5":
                    req.setAttribute("message", "Your password is too short");
                    req.getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
                    break;
                default:
                    req.setAttribute("message", "Congrats! Registration was successful.");
                    req.getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
                    break;
            }
        } catch (SQLException e) {
            if(e.getErrorCode() == 1){
                req.setAttribute("message", "User with such email/login already exists.");
                req.getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
            }else {
                e.printStackTrace();
                req.setAttribute("message", "Sorry, some troubles with database occurred.");
                req.getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
            }
        }
    }
}