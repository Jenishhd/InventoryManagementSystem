/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "PRODUCTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByProductid", query = "SELECT p FROM Products p WHERE p.productsPK.productid = :productid"),
    @NamedQuery(name = "Products.findByProductname", query = "SELECT p FROM Products p WHERE p.productsPK.productname = :productname"),
    @NamedQuery(name = "Products.findByProductsellingprice", query = "SELECT p FROM Products p WHERE p.productsellingprice = :productsellingprice"),
    @NamedQuery(name = "Products.findByProductcostprice", query = "SELECT p FROM Products p WHERE p.productcostprice = :productcostprice"),
    @NamedQuery(name = "Products.findByProducttotalcost", query = "SELECT p FROM Products p WHERE p.producttotalcost = :producttotalcost"),
    @NamedQuery(name = "Products.findByProducttotalprofit", query = "SELECT p FROM Products p WHERE p.producttotalprofit = :producttotalprofit"),
    @NamedQuery(name = "Products.findByProductquantity", query = "SELECT p FROM Products p WHERE p.productquantity = :productquantity"),
    @NamedQuery(name = "Products.findByProductquantitysold", query = "SELECT p FROM Products p WHERE p.productquantitysold = :productquantitysold")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductsPK productsPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRODUCTSELLINGPRICE")
    private BigDecimal productsellingprice;
    @Column(name = "PRODUCTCOSTPRICE")
    private BigDecimal productcostprice;
    @Column(name = "PRODUCTTOTALCOST")
    private BigDecimal producttotalcost;
    @Column(name = "PRODUCTTOTALPROFIT")
    private BigDecimal producttotalprofit;
    @Column(name = "PRODUCTQUANTITY")
    private Integer productquantity;
    @Column(name = "PRODUCTQUANTITYSOLD")
    private Integer productquantitysold;

    public Products() {
    }

    public Products(ProductsPK productsPK) {
        this.productsPK = productsPK;
    }

    public Products(int productid, String productname) {
        this.productsPK = new ProductsPK(productid, productname);
    }

    public ProductsPK getProductsPK() {
        return productsPK;
    }

    public void setProductsPK(ProductsPK productsPK) {
        this.productsPK = productsPK;
    }

    public BigDecimal getProductsellingprice() {
        return productsellingprice;
    }

    public void setProductsellingprice(BigDecimal productsellingprice) {
        this.productsellingprice = productsellingprice;
    }

    public BigDecimal getProductcostprice() {
        return productcostprice;
    }

    public void setProductcostprice(BigDecimal productcostprice) {
        this.productcostprice = productcostprice;
    }

    public BigDecimal getProducttotalcost() {
        return producttotalcost;
    }

    public void setProducttotalcost(BigDecimal producttotalcost) {
        this.producttotalcost = producttotalcost;
    }

    public BigDecimal getProducttotalprofit() {
        return producttotalprofit;
    }

    public void setProducttotalprofit(BigDecimal producttotalprofit) {
        this.producttotalprofit = producttotalprofit;
    }

    public Integer getProductquantity() {
        return productquantity;
    }

    public void setProductquantity(Integer productquantity) {
        this.productquantity = productquantity;
    }

    public Integer getProductquantitysold() {
        return productquantitysold;
    }

    public void setProductquantitysold(Integer productquantitysold) {
        this.productquantitysold = productquantitysold;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productsPK != null ? productsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.productsPK == null && other.productsPK != null) || (this.productsPK != null && !this.productsPK.equals(other.productsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Products[ productsPK=" + productsPK + " ]";
    }
    
}
