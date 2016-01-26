package model.javaBeans;

/**
 * Created by AndriiUSER on 28.11.2015.
 */
public class UserBean extends AbstractJSPBean {
    private Integer id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String email;


    public String getPassword() {
        return password;
    }

    public UserBean(){/*NOP*/}

    public UserBean(String name, String surname, String login, String password, String email){
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public UserBean(String surname, String login, String password, String email) {
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public UserBean(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public UserBean(Integer id, String name, String surname, String login, String password, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {

        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("User[name=%s, surname=%s, login=%s, email=%s, id=%s]",
                name, surname, login, email, id);
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof UserBean) && (id != null) ? id.equals(((UserBean) other).id) : (other == this);
    }

    @Override
    public int hashCode() {
        return (id != null) ? (getClass().hashCode() + id.hashCode()) : super.hashCode();
    }
}
