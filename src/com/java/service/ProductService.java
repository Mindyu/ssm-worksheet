package com.java.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.bean.Product;
import com.java.bean.ProductExample;
import com.java.dao.ProductMapper;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;
    /*查*/
    public List<Product> listProductsBylimit(int currentPage, int pageSize) {
    	System.out.println("分页请求下：" + currentPage + ' ' + pageSize);
    	ProductExample example = new ProductExample();
    	example.setOffset((currentPage-1)*pageSize);
    	example.setLimit(pageSize);
        List<Product> list = productMapper.selectByExampleWithBLOBs(example);
        if (list != null) for (Product prod:list) System.out.println(prod);
        return list;
    }
    public List<Product> listProducts() {
        return productMapper.selectByExampleWithBLOBs(null);
    }
    public long countProducts() {
    	return productMapper.countByExample(null);
    }
    public Product getProduct(Integer prodId) {
        Product product = productMapper.selectByPrimaryKey(prodId);
        return product;
    }
    public Product newProduct(Product prod) {
        productMapper.insertSelective(prod);
        return prod;
    }
    public int editProduct(Product prod) {
        int n = productMapper.updateByPrimaryKeyWithBLOBs(prod);
        return n;
    }
    public int deleteProduct(Integer prodId) {
        int n = productMapper.deleteByPrimaryKey(prodId);
        return n;
    }
}
