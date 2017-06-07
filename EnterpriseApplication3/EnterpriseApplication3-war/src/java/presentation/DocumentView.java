/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import DAO.DocumentFacadeLocal;
import Model.Archive;
import Model.Document;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author fours
 */
@Named(value = "documentView")
@SessionScoped
public class DocumentView implements Serializable{
    @EJB
    DocumentFacadeLocal documentFacade;
    
    public DocumentView(){
        this.document = new Document();
    }
    
    private Document document;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

 
    
    public List<Document> getAllDocument(){
        List<Document> list = documentFacade.findAll();
        return list;
    }
    
     public String addDocument(){
        documentFacade.create(document);
        return "/faces/document.xhtml";
    }
}
