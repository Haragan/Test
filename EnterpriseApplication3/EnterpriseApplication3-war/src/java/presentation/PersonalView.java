/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import DAO.PersonalFacadeLocal;
import Model.Personal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author fours
 */
@Named(value = "personalView")
@SessionScoped
public class PersonalView implements Serializable{
    @EJB
    PersonalFacadeLocal personalFacade;
    
    public PersonalView(){
        this.personal = new Personal();
    }
    
    private Personal personal;

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

  

 
    
    public List<Personal> getAllPersonal(){
        List<Personal> list = personalFacade.findAll();
        return list;
    }
    
    public String addPersonal(){
        personalFacade.create(personal);
        return "/faces/personal.xhtml";
    }
    
    
    public void deletePersonal(int id){
        personal = personalFacade.find(id);
        personalFacade.remove(this.personal);
    }
    
     public String editPersonal(int id){
        this.personal = personalFacade.find(id);
        return "/faces/editPersonal.xhtml";
    }
     
     public String edit(){
        personalFacade.edit(this.personal);
        return "faces/personal.xhtml";
    }
}
