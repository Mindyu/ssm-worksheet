package com.java.dao;

import com.java.bean.DepotItem;
import com.java.bean.DepotItemExample;
import com.java.bean.Product;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepotItemMapper {
    long countByExample(DepotItemExample example);

    int deleteByExample(DepotItemExample example);

    int insert(DepotItem record);

    int insertSelective(DepotItem record);

    List<DepotItem> selectByExample(DepotItemExample example);

    int updateByExampleSelective(@Param("record") DepotItem record, @Param("example") DepotItemExample example);

    int updateByExample(@Param("record") DepotItem record, @Param("example") DepotItemExample example);
    
    List<DepotItem> selectProductsByDepotno(Integer depotno);
    
    List<DepotItem> selectProductsPageByDepotno(DepotItemExample example);
}