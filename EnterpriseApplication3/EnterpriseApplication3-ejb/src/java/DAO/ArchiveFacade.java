/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Archive;
import Model.Company;
import Model.Customer;
import Model.Document;
import java.util.Calendar;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fours
 */
@Stateless
public class ArchiveFacade extends AbstractFacade<Archive> implements ArchiveFacadeLocal {

    @PersistenceContext(unitName = "EnterpriseApplication3-ejbPU")
    private EntityManager em;
    
    @Resource
    private SessionContext sc;
    
    @EJB
    DocumentFacadeLocal documentFacade;
    @EJB
    CompanyFacadeLocal companyFacade;
    @EJB
    CustomerFacadeLocal customerFacade;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void addDoc(Document document, String code, Customer customer){
        List<Document> list = documentFacade.findAll();
        int lastId = list.size();
        Company company = companyFacade.find((document.getIdDocument()));
        if (code.equals(company.getCodename())){
            Archive archive = new Archive();
            archive.setDocument(document);
            archive.setCustomer(customer);
            archive.setCompany(company);
            java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            archive.setDate(date);
            customer.setName(customer.getName()+"|"+document.getName());
            em.flush();
            em.persist(customer);
            em.persist(archive);
        }
        else {
            sc.setRollbackOnly();
        }
    }
    
    
    

    public ArchiveFacade() {
        super(Archive.class);
    }
    
}
