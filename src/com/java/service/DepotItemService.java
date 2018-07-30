package com.java.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.codegen.ibatis2.model.ExampleGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.bean.DepotItem;
import com.java.bean.DepotItemExample;
import com.java.bean.Product;
import com.java.dao.DepotItemMapper;

/**
 * @author iprcc
 * 
 */
@Service
public class DepotItemService {
    @Autowired
    private DepotItemMapper depotItemMapper;

    public List<DepotItem> selectProductByDepotno(Integer depotno) {
        return depotItemMapper.selectProductsByDepotno(depotno);
    }
    
    public List<DepotItem> selectProductPageByDepotno(Integer depotno, 
    								int currentPage, int pageSize) {
    	System.out.println("分页请求下：" + currentPage + ' ' + pageSize);
    	DepotItemExample example = new DepotItemExample();
     	example.setOffset((currentPage-1)*pageSize);
    	example.setLimit(pageSize);
    	example.or().andDepotnoEqualTo(depotno);
        return depotItemMapper.selectProductsPageByDepotno(example);
    }
    
    public long countDepotItems() {
    	return depotItemMapper.countByExample(null);
    }
    
    public long countDepotItemsByDepotno(Integer depotno) {
    	DepotItemExample example = new DepotItemExample();
    	example.or().andDepotnoEqualTo(depotno);
    	return depotItemMapper.countByExample(example);
    }
    
    public int newDepotItem(DepotItem depotItem) {
        DepotItemExample example = new DepotItemExample();
        example.or()
               .andDepotnoEqualTo(depotItem.getDepotno())
               .andProdIdEqualTo(depotItem.getProdId());
        List<DepotItem> list = new ArrayList<>();
        list = depotItemMapper.selectByExample(example); 
        int n = 0;
        if(list.size() == 1) {
            DepotItem depotItem1 = list.get(0);
            int a = depotItem.getQuantity();
            int b = depotItem1.getQuantity();
            depotItem.setQuantity(a+b);
            n = depotItemMapper.updateByExampleSelective(depotItem, example);
        }
        else {
            n = depotItemMapper.insertSelective(depotItem);
        }
        return n;
    }
    
    public int editDepotItem(DepotItem depotItem) {
        DepotItemExample example = new DepotItemExample();
        example.or()
               .andDepotnoEqualTo(depotItem.getDepotno())
               .andProdIdEqualTo(depotItem.getProdId()); 
        int n = depotItemMapper.updateByExampleSelective(depotItem, example);
        return n;
    }
    
    public int deleteDepotItem(DepotItem depotItem) {
        DepotItemExample example = new DepotItemExample();
        example.or()
               .andDepotnoEqualTo(depotItem.getDepotno())
               .andProdIdEqualTo(depotItem.getProdId()); 
        int n = depotItemMapper.deleteByExample(example);
        return n;
    }    
}
