package controller.administration;

import services.AdminServices;
import services.Andrii;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by AndriiUSER on 23.11.2015.
 */
@WebServlet(urlPatterns = "/admin")
public class AdminController extends HttpServlet {
    AdminServices services;
    @Override
    public void init() throws ServletException {
        services = new AdminServices();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/admin/mainPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = services.showUsers(new HttpServletRequestWrapper(req));
        req.getRequestDispatcher(result).forward(req, resp);
    }
}
