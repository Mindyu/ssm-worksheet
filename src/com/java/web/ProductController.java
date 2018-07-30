package com.java.web;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.bean.Product;
import com.java.bean.Result;
import com.java.service.ProductService;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @RequestMapping(value="/productpage",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getProductsPage(int page, int rows) {
    	long total = productService.countProducts();
    	System.out.println(total);
        List<Product> list = productService.listProductsBylimit(page, rows);
        
        Map<String, Object> map=new HashMap<String,Object>();  
        map.put("total", total);  
        map.put("rows", list);  
        return map;
    }
    @RequestMapping(value="/product",method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getAllProducts() {
    	return productService.listProducts();
    }
    @RequestMapping(value="/product/{prodId}",method = RequestMethod.GET)
    @ResponseBody
    public Result<Product> getProduct(@PathVariable Integer prodId) {
        Product product = productService.getProduct(prodId);
        System.out.println(product);
        Result<Product> result = new Result<>();
        result.setCode(201);
        result.setData(product);
        result.setMessage("SUCCESS");
        return result;
    }
    
    @RequestMapping(value="/product", method=RequestMethod.POST)
    @ResponseBody
    public Result newProduct(@RequestBody Product prod ) {
        System.out.println(prod);
        productService.newProduct(prod);
        System.out.println(prod.getProdId());
        Result<Product> result = new Result<>();
        result.setCode(201);
        result.setMessage("CREATED");
        result.setData(prod);
        return result;
    }
    
    @RequestMapping(value="/product", method=RequestMethod.PUT)
    @ResponseBody
    public Result editProduct(@RequestBody Product prod ) {
        System.out.println(prod);
        productService.editProduct(prod);
        Result<Product> result = new Result<>();
        result.setCode(200);
        result.setMessage("SUCCESS");
        result.setData(prod);
        return result;
    }
    
    @RequestMapping(value="/product/{prodId}", method=RequestMethod.DELETE)
    @ResponseBody
    public Result deleteProduct(@PathVariable Integer prodId ) {
        productService.deleteProduct(prodId);
        Result<Product> result = new Result<>();
        result.setCode(204);
        result.setMessage("NO CONTENT");
        return result;
    }
}
