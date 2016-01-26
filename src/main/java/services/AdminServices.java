package services;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

/**
 * Created by AndriiUSER on 05.12.2015.
 */
public class AdminServices {
    public String showUsers(HttpServletRequestWrapper wrapper){
        HttpSession session = wrapper.getSession();
        if(session.getAttribute("flag") == null){
            session.setAttribute("flag", "true");
            session.setAttribute("user", new Andrii().returnUser());
            return "/WEB-INF/admin/mainPage.jsp";
        }else {
            session.removeAttribute("flag");
            return "/WEB-INF/admin/mainPage.jsp";
        }
    }
}
