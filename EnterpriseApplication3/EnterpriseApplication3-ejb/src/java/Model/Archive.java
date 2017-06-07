/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author fours
 */
@Entity
@Table(name="archive")
public class Archive implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArchve;
    private Date date;
    @ManyToOne 
    private Document document;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idCustomer")
    private Customer customer;
    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;

    public Integer getIdArchve() {
        return idArchve;
    }

    public void setIdArchve(Integer idArchve) {
        this.idArchve = idArchve;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idArchve);
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
        final Archive other = (Archive) obj;
        if (!Objects.equals(this.idArchve, other.idArchve)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Archive{" + "idArchve=" + idArchve + '}';
    }
    
        
}
