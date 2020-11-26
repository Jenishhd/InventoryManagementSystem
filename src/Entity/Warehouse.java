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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Home Desktop
 */
@Entity
@Table(name = "WAREHOUSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Warehouse.findAll", query = "SELECT w FROM Warehouse w"),
    @NamedQuery(name = "Warehouse.findByProductid", query = "SELECT w FROM Warehouse w WHERE w.warehousePK.productid = :productid"),
    @NamedQuery(name = "Warehouse.findByProductname", query = "SELECT w FROM Warehouse w WHERE w.warehousePK.productname = :productname"),
    @NamedQuery(name = "Warehouse.findByProductwhquantity", query = "SELECT w FROM Warehouse w WHERE w.productwhquantity = :productwhquantity")})
public class Warehouse implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WarehousePK warehousePK;
    @Column(name = "PRODUCTWHQUANTITY")
    private Integer productwhquantity;

    public Warehouse() {
    }

    public Warehouse(WarehousePK warehousePK) {
        this.warehousePK = warehousePK;
    }

    public Warehouse(int productid, String productname) {
        this.warehousePK = new WarehousePK(productid, productname);
    }

    public WarehousePK getWarehousePK() {
        return warehousePK;
    }

    public void setWarehousePK(WarehousePK warehousePK) {
        this.warehousePK = warehousePK;
    }

    public Integer getProductwhquantity() {
        return productwhquantity;
    }

    public void setProductwhquantity(Integer productwhquantity) {
        this.productwhquantity = productwhquantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (warehousePK != null ? warehousePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warehouse)) {
            return false;
        }
        Warehouse other = (Warehouse) object;
        if ((this.warehousePK == null && other.warehousePK != null) || (this.warehousePK != null && !this.warehousePK.equals(other.warehousePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Warehouse[ warehousePK=" + warehousePK + " ]";
    }
    
}
