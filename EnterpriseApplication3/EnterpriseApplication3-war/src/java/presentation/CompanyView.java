/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import DAO.CompanyFacadeLocal;
import Model.Archive;
import Model.Company;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author fours
 */
@Named(value = "companyView")
@SessionScoped
public class CompanyView implements Serializable{
    @EJB
    CompanyFacadeLocal companyFacade;
    
    public CompanyView(){
        this.company = new Company();
    }
    
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

  
    
    public List<Company> getAllCompany(){
        List<Company> list = companyFacade.findAll();
        return list;
    }
    
    public String addCompany(){
        companyFacade.create(company);
        return "faces/company.xhtml";
    }
    
    public String editCompany(int id){
        this.company = companyFacade.find(id);
        return "faces/editCompany.xhtml";
    }
    
    public String edit(){
        companyFacade.edit(this.company);
        return "faces/company.xhtml";
    }
    
}