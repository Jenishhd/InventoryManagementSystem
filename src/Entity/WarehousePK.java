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
public class WarehousePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCTID")
    private int productid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PRODUCTNAME")
    private String productname;

    public WarehousePK() {
    }

    public WarehousePK(int productid, String productname) {
        this.productid = productid;
        this.productname = productname;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productid;
        hash += (productname != null ? productname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WarehousePK)) {
            return false;
        }
        WarehousePK other = (WarehousePK) object;
        if (this.productid != other.productid) {
            return false;
        }
        if ((this.productname == null && other.productname != null) || (this.productname != null && !this.productname.equals(other.productname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.WarehousePK[ productid=" + productid + ", productname=" + productname + " ]";
    }
    
}
