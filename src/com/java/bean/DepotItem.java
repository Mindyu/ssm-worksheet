package com.java.bean;

import java.math.BigDecimal;

public class DepotItem {
    private Integer depotno;

    private Integer depotItem;

    private Integer prodId;

    private Integer quantity;
        
    private BigDecimal prodPrice;
    
    private String prodDesc;
    
    private String prodName;
    
    
    
    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public BigDecimal getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(BigDecimal prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public Integer getDepotno() {
        return depotno;
    }

    public void setDepotno(Integer depotno) {
        this.depotno = depotno;
    }

    public Integer getDepotItem() {
        return depotItem;
    }

    public void setDepotItem(Integer depotItem) {
        this.depotItem = depotItem;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "DepotItem [depotno=" + depotno + ", depotItem=" + depotItem + ", prodId=" + prodId + ", quantity="
                + quantity + ", prodPrice=" + prodPrice + ", prodDesc=" + prodDesc + "]";
    }
    
    
}