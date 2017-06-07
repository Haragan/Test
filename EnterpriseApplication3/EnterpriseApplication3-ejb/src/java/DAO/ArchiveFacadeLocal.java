/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Archive;
import Model.Customer;
import Model.Document;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fours
 */
@Local
public interface ArchiveFacadeLocal {

    void create(Archive archive);

    void edit(Archive archive);

    void remove(Archive archive);

    Archive find(Object id);

    List<Archive> findAll();

    List<Archive> findRange(int[] range);

    int count();
    
    void addDoc(Document document, String code, Customer customer);
    
}
