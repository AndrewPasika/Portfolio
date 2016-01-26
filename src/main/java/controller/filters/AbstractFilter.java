package controller.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by AndriiUSER on 19.12.2015.
 */
public abstract class AbstractFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    abstract public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException;

    @Override
    public void destroy() {

    }
}
