package controller.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by AndriiUSER on 18.11.2015.
 */
//@WebFilter(urlPatterns = "/*", displayName = "asdasd")
    @WebFilter(servletNames = "RegistrationController")
public class MainFilter extends AbstractFilter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }
}
