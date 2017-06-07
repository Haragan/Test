/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author fours
 */
@Entity
@Table(name="companyEntity")
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompany;
    private String Name;
    private String INN;
    private String Codename;
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE) 
    private List<Customer> customers;
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Archive> documents;

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getCodename() {
        return Codename;
    }

    public void setCodename(String Codename) {
        this.Codename = Codename;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Archive> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Archive> documents) {
        this.documents = documents;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idCompany);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Company other = (Company) obj;
        if (!Objects.equals(this.idCompany, other.idCompany)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Company{" + "idCompany=" + idCompany + '}';
    }

    
    
}
