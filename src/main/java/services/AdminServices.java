package services;

import model.DAO_oracle.UserDAO;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by AndriiUSER on 05.12.2015.
 */
public class AdminServices {
    private final static String ERROR = "error_db";
    private final static String FLAG = "flag";
    private UserDAO userDAO = UserDAO.getInstance();

    public void showUsers(HttpServletRequestWrapper wrapper){
        HttpSession session = wrapper.getSession();
        if(session.getAttribute(FLAG) == null){
            try {
                session.setAttribute("list", userDAO.getAll());
                session.setAttribute(FLAG, "true");
            }catch (SQLException ex){
                wrapper.setAttribute(ERROR, "Oops, something wrong with the database");
            }
        }else {
            session.removeAttribute("flag");
        }
    }
}
