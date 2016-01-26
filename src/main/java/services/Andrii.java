package services;

import model.javaBeans.UserBean;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by AndriiUSER on 03.12.2015.
 */
public class Andrii {

    public UserBean returnUser(){
        UserBean userBean = new UserBean();
        userBean.setLogin("Andreyka-Batareyka");
        userBean.setEmail("Pasika2012@");
        userBean.setSurname("Pasika");
        userBean.setName("Andrii");
        userBean.setId(1);
        return userBean;
    }
}
