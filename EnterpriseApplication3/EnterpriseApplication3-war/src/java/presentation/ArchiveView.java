/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import DAO.ArchiveFacadeLocal;
import DAO.DocumentFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import Model.Archive;
import static Model.Archive_.document;
import Model.Document;
import java.util.List;

/**
 *
 * @author fours
 */
@Named(value = "archiveView")
@SessionScoped
public class ArchiveView implements Serializable{
    @EJB
    ArchiveFacadeLocal archiveFacade;
    @EJB 
    DocumentFacadeLocal documentFacade;
    
    public ArchiveView(){
        this.archive = new Archive();
        this.codeName = new String();
    }
    
    private Archive archive;
    private String codeName;

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
    
    

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }
    
    public List<Archive> getAllArhive(){
        List<Archive> list = archiveFacade.findAll();
        return list;
    }
    
    //Транзакция жи есь
    public void addToArchive(int idDoc){
        Document document = documentFacade.find(idDoc);
        archiveFacade.addDoc(document, codeName, archive.getCustomer());
    }
    
    
    
}
