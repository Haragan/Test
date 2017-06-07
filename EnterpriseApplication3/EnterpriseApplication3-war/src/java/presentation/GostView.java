/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import DAO.GOSTFacadeLocal;
import Model.GOST;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author fours
 */
@Named(value = "gostView")
@SessionScoped
public class GostView implements Serializable{
    @EJB
    GOSTFacadeLocal gostFacade;
    
    public GostView(){
        this.gost = new GOST();
    }
    
    private GOST gost;

    public GOST getGost() {
        return gost;
    }

    public void setGost(GOST gost) {
        this.gost = gost;
    }

  

 
    
    public List<GOST> getAllGost(){
        List<GOST> list = gostFacade.findAll();
        return list;
    }
    
    public String addGost(){
        gostFacade.create(gost);
        return "/faces/gost.xhtml";
    }
    
    
    public void deleteGost(int id){
        gost = gostFacade.find(id);
        gostFacade.remove(this.gost);
    }
}
