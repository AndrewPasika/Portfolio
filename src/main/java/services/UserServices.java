package services;

import model.DAO.UserDAO;
import model.javaBeans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by AndriiUSER on 02.12.2015.
 */
public class UserServices {
    private UserDAO userDAO = UserDAO.getInstance();
    private int id;
    private UserBean userBean;

    public String checkForAdmin(HttpServletRequestWrapper requestWrapper) {
        HttpSession session = requestWrapper.getSession();
        if (session.getAttribute("userBean") == null) {
            return "/error";
        } else {
            userBean = (UserBean) session.getAttribute("userBean");
            id = userBean.getId();
            if (id == 1) {
                return "/admin";
            } else {
                return "/error";
            }
        }
    }

    public String checkForRegistration(HttpServletRequestWrapper requestWrapper) {
        HttpSession session = requestWrapper.getSession();
        if (session.getAttribute("userBean") == null) {
            return "/registration";
        } else {
            return "/error";
        }
    }

    public String login(HttpServletRequestWrapper requestWrapper) throws SQLException {
        UserBean userBean;
        HttpSession session = requestWrapper.getSession();
        String loginOrEmail = requestWrapper.getParameter("loginOrEmail");
        String password = requestWrapper.getParameter("password");

        if (loginOrEmail.contains("@")) {
            userBean = userDAO.read(userDAO.authorization(loginOrEmail, password, 1, 2));
        } else {
            userBean = userDAO.read(userDAO.authorization(loginOrEmail, password, 2, 1));
        }
        session.setAttribute("userBean", userBean);
        if(userBean.getName() == null){
            return userBean.getLogin();
        }else {
            return userBean.getName();
        }
    }

    public String register(HttpServletRequestWrapper requestWrapper) throws SQLException {
        HttpSession session = requestWrapper.getSession();

        String firstname = requestWrapper.getParameter("firstname");
        String surname = requestWrapper.getParameter("surname");
        String login = requestWrapper.getParameter("login");
        String email = requestWrapper.getParameter("email");
        String password = requestWrapper.getParameter("password");
        String confPass = requestWrapper.getParameter("confPass");

        if (login.equals("") || email.equals("") || password.equals("") || confPass.equals("")) {
            return "error1";
        } else if (!password.equals(confPass)) {
            return "error2";
        }

        if (email.length() < 6) {
            return "error3";
        } else if (login.length() < 5) {
            return "error4";
        } else if (password.length() < 6) {
            return "error5";
        }

        if (firstname.equals("") || surname.equals("")) {
            UserBean userBean = new UserBean(login, password, email);
            userBean.setId(userDAO.create(userBean));
            session.setAttribute("userBean", userBean);
            return "created";
        } else if (firstname.equals("")) {
            UserBean userBean = new UserBean(surname, login, password, email);
            userBean.setId(userDAO.create(userBean));
            session.setAttribute("userBean", userBean);
            return "created";
        } else if (surname.equals("")) {
            UserBean userBean = new UserBean(firstname, login, password, email);
            userBean.setId(userDAO.create(userBean));
            session.setAttribute("userBean", userBean);
            return "created";
        }
        UserBean userBean = new UserBean(firstname, surname, login, password, email);
        userBean.setId(userDAO.create(userBean));
        session.setAttribute("userBean", userBean);
        return "created";
    }
}
