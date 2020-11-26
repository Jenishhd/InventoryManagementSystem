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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Home Desktop
 */
@Entity
@Table(name = "SALESPERSONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salespersons.findAll", query = "SELECT s FROM Salespersons s"),
    @NamedQuery(name = "Salespersons.findBySalespersonid", query = "SELECT s FROM Salespersons s WHERE s.salespersonid = :salespersonid"),
    @NamedQuery(name = "Salespersons.findBySpFirstname", query = "SELECT s FROM Salespersons s WHERE s.spFirstname = :spFirstname"),
    @NamedQuery(name = "Salespersons.findBySpLastname", query = "SELECT s FROM Salespersons s WHERE s.spLastname = :spLastname"),
    @NamedQuery(name = "Salespersons.findBySpCommisionpercentage", query = "SELECT s FROM Salespersons s WHERE s.spCommisionpercentage = :spCommisionpercentage"),
    @NamedQuery(name = "Salespersons.findBySpTotalcommission", query = "SELECT s FROM Salespersons s WHERE s.spTotalcommission = :spTotalcommission")})
public class Salespersons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALESPERSONID")
    private Integer salespersonid;
    @Size(max = 20)
    @Column(name = "SP_FIRSTNAME")
    private String spFirstname;
    @Size(max = 20)
    @Column(name = "SP_LASTNAME")
    private String spLastname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SP_COMMISIONPERCENTAGE")
    private BigDecimal spCommisionpercentage;
    @Column(name = "SP_TOTALCOMMISSION")
    private BigDecimal spTotalcommission;

    public Salespersons() {
    }

    public Salespersons(Integer salespersonid) {
        this.salespersonid = salespersonid;
    }

    public Integer getSalespersonid() {
        return salespersonid;
    }

    public void setSalespersonid(Integer salespersonid) {
        this.salespersonid = salespersonid;
    }

    public String getSpFirstname() {
        return spFirstname;
    }

    public void setSpFirstname(String spFirstname) {
        this.spFirstname = spFirstname;
    }

    public String getSpLastname() {
        return spLastname;
    }

    public void setSpLastname(String spLastname) {
        this.spLastname = spLastname;
    }

    public BigDecimal getSpCommisionpercentage() {
        return spCommisionpercentage;
    }

    public void setSpCommisionpercentage(BigDecimal spCommisionpercentage) {
        this.spCommisionpercentage = spCommisionpercentage;
    }

    public BigDecimal getSpTotalcommission() {
        return spTotalcommission;
    }

    public void setSpTotalcommission(BigDecimal spTotalcommission) {
        this.spTotalcommission = spTotalcommission;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salespersonid != null ? salespersonid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salespersons)) {
            return false;
        }
        Salespersons other = (Salespersons) object;
        if ((this.salespersonid == null && other.salespersonid != null) || (this.salespersonid != null && !this.salespersonid.equals(other.salespersonid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Salespersons[ salespersonid=" + salespersonid + " ]";
    }
    
}
