package com.java.web;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.bean.DepotItem;
import com.java.bean.Product;
import com.java.bean.Result;
import com.java.service.DepotItemService;

@Controller
public class DepotItemController {
    @Autowired
    private DepotItemService depotItemService;
                 
    @RequestMapping(value="/depotitem/{depotno}")
    @ResponseBody
    public List<DepotItem> getProductsByDepotno(@PathVariable Integer depotno) {
        List<DepotItem> products = depotItemService.selectProductByDepotno(depotno);
        if (products != null) {
            for (DepotItem de:products) System.out.println(de);
        }
        else {
            System.out.println("查询为空？？？");
        }
        return products;
    }
    
    @RequestMapping(value="/depotitempage/{depotno}")
    @ResponseBody
    public Map<String, Object> getProductsPageByDepotno(@PathVariable Integer depotno, int page, int rows) {
        List<DepotItem> list = depotItemService.selectProductPageByDepotno(depotno, page, rows);
        long total = depotItemService.countDepotItemsByDepotno(depotno);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", list);
        map.put("total", total);
        if (list != null) {
            for (DepotItem de:list) System.out.println(de);
        }
        else {
            System.out.println("查询为空？？？");
        }
        return map;
    }
    
    @RequestMapping(value="/depotitempage/{depotno}/{productName}")
    @ResponseBody
    public Map<String, Object> getProductsPageByDepotnoAndProdName(@PathVariable Integer depotno, @PathVariable String productName) {
        
        List<DepotItem> list = depotItemService.selectProductByDepotno(depotno);
        
        Iterator<DepotItem> it = list.iterator();
        while(it.hasNext()){
            DepotItem x = it.next();
            if(!x.getProdName().toUpperCase().contains(productName.toUpperCase())){
                it.remove();
            }
        }
        
        long total = list.size();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", list);
        map.put("total", total);
        if (list.isEmpty()) {
            System.out.println("查询为空");
        } else {
            for (DepotItem de:list) System.out.println(de);
        }
        return map;
    }
    
    @RequestMapping(value="/depotitem", method=RequestMethod.POST)
    @ResponseBody
    public Result<DepotItem> newDepotItem(@RequestBody DepotItem depotItem) {
        System.out.println(depotItem);
        int n = depotItemService.newDepotItem(depotItem);
        Result<DepotItem> result = new Result<>();
        if (n == 1) {
            result.setCode(201);
            result.setMessage("CREATED");
            result.setData(depotItem);
        }
        else {
            result.setCode(404);
            result.setMessage("NOTFOUND");
        }
        return result;
    }
    
    @RequestMapping(value="/depotitem", method=RequestMethod.PUT)
    @ResponseBody
    public Result<DepotItem> editDepotItem(@RequestBody DepotItem depotItem) {
        System.out.println(depotItem);
        int n = depotItemService.editDepotItem(depotItem);
        Result<DepotItem> result = new Result<>();
        if (n == 1) {
            result.setCode(201);
            result.setMessage("SUCCESS");
            result.setData(depotItem);
        }
        else {
            result.setCode(404);
            result.setMessage("NOTFOUND");
        }
        return result;
    }
    
    @RequestMapping(value="/depotitem/{depotno}/{prodId}", method=RequestMethod.DELETE)
    @ResponseBody
    public Result<DepotItem> deleteDepotItem(@PathVariable Integer depotno, 
                                             @PathVariable Integer prodId) {
        DepotItem depotItem = new DepotItem();
        depotItem.setDepotno(depotno);
        depotItem.setProdId(prodId);
        int n = depotItemService.deleteDepotItem(depotItem);
        Result<DepotItem> result = new Result<>();
        if (n == 1) {
            result.setCode(204);
            result.setMessage("NO CONTENT");
            result.setData(depotItem);
        }
        else {
            result.setCode(404);
            result.setMessage("NOTFOUND");
        }
        return result;
    }    
    
}
