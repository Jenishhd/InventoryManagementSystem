/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Home Desktop
 */
@Entity
@Table(name = "CUSTOMERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c"),
    @NamedQuery(name = "Customers.findByCustomerFirstname", query = "SELECT c FROM Customers c WHERE c.customersPK.customerFirstname = :customerFirstname"),
    @NamedQuery(name = "Customers.findByCustomerLastname", query = "SELECT c FROM Customers c WHERE c.customersPK.customerLastname = :customerLastname"),
    @NamedQuery(name = "Customers.findByCustomerAddress", query = "SELECT c FROM Customers c WHERE c.customersPK.customerAddress = :customerAddress"),
    @NamedQuery(name = "Customers.findByCustomerState", query = "SELECT c FROM Customers c WHERE c.customerState = :customerState"),
    @NamedQuery(name = "Customers.findByCustomerCountry", query = "SELECT c FROM Customers c WHERE c.customerCountry = :customerCountry"),
    @NamedQuery(name = "Customers.findByInvoiceid", query = "SELECT c FROM Customers c WHERE c.invoiceid = :invoiceid")})
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CustomersPK customersPK;
    @Size(max = 5)
    @Column(name = "CUSTOMER_STATE")
    private String customerState;
    @Size(max = 5)
    @Column(name = "CUSTOMER_COUNTRY")
    private String customerCountry;
    @Column(name = "INVOICEID")
    private Integer invoiceid;

    public Customers() {
    }

    public Customers(CustomersPK customersPK) {
        this.customersPK = customersPK;
    }

    public Customers(String customerFirstname, String customerLastname, String customerAddress) {
        this.customersPK = new CustomersPK(customerFirstname, customerLastname, customerAddress);
    }

    public CustomersPK getCustomersPK() {
        return customersPK;
    }

    public void setCustomersPK(CustomersPK customersPK) {
        this.customersPK = customersPK;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public Integer getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customersPK != null ? customersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.customersPK == null && other.customersPK != null) || (this.customersPK != null && !this.customersPK.equals(other.customersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Customers[ customersPK=" + customersPK + " ]";
    }
    
}
