/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Home Desktop
 */
@Entity
@Table(name = "INVOICES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoices.findAll", query = "SELECT i FROM Invoices i"),
    @NamedQuery(name = "Invoices.findByInvoiceid", query = "SELECT i FROM Invoices i WHERE i.invoiceid = :invoiceid"),
    @NamedQuery(name = "Invoices.findByPayment", query = "SELECT i FROM Invoices i WHERE i.payment = :payment"),
    @NamedQuery(name = "Invoices.findBySalespersonid", query = "SELECT i FROM Invoices i WHERE i.salespersonid = :salespersonid"),
    @NamedQuery(name = "Invoices.findByDays", query = "SELECT i FROM Invoices i WHERE i.days = :days"),
    @NamedQuery(name = "Invoices.findByIsdelivery", query = "SELECT i FROM Invoices i WHERE i.isdelivery = :isdelivery")})
public class Invoices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INVOICEID")
    private Integer invoiceid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PAYMENT")
    private BigDecimal payment;
    @Column(name = "SALESPERSONID")
    private Integer salespersonid;
    @Column(name = "DAYS")
    private Integer days;
    @Column(name = "ISDELIVERY")
    private Boolean isdelivery;

    public Invoices() {
    }

    public Invoices(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public Integer getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public Integer getSalespersonid() {
        return salespersonid;
    }

    public void setSalespersonid(Integer salespersonid) {
        this.salespersonid = salespersonid;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Boolean getIsdelivery() {
        return isdelivery;
    }

    public void setIsdelivery(Boolean isdelivery) {
        this.isdelivery = isdelivery;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceid != null ? invoiceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoices)) {
            return false;
        }
        Invoices other = (Invoices) object;
        if ((this.invoiceid == null && other.invoiceid != null) || (this.invoiceid != null && !this.invoiceid.equals(other.invoiceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Invoices[ invoiceid=" + invoiceid + " ]";
    }
    
}
