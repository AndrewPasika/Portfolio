package controller.filters;

import services.UserServices;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by AndriiUSER on 19.12.2015.
 */
@WebFilter(urlPatterns = "/registration/*")
public class RegistrationFilter extends AbstractFilter {
    UserServices userServices;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userServices = new UserServices();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String result = userServices.checkForRegistration(new HttpServletRequestWrapper(req));
        req.getRequestDispatcher(result).forward(request, response);
    }
}
