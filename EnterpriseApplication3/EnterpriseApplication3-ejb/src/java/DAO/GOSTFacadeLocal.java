/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.GOST;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fours
 */
@Local
public interface GOSTFacadeLocal {

    void create(GOST gOST);

    void edit(GOST gOST);

    void remove(GOST gOST);

    GOST find(Object id);

    List<GOST> findAll();

    List<GOST> findRange(int[] range);

    int count();
    
}
