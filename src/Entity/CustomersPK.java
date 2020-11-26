/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Home Desktop
 */
@Embeddable
public class CustomersPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CUSTOMER_FIRSTNAME")
    private String customerFirstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CUSTOMER_LASTNAME")
    private String customerLastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CUSTOMER_ADDRESS")
    private String customerAddress;

    public CustomersPK() {
    }

    public CustomersPK(String customerFirstname, String customerLastname, String customerAddress) {
        this.customerFirstname = customerFirstname;
        this.customerLastname = customerLastname;
        this.customerAddress = customerAddress;
    }

    public String getCustomerFirstname() {
        return customerFirstname;
    }

    public void setCustomerFirstname(String customerFirstname) {
        this.customerFirstname = customerFirstname;
    }

    public String getCustomerLastname() {
        return customerLastname;
    }

    public void setCustomerLastname(String customerLastname) {
        this.customerLastname = customerLastname;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerFirstname != null ? customerFirstname.hashCode() : 0);
        hash += (customerLastname != null ? customerLastname.hashCode() : 0);
        hash += (customerAddress != null ? customerAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomersPK)) {
            return false;
        }
        CustomersPK other = (CustomersPK) object;
        if ((this.customerFirstname == null && other.customerFirstname != null) || (this.customerFirstname != null && !this.customerFirstname.equals(other.customerFirstname))) {
            return false;
        }
        if ((this.customerLastname == null && other.customerLastname != null) || (this.customerLastname != null && !this.customerLastname.equals(other.customerLastname))) {
            return false;
        }
        if ((this.customerAddress == null && other.customerAddress != null) || (this.customerAddress != null && !this.customerAddress.equals(other.customerAddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CustomersPK[ customerFirstname=" + customerFirstname + ", customerLastname=" + customerLastname + ", customerAddress=" + customerAddress + " ]";
    }
    
}
