package com.java.bean;

import java.math.BigDecimal;
import java.util.List;

public class Product {
    private Integer prodId;

    private String prodName;

    private BigDecimal prodPrice;

    private String prodDesc;
    
    private List<Depot> depotList;
    
    public Integer getProdId() {
        return prodId;
    }
   
    public List<Depot> getDepotList() {
        return depotList;
    }


    public void setDepotList(List<Depot> depotList) {
        this.depotList = depotList;
    }


    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName == null ? null : prodName.trim();
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
        this.prodDesc = prodDesc == null ? null : prodDesc.trim();
    }

    public Product(Integer prodId, String prodName, BigDecimal prodPrice, String prodDesc) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodDesc = prodDesc;
    }

    public Product(String prodName, BigDecimal prodPrice, String prodDesc) {
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodDesc = prodDesc;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodDesc="
                + prodDesc + "]";
    }
    
    
}