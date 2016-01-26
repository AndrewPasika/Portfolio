package controller.filters;

import model.javaBeans.UserBean;
import services.UserServices;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by AndriiUSER on 26.11.2015.
 */
@WebFilter(urlPatterns = "/admin/*")
public class AdminFilter extends AbstractFilter{
    private UserServices services;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        services = new UserServices();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String result = services.checkForAdmin(new HttpServletRequestWrapper(req));
        if(result.equals("/admin")){
            req.getRequestDispatcher(result).forward(req, resp);
        }else {
            resp.sendRedirect(result);
        }
    }
}
