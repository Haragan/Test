/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import DAO.CustomerFacadeLocal;
import Model.Company;
import Model.Customer;
import static Model.Customer_.company;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author fours
 */
@Named(value = "customerView")
@SessionScoped
public class CustomerView implements Serializable{
    @EJB
    CustomerFacadeLocal customerFacade;
    
    public CustomerView(){
        this.customer = new Customer();
    }
    
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
    public List<Customer> getAllCustomers(){
        List<Customer> list = customerFacade.findAll();
        return list;
    }
    
    public String addCustomer(){
        customerFacade.create(customer);
        return "faces/customer.xhtml";
    }
    
    
}
