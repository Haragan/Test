package presentation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fours
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

// Аннотации managed bean компонента
@ManagedBean (name="Login") // определение managed bean и его наименования
@SessionScoped             // определение времени жизни - сессия
public class LoginBean
{
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
	}

	public String getPassword() {
	    return password;
	}

	public void setPassword(String password) {
	    this.password = password;
	}
 
    /* Метод простейшей авторизации.
     * Выполняется проверка имени и пароля пользователя. 
     * Результат проверки - наименование страницы перехода
     */
    public String checkLogin(){
        if ((login.equalsIgnoreCase("admin") && password.equalsIgnoreCase("qwerty")) || (login.equalsIgnoreCase("user") && password.equalsIgnoreCase("123456"))){
            return "faces/index.xhtml";
        } else {
            return "loginfailed?faces-redirect=true";
        }
    }
}